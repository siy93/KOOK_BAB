package kookmin.ac.kr.kook_bab;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                finish();
            }
        };

        hd.sendEmptyMessageDelayed(0, 2000); //스플래쉬 화면 2초간 띄우기
    } //end onCreate Method
}
