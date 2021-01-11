package com.example.myapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;
    private static final String databaseName="dbTest";

    private String sql="";
    Context context;

    public DatabaseHelper(Context context) {
        super(context, databaseName,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        String createTable="create table tbemployee(id integer primary key Autoincrement, name text(20), surename text(20), age integer, tel text(12));";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //tdod: drop older table
//        db.execSQL("Drop table if exists "+tableName);
    }

    public  long saveData( String name, String surname, int age, String tel){
        //todo: insert data
        try {
            database=this.getWritableDatabase();
            sql="Insert into tbemployee(name, surename, age, tel) Values (?,?,?,?)";
            SQLiteStatement stm= database.compileStatement(sql);
            stm.bindString(1,name);
            stm.bindString(2,surname);
            stm.bindLong(3,age);
            stm.bindString(4,tel);
            long ex=stm.executeInsert();
            database.close();
            return ex;
        }catch (Exception ex){
            Toast.makeText(context,"Error: "+ex.getMessage(),Toast.LENGTH_LONG).show();
            return -1;
        }
    }

    public  int updateData(int id, String name, String surname, int age, String tel){
        //todo: update data
        try {
            database=this.getWritableDatabase();
            sql="Update tbemployee Set name=?, surename=?, age=?, tel=? Where id=?";
            SQLiteStatement stm= database.compileStatement(sql);
            stm.bindString(1,name);
            stm.bindString(2,surname);
            stm.bindLong(3,age);
            stm.bindString(4,tel);
            stm.bindLong(5,id);
            int ex=stm.executeUpdateDelete();
            database.close();
            return ex;
        }catch (Exception ex){
            Toast.makeText(context,"Error: "+ex.getMessage(),Toast.LENGTH_LONG).show();
            return -1;
        }
    }

    public  int deleteData(int id){
        //todo: delete data
        try {
            database=this.getWritableDatabase();
            sql="Delete From tbemployee Where id="+id;
            SQLiteStatement stm= database.compileStatement(sql);
            int ex=stm.executeUpdateDelete();
            database.close();
            return ex;
        }catch (Exception ex){
            Toast.makeText(context,"Error: "+ex.getMessage(),Toast.LENGTH_LONG).show();
            return  -1;
        }
    }

    public String[] findByName(String name){
        try {
            String data[]=null;
            database=this.getReadableDatabase();
            sql="Select * From tbemployee Where name=?";
            String[] values=new String[] {name};
            Cursor cursor=database.rawQuery(sql,values);
            if(cursor!=null){
                if(cursor.moveToFirst()){
                    data=new  String[cursor.getColumnCount()];
                    data[0]=cursor.getString(0);
                    data[1]=cursor.getString(1);
                    data[2]=cursor.getString(2);
                    data[3]=cursor.getString(3);
                    data[4]=cursor.getString(4);
                }
            }
            database.close();
            return  data;
        }catch (Exception ex){
            return  null;
        }
    }

    public ArrayList<String> findAllName(){
        try {
            database=this.getReadableDatabase();
            sql="Select name From tbemployee";
            ArrayList<String> values=new ArrayList<>();
            Cursor cursor=database.rawQuery(sql,null);
            while (cursor.moveToNext()) {
                values.add(cursor.getString(0));
            }
            database.close();
            return values;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
