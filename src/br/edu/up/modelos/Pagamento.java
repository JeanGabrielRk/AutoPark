package br.edu.up.modelos;

public class Pagamento {

    private int tipo;
    private float vlrTotal;

    public Pagamento(int tipo, float vlrTotal) {
        this.tipo = tipo;
        this.vlrTotal = vlrTotal;
    }

    public int getTipo() {
        return tipo;
    }

    public float getVlrTotal() {
        return vlrTotal;
    }
}
