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
	static Rota rotaC;
	static Rota rotaD;
	static Rota rotaE;
	static Rota rotaF;
	static Rota rotaG;
	static Rota rotaH;
	static Rota rotaI;
	static Rota rotaJ;
	static Rota rotaK;
	static Rota rotaL;
	static Rota rotaM;
	static Rota rotaN;
	static Rota rotaO;
	static Rota rotaP;
	static Rota rotaQ;
	static Rota rotaR;
	static Rota rotaS;
	static Rota rotaT;


	

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		carroA = new Carro("ABC1A23", 50.00);
		carroB = new Carro("ABC1A24", 60.00);
		rotaA = new Rota(new Date (2022, 12, 1), "Rua 2", "Rua 3", 500);
		rotaB = new Rota(new Date (2022, 12, 2), "Rua 4", "Rua 5", 500);
		rotaC = new Rota(new Date (2022, 12, 3), "Rua 6", "Rua 7", 500);
		rotaD = new Rota(new Date (2022, 12, 4), "Rua 8", "Rua 9", 500);
		rotaE = new Rota(new Date (2022, 12, 5), "Rua 10", "Rua 10", 500);
		rotaF = new Rota(new Date (2022, 12, 6), "Rua 12", "Rua 13", 500);
		rotaG = new Rota(new Date (2022, 12, 7), "Rua 2", "Rua 3", 500);
		rotaH = new Rota(new Date (2022, 12, 8), "Rua 2", "Rua 3", 500);
		rotaI = new Rota(new Date (2022, 12, 9), "Rua 2", "Rua 3", 500);
		rotaJ = new Rota(new Date (2022, 12, 10), "Rua 2", "Rua 3", 500);
		rotaK = new Rota(new Date (2022, 12, 11), "Rua 2", "Rua 3", 500);
		rotaL = new Rota(new Date (2022, 12, 12), "Rua 2", "Rua 3", 500);
		rotaM = new Rota(new Date (2022, 12, 13), "Rua 2", "Rua 3", 500);
		rotaN = new Rota(new Date (2022, 12, 14), "Rua 2", "Rua 3", 500);
		rotaO = new Rota(new Date (2022, 12, 15), "Rua 2", "Rua 3", 500);
		rotaP = new Rota(new Date (2022, 12, 16), "Rua 2", "Rua 3", 500);
		rotaQ = new Rota(new Date (2022, 12, 17), "Rua 2", "Rua 3", 500);
		rotaR = new Rota(new Date (2022, 12, 18), "Rua 2", "Rua 3", 500);
		rotaS = new Rota(new Date (2022, 12, 19), "Rua 2", "Rua 3", 500);
		rotaT = new Rota(new Date (2022, 12, 20), "Rua 2", "Rua 3", 500);
		
	}
	
	@Test
	public void AdicionarRotaValida() {
		carroA.addRota(rotaA);
		assertEquals(1, carroA.getRotas().size());
	}
	

	@Test
	public void calcularOutrosCustosValido() {
		carroB.addRota(rotaA);
		carroB.addRota(rotaB);
		carroB.addRota(rotaC);
		carroB.addRota(rotaD);
		carroB.addRota(rotaE);
		carroB.addRota(rotaF);
		carroB.addRota(rotaG);
		carroB.addRota(rotaH);
		carroB.addRota(rotaI);
		carroB.addRota(rotaJ);
		carroB.addRota(rotaK);
		carroB.addRota(rotaL);
		carroB.addRota(rotaM);
		carroB.addRota(rotaN);
		carroB.addRota(rotaO);
		carroB.addRota(rotaP);
		carroB.addRota(rotaQ);
		carroB.addRota(rotaR);
		carroB.addRota(rotaS);
		carroB.addRota(rotaT);
		assertEquals(80, carroB.calcularOutrosCustos());
		
	}


}