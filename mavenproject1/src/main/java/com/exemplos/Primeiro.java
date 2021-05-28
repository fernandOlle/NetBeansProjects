package com.exemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author owzi
 */
public class Primeiro {
    
    /* FileOutputStream */

    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            File arquivo = new File("/home/owzi/testePC2/ola2.txt");
            fos = new FileOutputStream(arquivo);
            byte[] dados = "Teste de gravação".getBytes();
            fos.write(dados);
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
