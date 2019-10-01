package com.erikriosetiawan.cubecalc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cardViewMenuKubus, cardViewBalok, cardViewLimasSegiempat, cardViewPrismaSegitiga, cardViewLimasSegitiga, cardViewTabung, cardViewKerucut, cardViewBola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewMenuKubus = findViewById(R.id.menu_kubus);
        cardViewMenuKubus.setOnClickListener(this);

        cardViewBalok = findViewById(R.id.menu_balok);
        cardViewBalok.setOnClickListener(this);

        cardViewLimasSegiempat = findViewById(R.id.menu_limas_segiempat);
        cardViewLimasSegiempat.setOnClickListener(this);

        cardViewPrismaSegitiga = findViewById(R.id.menu_prisma_segitiga);
        cardViewPrismaSegitiga.setOnClickListener(this);

        cardViewLimasSegitiga = findViewById(R.id.menu_limas_segitiga);
        cardViewLimasSegitiga.setOnClickListener(this);

        cardViewTabung = findViewById(R.id.menu_tabung);
        cardViewTabung.setOnClickListener(this);

        cardViewKerucut = findViewById(R.id.menu_kerucut);
        cardViewKerucut.setOnClickListener(this);

        cardViewBola = findViewById(R.id.menu_bola);
        cardViewBola.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_kubus:
                Intent intentKubus = new Intent(MainActivity.this, KubusActivity.class);
                startActivity(intentKubus);
                break;
            case R.id.menu_balok:
                Intent intentBalok = new Intent(MainActivity.this, BalokActivity.class);
                startActivity(intentBalok);
                break;
            case R.id.menu_limas_segiempat:
                Intent intentLimasSegiempat = new Intent(MainActivity.this, LimasSegiEmpatActivity.class);
                startActivity(intentLimasSegiempat);
                break;
            case R.id.menu_prisma_segitiga:
                Intent intentPrismaSegitiga = new Intent(MainActivity.this, PrismaSegitigaActivity.class);
                startActivity(intentPrismaSegitiga);
                break;
            case R.id.menu_limas_segitiga:
                Intent intentLimasSegitiga = new Intent(MainActivity.this, LimasSegitigaActivity.class);
                startActivity(intentLimasSegitiga);
                break;
            case R.id.menu_tabung:
                Intent intentTabung = new Intent(MainActivity.this, TabungActivity.class);
                startActivity(intentTabung);
                break;
            case R.id.menu_kerucut:
                Intent intentKerucut = new Intent(MainActivity.this, KerucutActivity.class);
                startActivity(intentKerucut);
                break;
            case R.id.menu_bola:
                Intent intentBola = new Intent(MainActivity.this, BolaActivity.class);
                startActivity(intentBola);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hai! Coba aplikasi saya di: https://play.google.com/store/apps/details?id=com.erikriosetiawan.cubecalc");
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
                break;
            case R.id.rate:
                String url = "https://play.google.com/store/apps/details?id=com.erikriosetiawan.cubecalc";
                Intent rateIntent = new Intent(Intent.ACTION_VIEW);
                rateIntent.setData(Uri.parse(url));
                startActivity(rateIntent);
                break;
            case R.id.feedback:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "erikrio.16061@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Kirim email..."));
                break;
            case R.id.about_me:
                Intent aboutMeIntent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(aboutMeIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
