import java.util.ArrayList;

public class Caminhao extends Veiculo {
	public static final double TAXA_SEGURO = 0.02;
	public static final double TAXA_IPVA = 0.01;
	public static final double SEGURO_ADICIONAL = 2000;
	public static final double KMMEDIOPORLITRO = 10;
	public static final int CAPACIDADE_TANQUE = 250;

	public Caminhao(String placa, double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda, double kmRodado, ArrayList<Rota> rotas, double gastoTotal) {
		super(placa, capacidadeTanque);
	}
	
	@Override
	public void addRota(Rota rota) {
		double distanciaLimiteMaisAdicionada  = this.obterLimitePorData(rota.getData()) + rota.getDistancia();
		if(distanciaLimiteMaisAdicionada <= this.calcularLimiteDiario()) {
			this.rotas.add(rota);
		}
	}

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

	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Caminhao.CAPACIDADE_TANQUE * Caminhao.KMMEDIOPORLITRO;
		return limiteDiario;
	}

	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Caminhao.TAXA_IPVA;
	}

	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Caminhao.TAXA_SEGURO + Caminhao.SEGURO_ADICIONAL;
	}
	
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo veículo: Caminhão");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}
}
