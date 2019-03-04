package com.ismailhakkiaydin.gridviewcalisma;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


class Ulke {

    int ulkeResmi;
    String ulkeAdi;

    Ulke(int resim, String ad) {
        this.ulkeResmi = resim;
        this.ulkeAdi = ad;

    }

}

class ViewYerTutucu {

    ImageView ulkeResmi;

    ViewYerTutucu(View view) {

        ulkeResmi = (ImageView) view.findViewById(R.id.imageView);

    }


}


public class CustomAdapter extends BaseAdapter {

    ArrayList<Ulke> tumUlkeler;
    Context context;

    CustomAdapter(Context c) {
        this.context = c;
        tumUlkeler = new ArrayList<Ulke>();
        Resources kaynak = c.getResources();
        String[] ulkeAdlari = kaynak.getStringArray(R.array.ulkeAdlari);
        int[] bayrakResimleri = {R.drawable.ulke1, R.drawable.ulke2, R.drawable.ulke3, R.drawable.ulke4,
                R.drawable.ulke5, R.drawable.ulke6, R.drawable.ulke7, R.drawable.ulke8,
                R.drawable.ulke9, R.drawable.ulke10, R.drawable.ulke10, R.drawable.ulke11,
                R.drawable.ulke12, R.drawable.ulke13, R.drawable.ulke14, R.drawable.ulke15,
                R.drawable.ulke16, R.drawable.ulke17, R.drawable.ulke18,
                R.drawable.ulke19, R.drawable.ulke20};


        for (int i = 0; i < 20; i++) {
            /*Ulke geciciUlke=new Ulke();
            geciciUlke.ulkeAdi=ulkeAdlari[i];
            geciciUlke.ulkeResmi=bayrakResimleri[i];
            */
            Ulke gecici = new Ulke(bayrakResimleri[i], ulkeAdlari[i]);


            tumUlkeler.add(gecici);

        }


    }


    @Override
    public int getCount() {
        return tumUlkeler.size();
    }

    @Override
    public Object getItem(int position) {
        return tumUlkeler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View teksatir = convertView;
        ViewYerTutucu tutucu;
        if (teksatir == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            teksatir = inf.inflate(R.layout.tek_satir, parent, false);
            tutucu = new ViewYerTutucu(teksatir);
            teksatir.setTag(tutucu);
        } else {
            tutucu = (ViewYerTutucu) teksatir.getTag();

        }
        Ulke gecici=tumUlkeler.get(position);

        tutucu.ulkeResmi.setImageResource(gecici.ulkeResmi);
        tutucu.ulkeResmi.setTag(gecici);
        return teksatir;
    }
}