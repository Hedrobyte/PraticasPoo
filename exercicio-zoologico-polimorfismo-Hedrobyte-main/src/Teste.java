/**
 * Classe para experimentar o conceito de Polimorfismo
 */
public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal;

        animal = new Lobo("lobo 1", "cinza");
        System.out.println(animal.getDescricaoLonga());

        animal = new Galinha("galinha 1");
        System.out.println(animal.getDescricaoLonga());

        
    }
}
