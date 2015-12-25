package com.example.aj.endsem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    int mat[][];
    EditText text;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        //text = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView4);
        int r = intent.getIntExtra("sizer", 0), i;
        int c = intent.getIntExtra("sizec",0);
        mat = new int[r][c];

        for (i = 0; i < r; i++) {

            mat[i] = new int[c];
            mat[i] = intent.getIntArrayExtra("row" + i);
        }
    }

    public void display(View v) {
        int i, j, r = mat.length, c = mat[0].length;

        String elements = "";

        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++)
                elements += mat[i][j] + ", ";
            elements += "\n";
        }
        //Toast.makeText(this,elements,Toast.LENGTH_LONG).show();
        //text.setText(elements);
        textView.setText(elements);
    }
    public void transpose(View v){
        int newMat[][]=new int[mat[0].length][mat.length],i,j,r=mat.length,c=mat[0].length;

        for(i=0; i<r; i++)
            for(j=0; j<c; j++)
                newMat[j][i] = mat[i][j];

        String elements = "";

        for (i = 0; i < c; i++) {
            for (j = 0; j < r; j++)
                elements += newMat[i][j] + ", ";
            elements += "\n";
        }
        //Toast.makeText(this,elements,Toast.LENGTH_LONG).show();
        //text.setText(elements);
        textView.setText(elements);
    }

    public void evenOdd(View v){
        int countEven=0,countOdd=0,i,j,r = mat.length,c=mat[0].length;

        for(i=0; i<r; i++)
            for(j=0; j<c; j++)
                if(mat[i][j]%2==0)
                    countEven++;
                else
                    countOdd++;
        textView.setText("Number of even elements = "+countEven+"\nNumber of Odd Elements: "+countOdd);
    }

    public void back(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        finish();
        startActivity(i);
    }
}