package exercicios;

public class Exercicio03 {

    public static void main(String[] args) {
        int x = 12;
        int i = 0;
        fim:
        while (i < 10) {
            i++;
            x--;
            if (i == 4) {
                break fim;
            }
        }
        switch (x) { 
// Qual o valor de x e de i? (Use o debug passo a passo) 8 e 4
            case 8:
                System.out.println("8 ");
            case 7:
                System.out.println("7 ");
                /* Este comando será executado? sim  */
                break;
            default:
                System.out.println("--- Default ---");
        }
    } 
// Qual foi o resultado na janela de Output? 8\n7
}
