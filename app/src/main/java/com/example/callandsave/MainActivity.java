package com.example.callandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText display;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnCall, btnSave, btnStar, btnHash, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.but0);
        btn1 = findViewById(R.id.but1);
        btn2 = findViewById(R.id.but2);
        btn3 = findViewById(R.id.but3);
        btn4 = findViewById(R.id.but4);
        btn5 = findViewById(R.id.but5);
        btn6 = findViewById(R.id.but6);
        btn7 = findViewById(R.id.but7);
        btn8 = findViewById(R.id.but8);
        btn9 = findViewById(R.id.but9);

        btnHash = findViewById(R.id.buth);
        btnSave = findViewById(R.id.butsave);
        btnStar = findViewById(R.id.buts);
        btnCall = findViewById(R.id.butcall);
        btnRemove = findViewById(R.id.butdel);

        display = findViewById(R.id.display);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("9");
            }
        });
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("*");
            }
        });
        btnHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("#");
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = display.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+data));
                startActivity(intent);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = display.getText().toString();

                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,data);
                startActivity(intent);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = display.getText().toString();
                if(data.length()>0) {
                    String val = data.substring(0,data.length()-1);
                    display.setText(val);
                }
                else{
                    display.setText("");
                }

            }
        });
    }
}