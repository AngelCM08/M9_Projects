package uf3.udp.tasca4;

import java.util.ArrayList;
import java.util.List;

public class FrasesAleatories {
    List<String> frasesAleatories = new ArrayList<>();
    public FrasesAleatories() {
        frasesAleatories.add("Hola, que tal estas coleguita?");
        frasesAleatories.add("Pues MP9 no está tan mal como dice el Jowi.");
        frasesAleatories.add("El diseño en Android Studio es de lo mejor...");
        frasesAleatories.add("Los ordenadores de clase van bien y tal...");
        frasesAleatories.add("No se me ocurre nada más.");
        frasesAleatories.add("Compartir es tener menos.");
        frasesAleatories.add("Tiparraco es una persona tranquila y seria, no es broma. ");
        frasesAleatories.add("Que vas liao pollito, ni sacar un billete de tren sabes.");
        frasesAleatories.add("Pues no se ha quedado tan mala tarde al final.");
        frasesAleatories.add("Este finde va a ser muy divertido con el par de trabajos que tenemos.");
    }

    public String agafaFraseAleatoria() {
        return frasesAleatories.get((int)(Math.random()*frasesAleatories.size()));
    }
}
