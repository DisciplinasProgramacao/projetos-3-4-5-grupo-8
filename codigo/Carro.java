import java.util.ArrayList;

public class Carro extends Veiculo {
	public static final double TAXA_SEGURO = 0.05;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double TAXA_IPVA = 0.04;
	public static final double KMMEDIOPORLITRO = 10;
	public static final int CAPACIDADE_TANQUE = 50;

	public Carro(String placa, double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda, double kmRodado, ArrayList<Rota> rotas, double gastoTotal) {
		super(placa, capacidadeTanque, seguro, custosAdicionais, limiteDiario);
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
		double alinhamento = 0;
		if(this.kmRodado >= 1000) {
			int calc = (int) (this.kmRodado / 1000);
			alinhamento = calc * 80;
		}
		double outrosCustos = alinhamento;
		return outrosCustos;
	}

	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Carro.CAPACIDADE_TANQUE * Carro.KMMEDIOPORLITRO;
		return limiteDiario;
	}
	
	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Carro.TAXA_IPVA;
	}

	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Carro.TAXA_SEGURO + Carro.SEGURO_ADICIONAL;
	}
	
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo ve�culo: Carro");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}

}
