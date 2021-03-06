package com.company;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

        // add currency codes
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "EUR");
        currencyCodes.put(3, "RUB");

        String fromCode, toCode;
        double amount;
        Integer from, to;


        Validator validator = new Validator();

        System.out.println("Welcome to the currency converter...");

        validator.getFromCode(); // input FROM code

        fromCode = currencyCodes.get(validator.getFrom()); // get code

        validator.getToCode(); // input TO code

        toCode = currencyCodes.get(validator.getTo()); // get code

        System.out.println("Enter the amount you'd like to convert...");
        amount = scanner.nextFloat();

        sendHttpGETRequest(fromCode, toCode, amount);
        System.out.println("Successfully converted.");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {

        // format output
        DecimalFormat format = new DecimalFormat("00.00");

        // Abstract API api_key
        String api_key = "ff1bf63920494ca7a14b7653a7faf032";
        String getURL = "https://exchange-rates.abstractapi.com/v1/live/?api_key=" + api_key + "&base=" + toCode + "&target=" + fromCode;
        URL url = new URL(getURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject object = new JSONObject(response.toString());
            Double exchangeRate = object.getJSONObject("exchange_rates").getDouble(fromCode);
            System.out.println(object.getJSONObject("exchange_rates"));

            // current rates to debug
            System.out.println(exchangeRate);
            System.out.println();

            // output
            System.out.println(format.format(amount) + " "+ fromCode + " = " + format.format(amount / exchangeRate) + " "+ toCode);
        } else {
            System.out.println("GET request failed...");
        }
    }
}
