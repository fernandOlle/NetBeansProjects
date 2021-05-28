/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio02;
    
public class SempreFinally {

    public static void main(String[] args) {
        System.out.println(" ---- ");
        System.out.println("Entrando no primeiro bloco TRY");
        try {
            System.out.println("Entrando no segundo bloco TRY");
            try {
                throw new MinhaException();
            } finally {
                System.out.println("FINALLY do segundo bloco TRY");
            }
        } catch (MinhaException e) {
            System.out.println("Capturando MinhaException no primeiro bloco TRY");
        } finally {
            System.out.println("FINALLY do primeiro bloco TRY");
            System.out.println(" ---- ");
        }
    }
}

/* 
    Foi impresso exatamente o esperado, 
    e eu concordo com o resultado pois 
    deve levar em conta que o a classe
    MinhaException não implementou nem
    um metodo.
*/