import java.util.ArrayList;
import java.util.Date;

public class Van extends Veiculo implements IVeiculo {
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double ALINHAMENTO = 120;
	public static final double VISTORIA = 500;

	public Van(String placa, double ipva, double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda, double kmRodado, ArrayList<Rota> rotas, double gastoTotal) {
		super(placa, ipva, capacidadeTanque, seguro, custosAdicionais, limiteDiario, valorDeVenda, kmRodado, rotas,
				gastoTotal);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addRota(Rota rota) {
		if(validarLimiteDiario(rota.getData())) {
			this.rotas.add(rota);
		}
	}

	@Override
	public double autonomiaDiaria() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean validarLimiteDiario(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double obterLimitePorData(Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularOutrosCustos() {
		return 0.00;
	}

	@Override
	public void gerarRelatorio() {
		// TODO Auto-generated method stub
	}

	@Override
	public double calcularLimiteDiario() {
		// TODO Auto-generated method stub
		return 0;
	}
}
