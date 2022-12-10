import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Aplicacao {
    static FabricaCarro carro = new FabricaCarro();
    static FabricaVan van = new FabricaVan();
    static FabricaFurgao furgao = new FabricaFurgao();
    static FabricaCaminhao caminhao = new FabricaCaminhao();
    
	/**
	 * @return
	 * @throws IOException
	 */
	public static Frota lerArquivo() throws IOException {
		try {
			Frota frota = new Frota();
			BufferedReader buffRead = new BufferedReader(new FileReader("codigo/veiculos.txt"));
			String linha = buffRead.readLine();
			
			while(linha != null) {
				String[] partes = linha.split(";");
				int tipoVeiculo = 0;
				String placa = "";
				double precoVenda = 0;
				if(partes.length > 0) {
					tipoVeiculo = Integer.parseInt(partes[0]);
					placa = partes[1];
					precoVenda = Double.parseDouble(partes[2]);
				}
				
	//			1 - Carro
	//			2 - Van
	//			3 - Furg�o
	//			4 - Caminhao
				switch (tipoVeiculo) {
				case 1:
					frota.addVeiculo(new Carro(placa, precoVenda, 1));
				break;
				case 2:
					frota.addVeiculo(new Van(placa, precoVenda, 1));
				break;
				case 3:
					frota.addVeiculo(new Furgao(placa, precoVenda, 1));
				break;
				case 4:
					frota.addVeiculo(new Caminhao(placa, precoVenda, 3));
				break;
				default:
					throw new IllegalArgumentException("Valor inesperado: " + tipoVeiculo);
				}
				
				
				linha = buffRead.readLine();
			}
			buffRead.close();
			
			return frota;
		}catch(IOException ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void salvarArquivo(Frota frota) throws IOException {
		try {
			File file = new File("dadosFrota.txt");
	        PrintWriter writer = new PrintWriter("dadosFrota.txt", "UTF-8");
	        for (Veiculo v : frota.getVeiculos()) {
	            writer.println("------------------------"+v.getNome()+"----------------------------");
	            writer.println("Placa: " + v.placa);
	            writer.println("IPVA: " + v.calcularIPVA());
	            writer.println("IPVA: " + v.calcularSeguro());
	            writer.println("Outros custos: " + v.calcularOutrosCustos());
	            writer.println("Custos totais: " + v.calcularCustosTotais());
	            for(Rota r : v.rotas) {
	            	writer.println(" Rota");
	            	writer.println("   Data: " + r.getData());
	            	writer.println("   Origem: " + r.getOrigem());
	            	writer.println("   Destino: " + r.getDestino());
	            	writer.println("   Dist�ncia: " + r.getDistancia());
	            }
	            writer.println("-----------------------------------------------------");
	        }
	        
	        writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try {
		 Frota frota = lerArquivo();
		 
		 Scanner in = new Scanner( System.in );
	        String opcao = "-1";
	        
			while(opcao.compareTo("0") != 0) {
				System.out.println("(1) Incluir novo veiculo");
				System.out.println("(2) Incluir rota para um veiculo");
				System.out.println("(3) Salvar um conjunto de ve�culos de um arquivo;");
				System.out.println("(4) Localizar um veiculo na frota");
				System.out.println("(5) Imprimir um relat�rio do ve�culo com seus gastos at� o momento");
				System.out.println("(6) A quilometragem m�dia de todas as rotas da empresa");
				System.out.println("(7) Os 3 ve�culos que mais fizeram rotas;");
				System.out.println("(8) Lista de ve�culos ordenada decrescentemente por custos gerados");
				System.out.println("(9) Filtrar rotas por data");
				System.out.println("(0) sair");
				System.out.println("Selecione uma op��o: ");
				opcao = in.nextLine();
				if(opcao.compareTo("1") == 0) {		
					System.out.println("Escolha o tipo do veiculo");
					System.out.println(" 1 - Carro");
					System.out.println(" 2 - Van");
					System.out.println(" 3 - Furg�o");
					System.out.println(" 4 - Caminhao");
					int tipoVeiculo = Integer.parseInt(in.nextLine());
					System.out.println("Digite a placa: ");
					String placa = in.nextLine();
					System.out.println("Digite o preco de venda");
					double precoVenda = Double.parseDouble( in.nextLine());
					
					switch (tipoVeiculo) {
					case 1:
						System.out.println("Escolha o combust�vel");
						System.out.println(" 1 - Gasolina");
						System.out.println(" 2 - Etanol");
						int tipoCombustivel = Integer.parseInt(in.nextLine());
						frota.addVeiculo(new Carro(placa, precoVenda, tipoCombustivel));
					break;
					case 2:
						System.out.println("Escolha o combust�vel");
						System.out.println(" 1 - Gasolina");
						System.out.println(" 3 - Diesel");
						tipoCombustivel = Integer.parseInt(in.nextLine());
						frota.addVeiculo(new Van(placa, precoVenda, tipoCombustivel));
					break;
					case 3:
						tipoCombustivel = 1;
						frota.addVeiculo(new Furgao(placa, precoVenda, tipoCombustivel));
					break;
					case 4:
						tipoCombustivel = 3;
						frota.addVeiculo(new Caminhao(placa, precoVenda, 3));
					break;
					default:
						throw new IllegalArgumentException("Valor inesperado: " + tipoVeiculo);
					}
				}else if(opcao.compareTo("2") == 0) {
					System.out.println("Digite a placa do veiculo:");
					String placa = in.nextLine();
					Veiculo veiculo = frota.localizarVeiculo(placa);
					if(veiculo != null) {
						System.out.println("Digite o dia da rota:");
						int dia = Integer.parseInt(in.nextLine());
						System.out.println("Digite o m�s da rota:");
						int mes = Integer.parseInt(in.nextLine());
						System.out.println("Digite o ano da rota:");
						int ano = Integer.parseInt(in.nextLine());
						System.out.println("Digite a origem da rota:");
						String origem = in.nextLine();
						System.out.println("Digite o destino da rota:");
						String destino = in.nextLine();
						System.out.println("Digite a dist�ncia da rota:");
						Double distancia = Double.parseDouble(in.nextLine());
						veiculo.addRota(new Rota(new Date(ano, mes, dia), origem, destino, distancia));
					} else {
						System.out.println("Veiculo n�o encontrado!");
					}
					
				}else if(opcao.compareTo("3") == 0) {
					salvarArquivo(frota);
				}
				else if(opcao.compareTo("4") == 0) {
					System.out.println("Digite a placa do veiculo:");
					String placa = in.nextLine();
					Veiculo veiculo = frota.localizarVeiculo(placa);
					System.out.println("Nome: " + veiculo.getNome());
					System.out.println("Placa: " + veiculo.getPlaca());
					System.out.println("Km rodado: " + veiculo.getKmRodado() + "km");
					
				}else if(opcao.compareTo("5") == 0) {
					System.out.println("Digite a placa do veiculo:");
					String placa = in.nextLine();
					Veiculo veiculo = frota.localizarVeiculo(placa);
					veiculo.gerarRelatorio();
				}else if(opcao.compareTo("6") == 0) {
					System.out.println("Quilometragem m�dia de todas as rotas � " + frota.obterKmMedia() + "km");
				}else if(opcao.compareTo("7") == 0) {
					frota.obterVeiculosComMaisRotas();
				}else if(opcao.compareTo("8") == 0) {
					frota.obterVeiculosPorCusto();
				}else if(opcao.compareTo("9") == 0) {
					System.out.println("Digite o dia da rota:");
					int dia = Integer.parseInt(in.nextLine());
					System.out.println("Digite o m�s da rota:");
					int mes = Integer.parseInt(in.nextLine());
					System.out.println("Digite o ano da rota:");
					int ano = Integer.parseInt(in.nextLine());
					if(frota.localizarRotasPorData(new Date(ano, mes, dia)) != null) {
						for(Rota r : frota.localizarRotasPorData(new Date(ano, mes, dia))) {
							System.out.println(r.toString());
						}
					} else {
						System.out.println("N�o existe nenhuma rota nessa data!");
					}
				}else if(opcao.compareTo("0") == 0) {
					break;
				} 
				else {
					System.out.println("Op��o inv�lida!");
				}
			}
	}catch(IOException ex){
		ex.printStackTrace();
	}
	}
}
