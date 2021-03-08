package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

               //You need a default sms app to run this program , which your emulator doesnt have

//                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("msg"+no));
//                i.putExtra("sms body",msg);
//                i.setType("vnd.android-dir/mms-sms");
//                startActivity(i);

                // This is how you actually do ( or how i do )

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address"  , new String ("9741809115"));
                smsIntent.putExtra("sms_body"  , "Test ");
                startActivity(smsIntent);

            }
        });
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}