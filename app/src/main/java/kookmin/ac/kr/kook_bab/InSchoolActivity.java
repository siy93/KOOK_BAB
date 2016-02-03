package kookmin.ac.kr.kook_bab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by 송인엽 on 2016-01-23.
 */
public class InSchoolActivity extends Activity{

    Button bt_hak;

    Intent Menu_intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inschool);

        bt_hak = (Button)findViewById(R.id.button_hak);
        Menu_intent = new Intent(this,MenuActivity.class);

        bt_hak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     startActivity(Menu_intent);
            }
        });

    }
}
