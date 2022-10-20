import java.util.ArrayList;
import java.util.Date;

public class Furgao extends Veiculo implements IVeiculo {
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double KMMEDIOPORLITRO = 10;
	public static final int CAPACIDADE_TANQUE = 80;

	public Furgao(String placa, double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda, double kmRodado, ArrayList<Rota> rotas, double gastoTotal) {
		super(placa, capacidadeTanque);
	}
	
	@Override
	public void addRota(Rota rota) {
		double distanciaLimiteMaisAdicionada  = obterLimitePorData(rota.getData()) + rota.getDistancia();
		if(distanciaLimiteMaisAdicionada <= this.calcularLimiteDiario()) {
			this.rotas.add(rota);
		}
	}

	@Override
	public double obterLimitePorData(Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

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

	@Override
	public double calcularLimiteDiario() {
		double limiteDiario = Furgao.CAPACIDADE_TANQUE * Furgao.KMMEDIOPORLITRO;
		return limiteDiario;
	}
	
	@Override
	public double calcularIPVA() {
		return this.valorDeVenda * Furgao.TAXA_IPVA;
	}

	@Override
	public double calcularSeguro() {
		return this.valorDeVenda * Furgao.TAXA_SEGURO;
	}
	
	@Override
	public void gerarRelatorio() {
		System.out.println("Tipo veículo: Furgão");
		System.out.println("Placa: " + this.placa);
		System.out.println("IPVA: " + this.calcularIPVA());
		System.out.println("IPVA: " + this.calcularSeguro());
		System.out.println("Outros custos: " + this.calcularOutrosCustos());
	}
}
