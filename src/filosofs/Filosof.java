package filosofs;

import static filosofs.SoparFilosofs.dead;
import static filosofs.SoparFilosofs.lock;

public class Filosof extends Thread {
    private Cobert cobert1;
    private Cobert cobert2;

    public Filosof(String name, Cobert cobert1, Cobert cobert2) {
        super(name);
        this.cobert1 = cobert1;
        this.cobert2 = cobert2;
    }

    @Override
    public void run() {
        for(;;){
            pensar();
            menjar();
        }
    }

    private void menjar() {
        //synchronized (dead) {
        lock.lock();
            cobert1.agafar();
            try {
                Thread.sleep((long) (Math.random()*150) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cobert2.agafar();
        lock.unlock();
        //}

        //menjar
        System.out.printf("%s està menjant\n", getName());
        try {
            Thread.sleep((long) (Math.random()*150) + 50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cobert2.deixar();
        cobert1.deixar();
    }

    private void pensar(){
        try {
            System.out.printf("%s està pensant\n", getName());
            Thread.sleep((long) (Math.random()*100) + 50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}