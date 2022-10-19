import java.util.ArrayList;

public class Van extends Veiculo{
	public ArrayList<Van> listaVan = new ArrayList();
	public static final double TAXA_SEGURO = 0.03;
	public static final double TAXA_IPVA = 0.03;
	public static final double ALINHAMENTO = 120;
	public static final double VISTORIA = 500;
	
	public Van(String placa){
		setPlaca(placa);
		id = id++;
		listaVan.add(this);
	}
	
	public double calcularOutrosCustos() {
		
	}
}
