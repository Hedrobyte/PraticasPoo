/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.CarroFactory;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.ChevroletCarroFactory;
import fabricaautomoveis.carros.FIATCarroFactory;
import fabricaautomoveis.carros.VWCarroFactory;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {
   
    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {

        CarroFactory factory = new ChevroletCarroFactory();
        ppooVeiculos = new Concessionaria("PPOO Veículos",factory);
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    mudarFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar Franquia");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }

    private void mudarFranquia(){
        System.out.println("Escolha a franquia desejeda (1: Chevrolet, 2: VW, 3:Fiat ): ");
        CarroFactory franquia = franquiaCarro( Integer.parseInt(entrada.nextLine()));
        if (franquia != null){
            ppooVeiculos.mudarMarcaFranquia(franquia);
        }
        else{
            System.out.println("Sinto muito, não temos essa opção de franquia!");
        }

        esperarTecla();
    }

    private CarroFactory franquiaCarro(int opcaoFranquia){
        CarroFactory franquia = null;
        if (opcaoFranquia == 1){
            franquia = new ChevroletCarroFactory();
        }
        else if (opcaoFranquia == 2){
            franquia = new VWCarroFactory();
        }
        else if (opcaoFranquia == 3){
            franquia = new FIATCarroFactory();
        } 
        return franquia;
    }

}

