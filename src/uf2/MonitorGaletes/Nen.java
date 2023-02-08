package uf2.MonitorGaletes;

public class Nen extends Thread{
    PotDeGaletes pot;

    public Nen(PotDeGaletes pot, String nom){
        super(nom);
        this.pot = pot;
    }

    @Override
    public void run() {
        for(;;){
            if(pot.agafarGaleta()){
                System.out.println("\n"+getName() + " agafa el pot i una galeta.");
                System.out.println("**** Queden "+pot.num_galetes+" galetes al pot ****");
            }else{
                System.out.println("\n"+getName() + " No pot agafar galetes perque no en queden");
            }
            System.out.println(getName() + " deixa el pot.\n");
            pot.deixarPot();
            try {
                Thread.sleep((long) (Math.random()*1000)+500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
