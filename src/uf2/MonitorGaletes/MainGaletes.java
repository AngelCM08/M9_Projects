package uf2.MonitorGaletes;

public class MainGaletes {
    public static void main(String[] args) {
        PotDeGaletes pot = new PotDeGaletes();

        Pare joan = new Pare(pot, "Joan");
        Pare joana = new Pare(pot, "Joana");

        Nen manolin = new Nen(pot, "Manolin");
        Nen flautin = new Nen(pot, "Flautín");
        Nen menganin = new Nen(pot, "Menganin");

        joan.start();
        joana.start();
        manolin.start();
        flautin.start();
        menganin.start();
    }
}
