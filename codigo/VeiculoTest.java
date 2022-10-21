import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VeiculoTest {
	Caminhao caminhao;
	Carro carro;
	Furgao furgao;
	Van van;

	@BeforeEach
	public void criaVeiculo() {
		caminhao = new Caminhao("ABC123" , 700999.99);
		carro = new Carro("DEF123" , 30999.99);
		furgao = new Furgao("GHI123" , 60999.99);
		van = new Van("JKL123" , 90999.99);
		
	}
	
	@Test
	void testCriaCarro() {
		assertEquals("" , carro.getNome());
		assertEquals("DEF123" , carro.getPlaca());
		assertEquals(30999.99 , carro.getValorDeVenda());
		assertEquals(0 , carro.getKmRodado());
		assertTrue(carro.getRotas().isEmpty());
		assertEquals(0.05 , Carro.TAXA_SEGURO);
		assertEquals(300 , Carro.SEGURO_ADICIONAL);
		assertEquals(0.04 , Carro.TAXA_IPVA);
		assertEquals(10 , Carro.KMMEDIOPORLITRO);
		assertEquals(50 , Carro.CAPACIDADE_TANQUE);
	}
	
	@Test
	void testCriaCaminhao() {
		assertEquals("" , caminhao.getNome());
		assertEquals("ABC123" , caminhao.getPlaca());
		assertEquals(700999.99 , caminhao.getValorDeVenda());
		assertEquals(0 , caminhao.getKmRodado());
		assertTrue(caminhao.getRotas().isEmpty());
		assertEquals(0.02 , Caminhao.TAXA_SEGURO);
		assertEquals(2000.00 , Caminhao.SEGURO_ADICIONAL);
		assertEquals(0.01 , Caminhao.TAXA_IPVA);
		assertEquals(2.5 , Caminhao.KMMEDIOPORLITRO);
		assertEquals(400 , Caminhao.CAPACIDADE_TANQUE);
	}
	
	@Test
	void testCriaFurgao() {
		assertEquals("" , furgao.getNome());
		assertEquals("GHI123" , furgao.getPlaca());
		assertEquals(60999.99 , furgao.getValorDeVenda());
		assertEquals(0 , furgao.getKmRodado());
		assertTrue(furgao.getRotas().isEmpty());
		assertEquals(0.03 , Furgao.TAXA_SEGURO);
		assertEquals(0.03 , Furgao.TAXA_IPVA);
		assertEquals(5 , Furgao.KMMEDIOPORLITRO);
		assertEquals(80 , Furgao.CAPACIDADE_TANQUE);
	}
	
	@Test
	void testCriaVan() {
		assertEquals("" , van.getNome());
		assertEquals("JKL123" , van.getPlaca());
		assertEquals(90999.99 , van.getValorDeVenda());
		assertEquals(0 , van.getKmRodado());
		assertTrue(van.getRotas().isEmpty());
		assertEquals(0.03 , Van.TAXA_SEGURO);
		assertEquals(0.03 , Van.TAXA_IPVA);
		assertEquals(10 , Van.KMMEDIOPORLITRO);
		assertEquals(60 , Van.CAPACIDADE_TANQUE);
	}

	@Test
	void testSetKmRodado() {
		carro.setKmRodado(110.50);
		assertEquals(110.50 , carro.getKmRodado());
	}
	
	@Test
	void testSetNome() {
		carro.setNome("carro");
		assertEquals("carro" , carro.getNome());
	}
	
	@Test 
	void testSetPlaca() {
		carro.setPlaca("ABB123");
		assertEquals("ABB123" , carro.getPlaca());
	}
	
	@Test
	void testSetValorDeVenda() {
		carro.setValorDeVenda(40990.00);
		assertEquals(40990.00 , carro.getValorDeVenda());
	}

}
