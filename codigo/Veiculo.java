import java.util.ArrayList;
import java.util.Date;

public abstract class Veiculo implements IVeiculo {
	protected String nome;
	protected String placa;
	protected double valorDeVenda;
	protected double kmRodado;
	protected ArrayList<Rota> rotas;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Veiculo(String placa, double valorDeVenda) {
		this.nome = "";
		this.placa = placa;
		this.valorDeVenda = valorDeVenda;
		this.kmRodado = 0;
		this.rotas = new ArrayList<Rota>();
	}

	/**
	 * @return
	 */
	public double getKmRodado() {
		return kmRodado;
	}

	/**
	 * @param kmRodado
	 */
	public void setKmRodado(double kmRodado) {
		this.kmRodado = kmRodado;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public ArrayList<Rota> getRotas() {
		return rotas;
	}

	/**
	 * @param rotas
	 */
	public void setRotas(ArrayList<Rota> rotas) {
		this.rotas = rotas;
	}

	/**
	 * @return
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return
	 */
	public double getValorDeVenda() {
		return valorDeVenda;
	}

	/**
	 * @param valorDeVenda
	 */
	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}
	
	/**
	 * @param date
	 * @return
	 */
	public double obterLimitePorData(Date date) {
		double distanciaPercorridaDia = 0;
		for(Rota r : this.rotas) {
			if(r.getData().equals(date)) {
				distanciaPercorridaDia += r.getDistancia();
			}
		}
		return distanciaPercorridaDia;
	}
	
	/**
	 * @return
	 */
	public double calcularKmRodado() {
		double km = 0;
		for(Rota r : this.rotas) {
				km += r.getDistancia();
		}
		this.kmRodado = km;
		return km;
	}

	/**
	 *
	 */
	public abstract void addRota(Rota rota);
	
	/**
	 *
	 */
	public abstract double calcularOutrosCustos();
	
	/**
	 *
	 */
	public abstract double calcularIPVA();
	
	/**
	 *
	 */
	public abstract double calcularSeguro();
	
	/**
	 *
	 */
	public abstract void gerarRelatorio();

}
