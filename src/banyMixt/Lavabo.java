package banyMixt;

public class Lavabo {
    public static final int MAX = 10;
    Persona.TipusPersona tipus;
    int gentDins;

    public Lavabo(){
        gentDins = 0;
    }

    public synchronized void entrar(Persona.TipusPersona tipusPersona) {
        if(gentDins == 0){
            tipus = tipusPersona;
            gentDins++;
            notifyAll();
        } else if (tipusPersona == tipus) {
            gentDins++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void sortir(String name) {
        if(gentDins == 1){
            gentDins--;
            tipus = null;
            System.out.println("Tipo actual: "+tipus);
            notifyAll();
        }else{
            gentDins--;
        }
        System.out.println("Surt "+name);
    }
}
