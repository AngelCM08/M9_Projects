package filosofs;

public class Cobert {
    public enum EstatCobert {
        LLIURE, OCUPAT;
    }
    private EstatCobert estat;

    public Cobert() {
        estat = EstatCobert.LLIURE;
    }

    public synchronized void agafar() {
        while(estat == EstatCobert.OCUPAT) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        estat = EstatCobert.OCUPAT;
        notifyAll();
    }

    public synchronized void deixar() {
        estat = EstatCobert.LLIURE;
        notifyAll();
    }
}
