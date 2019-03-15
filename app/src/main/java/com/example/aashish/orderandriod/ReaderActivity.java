package com.example.aashish.orderandriod;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ReaderActivity extends AppCompatActivity {

    private Button scan_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        scan_btn = (Button) findViewById(R.id.scan_btn);
        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();




            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {


            if (result.getContents() == null) {
                Toast.makeText(this, "You Cancelled the Scanning ", Toast.LENGTH_SHORT).show();

            } else {


                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();  // For spliting link
                String[] words = result.getContents().split("=");
                String[] word = words[1].split("&");

                System.out.println(words);
                Intent intent = new Intent(ReaderActivity.this, AfterReading.class);
                startActivity(intent);



//                Toast.makeText(this, "id is :" + word[0] , Toast.LENGTH_SHORT).show();              // For spiling of id and table
//                Toast.makeText(this, "Table number is :" + words[2], Toast.LENGTH_SHORT).show();




            }
        } else {


            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
