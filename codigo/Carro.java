
public class Carro extends Veiculo {
	public static final double TAXA_SEGURO = 0.05;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double TAXA_IPVA = 0.04;
	public static final double KMMEDIOPORLITRO = 10;
	public static final int CAPACIDADE_TANQUE = 50;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Carro(String placa, double valorDeVenda) {
		super(placa, valorDeVenda);
		this.nome = "Carro";
	}
	
	/**
	 * Adiciona Rota a um veiculo
	 */
	@Override
	public void addRota(Rota rota) {
		double distanciaLimiteMaisAdicionada  = this.obterLimitePorData(rota.getData()) + rota.getDistancia();
		if(distanciaLimiteMaisAdicionada <= this.calcularLimiteDiario()) {
			this.rotas.add(rota);
			this.setKmRodado(this.kmRodado + rota.getDistancia());
		}
	}
	

	/**
	 * Calcula custos adicionais do veiculo
	 */
	@Override
	public double calcularOutrosCustos() {
		double alinhamento = 0;
		if(this.kmRodado >= 10000) {
			int calc = (int) (this.kmRodado / 10000);
			alinhamento = calc * 80;
		}
		double outrosCustos = alinhamento;
		return outrosCustos;
	}

	/**
	 * Calcula o limite de rotas diarias do veiculo com base no seu tanque e rotas ja cadastradas
	 */
	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Carro.CAPACIDADE_TANQUE * Carro.KMMEDIOPORLITRO;
		return limiteDiario;
	}
	
	/** 
	 * Calcula IPVA do veiculo
	 */ 
	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Carro.TAXA_IPVA;
	}

	/**
	 * Calcula Seguro do veiculo
	 */
	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Carro.TAXA_SEGURO + Carro.SEGURO_ADICIONAL;
	}
	
	/**
	 * Gera relatorio de todos os Carros
	 */
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo ve�culo: Carro");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}

}
