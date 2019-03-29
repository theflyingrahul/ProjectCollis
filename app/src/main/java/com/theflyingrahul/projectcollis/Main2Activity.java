package com.theflyingrahul.projectcollis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
EditText t1, t2, t3, t4, t5;
String s1, s2, s3, s4, s5;
DbMan dbMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1 = findViewById(R.id.editTextName);
        t2 = findViewById(R.id.editTextPass);
        t3 = findViewById(R.id.editTextMail);
        t4 = findViewById(R.id.editTextCity);
        t5 = findViewById(R.id.editTextBG);
        dbMan = new DbMan(Main2Activity.this);

    }

    public void signup(View view) {
        s1 = t1.getText().toString();
        s2 = t2.getText().toString();
        s3 = t3.getText().toString();
        s4 = t4.getText().toString();
        s5 = t5.getText().toString();

        long j = dbMan.insertData(s1, s2, s3, s4, s5);

        Toast.makeText(this, "Registered user: "+j, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        intent.putExtra("name", s1);
        intent.putExtra("pass", s2);
        intent.putExtra("mail", s3);
        intent.putExtra("city", s4);
        intent.putExtra("bg", s5);
        startActivity(intent);
    }
}
