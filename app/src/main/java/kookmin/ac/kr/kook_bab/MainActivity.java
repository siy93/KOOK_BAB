package kookmin.ac.kr.kook_bab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt_InUniv;
    Button bt_OutUniv;
    Button bt_DelUniv;

    Intent splash;
    Intent InSchool_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button 설정
        bt_InUniv = (Button)findViewById(R.id.button1);

        //intent 설정
        splash = new Intent(this, SplashActivity.class);
        InSchool_intent = new Intent(this,InSchoolActivity.class);


        startActivity(splash); //Splash 화면 띄우기


        bt_InUniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(InSchool_intent);
            }
        });



    }


}
