package CaixesConcurrents;

import java.util.ArrayList;
import java.util.List;

public class Caixa implements Runnable{
    String nom_caixa;
    List<Client> clients = new ArrayList<>();

    public float calcularPreu( List<Float> carret){
        int preu_total=0;
        for (float preu: carret) {
            preu_total += preu;
        }
        return preu_total;
    }

    public void setNomCaixa(String nom_caixa){
        this.nom_caixa = nom_caixa;
    }

    @Override
    public void run() {
        clients.forEach(client -> System.out.println("La compra del client "+client.getNom()+" a la caixa "+nom_caixa+" és de "+calcularPreu(client.getCarret())+"€"));
    }
}