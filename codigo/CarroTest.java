import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarroTest {

	static Carro carroA;
	static Carro carroB;
	static Rota rotaA;
	static Rota rotaB;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		carroA = new Carro("ABC1A23", 50.00);
		carroB = new Carro("ABC1A24", 60.00);
		rotaA = new Rota(new Date (2022, 12, 26), "Rua 2", "Rua 3", 50);
		rotaB = new Rota(new Date (2022, 12, 26), "Rua 2", "Rua 3", 2000);
	}
	
	@Test
	public void AdicionarRotaValida() {
		carroA.addRota(rotaA);
		assertEquals(1, carroA.getRotas().size());
	}
	

	@Test
	public void calcularOutrosCustosValido() {
		carroB.addRota(rotaB);
		assertEquals(160, carroB.calcularOutrosCustos());
	}


}