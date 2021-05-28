/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

public class Exercicio06 {
    public static void main(String[] args) {
        int c =9;
        try {
            c = c + 1;
            while (c < 14) {
                if (c == 13) {
                   throw new Exception();
                }
                c = c + 3;
            }
        } catch (Exception e) {
            c = c + 5;
        } finally {
            c = c + 6;
        }
        System.out.println("Valor= " + c);
    }
}
// resposta 9
