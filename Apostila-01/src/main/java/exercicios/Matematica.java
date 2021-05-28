/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

public class Matematica {
    private int val;
    
    public Matematica( ) { }
    
    public Matematica(int val) {
        this.val = val;
    }
    
    public int getValor( ) {
        return this.val;
    }
    
    public void setValor( int val ) {
        this.val = val;
    }
    
    public void dobra( ) {
        this.val *= 2;
    } 
    
    public void quadruplica( ) {
        this.val *= 4;
    }
    
    public void soma( int numero ) {
        this.val += numero; 
    }
}
