import java.io.Serializable;

public abstract class Combustivel implements Serializable {
	private double valorMedioLitro;
	private double consumo;
	
	
	/**
	 * 
	 */
	public Combustivel() {
		
	}

	

	/**
	 * @return
	 */
	public double getValorMedioLitro() {
		return valorMedioLitro;
	}



	/**
	 * @param valorMedioLitro
	 */
	public void setValorMedioLitro(double valorMedioLitro) {
		this.valorMedioLitro = valorMedioLitro;
	}



	/**
	 * @return
	 */
	public double getConsumo() {
		return consumo;
	}



	/**
	 * @param consumo
	 */
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	/**
	 * @param qtd
	 * @return
	 */
	public abstract double abastecer(double qtd);
}
