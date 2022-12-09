public class FabricaFurgao {
	static Furgao criar(String placa, double precoVenda, int tipoCombustivel){
           return new Furgao(placa, precoVenda, tipoCombustivel);
    }   
}
