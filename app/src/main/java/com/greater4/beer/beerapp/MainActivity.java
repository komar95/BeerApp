package com.greater4.beer.beerapp;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;

import java.util.logging.LogManager;

public class MainActivity extends AppCompatActivity {

    public Button startDrinking;
    public NotifyBeers notify = null;
    Listener listen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.start_menu);
        listen = new Listener(this);

        startDrinking = findViewById(R.id.startDrinking);
        startDrinking.setOnClickListener(listen);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(notify != null)
            notify.interrupt();
    }
}
