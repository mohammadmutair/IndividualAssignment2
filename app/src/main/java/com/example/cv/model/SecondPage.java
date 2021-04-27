package com.example.cv.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cv.R;
import com.google.gson.Gson;

public class SecondPage extends AppCompatActivity {

    private EditText edttext4,edttext5,edttext6,edttext7;
    public static final String hobbies="hobbie";
    public static final String skills="skill";
    public static final String education="educ";
    public static final String experience="experiences";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String DATA="Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        setupSharedPrefs();
        setupViews();
        SavedPrefs();

    }
    private void SavedPrefs(){


        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson=new Gson();
        String str=prefs.getString(DATA,"");
        information[] info =gson.fromJson(str,information[].class);

        edttext4.setText(info[0].hobbies);
        edttext5.setText(info[0].skills);
        edttext6.setText(info[0].education);
        edttext7.setText(info[0].experience);

    }
    public void setupSharedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();
    }
    public void setupViews(){
        edttext4=findViewById(R.id.editText4);
        edttext5=findViewById(R.id.editText5);
        edttext6=findViewById(R.id.editText6);
        edttext7=findViewById(R.id.editText7);


    }

    public void btn2_onClick(View view) {
        String Hobbies=edttext4.getText().toString();
        String Skills = edttext5.getText().toString();
        String Education=edttext6.getText().toString();
        String Experiences =edttext7.getText().toString();

        information[] info= new information[1];
        info[0]=new information(Hobbies,Skills,Education,Experiences);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String CVinfo = gson.toJson(info);
        editor.putString(DATA, CVinfo);
        editor.commit();

        Toast.makeText(this, "Data Saved:\n" + CVinfo,
                Toast.LENGTH_SHORT).show();

    }

}