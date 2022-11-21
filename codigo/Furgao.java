import java.util.Date;

public class Furgao extends Veiculo implements IVeiculo {
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double KMMEDIOPORLITRO = 6.25;
	public static final int CAPACIDADE_TANQUE = 80;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Furgao(String placa, double valorDeVenda, int combustivel) {
		super(placa, valorDeVenda, combustivel);
		this.nome = "Furgão";
		this.tanque = CAPACIDADE_TANQUE;
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
			this.tanque -= rota.getDistancia() / this.combustivel.getConsumo();
		} else {
			System.out.println("Tanque abastecido por não ter combustivel suficiente para a rota atual.");
			this.encherTanque();
			this.rotas.add(rota);
			this.setKmRodado(this.kmRodado + rota.getDistancia());
		}
		
		// cria um loop para imprimir 7 valores aleatórios entre 1 e 20
		for (int i = 0; i < 7; i++) {
	        int numRandom = (int)(Math.random() * 20 ) + 1;
	     // se os valores gerados forem 5, 7 ou 16 gera uma manutenção não programada
	        if(numRandom == 5 || numRandom == 7 || numRandom == 16) {
	        	System.out.println("Apareceu uma manutenção não programada no valor de R$" + numRandom * 10.00);
	        	this.manutencaoNaoProgramada.add(numRandom * 10.00);
	        }

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
		System.out.println("Tipo veï¿½culo: Furgï¿½o");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}
	
	/**
	 *
	 */
	@Override
	public double calcularCustosTotais() {
		double custosTotais = 0;
		custosTotais = this.calcularIPVA() + this.calcularSeguro() + this.calcularOutrosCustos();
		for(double m: this.manutencaoNaoProgramada) {
			custosTotais += m;
		}
		return custosTotais;
	}
	
	/**
	 *
	 */
	@Override
	public void encherTanque() {
		this.tanque = CAPACIDADE_TANQUE;
	}
}
