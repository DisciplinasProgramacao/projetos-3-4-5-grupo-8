import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrotaTest {
	Carro carro1;
	Carro carro2 = new Carro("FRO321" , 30993.99);	
	Frota frota;
	ArrayList<Veiculo> arrayveiculo = new ArrayList<Veiculo>();
	
	@BeforeEach
	void criaFrota() {
		carro1 = new Carro("DEF123" , 30999.99);
		arrayveiculo.add(carro1);
		frota = new Frota(arrayveiculo);
	}
	
	@Test
	void testRetornoVeiculos() {		
		frota.getVeiculos();
	}
	
	@Test
	void testAdcionaVeiculos() {	
		frota.addVeiculo(carro2);
	}	
	
	@Test
	void testLocalizaVeiculos() {	
		frota.localizarVeiculo("DEF123");
	}
}
