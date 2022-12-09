public class FabricaVan {
	static Van criar(String placa, double precoVenda, int tipoCombustivel){
           return new Van(placa, precoVenda, tipoCombustivel);
    }   
}
