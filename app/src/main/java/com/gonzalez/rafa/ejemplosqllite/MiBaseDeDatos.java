package com.gonzalez.rafa.ejemplosqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MiBaseDeDatos extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="misestudiantes.db";
    public static final String TABLE_NAME="estudiantes";

    public static final String COL_1="ID";
    public static final String COL_2="NOMBRE";
    public static final String COL_3="APELLIDOS";
    public static final String COL_4="NOTA";

    public MiBaseDeDatos(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE "+TABLE_NAME+"("+COL_1+" INTERGER PRIMARY KEY AUTOINCREMENT,"+
            COL_2+"TEXT,"+COL_3+"TEXT,"+COL_4+"INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertar(String nombre,String apellidos,String nota){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, apellidos);
        contentValues.put(COL_4, nota);
        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }
}
