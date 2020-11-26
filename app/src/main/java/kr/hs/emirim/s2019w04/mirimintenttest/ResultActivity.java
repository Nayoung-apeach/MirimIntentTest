package kr.hs.emirim.s2019w04.mirimintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent iintent = getIntent();
        String calc = (iintent.getStringExtra("Clac"));

        int calValue = 0;
        if(calc.equals("+")){
            calValue = iintent.getIntExtra("num1", 0) + iintent.getIntExtra("num2", 0);
        } else if (calc.equals("-")){
            calValue = iintent.getIntExtra("num1", 0) - iintent.getIntExtra("num2", 0);
        }else if(calc.equals("*")){
            calValue = iintent.getIntExtra("num1", 0) * iintent.getIntExtra("num2", 0);
        }else{
            calValue = iintent.getIntExtra("num1", 0) / iintent.getIntExtra("num2", 0);
        }
        final int reValue = calValue;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", reValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}