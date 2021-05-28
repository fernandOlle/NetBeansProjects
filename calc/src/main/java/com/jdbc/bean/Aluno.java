package com.jdbc.bean;

import java.util.Date;

/**
 *
 * @author owzi
 */
public class Aluno {
    private int matricula;
    private String nome;
    private Date dtIngresso;

    public Aluno() {
    }
    
    public Aluno(int matricula) {
        this.matricula = matricula;
    }
    
    public Aluno(int matricula, String nome, Date dtIngresso) {
        this.matricula = matricula;
        this.nome = nome;
        this.dtIngresso = dtIngresso;
    }
   
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDtIngresso() {
        return dtIngresso;
    }

    public void setDtIngresso(Date dtIngresso) {
        this.dtIngresso = dtIngresso;
    }

    @Override
    public String toString() {
        return this.matricula + ":" + this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 2;
        hash = 42 * hash + this.matricula;
        return hash;
    }
}
