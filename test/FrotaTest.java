import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class FrotaTest {
	

	static Carro carro;

    @Test
    public void adicaoVeiculo(){ 
    	carro = new Carro("ABC1A23", 50.00, 1);
        Frota frota = new Frota();
        frota.addVeiculo(carro);
        assertEquals(1, frota.getVeiculos().size());
    }
    

    @Test
    public void localizarCarro(){ 
    	carro = new Carro("ABC1A23", 50.00, 1);
        Frota frota = new Frota();
        frota.addVeiculo(carro);
        Veiculo v = frota.localizarVeiculo("ABC1A23");
        assertEquals("ABC1A23", v.getPlaca());
    }
    
    @Test
    public void obterVeiculos(){ 
    	carro = new Carro("ABC1A23", 50.00, 1);
        Frota frota = new Frota();
        frota.addVeiculo(carro);
        assertEquals(1, frota.getVeiculos().size());
    }



    
}