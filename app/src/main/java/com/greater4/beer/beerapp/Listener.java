package com.greater4.beer.beerapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Listener implements View.OnClickListener {

    MainActivity act;
    Button plusOne = null;
    TextView beersLabel, textLabel;
    int beers = 0;
    Random rand;

    String[] first = {"Drink more!", "Weak", "Do you even drink, bro?"};
    String[] second = {"Getting there", "Just one more", "Drink before you think", "Just keep going"};
    String[] third = {"Legend", "Drinking master", "Nothing can stop you now"};

    public Listener(MainActivity act){
        this.act = act;
        rand = new Random();
    }

    @Override
    public void onClick(View v){
        if(v.equals(act.startDrinking)){
            act.setContentView(R.layout.activity_main);
            plusOne = act.findViewById(R.id.addBeer);
            plusOne.setOnClickListener(this);
            beersLabel = act.findViewById(R.id.beersLabel);
            textLabel = act.findViewById(R.id.text);
            textLabel.setText(first[rand.nextInt(3)]);
            textLabel.invalidate();

            act.notify = new NotifyBeers(act);
            act.notify.start();
        }
        if(plusOne != null && v.equals(plusOne)){
            beers++;
            beersLabel.setText(beers + " beers");
            beersLabel.invalidate();
            if(beers < 4) {
                textLabel.setText(first[rand.nextInt(3)]);
            }else if(beers < 10){
                textLabel.setText(second[rand.nextInt(4)]);
            }else{
                textLabel.setText(third[rand.nextInt(3)]);
            }
            textLabel.invalidate();
        }
    }
}
