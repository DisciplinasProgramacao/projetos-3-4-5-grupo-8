import java.util.Date;
import java.io.Serializable;
import java.util.Collection;

public class Rota implements Comparable<Rota>, Serializable {
	private double distancia;
	private Date data;
	private String origem;
	private String destino;
	
	/**
	 * @param data
	 * @param origem
	 * @param destino
	 * @param distancia
	 */
	public Rota(Date data, String origem , String destino, double distancia) {
		this.distancia = distancia;
		this.data = data;
		this.origem = origem;
		this.destino = destino;
	}

	/**
	 * Pega distancia de uma rota
	 */
	public double getDistancia() {
		return distancia;
	}

	/**
	 * fixa distancia de uma rota
	 */
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	/**
	 * Pega data de uma rota
	 */
	public Date getData() {
		return data;
	}

	/**
	 * fixa data de uma rota
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Pega origem de uma rota
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * fixa origem de uma rota
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * Pega destino de uma rota
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * fixa destino de uma rota
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Rota [Distancia " + distancia + ", Data " + data + ", Origem " + origem + ", Destino " + destino + "]";
	}

	@Override
	public int compareTo(Rota o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
