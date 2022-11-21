import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Frota {
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
		for (Veiculo v : this.veiculos) {
			if (v.placa.equals(placa)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Obtem a quilometragem media de todas as rotas da empresa
	 */
	public double obterKmMedia() {
		double kmMedia = 0;
		int qtdRotas = 0;
		for (Veiculo v : this.veiculos) {
			for (Rota r : v.rotas) {
				kmMedia += r.getDistancia();
				qtdRotas++;
			}
		}
		return kmMedia / qtdRotas;
	}

	/**
	 * Obtem os 3 veiculos que mais fizeram rotas
	 */
	public void obterVeiculosComMaisRotas() {
		ArrayList<String> veiculosComMaisRotas = new ArrayList<String>();
		for (Veiculo v : this.veiculos) {
			if (v.rotas.size() > 0) {
				veiculosComMaisRotas.add("Número de Rotas - " + v.rotas.size() + "\n" + "Placa - " + v.placa);
			}

		}
		Collections.sort(veiculosComMaisRotas, Collections.reverseOrder());
		for (int i = 0; i < 3; i++) {
			System.out.println(veiculosComMaisRotas.get(i));
			System.out.println("");
		}
	}
	
	/**
	 * Obtem os veiculos por ordem decrescente de custos totais
	 */
	public void obterVeiculosPorCusto() {
		ArrayList<String> veiculosPorCusto = new ArrayList<String>();
		for (Veiculo v : this.veiculos) {
				veiculosPorCusto.add("Custos Totais - R$" + v.calcularCustosTotais() + "\n" + "Placa - " + v.placa);

		}
		Collections.sort(veiculosPorCusto, Collections.reverseOrder());
		for (int i = 0; i < 3; i++) {
			System.out.println(veiculosPorCusto.get(i));
			System.out.println("");
		}
	}
	
	/**
	 * Localiza rotas por data
	 */
	public ArrayList<Rota> localizarRotasPorData(Date data) {
		ArrayList<Rota> rotas = new ArrayList<Rota>();
		for (Veiculo v : this.veiculos) {
			for (Rota r : v.rotas) {
				if(data.compareTo(r.getData()) == 0) {
					rotas.add(r);
				}
			}
		}
		
		if(rotas.size() > 0) {
			return rotas;
		}
		
		return null;
	}
}
