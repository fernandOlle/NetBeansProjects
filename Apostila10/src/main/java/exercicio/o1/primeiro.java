package exercicio.o1;

import java.io.File;

/**
 *
 * @author owzi
 */
public class primeiro {

    public static void main(String[] args) {
        File caminho = new File("/home/owzi/Documents/work/fileTerinamento");
        File[] lista;
        lista = caminho.listFiles();
        System.out.println("Path: " + caminho.getAbsolutePath());
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].isDirectory()) {
                System.out.println("\t Diretorio: " + lista[i].getName());
            } else {
                System.out.println("\t Arquivo: " + lista[i].getName() + " Tamanho(bytes): " + lista[i].length());
            }
        }
    }
}
