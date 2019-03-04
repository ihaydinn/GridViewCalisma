package com.ismailhakkiaydin.gridviewcalisma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);

        Intent intent=getIntent();
        if(intent!=null)
        {
            ImageView img= (ImageView) findViewById(R.id.iVDialogBayrakResmi);
            TextView text= (TextView) findViewById(R.id.tvDialogUlkeAdi);

            img.setImageResource(intent.getIntExtra("ulkeResmi", R.drawable.ulke1));
            text.setText(intent.getStringExtra("ulkeAdi"));

        }

    }

    public void kapat(View v){
        finish();
    }
}