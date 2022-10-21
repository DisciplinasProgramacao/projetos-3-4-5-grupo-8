
public class Caminhao extends Veiculo {
	public static final double TAXA_SEGURO = 0.02;
	public static final double TAXA_IPVA = 0.01;
	public static final double SEGURO_ADICIONAL = 2000.00;
	public static final double KMMEDIOPORLITRO = 2.5;
	public static final int CAPACIDADE_TANQUE = 400;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Caminhao(String placa, double valorDeVenda) {
		super(placa, valorDeVenda);
		this.nome = "Caminh�o";
	}
	
	/**
	 * Adiciona Rota a um veiculo
	 */
	@Override
	public void addRota(Rota rota) {
		double distanciaLimiteMaisAdicionada  = this.obterLimitePorData(rota.getData()) + rota.getDistancia();
		if(distanciaLimiteMaisAdicionada <= this.calcularLimiteDiario()) {
			this.rotas.add(rota);
		}
	}

	/**
	 *  Calcula custos adicionais do veiculo
	 */
	@Override
	public double calcularOutrosCustos() {
		double manutencao = 0;
		double vistoria = 0;
		if(this.kmRodado >= 2000) {
			int calc = (int) (this.kmRodado / 2000);
			manutencao = calc * 1000;
		}
		if(this.kmRodado >= 3000) {
			int calc = (int) (this.kmRodado / 3000);
			vistoria = calc * 1000;
		} 
		double outrosCustos = manutencao + vistoria;
		return outrosCustos;
	}

	/**
	 * Calcula o limite de rotas diarias do veiculo com base no seu tanque e rotas ja cadastradas
	 */
	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Caminhao.CAPACIDADE_TANQUE * Caminhao.KMMEDIOPORLITRO;
		return limiteDiario;
	}

	/**
	 * Calcula IPVA do veiculo
	 */
	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Caminhao.TAXA_IPVA;
	}

	/**
	 * Calcula Seguro do veiculo
	 */
	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Caminhao.TAXA_SEGURO + Caminhao.SEGURO_ADICIONAL;
	}
	
	/**
	 * Gera relatorio de todos os Caminhoes
	 */
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo ve�culo: Caminh�o");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}
}
