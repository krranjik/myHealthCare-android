package com.android.myhealthcare.controllers;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.myhealthcare.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebviewFragment extends Fragment {

    WebView webView;
    View root;

    public WebviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_webview, container, false);
        webView = root.findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.healthline.com/nutrition/27-health-and-nutrition-tips#section1");
        return root;
    }

}
