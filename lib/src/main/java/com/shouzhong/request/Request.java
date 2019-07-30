package com.shouzhong.request;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

public class Request {

    private static final String TAG = "com.shouzhong.request.Request";

    private Activity activity;
    private Callback callback;
    private Intent intent;

    public Request() {
    }

    public Request with(Activity activity) {
        this.activity = activity;
        return this;
    }

    public Request setIntent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public Request setCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public void start() {
        getFragment(activity).setData(intent, callback);
        activity = null;
        intent = null;
        callback = null;
    }

    private RequestFragment getFragment(Activity activity) {
        RequestFragment f = (RequestFragment) activity.getFragmentManager().findFragmentByTag(TAG);
        if (f == null) {
            f = new RequestFragment();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction().add(f, TAG).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return f;
    }
}
