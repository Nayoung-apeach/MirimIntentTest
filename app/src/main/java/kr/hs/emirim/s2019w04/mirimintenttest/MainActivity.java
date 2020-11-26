package kr.hs.emirim.s2019w04.mirimintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editInput1 = (EditText) findViewById(R.id.input_1);
        final EditText editInput2 = (EditText) findViewById(R.id.input_2);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        Button btnNewActivity = (Button) findViewById(R.id.btnCal);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioadd:
                        intent.putExtra("cal", "+");
                        break;
                    case R.id.radiominus:
                        intent.putExtra("cal", "-");
                        break;
                    case R.id.radiomul:
                        intent.putExtra("cal", "*");
                        break;
                    case R.id.radiodiv:
                        intent.putExtra("cal", "/");
                        break;
                    default:
                        break;
                }
                intent.putExtra("num1", Integer.parseInt(editInput1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(editInput2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과" +hap, Toast.LENGTH_SHORT).show();
        }
    }
}