package uf2.DivisioEntera;

import java.util.concurrent.RecursiveTask;

public class DivisioEnteraTask extends RecursiveTask<Long> {

    private Long a;
    private final Long b;
    public DivisioEnteraTask(Long a, Long b) {
        this.a = a;
        this.b = b;
    }

    public Long divisioEnteraR(){
        System.out.printf("%d / %d \n", a, b);
        DivisioEnteraTask divEnt = new DivisioEnteraTask(a-b, b);
        divEnt.fork();
        return divEnt.join() + 1;
    }

    public Long divisioEnteraS() {
        int cont=0;
        while(a >= b){
            System.out.printf("%d / %d \n", a, b);
            a = a-b;
            cont++;
        }
        return (long) cont;
    }

    @Override
    protected Long compute() {
        int LLINDAR = 100;
        if((a-b) < LLINDAR){
            return divisioEnteraS();
        } else {
            return divisioEnteraR();
        }
    }

}