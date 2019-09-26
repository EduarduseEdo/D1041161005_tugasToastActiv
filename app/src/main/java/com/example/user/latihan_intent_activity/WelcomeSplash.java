package com.example.user.latihan_intent_activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeSplash extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splash);
        Toast.makeText(this,"Selamat Datang", Toast.LENGTH_LONG).show();
//        new android.os.Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent splashScreen = new Intent(WelcomeSplash.this,MainActivity.class);
//                startActivity(splashScreen);
//                finish();
//            }
//        },3000);

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
    public void onSubmit(View view) {
        EditText nimField = (EditText) findViewById(R.id.nim_field);
        Editable nimEditable = nimField.getText();
        String nim = nimEditable.toString();

        Intent intent = new Intent(WelcomeSplash.this, MainActivity.class);
//        intent.setData(Uri.parse("mailto: "));
//        intent.putExtra(Intent.EXTRA_SUBJECT,
//                getString(R.string.order_summary_email_subject, Name));
        intent.putExtra(intent.EXTRA_TEXT, nim);
//
//        if (intent.resolveActivity(getPackageManager()) != null){
//            startActivity(intent);
//        }
        startActivity(intent);
        finish();

    }

}
