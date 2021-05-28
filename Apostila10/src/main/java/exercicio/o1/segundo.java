package exercicio.o1;

import java.io.File;

/**
 *
 * @author owzi
 */
public class segundo {

    public static void main(String[] args) {
        File f = new File("/PCTEST2");
        if (f.exists()) {
            System.out.println("Já existe um diretório ou arquivo com este nome");
        } else {
            if (f.mkdir()) {
                System.out.println("Diretorio criado com sucesso");
            } else {
                System.out.println("Falha na criação do diretório");
            }
        }
    }
}
