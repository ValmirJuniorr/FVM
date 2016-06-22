package br.com.fvm.util;

import android.os.StrictMode;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import br.com.fvm.control.LoginActivity;

/**
 * Created by Valmir on 16/06/2016.
 */
public class HTTPUtils {
    public static String request(String endereco, String data){
        try {

            URL url = new URL(endereco);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner scanner = new Scanner(is);
            String conteudo = scanner. useDelimiter("\\A"). next();
            scanner.close();
            return conteudo;
        } catch (Exception e) {
            return null;
        }


    }

   /* public static String requestPost(String endereco, String data){
        URL url = null;
        try {
            url = new URL(endereco);
            HttpURLConnection urlc = null;
            urlc = (HttpURLConnection) url.openConnection();
            urlc.setDoOutput(true);
            urlc.setRequestMethod("POST");
            DataOutputStream dos = new DataOutputStream(urlc.getOutputStream());
            dos.write(data.getBytes());
            InputStream is=urlc.getInputStream();
            Scanner scanner = new Scanner(is);
            String conteudo = scanner. useDelimiter("\\A"). next();
            scanner. close();
            return conteudo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
   public static String requestPost(String endereco, String data){
       try {
           HttpURLConnection connection = null;

           URL url = new URL(endereco);

           connection = (HttpURLConnection)url.openConnection();

           InputStream content = connection.getInputStream();
           return  content.toString();

       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }

    public static String doGet(String urlString){
        Log.i("Metodo Get", "eita porra");
        try {
            URL url=new URL(urlString);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            //OutputStream outputStream=httpURLConnection.getOutputStream();
            InputStream inputStream =httpURLConnection.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String result=scanner.nextLine();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";

    }

}