package exercicio.o1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author owzi
 */
public class terceiro {

    public static void main(String[] args) {
        File f = new File("/home/owzi/PCTEST2/ola.txt");
        if (f.exists()) {
            System.out.println("Já existe um diretório ou arquivo com este nome");
        } else {
            try {
                if (f.createNewFile()) {
                    System.out.println("Arquivo criado com sucesso");
                } else {
                    System.out.println("Falha na criação do arquivo");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
