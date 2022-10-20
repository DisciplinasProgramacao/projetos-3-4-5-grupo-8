import java.util.Date;

public class Rota {
	private int id;
	private double distancia;
	private Date data;
	private String origem;
	private String destino;
	
	public Rota(double distancia , Date data , String origem , String destino) {
		this.distancia = distancia;
		this.data = data;
		this.origem = origem;
		this.destino = destino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
