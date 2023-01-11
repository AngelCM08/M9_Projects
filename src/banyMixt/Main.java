package banyMixt;

public class Main {
    public static void main(String[] args) {
        Lavabo lavabo = new Lavabo();

        Persona[] persones = new Persona[30];

        for (int i = 0, j = 0; i < 30; i=i+3, j++) {
            persones[i] = new Persona("Home"+j, Persona.TipusPersona.HOME, lavabo);
            persones[i+1] = new Persona("Dona"+j, Persona.TipusPersona.DONA, lavabo);
            persones[i+2] = new Persona("Nen"+j, Persona.TipusPersona.NEN, lavabo);
        }

        for (Persona persona : persones) {
            persona.start();
        }
    }
}
