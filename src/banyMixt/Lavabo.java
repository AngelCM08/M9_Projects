package banyMixt;

public class Lavabo {
    public static final int MAX = 10;
    Persona.TipusPersona tipus;
    int gentDins;

    public Lavabo(){
        gentDins = 0;
    }

    public synchronized void entrar(Persona persona) {
        while(true){
            if(gentDins == 0){
                tipus = persona.getTipus();
                System.out.println("*************************+");
                System.out.println(tipus);
                System.out.println("*************************+");
                gentDins++;
                notifyAll();
                break;
            } else if (persona.getTipus() == tipus) {
                gentDins++;
                break;
            } else {
                try {
                    System.out.println(persona.getName()+ " esperant...");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void sortir(String name) {
        if(gentDins == 1){
            gentDins--;
            tipus = null;
            notifyAll();
        }else{
            gentDins--;
        }
        System.out.println("Surt "+name);
    }
}
