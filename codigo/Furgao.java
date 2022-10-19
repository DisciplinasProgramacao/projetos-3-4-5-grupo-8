import java.util.ArrayList;

public class Furgao extends Veiculo {
	public ArrayList<Furgao> listaFurgao = new ArrayList();
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double ALINHAMENTO = 120;
	public static final double VISTORIA = 500;
	
	public Furgao(String placa){
		setPlaca(placa);
		id = id++;
		listaFurgao.add(this);
	}
	
	public double calcularOutrosCustos() {
		
	}
}
