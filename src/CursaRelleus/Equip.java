package CursaRelleus;

public class Equip {
    private Atleta a1, a2, a3, a4;

    public Equip(Atleta a1, Atleta a2, Atleta a3, Atleta a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    public long CalculaTempsTotal(){
        return a1.getTemps() + a2.getTemps() + a3.getTemps() + a4.getTemps();
    }
}
