import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FurgaoTest {

	static Furgao furgaoA;
	static Carro furgaoB;
	static Rota rotaA;
	static Rota rotaB;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		furgaoA = new Furgao("ABC1A23", 50.00);
		furgaoB = new Carro("ABC1A24", 60.00);
		rotaA = new Rota(new Date (2022, 12, 26), "Rua 2", "Rua 3", 50);
		rotaB = new Rota(new Date (2022, 12, 26), "Rua 2", "Rua 3", 2000);
	}
	
	@Test
	public void AdicionarRotaValida() {
		furgaoA.addRota(rotaA);
		assertEquals(1, furgaoA.getRotas().size());
	}
	

	@Test
	public void calcularOutrosCustosValido() {
		furgaoB.addRota(rotaB);
		assertEquals(160, furgaoB.calcularOutrosCustos());
	}


}