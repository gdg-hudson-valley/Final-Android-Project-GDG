package com.example.android.fivethings_michaelguarino;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the calculate button is pushed
     * It calculates metabolism from the 5 parameters on the front.
     */
    public void calculate(View view) {
        //dummy value for metabolism
        int metabolism=2000;

        //Get user's name
        EditText userNameEditText = (EditText) findViewById(R.id.user_Name);
        String name = userNameEditText.getText().toString();

        //Get user's email
        EditText userEmailEditText = (EditText) findViewById(R.id.user_email);
        String email = userEmailEditText.getText().toString();

        // Display metabolism on the screen
        String message = name +"Your metabolic rate is: "+metabolism+" calories per day.";

        //Toast displayed to user
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+ email));//only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Metabolism Calculation");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi"+name+", \n"+message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
