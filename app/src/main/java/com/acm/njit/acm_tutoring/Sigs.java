package com.acm.njit.acm_tutoring;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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

public class Sigs extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //gets sigs from resource file and displays them in a list fragment
        super.onActivityCreated(savedInstanceState);
        String[] sigs = getResources().getStringArray(R.array.sigs);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,sigs);

        setListAdapter(dataAdapter);


    }
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        String[] sigs = getResources().getStringArray(R.array.sigs);
        String selectedEmail = sigs[pos].substring(sigs[pos].lastIndexOf(" "));

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{selectedEmail});
        emailIntent.putExtra(Intent.EXTRA_CC, new String[]{""});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, new String[]{""});
        emailIntent.putExtra(Intent.EXTRA_TEXT, new String[]{""});
        emailIntent.setType("plain/text");
        startActivity(Intent.createChooser(emailIntent, "Choose Email App"));
    }

}
