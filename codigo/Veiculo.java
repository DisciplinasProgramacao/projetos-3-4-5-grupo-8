import java.util.ArrayList;
import java.util.Date;

public abstract class Veiculo implements IVeiculo {
	protected String placa;
	protected double capacidadeTanque;
	protected double limiteDiario;
	protected double valorDeVenda;
	protected double kmRodado;
	protected ArrayList<Rota> rotas;

	public Veiculo(String placa,  double capacidadeTanque, double seguro, double custosAdicionais,
			double limiteDiario, double valorDeVenda) {
		super();
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
		this.limiteDiario = limiteDiario;
		this.valorDeVenda = valorDeVenda;
		this.kmRodado = 0;
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

	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(double capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
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
	
	public double obterLimitePorData(Date date) {
		double distanciaPercorridaDia = 0;
		for(Rota r : this.rotas) {
			if(r.getData().equals(date)) {
				distanciaPercorridaDia += r.getDistancia();
			}
		}
		return distanciaPercorridaDia;
	}

	public abstract void addRota(Rota rota);
	
	public abstract double calcularOutrosCustos();
	
	public abstract double calcularIPVA();
	
	public abstract double calcularSeguro();
	
	public abstract void gerarRelatorio();

}
