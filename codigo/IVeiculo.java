import java.util.Date;

public interface IVeiculo {
	public void addRota(Rota rota);
	public double calcularOutrosCustos();
	public double autonomiaDiaria();
	public boolean validarLimiteDiario(Date date);
	public double obterLimitePorData(Date date);
	public double calcularLimiteDiario();
	public void gerarRelatorio();
}
