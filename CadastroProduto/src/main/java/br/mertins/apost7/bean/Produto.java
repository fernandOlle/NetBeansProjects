package br.mertins.apost7.bean;

/**
 *
 * @author owzi
 */
public class Produto implements Comparable {
    private String nome;
    private int cod;
    private int descricao;

    public Produto( ) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 2;
        hash = 42 * hash + this.cod;
        return hash;
    }

    public int compareTo(Object o) {
        Produto temp = (Produto)o;
        Integer cod = new Integer(this.cod);
        return cod.compareTo(temp.getCod());
    }
    
}
