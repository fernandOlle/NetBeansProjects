/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

public class Exercicio05 {

    public static void main(String[] args) {
        Matematica mat = new Matematica();
        mat.setValor(10);
        mat.dobra();
        if (mat.getValor() != 20) {
            System.out.println(" --- Erro, método dobra() não funciona");
            System.exit(1);
        }
        mat.setValor(34);
        mat.quadruplica();
        if (mat.getValor() != 136) {
            System.out.println(" --- Erro, método quadruplica() não funciona");
            System.exit(2);
        }
        mat.soma(4);
        if (mat.getValor() != 140) {
            System.out.println(" --- Erro, método soma(int) não funciona");
            System.exit(3);
        }
        System.out.println(" --- Todos os testes foram bem sucedidos!");
    }
}
