package com.example.testapplication.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.testapplication.R;

public class Flight {

    int x, y, width, height;
    int wingCounter = 0;
    Bitmap flight1, flight2;

    Flight(int screenY, Resources res) {
        flight1 = BitmapFactory.decodeResource(res, R.drawable.fly1);
        flight2 = BitmapFactory.decodeResource(res, R.drawable.fly2);

        width = flight1.getWidth();
        height = flight1.getHeight();

        //width /= 4;
        //height /= 4;

        //get the screenRatio values from GameView
        //width *= screenRatioX;
        //height *= screenRatioY;

        flight1 = Bitmap.createScaledBitmap(flight1, width, height, false);
        flight2 = Bitmap.createScaledBitmap(flight2, width, height, false);

        y = screenY;
        x = 32;

    }

    Bitmap getFlight() {
        if(wingCounter == 0) {
            wingCounter++;
            return flight1;
        }
        wingCounter--;
        return flight2;

    }

}
