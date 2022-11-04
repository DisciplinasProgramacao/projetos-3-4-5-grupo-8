public class Etanol extends Combustivel{
	public static final double VALORMEDIOLITRO = 3.65;
	public static final double CONSUMO = 8;
	
	@Override
	public double abastecer(double qtd) {
		return qtd * VALORMEDIOLITRO;
	}
}
