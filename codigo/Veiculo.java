import java.util.ArrayList;
import java.util.Date;

public abstract class Veiculo implements IVeiculo {
	protected String placa;
	protected double valorDeVenda;
	protected double kmRodado;
	protected ArrayList<Rota> rotas;

	public Veiculo(String placa, double valorDeVenda) {
		super();
		this.placa = placa;
		this.valorDeVenda = valorDeVenda;
		this.rotas = new ArrayList<Rota>();
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

	public double getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}
	
	public double obterLimitePorData(Date date) {
		double distanciaPercorridaDia = 0;
		for(Rota r : this.rotas) {
			if(r.getData().equals(date)) {
				distanciaPercorridaDia += r.getDistancia();
			}
		}
		return distanciaPercorridaDia;
	}
	
	public double calcularKmRodado() {
		double km = 0;
		for(Rota r : this.rotas) {
				km += r.getDistancia();
		}
		this.kmRodado = km;
		return km;
	}

	public abstract void addRota(Rota rota);
	
	public abstract double calcularOutrosCustos();
	
	public abstract double calcularIPVA();
	
	public abstract double calcularSeguro();
	
	public abstract void gerarRelatorio();

}
