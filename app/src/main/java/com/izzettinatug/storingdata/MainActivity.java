package com.izzettinatug.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);

         sharedPreferences = this.getSharedPreferences("izzettinatug.storingdata", Context.MODE_PRIVATE)  ;
         int StoredAge = sharedPreferences.getInt("StoredAge", 0);

         if(StoredAge == 0){
            textView.setText("Your Age: ");
         }else{
            textView.setText("Your Age: " + StoredAge);
         }
    }

        public void save (View view){

          if(!editText.getText().toString().matches("")){
                int UserAge  = Integer.parseInt(editText.getText().toString());
                textView.setText("Your Age: " + UserAge);
              sharedPreferences.edit().putInt("StoredAge", UserAge).apply();
          }

        }

        public void delete(View view){

        int storedData = sharedPreferences.getInt("StoredAge", 0);
        if (storedData != 0){
          sharedPreferences.edit().remove("StoredAge").apply();
          textView.setText("Your Age:" );
        }


        
        }

    }
