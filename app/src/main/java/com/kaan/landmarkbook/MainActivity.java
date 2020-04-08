package com.kaan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //app açıldığında liste görmek için,

        ListView listView = findViewById(R.id.listView);

        //Data

        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Eiffel Tower");
        landmarkNames.add("Mont Saint-Michel");
        landmarkNames.add("Acropolis");
        landmarkNames.add("Christ the Redeemer");
        landmarkNames.add("Blue Mosque");


        final ArrayList<String> countryNames = new ArrayList<>();

        countryNames.add("Paris, France");
        countryNames.add("Normandy, France");
        countryNames.add("Athens, Greece");
        countryNames.add("Rio de Janeiro, Brazil");
        countryNames.add("Istanbul, Turkey");



        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap saintmichel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.saintmichel);
        Bitmap acropolis = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.acropolis);
        Bitmap saviorjesus = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.saviorjesus);
        Bitmap bluemosque = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bluemosque);


        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(eiffel);
        landmarkImages.add(saintmichel);
        landmarkImages.add(acropolis);
        landmarkImages.add(saviorjesus);
        landmarkImages.add(bluemosque);




        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

               // System.out.println(landmarkNames.get(i));
                // System.out.println(countryNames.get(i));

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                // landmarknameleri çekmek için
                intent.putExtra("name",landmarkNames.get(i));
                // countrynamelerini çekmek için
                intent.putExtra("country", countryNames.get(i));
                //selectedImage = landmarkImages.get(i);

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));

                startActivity(intent);


            }
        });

    }
}
