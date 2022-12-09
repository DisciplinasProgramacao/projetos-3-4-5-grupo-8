public class FabricaCarro {
	static Carro criar(String placa, double precoVenda, int tipoCombustivel){
           return new Carro(placa, precoVenda, tipoCombustivel);
    }   
}