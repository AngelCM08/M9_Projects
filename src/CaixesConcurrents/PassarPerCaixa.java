package CaixesConcurrents;

import ambRunnable.Paleta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PassarPerCaixa {
    public static void main(String[] args) throws InterruptedException {
        int MAX_PRODS = 10, NUM_CLIENTS = 5;
        int i,j;
        boolean quinaCaixa=true;
        List<Float> carret = new ArrayList<>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        //Instanciem les caixes
        Caixa caixa1 = new Caixa();
        caixa1.setNomCaixa("Caixa1");
        Caixa caixa2 = new Caixa();
        caixa2.setNomCaixa("Caixa2");

        //instanciem els clients
        for (i=0; i<NUM_CLIENTS; i++){
            carret.clear();
            for(j=0; j<Math.random()*MAX_PRODS; j++){
                carret.add((float) (Math.random()*150));
            }
            carret.forEach(x -> System.out.print(x+" "));
            System.out.println();


            Client client = new Client("client"+(i+1), carret);
            if(quinaCaixa){
                caixa1.clients.add(client);
                quinaCaixa=false;
            } else {
                caixa2.clients.add(client);
                quinaCaixa=true;
            }
        }

        //Les caixes comencen a calcular preus
        executor.execute(caixa1);
        executor.execute(caixa2);

        executor.shutdown();
        executor.awaitTermination(15000,TimeUnit.MILLISECONDS);
    }
}
