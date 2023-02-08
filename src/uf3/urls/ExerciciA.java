package uf3.urls;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExerciciA {
    private static void printContent(URL url, String label){
        InputStream in;
        char[] cbuf = new char[512];
        int caractersLlegits;
        String outlabel = "</"+label.substring(1);

        try {
            in = url.openStream();
            InputStreamReader inr = new InputStreamReader(in);
            while((caractersLlegits=inr.read(cbuf))!=-1){
                String str = String.copyValueOf(cbuf, 0, caractersLlegits);
                if(str.contains(label)) System.out.println(label+str.split(label)[1]+outlabel);

            }
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(TestApunts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            ExerciciA.printContent(new URL(args[0]), args[1]);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
