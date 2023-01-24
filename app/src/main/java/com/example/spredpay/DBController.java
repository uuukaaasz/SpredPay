package com.example.spredpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context){
        super(context, "accounts.db" ,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.init(db);
    }

    private void init(SQLiteDatabase db) {
        db.execSQL(
                "create table if not exists quiz (" +
                        "id integer primary key autoincrement," +
                        "username text," +
                        "password text," +
                        "pin_code integer," +
                        "bank float," +
                        "crypto float," +
                        "spred float);" + "");
    }

    //-------------------------- USERS --------------------------
    public void InsertDataBase(Users users) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", users.getUsername());
        values.put("password", users.getPassword());
        values.put("pin_code", users.getPin_code());
        values.put("bank", users.getBank());
        values.put("crypto", users.getCrypto());
        values.put("spred", users.getSpred());
        db.insertOrThrow("users",null, values);
    }

    public List<SpinnerObject> getDataById(int Id) {
        List<SpinnerObject> read = new ArrayList<SpinnerObject>();
        String query =  "SELECT users.id, quiz.question" +
                " FROM" + " users" +
                " WHERE users.id = " + Id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.rawQuery(query, null);
        while (kursor.moveToNext()) {
            read.add(new SpinnerObject(kursor.getInt(0), kursor.getString(1)));
        }
        return read;
    }

    public void RemoveAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS users");
        init(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
