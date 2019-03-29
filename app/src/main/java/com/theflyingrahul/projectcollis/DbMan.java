package com.theflyingrahul.projectcollis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbMan extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;
    public DbMan(Context context) {
        super(context, "userDetails.db", null, 1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table logininfo(name text, mail text, pass text, city text, bg text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long insertData(String s1, String s2, String s3, String s4, String s5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", s1);
        contentValues.put("mail", s3);
        contentValues.put("pass", s2);
        contentValues.put("city", s4);
        contentValues.put("bg", s5);

        long j = sqLiteDatabase.insert("logininfo", null, contentValues);
        return j;
    }

    public String getDetails(String s) {
        Cursor cursor;
        cursor = sqLiteDatabase.query("logininfo", null, "name=?", new String[]{s}, null, null, null);
        cursor.moveToFirst();
        String s2="";
        if(cursor.getCount()<1) {
            s2 += "";
            return s2;
        }
        s2 += cursor.getString(cursor.getColumnIndex("mail"))+"\n";
        s2 += cursor.getString(cursor.getColumnIndex("city"))+"\n";
        s2 += cursor.getString(cursor.getColumnIndex("bg"));
        return s2;
    }

    public boolean getLogin(String mail, String pass) {
        Cursor cursor;
        String query = "select * from logininfo where mail='"+mail+"' and pass='"+pass+"'";
        cursor = sqLiteDatabase.rawQuery(query, null);
                //query("logininfo", null, "mail=? pass=?", new String[]{mail, pass}, null,null, null);
        if(cursor.getCount()==1)
            return true;
        else
            return false;
    }
}
