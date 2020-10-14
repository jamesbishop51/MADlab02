package edu.jbishop.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class calculation extends AppCompatActivity {

    public static final String WEIGHT = "WEIGHT";
    public static final String HEIGHT = "HEIGHT";

    float W = 0, H = 0, BMI = 0;
    TextView tvB;
    ImageView under,normal,over,obese,exobese;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        under = (ImageView) findViewById(R.id.bmiUnder);
        normal = (ImageView) findViewById(R.id.bmiNormal);
        over = (ImageView) findViewById(R.id.bmiOver);
        obese = (ImageView) findViewById(R.id.bmiObese);
        exobese = (ImageView) findViewById(R.id.bmiExObese);
        //gets the values from the first page for weight and height.
        W = getIntent().getIntExtra(WEIGHT, -1);
        H = getIntent().getIntExtra(HEIGHT,-1);

        // this is the calculations of the bmi
        float meters = H / 100 ;
        BMI = W / (meters * meters);
        tvB = findViewById(R.id.CBMI);
        tvB.setText("your BMI is "+ BMI + " Which puts you into the following category");

        //this sets the little downwards arrow based on the bmi.
        if(BMI <= 18.5){
            under.setImageResource(R.drawable.smallarrow);
        }
        else if(BMI > 18.5 && BMI <= 24.9){
            normal.setImageResource(R.drawable.smallarrow);
        }
        else if(BMI >= 25 && BMI <= 29.9){
            over.setImageResource((R.drawable.smallarrow));
        }
        else if(BMI >= 30 && BMI <= 34.9){
            obese.setImageResource(R.drawable.smallarrow);
        }
        else if(BMI >= 35) {
            exobese.setImageResource(R.drawable.smallarrow);
        }
    }
}