package kookmin.ac.kr.kook_bab;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.*;

public class GoogleMapActivity extends AppCompatActivity {

    SQLiteDatabase db;
    String dbName = "log.db";
    String tableName = "logListTable";
    int dbMode = Context.MODE_PRIVATE;

    //Object about Googlemap
    private GoogleMap map;
    static final LatLng SEOUL = new LatLng( 37.611141, 126.997289);

    GoogleApiClient googleApiClient;

    String whattype;
    String lon,lat;
    double mlon,mlat;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);


        //구글 맵 관련 메소드
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        map = mapFragment.getMap();

        db = openOrCreateDatabase(dbName, dbMode, null);
        createTable();


        insertData("그림비", 37.610368, 126.993525, "한식", "010");

        //현재 위치로 가는 버튼 표시
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 16));
        whattype = getIntent().getExtras().getString("type");
        selectDataAll(whattype);

    }

    public void selectDataAll(String what) {
        String sql = "select * from " + tableName + ";";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();

        while (!result.isAfterLast()) {
            String act = result.getString(4);

            if(act.equals(what)) {
                lon = result.getString(2);
                lat = result.getString(3);
                Log.d("lab_sqlite", "index= " + lon + " name=" + lat);

                mlon = Double.valueOf(lon);
                mlat = Double.valueOf(lat);
                Log.d("lab_sqlite", "d= " + mlon + " ae=" + mlat);

                final LatLng ThisLocation = new LatLng(mlon, mlat);
                Marker my = map.addMarker(new MarkerOptions().position(ThisLocation).title("그림비"));
            }
            result.moveToNext();
        }
        result.close();
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
        try {
            String sql = "INSERT INTO " + tableName + " VALUES (NULL, '" + name + "', '" + lon + "', '" + lat + "', '" + type + "', '" + tel + "'); WHERE NOT EXISTS (SELECT name FROM " + tableName + ")";
            db.execSQL(sql);
        }catch(Exception e){

        }
    }
}
