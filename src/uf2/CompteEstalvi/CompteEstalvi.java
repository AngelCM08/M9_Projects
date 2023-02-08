package uf2.CompteEstalvi;

public class CompteEstalvi {
    float saldo;

    public CompteEstalvi(float saldo) {
        this.saldo = saldo;
    }

    public void ingressar(float diners) {
        float aux;
        aux=saldo;
        aux=aux+diners;
        saldo=aux;
        guardarSaldo(saldo);
    }

    public void treure(float diners) {
        float aux;
        aux=saldo;
        aux=aux-diners;
        saldo=aux;
        guardarSaldo(saldo);
    }

    private void guardarSaldo(float saldo) {
        this.saldo += saldo;
    }
}