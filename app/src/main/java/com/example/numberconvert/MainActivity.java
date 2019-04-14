package com.example.numberconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText numb;
    private Button btn_con;
    private TextView txt_word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numb = findViewById(R.id.numb);
        btn_con=findViewById(R.id.button);
        txt_word=findViewById(R.id.txt_word);


        btn_con.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (validate()) {
                    int Number = Integer.parseInt(numb.getText().toString());
                    Word word = new Word();
                    String wd = Word.NumToWord(Number);
                    txt_word.setText(wd);
                }
            }
        });
    }


    private boolean validate() {
        boolean flag = true;
        Pattern p = Pattern.compile("[-+]?[0-9]");
        Matcher m1 = p.matcher(numb.getText().toString());

        //Validating for Empty Text
        if (TextUtils.isEmpty(numb.getText().toString())) {
            numb.setError("Enter Number");
            numb.requestFocus();
            flag = false;
        }
        else if (!m1.find())    //validating for number only
        {
            Toast.makeText(getApplicationContext(), "Enter a valid number", Toast.LENGTH_LONG).show();
            numb.setError("Enter Valid Number");
            numb.requestFocus();
            flag = false;
        }
        return flag;
    }

}
