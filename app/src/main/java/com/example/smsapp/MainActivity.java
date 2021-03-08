package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1=(EditText)findViewById(R.id.e1);
                String no=e1.getText().toString();
                EditText e2=(EditText)findViewById(R.id.e2);
                String msg=e2.getText().toString();

                Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("msg"+no));
                i.putExtra("sms body",msg);
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);
            }
        });
    }
}