import java.util.Date;

public class Furgao extends Veiculo implements IVeiculo {
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double KMMEDIOPORLITRO = 5;
	public static final int CAPACIDADE_TANQUE = 80;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Furgao(String placa, double valorDeVenda) {
		super(placa, valorDeVenda);
		this.nome = "Furg�o";
	}
	
	/**
	 * Adiciona Rota a um veiculo
	 */
	@Override
	public void addRota(Rota rota) {
		double distanciaLimiteMaisAdicionada  = obterLimitePorData(rota.getData()) + rota.getDistancia();
		if(distanciaLimiteMaisAdicionada <= this.calcularLimiteDiario()) {
			this.rotas.add(rota);
		}
	}

	/**
	 *
	 */
	@Override
	public double obterLimitePorData(Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Calcula custos adicionais do veiculo
	 */
	@Override
	public double calcularOutrosCustos() {
		double alinhamento = 0;
		double vistoria = 0;
		if(this.kmRodado >= 1000) {
			int calc = (int) (this.kmRodado / 1000);
			alinhamento = calc * 120;
		}
		if(this.kmRodado >= 1000) {
			int calc = (int) (this.kmRodado / 1000);
			vistoria = calc * 5000;
		} 
		double outrosCustos = alinhamento + vistoria;
		return outrosCustos;
	}

	/**
	 * Calcula o limite de rotas diarias do veiculo com base no seu tanque e rotas ja cadastradas
	 */
	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Furgao.CAPACIDADE_TANQUE * Furgao.KMMEDIOPORLITRO;
		return limiteDiario;
	}
	
	/**
	 * Calcula IPVA do veiculo
	 */
	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Furgao.TAXA_IPVA;
	}

	/**
	 * Calcula Seguro do veiculo
	 */
	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Furgao.TAXA_SEGURO;
	}
	
	/**
	 * Gera relatorio de todos os Furgao
	 */
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo ve�culo: Furg�o");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}
}
