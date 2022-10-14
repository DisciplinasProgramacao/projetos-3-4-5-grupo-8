import java.util.Date;

public class Rota {
	private int id;
	private double distancia;
	private Date data;
	String origem;
	String destino;
	
	public Rota(double distancia , Date data , String origem , String destino) {
		this.distancia = distancia;
		this.date = data;
		this.origem = origem;
		this.destino = destino;
	}

	public Rota obterRota() {
		
	}
}
