import corredores.Competidor;

public class Corredor implements Competidor {
    String nome;
    int velocidade;
    int distanciaDaCorrida;
    int distanciaPercorrida;

    public Corredor(String nome, int velocidade) {
        this.nome = nome;
        this.velocidade = velocidade;
        distanciaPercorrida = 0;
    }

    @Override
    public void run() {
        while (getDistanciaPercorrida() < distanciaDaCorrida) { 
            try {
                distanciaPercorrida += velocidade;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public boolean estaCorrendo() {
        return true;
    }

    @Override
    public void prepararParaNovaCorrida(int distanciaDaCorrida) {
        this.distanciaDaCorrida = distanciaDaCorrida;
    }
}