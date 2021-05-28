package com.exemplos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author owzi
 */
public class Sexto {
    
    /* RandomAccessFile */
    
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("/home/owzi/testePC2/ola.txt", "rw");
            raf.writeChars("Olá Pessoal\n");
            raf.seek(0);
            String linha = null;
            while ((linha = raf.readLine()) != null) {
                System.out.println("Arquivo: " + linha);
            }
            System.out.println(" ---- ");
            raf.seek(0);
            raf.writeChars("Gravei no inicio\n");
            raf.seek(0);
            while ((linha = raf.readLine()) != null) {
                System.out.println("Arquivo: " + linha);
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
