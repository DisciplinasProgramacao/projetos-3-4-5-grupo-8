import java.util.ArrayList;

public class Caminhao extends Veiculo{
	public ArrayList<Caminhao> listaCaminhao = new ArrayList();
	public static final double TAXA_SEGURO = 0.02;
	public static final double TAXA_IPVA = 0.01;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double ALINHAMENTO = 1000;
	public static final double VISTORIA = 1000;
	
	public Caminhao(String placa){
		setPlaca(placa);
		id = id++;
		listaCaminhao.add(this);
	}
	
	public double calcularOutrosCustos() {
		
	}
}
