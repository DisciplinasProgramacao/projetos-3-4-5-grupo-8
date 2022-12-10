import java.io.IOException;

public class Carro extends Veiculo {
	public static final double TAXA_SEGURO = 0.05;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double TAXA_IPVA = 0.04;
	public static final int CAPACIDADE_TANQUE = 50;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Carro(String placa, double valorDeVenda, int combustivel) {
		super(placa, valorDeVenda, combustivel);
		this.nome = "Carro";
		this.tanque = CAPACIDADE_TANQUE;
	}
	
	/**
	 * Adiciona Rota a um veiculo
	 */
	@Override
	public void addRota(Rota rota) {
		try {
			double distanciaLimiteMaisAdicionada  = this.obterLimitePorData(rota.getData()) + rota.getDistancia();
			if(distanciaLimiteMaisAdicionada <= this.calcularLimiteDiario()) {
				this.rotas.add(rota);
				this.setKmRodado(this.kmRodado + rota.getDistancia());
				this.tanque -= rota.getDistancia() / this.combustivel.getConsumo();
			} else {
				System.out.println("Tanque abastecido por n�o ter combustivel suficiente para a rota atual.");
				this.encherTanque();
				this.rotas.add(rota);
				this.setKmRodado(this.kmRodado + rota.getDistancia());
			}
			
			// cria um loop para imprimir 7 valores aleat�rios entre 1 e 20
			for (int i = 0; i < 7; i++) {
		        int numRandom = (int)(Math.random() * 20 ) + 1;
		     // se os valores gerados forem 5, 7 ou 16 gera uma manuten��o n�o programada
		        if(numRandom == 5 || numRandom == 7 || numRandom == 16) {
		        	System.out.println("Apareceu uma manuten��o n�o programada no valor de R$" + numRandom * 10.00);
		        	this.manutencaoNaoProgramada.add(numRandom * 10.00);
		        }
	
		     }
		}catch(IOException ex){
			ex.printStackTrace();
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
		try {
			double limiteDiario = Carro.CAPACIDADE_TANQUE * this.combustivel.getConsumo();
			return limiteDiario;
		}catch(IOException ex){
			ex.printStackTrace();
		}
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
		try {
		System.out.println("Tipo ve�culo: Carro");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		try {
			this.tanque = CAPACIDADE_TANQUE;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
