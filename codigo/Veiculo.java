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
			Carro novoCarro = new Carro(placa);
			
		}
		else if(tipo.equals("Caminhao")) {
			Caminhao novoCaminhao = new Caminhao(placa);
			
		}
		else if(tipo.equals("Furgao")) {
			Furgao novoFurgao = new Furgao(placa);
			
		}
		else if(tipo.equals("Van")) {
			Van novaVan = new Van(placa)
		}
		else {
			throw new Exception("Tipo inválido. Tente novamente");
		}
	}
	
	public Veiculo localizaVeiculo(String placa) {
		
	}
	
	
	public String gerarRelatorio() {
		
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
