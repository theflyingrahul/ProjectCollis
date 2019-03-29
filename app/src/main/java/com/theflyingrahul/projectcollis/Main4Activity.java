package com.theflyingrahul.projectcollis;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
TextView textView;
EditText editText;
DbMan dbMan;
String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView = findViewById(R.id.textViewDetails);
        editText = findViewById(R.id.editTextFind);
        dbMan = new DbMan(Main4Activity.this);
    }

    public void finduser(View view) {
        s = editText.getText().toString();
        String det = dbMan.getDetails(s);
        if (det == ""){
            Intent intent = new Intent(Main4Activity.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(Main4Activity.this, 0, intent, 0);

            Notification notification = new Notification.Builder(Main4Activity.this).setSmallIcon(android.R.drawable.checkbox_off_background)
                    .setContentTitle("User not found!")
                    .setContentIntent(pendingIntent)
                    .setContentText("Please try again later")
                    .build();

            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0, notification);
        }
        else
            textView.setText(det);
    }
}
