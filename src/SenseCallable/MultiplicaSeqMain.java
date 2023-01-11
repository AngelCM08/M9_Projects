package SenseCallable;

import java.util.ArrayList;
import java.util.List;

public class MultiplicaSeqMain {
    public static final int MAX = 10;

    public static void main(String[] args) {
        List<MultiplicacioSeq> llistaTasques= new ArrayList<MultiplicacioSeq>();

        for (int i = 0; i < MAX; i++) {
            MultiplicacioSeq calcula = new MultiplicacioSeq((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);

        }
        List<Integer> llistaResultats = new ArrayList<>();

        long temp1 = System.currentTimeMillis(); //agafem els milisegons de la data
        for (int i=0; i< llistaTasques.size(); i++) {
            llistaResultats.add(llistaTasques.get(i).call());
        }

        long temp2 = System.currentTimeMillis();  //tornem a capturar els milisegons per calcular quan ha trigat

        for (int i = 0; i < llistaResultats.size(); i++) {
            Integer resultat = llistaResultats.get(i);
            System.out.printf("El resultat de la tasca %d és %d%n", i, resultat);
        }

        System.out.printf("Ha trigat: %d milisegons", (temp2-temp1));
    }
}