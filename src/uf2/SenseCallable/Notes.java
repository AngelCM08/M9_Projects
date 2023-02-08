package uf2.SenseCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Notes {

    public static void main(String[] args) throws Exception {
        int numAlumnes = 10,tf,ti;
        String Modul = "M9";
        List<Integer> notes = new ArrayList<>();

        //instanciem els alumnes
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Alumne> A_m9 = new ArrayList<Alumne>();

        for (int i=0;i<numAlumnes;i++) {
            Alumne alumne = new Alumne(Modul + "-" + i);
            A_m9.add(alumne);
        }
        List<Future<Integer>> llistaNotes;

        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();

        //Donem nom als alumnes i els posem a fer l'examen
        llistaNotes = executor.invokeAll(A_m9);
        executor.shutdown();

        //Han acabat i agafem el temps final
        tf = (int) System.currentTimeMillis();

        //traiem els resultats i el temps que han trigat

        for (int i=0;i<numAlumnes;i++) {
            Future<Integer> resultat = llistaNotes.get(i);
            System.out.println("Alumne "+ A_m9.get(i).getNom()+" : " + resultat.get());
        }
        System.out.println("Han trigat: " + (tf - ti)/1000 + " segons");
    }
}