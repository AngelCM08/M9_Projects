package filosofs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SoparFilosofs {
    public static Object dead = new Object();
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        int numFilosofs = 4;
        Cobert[] coberts = new Cobert[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            coberts[i] = new Cobert();
        }

        Filosof f0 = new Filosof("Gerard", coberts[0], coberts[1]);
        Filosof f1 = new Filosof("Jonathan", coberts[1], coberts[2]);
        Filosof f2 = new Filosof("Xiao", coberts[2], coberts[3]);
        Filosof f3 = new Filosof("Joel", coberts[3], coberts[0]);

        f0.start();
        f1.start();
        f2.start();
        f3.start();
    }
}
