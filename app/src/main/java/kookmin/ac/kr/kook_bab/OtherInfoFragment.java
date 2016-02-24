package kookmin.ac.kr.kook_bab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 송인엽 on 2016-02-23.
 */
public class OtherInfoFragment extends Fragment {

    public OtherInfoFragment() {
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
         View rootView = inflater.inflate(R.layout.fragment_other,container,false);

        Button bt_library = (Button)rootView.findViewById(R.id.bt_library);
        bt_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("210.123.38.73/index.asp"));
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
        Button bt_conv = (Button)rootView.findViewById(R.id.bt_conv);
        bt_conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://m.kookmin.ac.kr/info/convinience.php"));
                startActivity(myIntent);
            }
        });
        Button bt_subinfo = (Button)rootView.findViewById(R.id.bt_subinfo);
        bt_subinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://m.kookmin.ac.kr/notice/scolarship.php"));
                startActivity(myIntent);
            }
        });
        Button bt_cyber = (Button)rootView.findViewById(R.id.bt_cyber);
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

        return rootView;
    }
}
