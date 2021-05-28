package com.pessoa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author owzi
 */
public class ProgramInput {

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/owzi/testePC2/objetopersistido.obj"))) {
           // String s;
           // s = (String) ois.readObject();
            Pessoa p1 = (Pessoa) ois.readObject();
           // System.out.println("Isso foi é um " + s);
            System.out.println("Id da Pessoa: " + p1.getId());
            System.out.println("Nome da Pessoa: " + p1.getNome());
            System.out.println("Count da Pessoa: " + p1.getCount());
            ois.close();
        } catch (ClassNotFoundException | IOException ex) { }
    }
}
