public class Gasolina extends Combustivel{
	public static final double VALORMEDIOLITRO = 4.8;
	public static final double CONSUMO = 12;
	
	public Gasolina() {
		super();
		this.setConsumo(CONSUMO);
		this.setValorMedioLitro(VALORMEDIOLITRO);
	}
	
	@Override
	public double abastecer(double qtd) {
		return qtd * VALORMEDIOLITRO;
	}
	
}
