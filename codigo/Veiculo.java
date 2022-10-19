public class Veiculo implements IVeiculo{
	private String placa;
	public static int id = 0;
	private double ipva;
	private double capacidadeTanque;
	private double seguro;
	private double custosAdicionais;
	private double limiteDiario;
	private double valorDeVenda;
	private double kmRodado;
	private Rota[] rotas;
	private double gastoTotal;
	
	public void cadastraVeiculo(String tipo , String placa) throws Exception {
		if(tipo.equals("Carro")){
			Carro novocarro = new Carro();
			
		}
		else if(tipo.equals("Caminhao")) {
			
		}
		else if(tipo.equals("Furgao")) {
			
		}
		else if(tipo.equals("Van")) {
			
		}
		else {
			throw new Exception("Tipo inválido. Tente novamente");
		}
	}
	
	public Veiculo localizaVeiculo(String placa) {
		
	}
	
	
	public String gerarRelatorio() {
		
	}
}
