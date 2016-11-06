package com.acm.njit.acm_tutoring;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to mainpage_layout.xml
 */

public class MainPage extends Fragment {

    View viewer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewer = inflater.inflate(R.layout.mainpage_layout, container, false);

        WebView myWebView = (WebView) viewer.findViewById(R.id.web_view);
        myWebView.loadUrl("http://njit.acm.org");
        return viewer;

    }
}
