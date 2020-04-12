package com.example.restservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class LoginAPI {


        public static void main(String[] args) {


            try {
                Scanner myObj = new Scanner(System.in);

                System.out.println("Enter latitude");

                // String input
                String lat = myObj.nextLine();
                System.out.println("latitude: " + lat);

                Scanner myOtherObj = new Scanner(System.in);

                System.out.println("Enter Longitude");

                // String input
                String lon = myOtherObj.nextLine();
                System.out.println("longitude: " + lon);


                //String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6ImJhc2ljIiwiaWF0IjoxNTg2NjU3OTM4LCJleHAiOjE1ODY2NTk3MzgsImlzcyI6IldhdHRUaW1lIiwic3ViIjoia3VzaCJ9.oPwMFX57rpHlXJZF1DsroAV65eRGPCdO-f6goVS5zJYyJ1LoWOHiwhyMOjqKaseTzO3htIg9Gz8_NKYJivVT6W90rJSHHdAVTMCoJFd4ve3mVqkNzKlxNsBmm73Di_-s3bJqAPJriUqmjpS7yURz_d9HYAGRz3CRbxmVZNbS20uSiw00kxvkFDx-Eh18_b96Cizpp6Xv_Bsf7WqIgM8dMPw8uHYVnn-KdMD0md1qYq193EMfTm-A-KYaqeUlSTdtp3lPjsNKWORfPZTXnG2i5LvqRkwMbdwd9MqP685CIBQDT8I0URJTNiUUSAyE49jkyjOmN-ajXSeT0VbKMZo9ZQ";
                //String lat = "37.5485";
                //String lon = "-121.9886";
                String token = RealLoginAPI.getToken();

                URL url = new URL("https://api2.watttime.org/v2/index/?latitude=" + lat + "&longitude=" + lon + "&style=all");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Authorization","Bearer "+ token);

                conn.setRequestProperty("Content-Type","application/json");
                conn.setRequestMethod("GET");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
                conn.disconnect();

            } catch (Exception e) {
                System.out.println("Exception in NetClientGet:- " + e);
            }
        }
    }




