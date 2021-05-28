package exercicios;

public class Exercicio02 {

    public static void main(String[] args) {
        System.out.printf("\n------ \n");
        int x = 9;
        int y = 26;
        label:
        for (int z = 0; z < 6; z++, y--) {
            if (x > 2) {
                x--;
            }
            if (x > 5) {
                System.out.printf("%d ", x);
                --x;
                continue label;
            }
            x--; 
// Quantas vezes o código passa por aqui? (Use o debug passo a passo) 4
        }
// Qual o valor da variável x e da variável y neste ponto? (Use o debug passo a passo) -1, 20

        System.out.printf("\n------ \n");
    }
}
