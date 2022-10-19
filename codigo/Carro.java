import java.util.ArrayList;
public class Carro extends Veiculo{
	public ArrayList<Carro> listaCarro = new ArrayList();
	public static final double TAXA_SEGURO = 0.05;
	public static final double SEGURO_ADICIONAL = 300;
	public static final double TAXA_IPVA = 0.04;
	public static final double ALINHAMENTO = 80;
	
	public Carro(String placa){
		setPlaca(placa);
		id = id++;
		listaCarro.add(this);
	}
	
	public double calcularOutrosCustos() {
		
	}

}
