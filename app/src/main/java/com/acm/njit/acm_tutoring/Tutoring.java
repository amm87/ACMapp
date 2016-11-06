package com.acm.njit.acm_tutoring;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends Fragment {

    View viewer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewer = inflater.inflate(R.layout.tutoring_layout, container, false);
        return viewer;

    }
}
