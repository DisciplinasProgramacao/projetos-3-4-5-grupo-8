import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Veiculo implements IVeiculo, Comparable<Veiculo>, Serializable {
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
		try {
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
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		try {
		this.kmRodado = kmRodado;
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		try {
		this.nome = nome;
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		try {
		this.rotas = rotas;
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		try {
		this.placa = placa;
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		try {
		this.valorDeVenda = valorDeVenda;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * @param date
	 * @return
	 */
	public double obterLimitePorData(Date date) {
		double limite = 0;
		try {
			limite = this.rotas.stream().filter(r -> r.getData().equals(date)).mapToDouble(r -> r.getDistancia()).sum();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return limite;
	}
	
	/**
	 * @return
	 */
	public double calcularKmRodado() {
		double kmRodado = 0;
		try {
			kmRodado = this.rotas.stream().mapToDouble(r -> r.getDistancia()).sum();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return kmRodado;
	}
	
	/**
	 * @return
	 */
	public int quantidadeRotas() {
		int quantidade = 0;
		try {
			quantidade = rotas.size();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return quantidade;
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
