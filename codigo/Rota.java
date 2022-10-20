import java.util.Date;

public class Rota {
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
	 * @return
	 */
	public double getDistancia() {
		return distancia;
	}

	/**
	 * @param distancia
	 */
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	/**
	 * @return
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * @param origem
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * @return
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
