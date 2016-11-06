package com.acm.njit.acm_tutoring;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends Fragment {

    View viewer;
    private ListView mainList;
    private Adapter mainAdapter;
    private ArrayAdapter<String> itemsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewer = inflater.inflate(R.layout.tutoring_layout, container, false);
        initalizeListView(viewer);

        return viewer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tutoring_layout); //TODO tutoring_layout ??


    }

    private void initalizeListView(View view){
        Log.d("Test", "Initializing list view");
        mainList = (ListView) view.findViewById(R.id.mainList);
        mainAdapter = new Adapter(getActivity());
        mainList.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();

        ArrayList<String> tutorList = new ArrayList<String>();

        /*itemsAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                tutorList
        );*/

    }

    @Override
    public void onResume(){
        super.onResume();
    }

}
