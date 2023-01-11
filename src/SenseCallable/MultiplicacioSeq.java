package SenseCallable;

public class MultiplicacioSeq {
    private int op1, op2;
    public MultiplicacioSeq(int op1, int op2) {
        this.op1=op1;
        this.op2=op2;
    }

    public Integer call() {
        return op1*op2;
    }
}