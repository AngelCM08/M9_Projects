package Scheduler;

public class DonarPunts implements Runnable{
    Jugador jugador;

    public DonarPunts(Jugador jugador) {
        this.jugador = jugador;
    }

    public void addPunts(int m) {
        jugador.punts += m;
    }
    @Override
    public void run() {
        int punts = (int) Math.floor(Math.random()*50);
        addPunts(punts);
        System.out.println(jugador.nom + ": he guanyat " + jugador.punts +" punts");
    }
}
