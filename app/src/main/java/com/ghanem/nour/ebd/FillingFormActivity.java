package com.ghanem.nour.ebd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FillingFormActivity extends AppCompatActivity {

    private RadioGroup aBalance,bBalance,abBalance,oBalance,bloodBalance;
    private RadioButton a,b,ab,o;
    private CheckBox bloodPressure;

    private TextView mback,mnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filling_form);


        aBalance = findViewById(R.id.a_balance);
        bBalance = findViewById(R.id.b_balance);
        abBalance = findViewById(R.id.ab_balance);
        oBalance = findViewById(R.id.o_balance);
        bloodBalance = findViewById(R.id.check_balance);
        bloodBalance.setVisibility(View.INVISIBLE);

        a = findViewById(R.id.filing_blooda);
        b = findViewById(R.id.filing_bloodb);
        ab = findViewById(R.id.filing_bloodab);
        o = findViewById(R.id.filing_bloodo);

        bloodPressure = findViewById(R.id.chech_blood);



        mback = findViewById(R.id.back);
        mnext = findViewById(R.id.next);

        SetVisibilty();

        bloodPressure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    bloodBalance.setVisibility(View.VISIBLE);
                }else {
                    bloodBalance.setVisibility(View.INVISIBLE);
                }
            }
        });
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToLoginActivity();
            }
        });

        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ShowingTheCorrectItem(1);
                }
            }});
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ShowingTheCorrectItem(2);
                }
            }});
        ab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ShowingTheCorrectItem(3);
                }
            }});
        o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ShowingTheCorrectItem(4);
                }
            }});





    }

    private void ShowingTheCorrectItem(int value) {
        switch (value){
            case 1 :
                SetVisibilty();
                aBalance.setVisibility(View.VISIBLE);
                break;
            case 2:
                SetVisibilty();
                bBalance.setVisibility(View.VISIBLE);
                break;
            case 3:
                SetVisibilty();
                abBalance.setVisibility(View.VISIBLE);
                break;
            case 4:
                SetVisibilty();
                oBalance.setVisibility(View.VISIBLE);
                break;
            default:
                SetVisibilty();
        }
    }


    private void SetVisibilty() {
        aBalance.setVisibility(View.INVISIBLE);
        bBalance.setVisibility(View.INVISIBLE);
        abBalance.setVisibility(View.INVISIBLE);
        oBalance.setVisibility(View.INVISIBLE);

    }


    private void SendUserToLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
