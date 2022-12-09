
public class FabricaCaminhao {
	static Caminhao criar(String placa, double precoVenda, int tipoCombustivel){
           return new Caminhao(placa, precoVenda, tipoCombustivel);
    }   
}
