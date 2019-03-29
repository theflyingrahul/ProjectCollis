package com.theflyingrahul.projectcollis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
EditText t1, t2;
String s1, s2;
DbMan dbMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.editTextMailIN);
        t2 = findViewById(R.id.editTextPassIN);
        dbMan = new DbMan(MainActivity.this);
    }

    public void signup(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void signin(View view) {
        s1 = t1.getText().toString();
        s2 = t2.getText().toString();
        if(checkIn(s1, s2)) {
            Intent intent2 = new Intent(MainActivity.this, Main3Activity.class);
            intent2.putExtra("mail", s1);
            intent2.putExtra("pass", s2);
            startActivity(intent2);
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Invalid Credentials!");
            builder.setMessage("Invalid user name or password.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
    }

    private boolean checkIn(String mail, String pass) {
        return dbMan.getLogin(mail, pass);

    }

    public void ui2_0(View view) {
        Intent intent3 = new Intent(MainActivity.this, NewHomeActivity.class);
        startActivity(intent3);
    }
}
