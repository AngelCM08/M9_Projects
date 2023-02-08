package uf2.banyMixt;

public class Persona extends Thread{
    public enum TipusPersona {
        HOME, DONA, NEN;
    }
    private TipusPersona tipus;
    private Lavabo bany;

    public Persona(String name, TipusPersona tipus, Lavabo bany) {
        super(name);
        this.tipus = tipus;
        this.bany = bany;
    }

    @Override
    public void run() {
        for(;;){
            treballar();
            anarAlLavabo();
        }
    }

    private void anarAlLavabo() {
        bany.entrar(this);
        System.out.printf("%s està pixant\n", getName());
        try {
            Thread.sleep((long) (Math.random() * 150) + 50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bany.sortir(getName());
    }

    private void treballar() {
        try {
            System.out.printf("%s està treballant\n", getName());
            Thread.sleep((long) (Math.random()*2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public TipusPersona getTipus() {
        return tipus;
    }
}
