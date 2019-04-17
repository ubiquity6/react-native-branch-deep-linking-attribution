package com.webview_example;

import android.content.Intent;
import android.net.Uri;

import com.facebook.react.ReactActivity;

import io.branch.rnbranch.*;

public class MainActivity extends ReactActivity {
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "webview_example";
    }

    @Override
    protected void onStart() {
        super.onStart();

        Uri uri = getIntent().getData();

        // These are handled by Linking.
        if (uri != null && uri.getScheme().equals("jdtest")) return;

        // Pass anything else to Branch.
        RNBranchModule.initSession(uri, this);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
