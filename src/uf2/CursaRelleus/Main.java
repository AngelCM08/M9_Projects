package uf2.CursaRelleus;

public class Main {
    public static void main(String[] args) {
        Testimoni testimoni1 = new Testimoni();
        Testimoni testimoni2 = new Testimoni();
        Testimoni testimoni3 = new Testimoni();
        Equip equip1, equip2, equip3;
        Atleta[] atletes = new Atleta[12];
        int cont = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                switch (i) {
                    case 0 -> atletes[cont] = new Atleta(testimoni1, "atleta" + j + "-Equip1");
                    case 1 -> atletes[cont] = new Atleta(testimoni2, "atleta" + j + "-Equip2");
                    case 2 -> atletes[cont] = new Atleta(testimoni3, "atleta" + j + "-Equip3");
                }
                cont++;
            }
        }

        equip1 = new Equip(atletes[0],atletes[1],atletes[2],atletes[3]);
        equip2 = new Equip(atletes[4],atletes[5],atletes[6],atletes[7]);
        equip3 = new Equip(atletes[8],atletes[9],atletes[10],atletes[11]);

        for (Atleta atleta : atletes) {
            atleta.start();
        }

        for (Atleta atleta : atletes) {
            try {
                atleta.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("**********  RESULTATS  *********");
        System.out.println("Equip 1: "+ (float) equip1.CalculaTempsTotal()/1000 +" segons");
        System.out.println("Equip 2: "+ (float) equip2.CalculaTempsTotal()/1000 +" segons");
        System.out.println("Equip 3: "+ (float) equip3.CalculaTempsTotal()/1000 +" segons");
    }
}
