package com.pessoa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pessoa implements Serializable {

    private long id;
    private String nome;
    private transient int count = 0;

    public Pessoa() {
        System.out.println("Executou Construtor");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
