package uf3.urls;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class ExerciciB {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://docs.google.com/forms/u/0/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/formResponse");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            String parameters = "entry.835030737=ÁngelCastro&entry.1616686619=Si";
            out.write(parameters);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
