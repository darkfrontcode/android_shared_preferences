package com.example.uesleisouza.android_shared_preferences;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelect;
    private Button buttonSave;
    private ConstraintLayout layout;
    private static final String FILE_PREFERENCE = "preferences";
    private static final String KEY = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.RadioGroupId);
        buttonSave = (Button) findViewById(R.id.ButtonSave);
        layout = (ConstraintLayout) findViewById(R.id.layoutId);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = radioGroup.getCheckedRadioButtonId();

                if(id > 0)
                {
                    radioButtonSelect = (RadioButton) findViewById(id);
                    String color = radioButtonSelect.getText().toString();

                    SharedPreferences sharedPreferences = getSharedPreferences(FILE_PREFERENCE, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY, color);
                    editor.commit();
                    setBackground(color);
                }

            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_PREFERENCE, 0);
        if(sharedPreferences.contains(KEY))
        {
            String color = sharedPreferences.getString(KEY, "#00BFFF");
            setBackground(color);
        }

    }

    private void setBackground(String color)
    {
        switch(color)
        {
            case "Blue":
                layout.setBackgroundColor(Color.parseColor("#00BFFF"));
                break;

            case "Orange":
                layout.setBackgroundColor(Color.parseColor("#FF8C00"));
                break;

            case "Green":
                layout.setBackgroundColor(Color.parseColor("#3CB371"));
                break;
        }
    }
}
