package com.exemplos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author owzi
 */
public class Terceiro {
    
    /* DataOutputStream */
    
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            File arquivo = new File("/home/owzi/testePC2/ola.txt");
            dos = new DataOutputStream(new FileOutputStream(arquivo));
            dos.writeUTF("Teste de gravação");
            dos.writeDouble(12375.564);
            dos.writeInt(76849224);
            dos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
