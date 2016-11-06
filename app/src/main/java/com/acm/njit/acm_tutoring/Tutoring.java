package com.acm.njit.acm_tutoring;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends Activity {

    //View viewer;
    private ListView mainList;
    //private Adapter mainAdapter;
    private ArrayAdapter<String> listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutoring_layout); //TODO ????

        //Find ListView resource
        mainList = (ListView) findViewById(R.id.mainList);

        //Create and populate a list of tutor names
        String[] names = new String[] {"Alec Brion"};

        ArrayList<String> tutorList = new ArrayList<String>();
        tutorList.addAll( Arrays.asList(names));

        //Create ArrayAdapter using tutorList
        listAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                tutorList
        );

        mainList.setAdapter(listAdapter);

    }


}
