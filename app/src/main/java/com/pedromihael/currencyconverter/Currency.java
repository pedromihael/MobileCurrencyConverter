package com.pedromihael.currencyconverter;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Currency {

    private Double mDollar, mEuro;
    private RequestQueue requestQueue;

    public Currency(RequestQueue requestQueue) {
        String url = "https://api.exchangeratesapi.io/latest?base=BRL";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        mDollar = jsonObject.getJSONObject("rates").getDouble("USD");
                        mEuro = jsonObject.getJSONObject("rates").getDouble("EUR");
                    } catch (JSONException err) {
                        Log.d("Error", err.toString());
                    }

                },
                error -> Log.d("API-RESPONSE", "onErrorResponse: API ERROR: ", error));

        this.requestQueue = requestQueue;
        this.requestQueue.add(stringRequest);
    }
    public double convertToDollar (Double realValue) {
        return realValue * this.mDollar;
    }

    public double convertToEuro (Double realValue) {
        return realValue * this.mEuro;
    }

}
