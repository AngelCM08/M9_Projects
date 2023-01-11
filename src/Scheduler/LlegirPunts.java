package Scheduler;

import CursaCargols.Cargol;

public class LlegirPunts implements Runnable{
    private Jugador jugador;

    public LlegirPunts(Jugador j) {
        jugador = j;
    }

    @Override
    public void run() {
        System.out.println(jugador.nom  + " acumula " + jugador.punts + " punts");
    }
}
