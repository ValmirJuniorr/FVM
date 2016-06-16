package br.com.fvm.util;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Valmir on 16/06/2016.
 */
public class HTTPUtils {
    public static String request(String endereco){
        try {
            URL url = new URL(endereco);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner scanner = new Scanner(is);
            String conteudo = scanner.next();
            scanner.close();
            return conteudo;
        } catch (Exception e) {
            return null;
        }
    }
}