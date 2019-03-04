package com.ismailhakkiaydin.gridviewcalisma;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste= (GridView) findViewById(R.id.gVBayrakListesi);
        CustomAdapter adapter=new CustomAdapter(this);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(this);




    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this, MyDialog.class);
        ViewYerTutucu tutucu= (ViewYerTutucu) view.getTag();
        Ulke tiklanilanUlke= (Ulke) tutucu.ulkeResmi.getTag();

        intent.putExtra("ulkeResmi", tiklanilanUlke.ulkeResmi);
        intent.putExtra("ulkeAdi", tiklanilanUlke.ulkeAdi);

        startActivity(intent);


    }


}