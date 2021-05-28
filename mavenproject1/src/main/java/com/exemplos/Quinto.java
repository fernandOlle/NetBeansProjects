package com.exemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author owzi
 */
public class Quinto {

    /* FileWriter */
    
    public static void main(String[] args) {
        try {
            File arquivo = new File("/home/owzi/testePC2/ola.txt");
            FileWriter fw = new FileWriter(arquivo);
            fw.write("Teste de gravação");
            fw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
