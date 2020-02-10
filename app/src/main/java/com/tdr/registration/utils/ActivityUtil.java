package com.tdr.registration.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by parry
 */
public class ActivityUtil {
    public static void goActivity(Activity activity, Class clazz) {
        Intent intent = new Intent(activity,
                clazz);
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
    }

    public static void goActivity(Activity activity, Class clazz, Bundle bundle) {
        try {
            Intent intent = new Intent(activity, clazz);
            intent.putExtras(bundle);
            activity.startActivity(intent);
            activity.overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goActivityAndFinish(Activity activity, Class clazz) {
        Intent intent = new Intent(activity,
                clazz);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void goActivityWithBundle(Activity activity, Class clazz, Bundle bundle) {
        goActivity(activity, clazz, bundle);

    }

    public static void goActivityForResult(Activity activity, Class clazz, int requestID) {
        Intent intent = new Intent(activity,
                clazz);
        activity.startActivityForResult(intent, requestID);
    }


    public static void goActivityForResult(Activity activity, Class clazz, Bundle bundle, int requestID) {
        try {
            Intent intent = new Intent(activity,
                    clazz);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, requestID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Intent goActivityForResultForFragment(Activity activity, Class clazz, Bundle bundle) {
        Intent intent = new Intent(activity,
                clazz);
        try {
            intent.putExtras(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return intent;
    }

    public static void goActivityForResultWithBundle(Activity activity, Class clazz, Bundle bundle, int requestID) {
        goActivityForResult(activity, clazz, bundle, requestID);

    }

}
