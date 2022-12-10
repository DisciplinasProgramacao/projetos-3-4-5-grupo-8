import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Frota implements Comparable<Frota>, Serializable {
	private ArrayList<Veiculo> veiculos;

	/**
	 * @param veiculos
	 */
	public Frota(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	/**
	 * 
	 */
	public Frota() {
		this.veiculos = new ArrayList<Veiculo>();
	}

	/**
	 * retorna veiculos de uma frota
	 */
	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	/**
	 * @param veiculos
	 */
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	/**
	 * Adiciona veiculo a uma frota
	 */
	public void addVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}

	/**
	 * Localiza veiculo presente em uma frota a partir de sua placa
	 */
	public Veiculo localizarVeiculo(String placa) {
		return this.veiculos.stream().filter(v -> v.getPlaca().equals(placa))
		.findAny()
		.orElse(null);
	}

	/**
	 * Obtem a quilometragem media de todas as rotas da empresa
	 */
	public double obterKmMedia() {
		int qtdRotas = this.veiculos.stream().mapToInt(v -> v.quantidadeRotas()).sum();
		
		double kmMedia = this.veiculos.stream().mapToDouble(v -> v.getKmRodado()).sum();
		
		return kmMedia / qtdRotas;
	}

	/**
	 * Obtem os 3 veiculos que mais fizeram rotas
	 */
	public void obterVeiculosComMaisRotas() {
		this.veiculos.stream().filter(v -> v.quantidadeRotas() > 0).sorted(Comparator.comparing(Veiculo::quantidadeRotas)).limit(3).forEach((Veiculo v) -> {
			System.out.println("Número de Rotas - " + v.rotas.size() + "\n" + "Placa - " + v.placa);
			System.out.println("");
		});
	}
	
	/**
	 * Obtem os veiculos por ordem decrescente de custos totais
	 */
	public void obterVeiculosPorCusto() {
		this.veiculos.stream().sorted(Comparator.comparing(Veiculo::calcularCustosTotais).reversed()).forEach((Veiculo v) -> {
			System.out.println("Custos Totais - R$ " + String.format("%.2f", v.calcularCustosTotais()) + "\n" + "Placa - " + v.placa);
			System.out.println("");
		});
	}
	
	/**
	 * Localiza rotas por data
	 */
	public ArrayList<Rota> localizarRotasPorData(Date data) {
		ArrayList<Rota> rotas = new ArrayList<Rota>();
		this.veiculos.stream().filter(v -> v.quantidadeRotas() > 0).forEach((Veiculo v) -> {
			v.rotas.stream().filter(r -> data.compareTo(r.getData()) == 0).forEach((Rota r) -> {
				rotas.add(r);
			});
		});
		
		return rotas;
	}

	@Override
	public int compareTo(Frota o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
