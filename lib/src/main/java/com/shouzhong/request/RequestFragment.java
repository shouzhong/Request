package com.shouzhong.request;

import android.app.Fragment;
import android.content.Intent;

public class RequestFragment extends Fragment {

    private Callback callback;

    public void setData(Intent intent, Callback callback) {
        this.callback = callback;
        startActivityForResult(intent, 10000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10000) {
            callback.call(resultCode, data);
        }
    }
}
