package com.daimao.atry;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Game extends AppCompatActivity {
    private enum napis {czerwony, żółty, zielony, niebieski}


    Random r = new Random();
    private int losNapis, losKolor;
    private String wylosowanyNapis;
    private int wylosowanyKolor;
    Button button1, button2, button3, button4, nextButton;
    TextView mainText;
    String s1, s2, s3, s4, naglowek;
    int k1, k2, k3, k4;
    int punkty;
    TextView licznik;
    String sLicznik;
    int wylosowanyKolorNaglowka;

    TextView textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        punkty = 0;

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        nextButton = (Button) findViewById(R.id.nextButton);
        mainText = (TextView) findViewById(R.id.mainText);
        licznik = (TextView) findViewById(R.id.licznik);
        licznik.setText("Punkty: 0");

        textViewTime = (TextView) findViewById(R.id.textViewTime);

        textViewTime.setText("Czas: 03:00");

        final CounterClass timer = new CounterClass(45000, 1000);
        timer.start();


        uzupelnijDane();

    }

    public void back(View view) {
        finish();
    }

    public String losujNapis() {
        losNapis = r.nextInt(4) + 1;
        switch (losNapis) {
            case 1:
                wylosowanyNapis = napis.czerwony.toString();
                break;
            case 2:
                wylosowanyNapis = napis.żółty.toString();
                break;
            case 3:
                wylosowanyNapis = napis.zielony.toString();
                break;
            case 4:
                wylosowanyNapis = napis.niebieski.toString();
                break;
        }
        return wylosowanyNapis;
    }

    public void losujKolor() {
        losKolor = r.nextInt(4) + 1;
        switch (losKolor) {
            case 1:
                wylosowanyKolor = Color.YELLOW;
                break;
            case 2:
                wylosowanyKolor = Color.RED;
                break;
            case 3:
                wylosowanyKolor = Color.BLUE;
                break;
            case 4:
                wylosowanyKolor = Color.GREEN;
                break;
        }
    }

    public int losujKolorNaglowka() {
        losKolor = r.nextInt(4) + 1;
        switch (losKolor) {
            case 1:
                wylosowanyKolorNaglowka = Color.BLUE;
                break;
            case 2:
                wylosowanyKolorNaglowka = Color.YELLOW;
                break;
            case 3:
                wylosowanyKolorNaglowka = Color.GREEN;
                break;
            case 4:
                wylosowanyKolorNaglowka = Color.RED;
                break;
        }
        return wylosowanyKolorNaglowka;
    }


    public void uzupelnijDane() {
        naglowek = losujNapis().toUpperCase();
        mainText.setTextColor(losujKolorNaglowka());
        mainText.setText("Dotknij poprawny napis: \n" + naglowek);
        button1.setText(s1 = losujNapis());
        while (s1.equals(wylosowanyNapis) == true)
            losujNapis();
        button2.setText(s2 = wylosowanyNapis);
        while (s1.equals(wylosowanyNapis) == true || s2.equals(wylosowanyNapis) == true)
            losujNapis();
        button3.setText(s3 = wylosowanyNapis);
        while (s1.equals(wylosowanyNapis) == true || s2.equals(wylosowanyNapis) == true || s3.equals(wylosowanyNapis) == true)
            losujNapis();
        button4.setText(s4 = wylosowanyNapis);

        losujKolor();
        button1.setBackgroundColor(k1 = wylosowanyKolor);
        while (wylosowanyKolor == k1)
            losujKolor();
        button2.setBackgroundColor(k2 = wylosowanyKolor);
        while (wylosowanyKolor == k1 || wylosowanyKolor == k2)
            losujKolor();
        button3.setBackgroundColor(k3 = wylosowanyKolor);
        while (wylosowanyKolor == k1 || wylosowanyKolor == k2 || wylosowanyKolor == k3)
            losujKolor();
        button4.setBackgroundColor(k4 = wylosowanyKolor);


    }

    //test przycisków - sprawdza poprawność odpowiedzi. Odejmuje życie za złe odpowiedzi
    public void button1Clicked(View view) {
        if (naglowek.toUpperCase().equals(s1.toUpperCase()) == true) {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Dobrze!");
            punkty++;
        } else {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Źle!");
        }
    }

    public void button2Clicked(View view) {
        if (naglowek.toUpperCase().equals(s2.toUpperCase()) == true) {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Dobrze!");
            punkty++;
        } else {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Źle!");
        }
    }

    public void button3Clicked(View view) {
        if (naglowek.toUpperCase().equals(s3.toUpperCase()) == true) {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Dobrze!");
            punkty++;
        } else {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Źle!");
        }
    }

    public void button4Clicked(View view) {
        if (naglowek.toUpperCase().equals(s4.toUpperCase()) == true) {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Dobrze!");
            punkty++;
        } else {
            mainText.setTextColor(Color.BLACK);
            mainText.setText("Źle!");
        }
    }

    public void nextClick(View view) {

        uzupelnijDane();
        sLicznik = Integer.toString(punkty);
        licznik.setText("Punkty: " + sLicznik);
    }
    //przerobić to tak, aby w lewym górnym rogu pokazywał czas (np.30 sekund), w prawym punkty.  W ciągu tego czasu trzeba zaznaczyć X poprawnych odpowiedzi, żeby wygrać.

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            textViewTime.setText("Czas: " + hms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            textViewTime.setText("Koniec czasu!");
            if (punkty >= 20) {
                mainText.setText("GRATULACJE! WYGRAŁEŚ! \n Liczba zdobytych punktów: " + sLicznik);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                nextButton.setEnabled(false);
                nextButton.setText("");

            } else {
                mainText.setText("Niestety nie udało Ci się osiągnąć 20 punktów w wyznaczonym czasie. Przegrałeś :(");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                nextButton.setEnabled(false);
                nextButton.setText("");

            }
        }


    }

}
