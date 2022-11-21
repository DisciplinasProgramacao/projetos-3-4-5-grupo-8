import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaminhaoTest {

	static Caminhao caminhaoA;
	static Caminhao caminhaoB;
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
	static Rota rotaU;
	static Rota rotaV;
	static Rota rotaW;
	static Rota rotaX;


	

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		caminhaoA = new Caminhao ("ABC1A23", 50.00, 3);
		caminhaoB = new Caminhao ("ABC1A24", 60.00, 3);
		rotaA = new Rota(new Date (2022, 12, 1), "Rua 2", "Rua 3", 1250);
		rotaB = new Rota(new Date (2022, 12, 2), "Rua 4", "Rua 5", 1250);
		rotaC = new Rota(new Date (2022, 12, 3), "Rua 6", "Rua 7", 1250);
		rotaD = new Rota(new Date (2022, 12, 4), "Rua 8", "Rua 9", 1250);
		rotaE = new Rota(new Date (2022, 12, 5), "Rua 10", "Rua 10", 1250);
		rotaF = new Rota(new Date (2022, 12, 6), "Rua 12", "Rua 13", 1250);
		rotaG = new Rota(new Date (2022, 12, 7), "Rua 2", "Rua 3", 1250);
		rotaH = new Rota(new Date (2022, 12, 8), "Rua 2", "Rua 3", 1250);
		rotaI = new Rota(new Date (2022, 12, 9), "Rua 2", "Rua 3", 1250);
		rotaJ = new Rota(new Date (2022, 12, 10), "Rua 2", "Rua 3", 1250);
		rotaK = new Rota(new Date (2022, 12, 11), "Rua 2", "Rua 3", 1250);
		rotaL = new Rota(new Date (2022, 12, 12), "Rua 2", "Rua 3", 1250);
		rotaM = new Rota(new Date (2022, 12, 13), "Rua 2", "Rua 3", 1250);
		rotaN = new Rota(new Date (2022, 12, 14), "Rua 2", "Rua 3", 1250);
		rotaO = new Rota(new Date (2022, 12, 15), "Rua 2", "Rua 3", 1250);
		rotaP = new Rota(new Date (2022, 12, 16), "Rua 2", "Rua 3", 1250);
		rotaQ = new Rota(new Date (2022, 12, 17), "Rua 2", "Rua 3", 1250);
		rotaR = new Rota(new Date (2022, 12, 18), "Rua 2", "Rua 3", 1250);
		rotaS = new Rota(new Date (2022, 12, 19), "Rua 2", "Rua 3", 1250);
		rotaT = new Rota(new Date (2022, 12, 20), "Rua 2", "Rua 3", 1250);
		rotaU = new Rota(new Date (2022, 12, 20), "Rua 2", "Rua 3", 1250);
		rotaV = new Rota(new Date (2022, 12, 20), "Rua 2", "Rua 3", 1250);
		rotaW = new Rota(new Date (2022, 12, 20), "Rua 2", "Rua 3", 1250);
		rotaX = new Rota(new Date (2022, 12, 20), "Rua 2", "Rua 3", 1250);
		
	}
	
	@Test
	public void AdicionarRotaValida() {
		caminhaoA.addRota(rotaA);
		assertEquals(1, caminhaoA.getRotas().size());
	}
	

	@Test
	public void calcularOutrosCustosValido() {
		caminhaoB.addRota(rotaA);
		caminhaoB.addRota(rotaB);
		caminhaoB.addRota(rotaC);
		caminhaoB.addRota(rotaD);
		caminhaoB.addRota(rotaE);
		caminhaoB.addRota(rotaF);
		caminhaoB.addRota(rotaG);
		caminhaoB.addRota(rotaH);
		caminhaoB.addRota(rotaI);
		caminhaoB.addRota(rotaJ);
		caminhaoB.addRota(rotaK);
		caminhaoB.addRota(rotaL);
		caminhaoB.addRota(rotaM);
		caminhaoB.addRota(rotaN);
		caminhaoB.addRota(rotaO);
		caminhaoB.addRota(rotaP);
		caminhaoB.addRota(rotaQ);
		caminhaoB.addRota(rotaR);
		caminhaoB.addRota(rotaS);
		caminhaoB.addRota(rotaT);
		caminhaoB.addRota(rotaU);
		caminhaoB.addRota(rotaV);
		caminhaoB.addRota(rotaW);
		caminhaoB.addRota(rotaX);
		System.out.println(caminhaoB.kmRodado);
		assertEquals(1000, caminhaoB.calcularOutrosCustos());
		
	}


}