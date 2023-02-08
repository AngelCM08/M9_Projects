package uf2.CompteEstalvi;

/*
    Crear un programa main on hi hagi processos que realitzin 1000 ingressos de 100 euros i processos que treguin 1000 vegades 50 euros.
    Tots els processos s'han d'executar alhora.
    Comprovar el saldo final executant-lo varies vegades.
    Implementar una solució amb semàfors per garantir un accés sincronitzat al saldo i no tingui un valor inesperat.
*/

import java.util.ArrayList;
import java.util.List;

public class MainEstalvi {
    public static void main(String[] args) {
        CompteEstalvi ce = new CompteEstalvi(0);

        Runnable ingressar = () -> ce.ingressar(1000);
        Runnable treure = () -> ce.ingressar(500);

        List<Thread> processos = new ArrayList<>();

        for(int i = 0; i<1000; i++) {
            processos.add(new Thread(ingressar));
            processos.add(new Thread(treure));
        }

        processos.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(ce.saldo);
    }
}
