package com.ghanem.nour.ebd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread(){

            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    CheckUser();
                }
            }
        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
            finish();
    }

    private void CheckUser() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
