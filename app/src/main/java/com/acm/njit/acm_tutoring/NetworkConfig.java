package com.acm.njit.acm_tutoring;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by caton on 12/11/2016.
 */

public class NetworkConfig
{
    private Context appContext;
    private String url;

    public NetworkConfig(String inputurl, Context context)
    {
        appContext = context;
        url = inputurl;
    }

    public void volleyService(final VolleyCallback callback)
    {

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>(){

            //Called if there was a successful response
            public void onResponse(String response)
            {
                //Returns the parsed JSON data in the form of a string array to onSuccess method
                //in Tutoring.java
                callback.onSuccess(showJSON(response));
            }

        }, new Response.ErrorListener()
        {

            //Called if unsuccessful response
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(appContext,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }

        });

        RequestQueue requestQueue = Volley.newRequestQueue(appContext);
        requestQueue.add(stringRequest);

    }

    private String[] showJSON(String response)
    {
        try
        {

            //Instantiate JSON and tutorsInput array
            JSONArray jArray = new JSONArray(response);
            String[] tutorsInput = new String[jArray.length()];

            //Read rows from JSON data into tutorsInput array
            for(int i = 0; i< jArray.length();i++)
            {
                JSONObject json_data = jArray.getJSONObject(i);
                tutorsInput[i] = json_data.getString("name")+" \n "+json_data.getString("availability");
            }

            return tutorsInput;

        } catch(JSONException e)
        {
            Toast.makeText(appContext,"Could not get user data",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        return null;
    }
}
