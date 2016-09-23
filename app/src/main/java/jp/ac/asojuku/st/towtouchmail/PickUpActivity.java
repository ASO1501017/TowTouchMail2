package jp.ac.asojuku.st.towtouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                RadioGroup rgPlace = (RadioGroup)findViewById(R.id.rg_place);
                int checkedId = rgPlace.getCheckedRadioButtonId();
                String strPlace = ((RadioButton)findViewById(checkedId)).getText().toString();
                EditText edit01 = (EditText)findViewById(R.id.editText);
                String title = edit01.getText().toString();
                


                Uri uri = Uri.parse("mailto:"+ rndMail().toString());

                Intent intent = new Intent(Intent.ACTION_SEND,uri);
                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(Intent.EXTRA_TEXT,strPlace+"に迎えにきて");
                startActivity(intent);
            }
        });


    }

    public String rndMail(){
        String[] mailList = new String[3];
        Resources res = getResources();
        mailList[0] = res.getString(R.string.mail_to1);
        mailList[1] = res.getString(R.string.mail_to2);
        mailList[2] = res.getString(R.string.mail_to3);

        Random rnd = new Random();
        return mailList[rnd.nextInt(3)];
    }
}
