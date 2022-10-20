
public class Furgao extends Veiculo implements IVeiculo {
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double ALINHAMENTO = 120;
	public static final double VISTORIA = 500;
	
	
	
	public Furgao(String placa, double ipva, double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda, double kmRodado, Rota[] rotas, double gastoTotal) {
		super(placa, ipva, capacidadeTanque, seguro, custosAdicionais, limiteDiario, valorDeVenda, kmRodado, rotas, gastoTotal);
		// TODO Auto-generated constructor stub
	}



	@Override
	public double autonomiaDiaria() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public boolean validaLimite() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public double calcularOutrosCustos() {
		return 0.00;
	}



	@Override
	public void gerarRelatorio() {
		// TODO Auto-generated method stub
	}
}
