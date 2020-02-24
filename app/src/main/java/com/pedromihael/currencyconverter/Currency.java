package com.pedromihael.currencyconverter;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class Currency {

    private String mApiResponse;
    private Double mDollar;
    private Double mEuro;

    /*
    public Currency() {
        RequestQueue requestQueue = new RequestQueue();
        String url = "https://api.exchangeratesapi.io/latest?base=BRL";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mApiResponse = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("API-RESPONSE", "onErrorResponse: API ERROR: ", error);
            }
        });

        requestQueue.add(stringRequest);
    }
*/
    public void convertToDollar (Double realValue) {
        // return valor convertido
    }

    public void convertToEuro (Double realValue) {
        // return valor convertido
    }

}
