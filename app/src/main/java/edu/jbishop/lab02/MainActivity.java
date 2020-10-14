package edu.jbishop.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    //sets the regex patterns for both inputs
    private static final Pattern WEIGHT_PATTERN =
            Pattern.compile("^([2-8][0-9]|9[0-9]|1[0-9]{2}|200)");
    private static final Pattern HEIGHT_PATTERN =
            Pattern.compile("^(8[0-9]|9[0-9]|[12][0-9]{2}|300)");


    EditText height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.Height);
        weight = findViewById(R.id.weight);
    }

    //clears the entered numbers for both fields on the clear button press.
    public void doClear(View view) {
        height.setText("0");
        weight.setText("0");
    }
    //this validates the input for weight and returns false if it doesn't match.
    private boolean ValidateWeight(){
        String weightInput = weight.getText().toString();
         if(!WEIGHT_PATTERN.matcher(weightInput).matches()) {
             weight.setText("");
             Toast.makeText(this, "please enter a valid weight between 20 and 200 KG's", Toast.LENGTH_LONG).show();
             return false;
         }
         else {
             return true;
         }
    }
    //this validates the input for height and returns false if it doesn't match.
    private boolean validateHeight(){
        String heightInput = height.getText().toString();
        if (!HEIGHT_PATTERN.matcher(heightInput).matches()) {
            height.setText("");
            Toast.makeText(this, "please enter a valid height between 80 and 300 cm's", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            return true;
        }
    }
    public void doCalculation(View view) {
        //if one of the validations return false this will prevent the intent from running.
        //both have to return true to run the intent.
        if(!validateHeight() | !ValidateWeight()){
            return;
        }
        //starts the intent for displaying the bmi on a second page.
        Intent i = new Intent(view.getContext(),calculation.class);
        int kg = Integer.parseInt(weight.getText().toString());
        int cm = Integer.parseInt(height.getText().toString());
        i.putExtra(calculation.WEIGHT,kg);
        i.putExtra(calculation.HEIGHT,cm);

        startActivity(i);

    }

}