package com.example.spredpay;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonLoadData extends Application {
    private String JSON = "";

    private final String API_key = "39060FEA-8DB9-41B7-A74D-C73D386761FD";
    private final String API_url = "https://rest.coinapi.io/v1/exchangerate/";

    private String Btcusd = "0";
    private String Ethusd = "0";
    private String Bnbusd = "0";
    private String Xrpusd = "0";
    private String Adausd = "0";
    private String Solusd = "0";
    private String Dogeusd = "0";

    public String getBtcusd() {
        return Btcusd;
    }
    public void setBtcusd(String btcusd) {
        this.Btcusd = btcusd;
    }
    public String getEthusd() {
        return Ethusd;
    }
    public void setEthusd(String ethusd) {
        this.Ethusd = ethusd;
    }
    public String getBnbusd() {
        return Bnbusd;
    }
    public void setBnbusd(String bnbusd) {
        this.Bnbusd = bnbusd;
    }
    public String getXrpusd() {
        return Xrpusd;
    }
    public void setXrpusd(String xrpusd) {
        this.Xrpusd = xrpusd;
    }
    public String getAdausd() {
        return Adausd;
    }
    public void setAdausd(String adausd) {
        this.Adausd = adausd;
    }
    public String getSolusd() {
        return Solusd;
    }
    public void setSolusd(String solusd) {
        this.Solusd = solusd;
    }
    public String getDogeusd() {
        return Dogeusd;
    }
    public void setDogeusd(String dogeusd) {
        this.Dogeusd = dogeusd;
    }

    public void getJSON() {
        System.out.println("It works");
        new JsonTask().execute("https://rest.coinapi.io/v1/exchangerate/BTC/USD?apikey=39060FEA-8DB9-41B7-A74D-C73D386761FD");
        //new JsonTask().execute(API_url+"ETH/USD?apikey="+API_key);
        //new JsonTask().execute(API_url+"BNB/USD?apikey="+API_key);
        //new JsonTask().execute(API_url+"XRP/USD?apikey="+API_key);
        //new JsonTask().execute(API_url+"ADA/USD?apikey="+API_key);
        //new JsonTask().execute(API_url+"SOL/USD?apikey="+API_key);
        //new JsonTask().execute(API_url+"DOGE/USD?apikey="+API_key);
    }

    private void setValue(){
        try {
            JSONObject jsonObj = new JSONObject(JSON);
            String rate = jsonObj.getString("rate");
            String asset_id_base = jsonObj.getString("asset_id_base");
            if(asset_id_base.equals("BTC")) setBtcusd(rate);
            if(asset_id_base.equals("ETH")) setEthusd(rate);
            if(asset_id_base.equals("BNB")) setBnbusd(rate);
            if(asset_id_base.equals("XRP")) setXrpusd(rate);
            if(asset_id_base.equals("ADA")) setAdausd(rate);
            if(asset_id_base.equals("SOL")) setSolusd(rate);
            if(asset_id_base.equals("DOGE")) setDogeusd(rate);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class JsonTask extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            JSON = result;
            setValue();
        }
    }
}
