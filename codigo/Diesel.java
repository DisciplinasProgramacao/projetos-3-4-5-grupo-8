public class Diesel extends Combustivel{
	public static final double VALORMEDIOLITRO = 6.65;
	public static final double CONSUMO = 3.5;
	
	public Diesel() {
		super();
		this.setConsumo(CONSUMO);
		this.setValorMedioLitro(VALORMEDIOLITRO);
	}
	
	@Override
	public double abastecer(double qtd) {
		return qtd * VALORMEDIOLITRO;
	}
}
