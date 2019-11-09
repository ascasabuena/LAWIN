package com.example.lawin;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class background extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {
        String result = "";
        String username = params[0];
        String password = params[1];
        String password2 = login.password1;

        String connstr = "https://lawin.000webhostapp.com/login_app.php?username_login=" + username + "&password_login=" + password;

        try {
            URL url = new URL(connstr);
            HttpsURLConnection https=(HttpsURLConnection)url.openConnection();
            https.setRequestMethod("POST");
            https.setDoInput(true);
            https.setDoOutput(true);

            OutputStream ops = https.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8")
                    +"&&"+URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = https.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while((line = reader.readLine()) != null){
                result += line;
            }

            reader.close();
            ips.close();
            https.disconnect();
            return result;




        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
       // MainActivity.bars.setVisibility(View.VISIBLE);
    }
}
