package MonitorGaletes;

public class PotDeGaletes {
    public final int MAX;
    public int num_galetes;
    private boolean lliure;

    public PotDeGaletes() {
        MAX = 15;
        this.num_galetes = 10;
        lliure = true;
    }

    public synchronized boolean agafarGaleta() {
        if (num_galetes != 0) {
            agafarPot();
            return true;
        } else return false;
    }

    public synchronized boolean omplirPot() {
        if (num_galetes != MAX) {
            agafarPot();
            if (num_galetes != 0 && num_galetes+3 <= MAX) {
                num_galetes += 3;
            } else {
                num_galetes += 10;
            }
            deixarPot();
            return true;
        }
        return false;
    }

    public synchronized void agafarPot() {
        try {
            while (!lliure) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lliure = false;
        notifyAll();
    }

    public synchronized void deixarPot() {
        lliure = true;
        notifyAll();
    }
}