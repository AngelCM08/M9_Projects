package uf2.ambCallable;

import java.util.concurrent.Callable;

public class Multiplicacio implements Callable<Integer> {
    private int op1, op2;
    public Multiplicacio(int op1, int op2) {
        this.op1=op1;
        this.op2=op2;
    }

    @Override
    public Integer call() throws Exception {
        return op1*op2;
    }
}