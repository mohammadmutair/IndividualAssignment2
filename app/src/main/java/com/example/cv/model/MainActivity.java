package com.example.cv.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cv.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edttext1,edttext2,edttext3;
    public static final String Name="name";
    public static final String Email="email";
    public static final String Phone="phone";
    public static final String City="city";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private RadioGroup radioGroup;
    private int radioGenderID=0;
    public static final String DATA="Data";
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);
        setupSharedPrefs();
        setupViews();
        populateSpinner();
        SavedPrefs();
    }
    private void SavedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
         Gson gson=new Gson();
         String str=prefs.getString(DATA,"");
        information[] info =gson.fromJson(str,information[].class);

        edttext1.setText(info[0].name);
        edttext2.setText(info[0].email);
        edttext3.setText(info[0].phone);

        Toast.makeText(MainActivity.this, info[0].radioID, Toast.LENGTH_SHORT).show();




    }
    public void setupSharedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();
    }

    public void setupViews(){
        edttext1=findViewById(R.id.name);
        edttext2=findViewById(R.id.email);
        edttext3=findViewById(R.id.phone);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

    }

    private void populateSpinner() {

        ArrayList<String> list = new ArrayList<>();
        list.add("Ramallah");
        list.add("Jerusalem");
        list.add("Nablus");
        list.add("Jenin");
        list.add("Tulkarem");
        list.add("Jericho");
        list.add("Hebron");
        list.add("Beit-Lahem");
        list.add("Gaza");
        list.add("Qalqelya");

        ArrayAdapter adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }
    public void btn_OnClick(View view) {
        Intent intent=new Intent(this, SecondPage.class);
        String name=edttext1.getText().toString();
        String email = edttext2.getText().toString();
        String phone=edttext3.getText().toString();
        String city=spinner.getSelectedItem().toString();
        int radioID=radioGroup.getCheckedRadioButtonId();
        
        information[] info= new information[1];
        info[0]=new information(name,email,phone,city,radioID);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String CVinfo = gson.toJson(info);
        editor.putString(DATA, CVinfo);
        editor.commit();

        Toast.makeText(this, "Data Saved:\n" + CVinfo,
                Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}