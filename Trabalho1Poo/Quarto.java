package Java;

public class Quarto {
    private int numero;
    private String tipo;
    private double preco;
    private boolean estaDisponivel;

    public Quarto(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.estaDisponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public boolean estaDisponivel() {
        return estaDisponivel;
    }

    public void reservar() {
        estaDisponivel = false;
    }

    public void liberar() {
        estaDisponivel = true;
    }
}