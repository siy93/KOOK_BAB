package kookmin.ac.kr.kook_bab;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class GoogleMapActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    //Object about Googlemap
    private GoogleMap map;
    static final LatLng SEOUL = new LatLng( 37.611141, 126.997289);

    GoogleApiClient googleApiClient;

    double lon,lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);


        //구글 맵 관련 메소드
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        map = mapFragment.getMap();

        //현재 위치로 가는 버튼 표시
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 16));

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .build();
        }

    }


    MyLocation.LocationResult locationResult = new MyLocation.LocationResult() {
        @Override
        public void gotLocation(Location location) {

            String msg = "현재 위치 \n위도: "+location.getLongitude()+" -- 경도: "+location.getLatitude();
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            drawMarker(location);
            lon = location.getLongitude();
            lat = location.getLatitude();
        }
    };


    //구글 맵 관련 메소드
    private void drawMarker(Location location) {

        //기존 마커 지우기
        map.clear();
        LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());

        //currentPosition 위치로 카메라 중심을 옮기고 화면 줌을 조정한다. 줌범위는 2~21, 숫자클수록 확대
        map.moveCamera(CameraUpdateFactory.newLatLngZoom( currentPosition, 17));
        map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);

        //마커 추가
        map.addMarker(new MarkerOptions()
                .position(currentPosition)
                .snippet(getLocation(location.getLatitude(),location.getLongitude()))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("현재위치"));
    }

    public String getLocation(double lat,double lng){
        String str = null;
        Geocoder geocoder = new Geocoder(this, Locale.KOREA);

        List<Address> address;
        try {
            if (geocoder != null) {
                address = geocoder.getFromLocation(lat, lng, 1);
                if (address != null && address.size() > 0) {
                    str = address.get(0).getAddressLine(0).toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 위치 자동 완성
     * */
    protected void createPickerActivity(){
        try {
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN).build(this);
            startActivityForResult(intent, 1);
            //  startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    //자동 검색 완성으로부터 나온 결과 값을 처리하는 함수
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                Log.d("gps place", place.getAddress() + " " + place.getPlaceTypes());
                lon = place.getLatLng().longitude;
                lat = place.getLatLng().latitude;
                map.clear();

                MarkerOptions marker = new MarkerOptions().position(new LatLng(lat, lon)).title("MyLoc");
                map.addMarker(marker);
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 17));
                CircleOptions circle = new CircleOptions().center(new LatLng(lat, lon))
                        .strokeColor(Color.RED)
                        .strokeWidth(3);
                map.addCircle(circle);
                Log.d("result", lon+" "+lat);
            }
        }
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }


    @Override
    public void onConnected(Bundle connectionHint) {
            // Connected to Google Play services!
            // The good stuff goes here.
    }

    @Override
    public void onConnectionSuspended(int cause) {
            // The connection has been interrupted.
            // Disable any UI components that depend on Google APIs
            // until onConnected() is called.
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
            // This callback is important for handling errors that
            // may occur while attempting to connect with Google.
            //
            // More about this in the 'Handle Connection Failures' section.

    }



}
