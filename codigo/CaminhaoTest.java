import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaminhaoTest {

	static Furgao caminhaoA;
	static Carro caminhaoB;
	static Rota rotaA;
	static Rota rotaB;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		caminhaoA = new Furgao("ABC1A23", 50.00);
		caminhaoB = new Carro("ABC1A24", 60.00);
		rotaA = new Rota(new Date (2022, 12, 26), "Rua 2", "Rua 3", 50);
		rotaB = new Rota(new Date (2022, 12, 26), "Rua 2", "Rua 3", 2000);
	}
	
	@Test
	public void AdicionarRotaValida() {
		caminhaoA.addRota(rotaA);
		assertEquals(1, caminhaoA.getRotas().size());
	}
	

	@Test
	public void calcularOutrosCustosValido() {
		caminhaoB.addRota(rotaB);
		assertEquals(160, caminhaoB.calcularOutrosCustos());
	}


}