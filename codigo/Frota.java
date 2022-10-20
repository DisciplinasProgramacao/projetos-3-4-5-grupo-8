import java.util.ArrayList;

public class Frota {
	private ArrayList<Veiculo> veiculos;
	
	/**
	 * @param veiculos
	 */
	public Frota(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	/**
	 * 
	 */
	public Frota() {
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	/**
	 * @return
	 */
	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	/**
	 * @param veiculos
	 */
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	/**
	 * @param veiculo
	 */
	public void addVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}
	
	/**
	 * @param placa
	 * @return
	 */
	public Veiculo localizarVeiculo(String placa) {
		for(Veiculo v : this.veiculos) {
			 if(v.placa.equals(placa)) {
				 return v;
			 }
		 }
		return null;
	}
	
}
