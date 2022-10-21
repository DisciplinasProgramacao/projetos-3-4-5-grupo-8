
public class Van extends Veiculo implements IVeiculo {
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double KMMEDIOPORLITRO = 10;
	public static final int CAPACIDADE_TANQUE = 60;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Van(String placa, double valorDeVenda) {
		super(placa, valorDeVenda);
		this.nome = "Van";
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
		double vistoria = 0;
		if(this.kmRodado >= 10000) {
			int calc = (int) (this.kmRodado / 10000);
			alinhamento = calc * 120;
		}
		if(this.kmRodado >= 10000) {
			int calc = (int) (this.kmRodado / 10000);
			vistoria = calc * 500;
		} 
		double outrosCustos = alinhamento + vistoria;
		return outrosCustos;
	}

	/**
	 * Calcula o limite de rotas diarias do veiculo com base no seu tanque e rotas ja cadastradas
	 */
	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Van.CAPACIDADE_TANQUE * Van.KMMEDIOPORLITRO;
		return limiteDiario;
	}
	
	/**
	 * Calcula IPVA do veiculo
	 */
	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Van.TAXA_IPVA;
	}

	/**
	 * Calcula Seguro do veiculo
	 */
	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Van.TAXA_SEGURO;
	}
	
	/**
	 * Gera relatorio de todos as Vans
	 */
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo ve�culo: Van");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}
	
}
