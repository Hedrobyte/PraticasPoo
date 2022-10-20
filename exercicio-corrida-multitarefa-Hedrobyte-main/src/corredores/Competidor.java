package corredores;

/*
 * Interface que define um contrato para um competidor de corridas
 * 
 * Repare que esta interface estende a interface `Runnable`. Isso significa
 * que um classe concreta que implemente a interface `Competidor` deverá 
 * sobrescrever os métodos definidos aqui e também os métodos definidos na
 * interface `Runnable`.
 */
public interface Competidor extends Runnable {
    // Nome do competidor
    String getNome();
    // Velocidade do competidor em metros por segundo
    int getVelocidade();
    // Distância (em metros) percorrida pelo competidor desde o início da corrida
    int getDistanciaPercorrida();
    // Indica se o competidor está correndo ou não
    boolean estaCorrendo();
    // Prepara o competidor para uma nova corrida, informando a distância (em metros) a ser percorrida
    void prepararParaNovaCorrida(int distanciaDaCorrida);
}