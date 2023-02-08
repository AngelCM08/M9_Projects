package uf2.ambRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FerParet {

    public static void main(String[] args) throws InterruptedException {
        int ti, tf;
        int numPaletes = 9;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();
        //Donem nom als paletes i els posem a fer fer la paret

        //instanciem els paletes
        for (int i = 0; i < numPaletes; i++) {
            Paleta p = new Paleta("paleta " + (i + 1));
            executor.execute(p);
        }
        executor.shutdown();

        //Han acabat i agafem el temps final
        executor.awaitTermination(15000, TimeUnit.MILLISECONDS);

        tf = (int) System.currentTimeMillis();
        System.out.println("Han trigat: " + (tf - ti)/1000 + " segons");
    }
}