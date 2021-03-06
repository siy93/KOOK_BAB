package kookmin.ac.kr.kook_bab.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import kookmin.ac.kr.kook_bab.Activity.GoogleMapActivity;
import kookmin.ac.kr.kook_bab.R;


public class OtherInfoFragment extends Fragment {

    public OtherInfoFragment() {
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
         View rootView = inflater.inflate(R.layout.fragment_other,container,false);

        Button bt_library = (Button)rootView.findViewById(R.id.bt_library);
        bt_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://210.123.38.73/index.asp"));
                startActivity(myIntent);
            }
        });
        Button bt_tel = (Button)rootView.findViewById(R.id.bt_tel);
        bt_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://m.kookmin.ac.kr/campus/contact.php"));
                startActivity(myIntent);
            }
        });
        Button bt_bus = (Button)rootView.findViewById(R.id.bt_bus);
        bt_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://m.kookmin.ac.kr/campus/bus.php"));
                startActivity(myIntent);
            }
        });
        Button bt_conv = (Button)rootView.findViewById(R.id.bt_other);
        bt_conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://m.kookmin.ac.kr/info/convinience.php"));
                startActivity(myIntent);
            }
        });
        Button bt_subinfo = (Button)rootView.findViewById(R.id.bt_sub_info);
        bt_subinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://m.kookmin.ac.kr/notice/scolarship.php"));
                startActivity(myIntent);
            }
        });
        Button bt_cyber = (Button)rootView.findViewById(R.id.bt_internet);
        bt_cyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://cyber2010.kookmin.ac.kr/MMain.do?cmd=viewIndexPage"));
                startActivity(myIntent);
            }
        });
        Button bt_sys = (Button)rootView.findViewById(R.id.bt_sys);
        bt_sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://ktis.kookmin.ac.kr"));
                startActivity(myIntent);
            }
        });
        Button bt_atm = (Button)rootView.findViewById(R.id.atm);
        bt_atm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","atm");
                startActivity(map);
            }
        });
        Button bt_submit = (Button)rootView.findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(),"준비중입니다",Toast.LENGTH_SHORT);
            }
        });
        return rootView;
    }
}
