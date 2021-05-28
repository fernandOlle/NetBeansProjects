package com.pessoa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author owzi
 */
public class ProgramOutput {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1201);
        pessoa.setNome("João");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/owzi/testePC2/objetopersistido.obj"))) {
            // oos.writeObject("Gravando objeto\n");
            oos.writeObject(pessoa);
            oos.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) { }
    }
}
