package exercicios;

public class Exercicio01 {

    public String inverte(String param) {
        StringBuilder sb = new StringBuilder();
        for (int i = param.length() - 1; i >= 0; i--) {
            sb.append(param.charAt(i));
        }
        return sb.toString(); 
// qual o maior valor de i? i tem o comprimento da string passada
    }

    public static void main(String[] args) {
        String msg = "abc teste ovo";
        Exercicio01 ts = new Exercicio01();
        System.out.printf("Msg [%s]\n", ts.inverte(msg)); 
// Qual resultado na console? é a string invertida
    }

}

