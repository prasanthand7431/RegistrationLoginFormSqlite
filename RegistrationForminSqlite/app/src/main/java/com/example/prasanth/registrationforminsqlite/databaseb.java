package com.example.prasanth.registrationforminsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class databaseb extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public databaseb(Context context) {
        super(context, "Students.db", null, 1);
        sqLiteDatabase=getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table details(Name text,MobileNumber text,Email text,Password text,Confirmpassword)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long saveit(String sName,String sMobileNumber,String sEmail,String sPassword,String sConfirmpassword){

        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",sName);
        contentValues.put("MobileNumber",sMobileNumber);
        contentValues.put("Email",sEmail);
        contentValues.put("Password",sPassword);
        contentValues.put("Confirmpassword",sConfirmpassword);
        long k=sqLiteDatabase.insert("details",null,contentValues);
        return k;
        }

        public int checkuser(String sEmail,String sPassword){

            Log.d(TAG,"checkUser is called ");

            Cursor cursor;
            cursor=sqLiteDatabase.query("details",null,"Email=?",new String[]{sEmail},null,null,null);
            cursor.moveToFirst();
            String tem=cursor.getString(cursor.getColumnIndex("Password"));

            Log.d(TAG,"password is "+tem);

            if(sPassword.equals(tem)){
                return 1;
            }else{

                return 0;
            }
    }

//    public  Cursor fetchData(String userid){
//
//        Cursor cursor;
//        cursor=mSQLiteDatabase.query("users_data",null,"Number=?",new String[]{userid},null,null,null);
//        cursor.moveToFirst();
//
//        return cursor;
//    }
//}


}
