package kr.co.company.smart_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "MyList.db";  //DB이름

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table list (name text primary key, amount text, caution text)");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS list");
        onCreate(db);
    }

    public boolean insertList(String name, String amount, String caution) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("amount", amount);
        contentValues.put("caution", caution);

        long result = db.insert("list", null, contentValues);
        if(result==-1)
        {
            return false;
        }else {
            return true;
        }
    }

    public void deleteList(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("list","name=?",new String[] {name});
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from list", null);
        return cursor;
    }

}
