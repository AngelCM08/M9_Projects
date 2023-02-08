package uf2.CursaRelleus;

import java.util.Random;

public class Testimoni {
    private boolean agafat;

    public Testimoni() {
        this.agafat = false;
    }

    public synchronized void agafar(Atleta atleta) {
        Random rd = new Random();
        while(agafat) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        agafat = true;
        notifyAll();

        System.out.println(atleta.getName()+" ha agafat el testimoni, comença a correr...");

        long time;
        try {
            Thread.sleep(time = rd.nextLong(3000)+2000);
            atleta.setTemps(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void deixar(Atleta atleta) {
        System.out.println(atleta.getName()+" ha deixat el testimoni, ha fet un temps de "+atleta.getTemps());
        agafat = false;
        notifyAll();
    }
}
