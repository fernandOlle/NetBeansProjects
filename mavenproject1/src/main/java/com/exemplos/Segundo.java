package com.exemplos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author owzi
 */
public class Segundo {
    
    /* FileInputStream */

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            File arquivo = new File("/home/owzi/testePC2/ola2.txt");
            fis = new FileInputStream(arquivo);
            int leitura = -1;
            do {
                leitura = fis.read();
                if (leitura != -1) {
                    System.out.println(leitura + " " + (char) leitura);
                }
            } while (leitura != -1);
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
