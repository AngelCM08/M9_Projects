package uf2.Scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppMain {
    public static void main(String[] args) {
        List<Jugador> jugadors = new ArrayList<>();

        Jugador angel = new Jugador("Ángel");
        DonarPunts partidaAngel = new DonarPunts(angel);
        LlegirPunts llegirAngel = new LlegirPunts(angel);
        jugadors.add(angel);

        Jugador jowi = new Jugador("Jowi");
        DonarPunts partidaJowi = new DonarPunts(jowi);
        LlegirPunts llegirJowi = new LlegirPunts(jowi);
        jugadors.add(jowi);

        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        schExService.scheduleWithFixedDelay(partidaAngel, 1, 2, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(partidaJowi, 2, 3, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(llegirAngel, 5, 4, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(llegirJowi, 7, 4, TimeUnit.SECONDS);

        // Esperem a que passin els 25s o bé a que acabin tots
        try {
            schExService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schExService.shutdownNow();

        jugadors.stream()
                .sorted((o1, o2) -> Integer.compare(o2.punts, o1.punts))
                .forEach(j -> System.out.println("El jugador " + j.nom + " te un total de " + j.punts));
    }
}
