import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VanTest {

	static Van vanA;
	static Van vanB;
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
		vanA = new Van("ABC1A23", 50.00, 1);
		vanB = new Van("ABC1A24", 60.00, 1);
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
		vanA.addRota(rotaA);
		assertEquals(1, vanA.getRotas().size());
	}
	

	@Test
	public void calcularOutrosCustosValido() {
		vanB.addRota(rotaA);
		vanB.addRota(rotaB);
		vanB.addRota(rotaC);
		vanB.addRota(rotaD);
		vanB.addRota(rotaE);
		vanB.addRota(rotaF);
		vanB.addRota(rotaG);
		vanB.addRota(rotaH);
		vanB.addRota(rotaI);
		vanB.addRota(rotaJ);
		vanB.addRota(rotaK);
		vanB.addRota(rotaL);
		vanB.addRota(rotaM);
		vanB.addRota(rotaN);
		vanB.addRota(rotaO);
		vanB.addRota(rotaP);
		vanB.addRota(rotaQ);
		vanB.addRota(rotaR);
		vanB.addRota(rotaS);
		vanB.addRota(rotaT);
		assertEquals(620, vanB.calcularOutrosCustos());
		
	}


}