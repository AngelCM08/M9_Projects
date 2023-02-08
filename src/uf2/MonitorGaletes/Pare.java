package uf2.MonitorGaletes;

public class Pare extends Thread {
    PotDeGaletes pot;

    public Pare(PotDeGaletes pot, String nom) {
        super(nom);
        this.pot = pot;
    }

    @Override
    public void run() {
        for (;;) {
            if (pot.omplirPot()) {
                System.out.println("**** Queden " + pot.num_galetes + " galetes al pot ****");
                System.out.println(getName() + " agafa el pot i posa galetes.\n");
            } else {
                System.out.println("\nNo es poden possar més galetes, el pot és ple.");
            }
            System.out.println(getName() + " deixa el pot.\n");
            pot.deixarPot();
            try {
                Thread.sleep((long) (Math.random() * 3000) + 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
