package fabricaautomoveis.carros;

public interface CarroFactory {

    Carro criarCarro(Categoria categoria, String cor);
    Marca getMarcaFranquia();
    
}
