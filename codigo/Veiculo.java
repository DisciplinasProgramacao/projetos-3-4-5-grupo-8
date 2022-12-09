import java.util.ArrayList;
import java.util.Date;

public abstract class Veiculo implements IVeiculo, Comparable<Veiculo> {
	protected String nome;
	protected String placa;
	protected double valorDeVenda;
	protected double kmRodado;
	protected ArrayList<Rota> rotas;
	protected Combustivel combustivel;
	protected double tanque;
	protected ArrayList<Double> manutencaoNaoProgramada;

	/**
	 * @param placa
	 * @param valorDeVenda
	 */
	public Veiculo(String placa, double valorDeVenda, int combustivel) {
		this.nome = "";
		this.placa = placa;
		this.valorDeVenda = valorDeVenda;
		this.kmRodado = 0;
		this.rotas = new ArrayList<Rota>();
		switch (combustivel) {
		case 1:
			this.combustivel = new Gasolina();
		break;
		case 2:
			this.combustivel = new Etanol();
		break;
		case 3:
			this.combustivel = new Diesel();
		break;
		default:
			throw new IllegalArgumentException("Valor inesperado: " + combustivel);
		}
		manutencaoNaoProgramada = new ArrayList<Double>();
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
		return this.rotas.stream().filter(r -> r.getData().equals(date)).mapToDouble(r -> r.getDistancia()).sum();
	}
	
	/**
	 * @return
	 */
	public double calcularKmRodado() {
		return this.rotas.stream().mapToDouble(r -> r.getDistancia()).sum();
	}
	
	/**
	 * @return
	 */
	public int quantidadeRotas() {
		return rotas.size();
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
	
	/**
	 *
	 */
	public abstract double calcularCustosTotais();
	
	/**
	 *
	 */
	public abstract void encherTanque();
	
	public int compareTo(Veiculo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
