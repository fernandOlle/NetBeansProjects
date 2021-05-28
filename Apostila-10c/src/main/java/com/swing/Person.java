package com.swing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Person implements Serializable {

    private String endereco;
    private String nome;
    private transient int count = 0;

    public Person() {
        System.out.println("Executou Construtor");
    }

    public Person(String endereco, String nome) {
        this.endereco = endereco;
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCount() {
        return count;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        this.count++;
        stream.writeInt(this.count);
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        this.count = stream.readInt();
        stream.defaultReadObject();
    }
}
