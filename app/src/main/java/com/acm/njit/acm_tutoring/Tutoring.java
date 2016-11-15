package com.acm.njit.acm_tutoring;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //gets tutors from a resource file and displays them on the screen in a list fragment
        super.onActivityCreated(savedInstanceState);
        String[] tutors = getResources().getStringArray(R.array.tutors);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,tutors);

        setListAdapter(dataAdapter);


    }


}
