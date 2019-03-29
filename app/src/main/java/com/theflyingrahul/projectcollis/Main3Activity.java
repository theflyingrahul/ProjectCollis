package com.theflyingrahul.projectcollis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
String name, mail, pass, bg, city;
ListView listView;
ArrayAdapter<String> arrayAdapter;
ArrayList<String> arrayList;
DbMan dbMan;
//Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView = findViewById(R.id.listView);
        dbMan = new DbMan(Main3Activity.this);
        //name = getIntent().getStringExtra("name");
        pass = getIntent().getStringExtra("pass");
        mail = getIntent().getStringExtra("mail");
        //bg = getIntent().getStringExtra("bg");
        //city = getIntent().getStringExtra("city");
        arrayList = new ArrayList<>();

        arrayList.add(mail);
        arrayList.add(pass);

        arrayAdapter = new ArrayAdapter<String>(Main3Activity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Main3Activity.this, "You clicked item " + (i + 1), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void find(MenuItem item) {
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        startActivity(intent);
    }

    public void signout(MenuItem item) {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }

    public void locator(MenuItem item) {
        Intent mapIntent = new Intent(Main3Activity.this, MapsActivity.class);
        startActivity(mapIntent);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
