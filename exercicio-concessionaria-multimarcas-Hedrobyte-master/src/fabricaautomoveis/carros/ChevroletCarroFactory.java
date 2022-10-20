package fabricaautomoveis.carros;

public class ChevroletCarroFactory implements CarroFactory {
    private Marca marcaFranquia;

    public ChevroletCarroFactory() {
        marcaFranquia = Marca.CHEVROLET;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;

        if (categoria == Categoria.POPULAR) {
            carro = new Corsa(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Montana(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Corsa(cor);
        }

        return carro;
    }

    @Override
    public Marca getMarcaFranquia(){
        return marcaFranquia;
    }
    
}
