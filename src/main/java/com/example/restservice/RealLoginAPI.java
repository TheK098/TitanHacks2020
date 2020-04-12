package com.example.restservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class RealLoginAPI {

        public static String getToken() {

            String output="";

            try {


                String auth = "kush:the_frog";
                String encoded = Base64.getEncoder().withoutPadding().encodeToString((auth).getBytes(StandardCharsets.UTF_8));

                URL url = new URL("https://api2.watttime.org/v2/login/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Authorization", "Basic "+encoded);

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
                conn.disconnect();


            } catch (Exception e) {
                System.out.println("Exception in NetClientGet:- " + e);
            }

            return output;

        }

    public static void main(String[] args) {

    }
}
