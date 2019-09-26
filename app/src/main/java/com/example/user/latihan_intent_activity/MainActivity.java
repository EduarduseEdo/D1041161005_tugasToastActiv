package com.example.user.latihan_intent_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    int quantity ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String nim = intent.getStringExtra(Intent.EXTRA_TEXT);

        TextView textView =findViewById(R.id.nama);
        textView.setText("Hallo Edo");
        TextView textView2 =findViewById(R.id.nomor);
        textView2.setText(nim.substring(nim.length()-2));
        quantity = Integer.parseInt(nim.substring(nim.length()-2));
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;}else{
            backToast=Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
    public void increment(View view){
        if (quantity == 100) {
            backToast=Toast.makeText(getBaseContext(), "Mencapai Angka Maksimum", Toast.LENGTH_SHORT);
            backToast.show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    public void decrement(View view){
        if (quantity == 0) {
            backToast=Toast.makeText(getBaseContext(), "Mencapai Angka Minimum", Toast.LENGTH_SHORT);
            backToast.show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    private void displayQuantity(int number) {
        TextView textView2 = (TextView) findViewById(
                R.id.nomor);
        textView2.setText("" + number);
    }

}
