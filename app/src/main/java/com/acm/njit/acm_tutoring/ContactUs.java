package com.acm.njit.acm_tutoring;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jesse on 11/6/2016.
 * Corresponds to social_media_layout.xmlout.xml
 */

public class ContactUs extends Fragment {

    View viewer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewer = inflater.inflate(R.layout.contact_us_layout, container, false);
        return viewer;
    }


    public void onClickTwitter(View view) {
        // Perform action on click
    }
    public void onClickInstagram(View view) {
        // Perform action on click
    }
    public void onClickSlack(View view) {
        // Perform action on click
    }
    public void onClickLinkedIn(View view) {
        // Perform action on click
    }

}
