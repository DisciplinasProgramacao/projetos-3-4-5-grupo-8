public class Gasolina extends Combustivel{
	protected static final double VALORMEDIOLITRO = 4.8;
	protected static final double CONSUMO = 12;
	
	public Gasolina() {
		super();
	}
	
	@Override
	public double abastecer(double qtd) {
		return qtd * VALORMEDIOLITRO;
	}
	
}
