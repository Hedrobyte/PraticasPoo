package fabricaautomoveis.carros;

public class FIATCarroFactory implements CarroFactory {
    private Marca marcaFranquia;

    public FIATCarroFactory() {
        marcaFranquia = Marca.FIAT;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;

        if (categoria == Categoria.POPULAR) {
            carro = new Uno(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Strada(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Toro(cor);
        }

        return carro;
    }
    
    @Override
    public Marca getMarcaFranquia(){
        return marcaFranquia;
    }
    
}
