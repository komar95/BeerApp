package com.greater4.beer.beerapp;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.Random;

/**
 * Created by alexander on 4/3/18.
 */

public class NotifyBeers extends Thread {

    Context cont;
    private String[] notifyTexts = {"Are you still drinking? Finish your beer!", "Time to order another beer", "Your beer is getting stale, order a new one"};
    private Random rand;
    private PendingIntent pi;


    public NotifyBeers(MainActivity act){
        super();
        cont = act;
        rand = new Random();
        Intent intent = new Intent(act, MainActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        pi = PendingIntent.getActivity(act, 0, intent, 0);
    }

    @Override
    public void run(){
        while(true) {
            try {
                NotificationCompat.Builder mBuild = new NotificationCompat.Builder(cont, "Beer")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Beer App")
                        .setContentText(notifyTexts[rand.nextInt(3)])
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setVibrate(new long[] {0, 200, 300, 200})
                        .setLights(Color.parseColor("#ffbc5d2d"), 700, 700)
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat man = NotificationManagerCompat.from(cont);
                man.notify(1, mBuild.build());
                Thread.sleep(1000 * 60 * 15);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
