package exercicio03;

/**
 *
 * @author owzi
 */
public class Conta {

    private double saldo;

    public Conta() {
    }

    public void setValor(double valor) {
        saldo = valor;
    }

    public double getValor() {
        return saldo;
    }

    public void deposita(double valor) {
        try {
            if (valor == 0) {
                throw new IllegalArgumentException("Deposito Nulo");
            }
            double temp = getValor();
            temp += valor;
            setValor(temp);
        } catch (IllegalArgumentException e) {
            System.out.println("Por favor entre outro valor ");
        } finally { }
    }

    public static void main(String[] args) {
        Conta corrente = new Conta();
        
        corrente.deposita(0);
        corrente.deposita(10);
    }
}
