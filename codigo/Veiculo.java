import java.util.ArrayList;
import java.util.Date;

public abstract class Veiculo implements IVeiculo {
	protected String placa;
	protected double ipva;
	protected double capacidadeTanque;
	protected double seguro;
	protected double custosAdicionais;
	protected double limiteDiario;
	protected double valorDeVenda;
	protected double kmRodado;
	protected ArrayList<Rota> rotas = new ArrayList<Rota>();
	protected double gastoTotal;

	public Veiculo(String placa, double ipva, double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda, double kmRodado, ArrayList<Rota> rotas, double gastoTotal) {
		super();
		this.placa = placa;
		this.ipva = ipva;
		this.capacidadeTanque = capacidadeTanque;
		this.seguro = seguro;
		this.custosAdicionais = custosAdicionais;
		this.limiteDiario = limiteDiario;
		this.valorDeVenda = valorDeVenda;
		this.kmRodado = kmRodado;
		this.rotas = rotas;
		this.gastoTotal = gastoTotal;
	}

	public ArrayList<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(ArrayList<Rota> rotas) {
		this.rotas = rotas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getIpva() {
		return ipva;
	}

	public void setIpva(double ipva) {
		this.ipva = ipva;
	}

	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(double capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public double getSeguro() {
		return seguro;
	}

	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}

	public double getCustosAdicionais() {
		return custosAdicionais;
	}

	public void setCustosAdicionais(double custosAdicionais) {
		this.custosAdicionais = custosAdicionais;
	}

	public double getLimiteDiario() {
		return limiteDiario;
	}

	public void setLimiteDiario(double limiteDiario) {
		this.limiteDiario = limiteDiario;
	}

	public double getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public double getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(double kmRodado) {
		this.kmRodado = kmRodado;
	}

	public double getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}

	public abstract void addRota(Rota rota);
	
	public abstract double calcularOutrosCustos();
	
	public abstract double autonomiaDiaria();
	
	public abstract boolean validarLimiteDiario(Date date);
	
	public abstract double obterLimitePorData(Date date);
	
	public abstract void gerarRelatorio();

}
