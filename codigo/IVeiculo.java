

public interface IVeiculo {
	public void addRota(Rota rota);
	public double calcularOutrosCustos();
	public double calcularLimiteDiario();
	public double calcularIPVA();
	public double calcularSeguro();
	public void gerarRelatorio();
}
