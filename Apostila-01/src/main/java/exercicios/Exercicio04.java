/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

public class Exercicio04 {

    public int processaValor(int val) {
        int temp1 = val + 20;
        int temp2 = temp1 * 9;
        int temp3 = temp2 + temp1 * 3;
        int temp4 = temp3 % temp2;
        return temp4; 
// Qual os valores de temp1, temp2, temp3 e temp4? 35, 315, 420, 105
    }

    public static void main(String[] args) {
        int temp1 = 15;
        Exercicio04 exercicio = new Exercicio04();
        int temp2 = exercicio.processaValor(temp1);
        System.out.printf("Exercicio 3: %d\n", temp2);
        /* Qual o valor de temp1 e temp2? 15, 105 */ 
    }
}
