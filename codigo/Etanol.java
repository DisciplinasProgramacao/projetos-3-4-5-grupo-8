public class Etanol extends Combustivel{
	private static final double VALORMEDIOLITRO = 3.65;
	private static final double CONSUMO = 8;
	
	public Etanol() {
		super();
		this.setConsumo(CONSUMO);
		this.setValorMedioLitro(VALORMEDIOLITRO);
	}
	
	@Override
	public double abastecer(double qtd) {
		return qtd * VALORMEDIOLITRO;
	}
}
