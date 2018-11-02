package com.example.deneme.xapikaydirmag;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bK1, bK2, bK3, bK4;
    Button bKontrol;
    TextView soru;
    String soruS, cevapS;
    int isaretlenmis_kel_s = 0;  //Kaç kelime işaretlenmiş
    float xx, yy;               // En son eklenen kelimenin konumu
    float w, h;                // En son eklenen kelimenin boyutları

    Point P1, P2, P3, P4;

    String[] kelimeler;

    int s1 = 0;
    int s2 = 0;
    int s3 = 0;
    int s4 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bK1 = findViewById(R.id.kel1);
        bK2 = findViewById(R.id.kel2);
        bK3 = findViewById(R.id.kel3);
        bK4 = findViewById(R.id.kel4);
        bKontrol = findViewById(R.id.btnKontrol);
        soru = findViewById(R.id.soru);

        soruS = soru.getText().toString();

        kelimeler = soruS.split(" ");

        StringBuilder sb = new StringBuilder(soruS);

        Log.d("1111111111111", soruS);

        int u = kelimeler[kelimeler.length-1].length();

        StringBuilder sbb = new StringBuilder(kelimeler[kelimeler.length-1]);

        if(kelimeler[0].charAt(0) == '"'){
            kelimeler[0] = kelimeler[0].substring(1,kelimeler[0].length());
        }
        if(kelimeler[kelimeler.length-1].charAt(u-1) == '"'){
            kelimeler[kelimeler.length-1] =  kelimeler[kelimeler.length-1].substring(0,kelimeler[kelimeler.length-1].length()-1);
        }
        //Soru içerisindeki kelimelerimiz hazır //kelimeler içerisinde

        P1 = getPointOfView(bK1);
        Log.d("*******", "view point x,y (" + P1.x + ", " + P1.y + ")");
        P2 = getPointOfView(bK2);
        Log.d("*******", "view point x,y (" + P2.x + ", " + P2.y + ")");
        P3 = getPointOfView(bK3);
        Log.d("*******", "view point x,y (" + P3.x + ", " + P3.y + ")");
        P4 = getPointOfView(bK4);
        Log.d("*******", "view point x,y (" + P4.x + ", " + P4.y + ")");
    }




    private Point getPointOfView(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void kaydir1(View v){


       if(s1 == 0){
           if(isaretlenmis_kel_s == 0){

               bK1.animate().x(50).y(450).withEndAction(new Runnable() {
                   @Override
                   public void run() {
                       isaretlenmis_kel_s++;
                       s1 = 1;
                       xx = bK1.getX();
                       yy = bK1.getY();
                       w = bK1.getWidth();
                       h = bK1.getHeight();
                       cevapS = kelimeler[0];
                       Log.d("--------------------", "w:"+w+"----"+"h:"+h);
                       Log.d("--------------------", "xx:" + xx + "----" + " yy:"+yy);
                       Log.d("********************", ""+cevapS);
                   }
               });
           }
           else{ //xx= 50
               bK1.animate().x(xx+w).y(450).withEndAction(new Runnable() {
                   @Override
                   public void run() {
                       isaretlenmis_kel_s++;
                       s1 = 1;
                       xx = bK1.getX();
                       yy =  bK1.getY();
                       w = bK1.getWidth();
                       h = bK1.getHeight();
                       cevapS = cevapS+kelimeler[0];
                       Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                       Log.d("********************", ""+cevapS);
                   }
               });
           }
       }
       else if(s1 == 1) {
           bK1.animate().x(P1.x).y(P1.y).withEndAction(new Runnable() {
               @Override
               public void run() {
                   isaretlenmis_kel_s--;
                   s1 = 0;
                   xx = bK1.getX();
                   yy = bK1.getY();
                   w = bK1.getWidth();
                   h = bK1.getHeight();
                   Log.d("--------------------", "xx:" + xx + "----" + " yy:" + yy);
                   Log.d("********************", ""+cevapS);
               }
           });
       }


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void kaydir2(View v){

        if(s2 == 0){
            if(isaretlenmis_kel_s == 0){

                bK2.animate().x(50).y(450).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        s2 = 1;
                        isaretlenmis_kel_s++;
                        xx = bK2.getX();
                        yy = bK2.getY();
                        w = bK2.getWidth();
                        h = bK2.getHeight();
                        cevapS = kelimeler[1];
                        Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                        Log.d("********************", ""+cevapS);
                    }
                });

            }
            else{
                bK2.animate().x(xx+w).y(450).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        s2 = 1;
                        isaretlenmis_kel_s++;
                        xx =  bK2.getX();
                        yy =  bK2.getY();
                        w = bK2.getWidth();
                        h = bK2.getHeight();
                        cevapS = cevapS+kelimeler[1];
                        Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                        Log.d("********************", ""+cevapS);
                    }
                });

            }
        }
        else if(s2 == 1){
            bK2.animate().x(P2.x).y(P2.y).withEndAction(new Runnable() {
                @Override
                public void run() {
                    s2 = 0;
                    isaretlenmis_kel_s--;
                    s2 = 0;
                    xx = bK2.getX();
                    yy = bK2.getY();
                    w = bK2.getWidth();
                    h = bK2.getHeight();
                    Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                    Log.d("********************", ""+cevapS);
                }
            });
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void kaydir3(View v){

        if(s3 == 0){
            if(isaretlenmis_kel_s == 0){

                bK3.animate().x(50).y(450).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        s3 = 1;
                        isaretlenmis_kel_s++;
                        xx = bK3.getX();
                        yy = bK3.getY();
                        w = bK3.getWidth();
                        h = bK3.getHeight();
                        cevapS = kelimeler[2];
                        Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                        Log.d("********************", ""+cevapS);
                    }
                });

            }
            else {
                bK3.animate().x(xx+w).y(450).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        s3 = 1;
                        isaretlenmis_kel_s++;
                        xx =  bK3.getX();
                        yy =  bK3.getY();
                        w = bK3.getWidth();
                        h = bK3.getHeight();
                        cevapS = cevapS+kelimeler[2];
                        Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                        Log.d("********************", ""+cevapS);
                    }
                });

            }
        }
        else if(s3 == 1){
            bK3.animate().x(P3.x).y(P3.y).withEndAction(new Runnable() {
                @Override
                public void run() {
                    s3 = 0;
                    isaretlenmis_kel_s--;
                    xx = bK3.getX();
                    yy = bK3.getY();
                    w = bK3.getWidth();
                    h = bK3.getHeight();
                    Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                    Log.d("********************", ""+cevapS);
                }
            });
        }


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void kaydir4(View v){

        if(s4 == 0){
            if(isaretlenmis_kel_s == 0){

                bK4.animate().x(50).y(450).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        s4 = 1;
                        isaretlenmis_kel_s++;
                        xx = bK4.getX();
                        yy = bK4.getY();
                        w = bK4.getWidth();
                        h = bK4.getHeight();
                        cevapS = kelimeler[3];
                        Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                        Log.d("********************", ""+cevapS);
                    }
                });

            }
            else {
                bK4.animate().x(xx+w).y(450).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        s4 = 1;
                        isaretlenmis_kel_s++;
                        xx = bK4.getX();
                        yy = bK4.getY();
                        w = bK4.getWidth();
                        h = bK4.getHeight();
                        cevapS = cevapS+kelimeler[3];
                        Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                        Log.d("********************", ""+cevapS);
                    }
                });

            }
        }
        else if(s4 == 1){
            bK4.animate().x(P4.x).y(P4.y).withEndAction(new Runnable() {
                @Override
                public void run() {
                    isaretlenmis_kel_s--;
                    s4 =0;
                    xx = bK4.getX();
                    yy = bK4.getY();
                    w = bK4.getWidth();
                    h = bK4.getHeight();
                    Log.d("--------------------", "xx:"+xx+"----"+"xx:"+xx);
                    Log.d("********************", ""+cevapS);
                }
            });
        }



    }




}
