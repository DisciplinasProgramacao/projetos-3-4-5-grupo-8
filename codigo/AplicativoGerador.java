
/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * App para gerar um arquivo binário de veiculos e seus pedidos.
 */
public class AplicativoGerador {
    static Random aleat = new Random(42);
    static String nomeArq = "veiculos.txt";
    static LocalDate today = LocalDate.now();
    static Date hoje = new Date();
    
    public static String gerarPlaca() {
		 Random letraPlaca = new Random();
		    Random numeroPlaca = new Random();
//	    	ABC1D23
	    	 String alphabet = "ABCDEFGHIJKLMNOPQRSTUV";
	    	 char letra1 = alphabet.charAt(letraPlaca.nextInt(alphabet.length()));
	    	 char letra2 = alphabet.charAt(letraPlaca.nextInt(alphabet.length()));
	    	 char letra3 = alphabet.charAt(letraPlaca.nextInt(alphabet.length()));
	    	 char letra4 = alphabet.charAt(letraPlaca.nextInt(alphabet.length()));
	    	 
	    	 int numero1 = numeroPlaca.nextInt(10);
	    	 int numero2 = numeroPlaca.nextInt(10);
	    	 int numero3 = numeroPlaca.nextInt(10);
	    	 
	    	 return "" + letra1 + "" + letra2 + "" + letra3 + "" + numero1 + "" + letra4 + "" + numero2 + "" + numero3;
	    }

    /**
     * Gravação serializada do conjunto de veiculos
     * 
     * @param veiculos Conjunto de veiculos a salvar
     * @throws IOException Em caso de erro na escrita ou abertura do arquivo
     *                     (propagação de exceção)
     */
    public static void gravarDados(Set<Frota> frotas) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("tudo.bin"));
        for (Frota f : frotas) {
            obj.writeObject(f);
        }
        obj.close();
    }

    /**
     * Carrega dados do arquivo de veiculos serialiado. Tratamento de diversas
     * exceções
     * 
     * @return Um TreeSet com os veiculos e seus pedidos
     */

    public static Set<Veiculo> carregarDados() throws IOException, ClassNotFoundException {
        FileInputStream dados = new FileInputStream("tudo.bin");
        ObjectInputStream obj = new ObjectInputStream(dados);
        TreeSet<Veiculo> todos = new TreeSet<>();

        while (dados.available() != 0) {
            Veiculo novo = (Veiculo) obj.readObject();
            todos.add(novo);
        }
        obj.close();
        return todos;
    }

    /**
     * Carrega o arquivo de veiculos em um tree map
     * 
     * @param nomeArq Arquivo com os veiculos
     * @return HashMap com o nome como chave e o veiculo como valor
     * @throws IOException Arquivo não encontrado
     */
    private static TreeSet<Frota> carregarFrota(String nomeArq) throws IOException {
        Scanner leitor = new Scanner(new File(nomeArq), "UTF-8");
        TreeSet<Frota> frota = new TreeSet<>();
        Frota novo = new Frota();
        while (leitor.hasNextLine()) {
            String nome = leitor.nextLine();
            novo.addVeiculo(criarVeiculo(nome));
        }
        frota.add(novo);
        leitor.close();
        return frota;
    }
    
    /**
     * Cria uma rota com data, origem, destibo
     * 
     * @param quantasComidas Quantidade de itens do pedido
     * @return Pedido com diversas comidas aleatórias
     */
    public static Rota criarRota() {
    	Random random = new Random();
    	
    	int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
    	int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
    	long randomDay = minDay + random.nextInt(maxDay - minDay);
    	Random rua = new Random();
    	String alphabet = "ABCDEFGHIJKLMNOPQRSTUV";
    	String origem = "Rua " + alphabet.charAt(rua.nextInt(alphabet.length()));
    	String destino = "Rua " + alphabet.charAt(rua.nextInt(alphabet.length()));
    	Date randomDate = new Date(randomDay);
        
        Rota nova = new Rota(randomDate, origem, destino, 10);
        
        return nova;
    }

    /**
     * Cria uma refeição aleatoriamente (pizza ou sanduíche) com ingredientes
     * aleatórios
     * 
     * @return Comida com ingredientes
     */
    public static Veiculo criarVeiculo(String nome) {
        Veiculo novo = null;
        Random random = new Random();
        double precoVenda = 0.00;
        int quantos = aleat.nextInt(3);
        String placaVeiculo = "";

        switch (nome) {
            case "carro":
            	placaVeiculo = gerarPlaca();
            	precoVenda = random.nextInt(100000 - 20000 + 1) + 20000;
            	novo = new Carro(placaVeiculo, precoVenda, 1);
                break;
            case "van":
            	placaVeiculo = gerarPlaca();
            	precoVenda = random.nextInt(100000 - 20000 + 1) + 20000;
            	novo = new Van(placaVeiculo, precoVenda, 1);
                break;
            case "furgao":
            	placaVeiculo = gerarPlaca();
            	precoVenda = random.nextInt(100000 - 20000 + 1) + 20000;
            	novo = new Furgao(placaVeiculo, precoVenda, 1);
                break;
            case "caminhao":
            	placaVeiculo = gerarPlaca();
            	precoVenda = random.nextInt(100000 - 20000 + 1) + 20000;
            	novo = new Caminhao(placaVeiculo, precoVenda, 3);
                break;    
        }
        
        for (int i = 0; i < quantos; i++) {
            novo.addRota(criarRota());
        }
        
        return novo;
    }

    /**
     * Utilizade para 'limpar' o console (terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        TreeSet<Frota> todaFrota = (TreeSet<Frota>) carregarFrota("frota.txt");
        gravarDados(todaFrota);
        System.out.println("FIM");
        teclado.close();
    }

}
