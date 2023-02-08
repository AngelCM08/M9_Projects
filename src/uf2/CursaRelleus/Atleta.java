package uf2.CursaRelleus;

public class Atleta extends Thread{
    private Testimoni testimoni;
    private long temps;

    public Atleta(Testimoni testimoni, String nom) {
        super(nom);
        this.testimoni = testimoni;
        this.temps = 0;
    }

    @Override
    public void run() {
        testimoni.agafar(this);
        testimoni.deixar(this);
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }
}
