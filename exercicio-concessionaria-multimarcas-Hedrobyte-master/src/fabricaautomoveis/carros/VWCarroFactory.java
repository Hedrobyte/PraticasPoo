package fabricaautomoveis.carros;

public class VWCarroFactory implements CarroFactory{

    private Marca marcaFranquia;

    public VWCarroFactory(){
        marcaFranquia = Marca.VW;
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Saveiro(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Arteon(cor);
        }
        return carro;  
    }
    
    @Override
    public Marca getMarcaFranquia(){
        return marcaFranquia;
    }
    
}
