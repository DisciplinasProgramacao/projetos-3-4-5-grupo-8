import javax.management.InvalidAttributeValueException;

public class FabricaVeiculo {
	static Veiculo criarVeiculo(String tipo, String placa, double precoVenda, int tipoCombustivel) throws InvalidAttributeValueException{
        switch (tipo.toLowerCase()){
            case "carro": return new Carro(placa, precoVenda, tipoCombustivel);
            case "van": return new Van(placa, precoVenda, tipoCombustivel);
            case "caminhao": return new Caminhao(placa, precoVenda, tipoCombustivel);
            case "furgao": return new Furgao(placa, precoVenda, tipoCombustivel);
            default: throw new InvalidAttributeValueException("Tipo de veiculo inexistente");
        }
    }   
}
