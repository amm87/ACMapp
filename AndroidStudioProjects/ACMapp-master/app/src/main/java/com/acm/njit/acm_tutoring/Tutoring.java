package com.acm.njit.acm_tutoring;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends ListFragment
{

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        //gets tutors from a resource file and displays them on the screen in a list fragment
        super.onActivityCreated(savedInstanceState);

        //Instantiate NetworkConfig, send url and context
        NetworkConfig nc = new NetworkConfig("http://192.168.56.1/getData.php", getContext());

        /**
         * Call volleyService, send new VolleyCallback. The result parameter is a string array of
         * database results
         */
        nc.volleyService(new VolleyCallback(){
            public void onSuccess(String[] result)
            {
                if(!(result==null))
                {
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, result);
                    setListAdapter(dataAdapter);
                }
            }
        });
    }
}

