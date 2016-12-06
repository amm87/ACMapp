package com.acm.njit.acm_tutoring;

import android.app.Application;
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
 * Created by caton on 12/5/2016.
 */

public class NetworkConfig extends Application
{
    private String[] tutors;
    private Context appContext;
    private String url;

    public NetworkConfig(String passedURL, Context context)
    {
        //Set up url and context
        url = passedURL;
        appContext = context;
    }

    public void volleyService(final VolleyCallback callback)
    {
        //Instantiate request queue
        RequestQueue requestQueue = Volley.newRequestQueue(appContext);

        //Start string request, call showJSON method if successful response
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>(){

            public void onResponse(String response)
            {
                /**
                 * showJSON method returns an array containing the database results.
                 * The callback class uses the onSuccess method to send the results back to
                 * the activity
                 */
                callback.onSuccess(showJSON(response));
            }
        }, new Response.ErrorListener()
        {

            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(appContext,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

        //Add request to queue
        requestQueue.add(stringRequest);

    }

    private String[] showJSON(String response)
    {
        try
        {
            //Instantiate JSON and tutors array
            JSONArray jArray = new JSONArray(response);
            tutors = new String[jArray.length()];

            //Read rows from JSON data into tutors array
            for(int i = 0; i< jArray.length();i++)
            {
                JSONObject json_data = jArray.getJSONObject(i);
                tutors[i] = json_data.getString("tutors")+"\t"+json_data.getString("availability");
            }

            return tutors;

        } catch(JSONException e)
        {
            Toast.makeText(appContext,"Could not get user data",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        return null;
    }
}
