package uf2.CaixesConcurrents;

import java.util.List;

/**
 * Un client que té una llista de valors que representen el preu(int)
 * dels productes que porta al seu carret
 * Aquesta llista és el que la Caixa agafarà per calcular el preu total a pagar
 * Fitxers: 'Caixa.java', 'Supermercat.java'
 */

public class Client {
    private String Nom;
    private List<Float> carret;

    public Client(String nom, List<Float> carret) {
        Nom = nom;
        this.carret = carret;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public List<Float> getCarret() {
        return carret;
    }

    public void setCarret(List<Float> carret) {
        this.carret = carret;
    }
}