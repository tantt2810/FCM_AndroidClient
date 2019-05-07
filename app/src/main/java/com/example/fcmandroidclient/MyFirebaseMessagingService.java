package com.example.fcmandroidclient;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingService";
    @SuppressLint("LongLogTag")
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d(TAG, "Refreshed token: " + token);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        String message = "";

        if (remoteMessage.getData().size() > 0) {
            message = "Message data payload: " + remoteMessage.getData();
            Log.d(TAG, message);
        }

        if (remoteMessage.getNotification() != null) {
            message = "Message Notification Body: " + remoteMessage.getNotification().getBody();
            Log.d(TAG, message);
        }

        Handler handler = new Handler(Looper.getMainLooper());
        final String finalMessage = message;
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), finalMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}
