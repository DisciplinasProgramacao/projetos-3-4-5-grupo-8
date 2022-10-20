import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotaTest {
	Date hoje = new Date();
	Rota rota;
	
	@BeforeEach
	void criaRota() {
		rota = new Rota(hoje , "BH" , "Rio" , 426.70);
	}

	@Test
	void testCriacaoRota() {		
		assertEquals(426.70 , rota.getDistancia());
		assertEquals("BH" , rota.getOrigem());
		assertEquals("Rio" , rota.getDestino());
	}
	
	@Test
	void testSetDistancia() {
		rota.setDistancia(480.48);
		assertEquals(480.48 , rota.getDistancia());
	}
	
	@Test
	void testSetOrigem() {
		rota.setOrigem("Florianópolis");
		assertEquals("Florianópolis" , rota.getOrigem());
	}
	
	@Test
	void testSetDestino() {
		rota.setDestino("Fortaleza");
		assertEquals("Fortaleza" , rota.getDestino());
	}
	
}
	
