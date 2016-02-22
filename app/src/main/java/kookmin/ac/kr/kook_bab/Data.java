package kookmin.ac.kr.kook_bab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Data extends AppCompatActivity{
    SQLiteDatabase db;
    String dbName = "log.db";
    String tableName = "logListTable";
    int dbMode = Context.MODE_PRIVATE;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        db = openOrCreateDatabase(dbName,dbMode,null);
        createTable();

        insertData("그림비",37.610368 ,126.993525 , "한식", "010");
        insertData("송백식당",37.610385 ,126.994300, "한식", "010");
        insertData("명륜골",37.610277,126.994389, "한식", "010");


    }

    public void createTable(){
        try {
            String sql = "create table " + tableName + "(id integer primary key autoincrement, name TEXT, lon TEXT, lat TEXT, type TEXT, tel TEXT)";
            db.execSQL(sql);
        } catch (android.database.sqlite.SQLiteException e) {
        }
    }
    //Data 추가
    public void insertData(String name,Double lon,Double lat,String type,String tel) {
        String sql = "INSERT INTO " + tableName + " VALUES (NULL, '" +name +  "', '" + lon + "', '" + lat + "', '" + type + "', '" + tel + "');";
        db.execSQL(sql);
    }

}
