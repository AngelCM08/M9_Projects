package uf3.urls;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicis {
    public static void exerciciA(URL url, String label){
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

    public static void exerciciB(String input1, String input2){
        try {
            URL url = new URL("https://docs.google.com/forms/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/formResponse");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write("entry.835030737=" + input1 + "&entry.1616686619=" + input2);
            out.close();
            InputStream in = con.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws MalformedURLException {
        //Exercicis.exerciciA(new URL(args[0]), args[1]);
        Exercicis.exerciciB("Ángel Castro", "Si");
    }
}