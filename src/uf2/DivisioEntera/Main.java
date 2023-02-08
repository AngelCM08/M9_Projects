package uf2.DivisioEntera;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public Main() {}

    public static void main(String[] args) {
        Long a = Long.valueOf(7000), b = Long.valueOf(9);
        ForkJoinPool pool = new ForkJoinPool();
        DivisioEnteraTask tasca = new DivisioEnteraTask(a,b);

        // crida a la tasca i esperar que es completin
        pool.invoke(tasca);
        Long result = tasca.join();

        System.out.println("Resultat: " + result);
    }
}
