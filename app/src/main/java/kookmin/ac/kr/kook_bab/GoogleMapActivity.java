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
    String getPosition;
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
        insertData("그림비", 37.610368, 126.993525, "한식", "010");
        insertData("송백식당", 37.610385, 126.994300, "한식", "010");
        insertData("배밭골", 37.607937, 126.999705, "고기", "");
        insertData("샛별왕족발", 37.607918, 126.999743, "고기", "");
        insertData("현주네포차", 37.607916, 126.999791, "술", "");
        insertData("별밤", 37.607878, 126.999804, "술", "");
        insertData("1박2일", 37.607691, 126.999538, "술", "");
        insertData("감자에빠지다", 37.607706, 126.999707, "한식", "");
        insertData("소문난순대국", 37.607706, 126.999707, "한식", "");
        insertData("풍년포차", 37.607799, 126.999959, "술", "");
        insertData("동아리주점", 37.607612, 126.999903, "술", "");
        insertData("도꼬돈카츠", 37.607498, 127.000123, "양식", "");
        insertData("먹쇠식당", 37.607485, 127.000195, "한식", "");
        insertData("삼성원", 37.607483, 127.000270, "중식", "");
        insertData("청춘노가리", 37.607483, 127.000270, "술", "");
        insertData("고씨네", 37.608165, 126.998585, "양식", "");
        insertData("즐겨찾기", 37.610113, 126.999007, "술", "");
        insertData("보성각", 37.610893, 126.999329, "중식", "");
        insertData("멋진사람들", 37.610912, 126.999388, "한식", "");
        insertData("people's place", 37.610927, 126.999348, "카페", "");
        insertData("봉구스밥버거", 37.610948, 126.999399, "분식", "");
        insertData("이디야 커피", 37.610948, 126.999399, "카페", "");
        insertData("콰이러", 37.611891, 127.002635, "중식", "");
        insertData("명원길 분식", 37.610242, 126.999183, "분식", "");
        insertData("채움늘", 37.610189, 126.999201, "한식", "");
        insertData("이삭토스트", 37.610155, 126.999220, "분식", "");
        insertData("김밥우리", 37.609543, 126.999467, "한식", "");
        insertData("뒤포", 37.609456, 126.999633, "한식", "");
        insertData("거기", 37.609578, 126.999688, "한식", "");
        insertData("소한마리", 37.607819, 127.003369, "고기", "");
        insertData("할매순대국", 37.607919, 127.003881, "한식", "");
        insertData("주경야돈", 37.607931, 127.002362, "고기", "");
        insertData("한솥", 37.607908, 127.002426, "한식", "");
        insertData("옛날참숯화로구이", 37.608270, 127.004222, "고기", "");
        insertData("대전식당", 37.608302, 127.003562, "한식", "");
        insertData("버드나무 식당", 37.608400, 127.003637, "한식", "");
        insertData("caffe TAIN", 37.608292, 127.003841, "카페", "");
        insertData("보리보리", 37.608358, 127.003935, "한식", "");
        insertData("청록원", 37.608398, 127.003989, "중식", "");
        insertData("김밥고을", 37.608659, 127.003951, "한식", "");
        insertData("쌈story", 37.608740, 127.004222, "한식", "");
        insertData("두번째이야기", 37.608710, 127.004386, "한식", "");
        insertData("이모네감자탕", 37.610364, 126.993786, "한식", "");
        insertData("cafe o", 37.610504, 126.994081, "카페", "");
        insertData("푸지매", 37.610304, 126.994105, "고기", "");
        insertData("명륜골 돼지불백", 37.610279, 126.994428, "고기", "");
        insertData("용비어천가", 37.610279, 126.994427, "술", "");
        insertData("작은마을", 37.610205, 126.994575, "한식", "");
        insertData("북악골", 37.610199, 126.994757, "고기", "");
        insertData("치즈밥 있슈?", 37.610091, 126.994926, "한식", "");
        insertData("Dear.Daily", 37.610091, 126.995071, "카페", "");
        insertData("NOM치킨&호프", 37.608211, 126.999125, "치킨", "");
        insertData("송정갈비", 37.608005, 126.999106, "고기", "");
        insertData("북악루", 37.608103, 126.999251, "중식", "");
        insertData("맛짱", 37.608090, 126.999283, "치킨", "");
        insertData("철이네", 37.607984, 126.999152, "고기", "");
        insertData("왕대포", 37.607969, 126.999182, "고기", "");
        insertData("국민닭갈비", 37.608099, 126.999370, "한식", "");
        insertData("BOGNERCOFFEE", 37.607678, 126.999464, "카페", "");
        insertData("Mr.전", 37.607578, 126.999485, "한식", "");
        insertData("미쳐버린파닭", 37.607542, 126.999276, "치킨", "");
        insertData("학교종이,땡땡땡", 37.607512, 126.999284, "한식", "");
        insertData("우리은행 복지관", 37.610519, 126.995881, "atm", "");
        insertData("우리은행 공학관", 37.611779, 126.993905, "atm", "");
        insertData("우리은행 경상관", 37.610795, 126.997628, "atm", "");
        insertData("우리은행 북악관", 37.610795, 126.997628, "atm", "");
        insertData("국민은행 예술관", 37.610198, 126.997755, "atm", "");
        insertData("국민은행 공학관", 37.610198, 126.997755, "atm", "");
        insertData("국민은행 성곡도서관", 37.610198, 126.997755, "atm", "");
        insertData("우체국 복지관", 37.610424, 126.995916, "atm", "");
        insertData("신한은행 북악관", 37.612164, 126.996936, "atm", "");
        insertData("공용", 37.610478, 126.994171, "atm", "");

        //현재 위치로 가는 버튼 표시
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 16));
        whattype = getIntent().getExtras().getString("type");
        selectDataAll(whattype);

        getPosition = getIntent().getExtras().getString("p_id");
        selectData(getPosition);

    }

    public void selectData(String what) {
        String sql = "select * from " + tableName + ";";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();

        while (!result.isAfterLast()) {
            String act = result.getString(0);
            String name = result.getString(1);
            if(act.equals(what)) {
                lon = result.getString(2);
                lat = result.getString(3);
                Log.d("lab_sqlite", "index= " + lon + " name=" + lat);

                mlon = Double.valueOf(lon);
                mlat = Double.valueOf(lat);
                Log.d("lab_sqlite", "d= " + mlon + " ae=" + mlat);

                final LatLng ThisLocation = new LatLng(mlon, mlat);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(ThisLocation, 16));
                Marker my = map.addMarker(new MarkerOptions().position(ThisLocation).title(name).icon(BitmapDescriptorFactory.fromResource(R.drawable.fork)));
                }
            result.moveToNext();
            }
        result.close();


    }

    public void selectDataAll(String what) {
        String sql = "select * from " + tableName + ";";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();

        while (!result.isAfterLast()) {
            String act = result.getString(4);
            String name = result.getString(1);

            if(act.equals(what)) {
                lon = result.getString(2);
                lat = result.getString(3);
                Log.d("lab_sqlite", "index= " + lon + " name=" + lat);

                mlon = Double.valueOf(lon);
                mlat = Double.valueOf(lat);
                Log.d("lab_sqlite", "d= " + mlon + " ae=" + mlat);

                final LatLng ThisLocation = new LatLng(mlon, mlat);
                if(act.equals("atm")) {
                    Marker my = map.addMarker(new MarkerOptions().position(ThisLocation).title(name));
                }
                else {
                    Marker my = map.addMarker(new MarkerOptions().position(ThisLocation).title(name).icon(BitmapDescriptorFactory.fromResource(R.drawable.fork)));
                }
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
