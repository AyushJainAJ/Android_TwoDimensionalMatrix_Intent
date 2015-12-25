package com.example.aj.endsem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText row,column,num;
    int r,c,tot,mat[][],x=0,y=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row=(EditText)findViewById(R.id.row);
        column=(EditText)findViewById(R.id.column);
        num=(EditText)findViewById(R.id.num);
    }

    public void storeSize(View v){
        r = Integer.parseInt(row.getText().toString());
        c = Integer.parseInt(column.getText().toString());
        tot=r*c;
        mat = new int[r][c];
        Toast.makeText(this,"Size Stored!",Toast.LENGTH_LONG).show();
    }
    public void exit(View v){
        finish();
    }

    public void storeNum(View v){
        if(tot>0){
            int n = Integer.parseInt(num.getText().toString());

            mat[x][y]=n;//0,0 = 1 ; 0,1 = 2
            tot--;//1,0
            y++;//1,2
            if(y==c)
            {
                x++;//1
                y=0;
            }
            Toast.makeText(this,"Number Added!",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,"Overflow!",Toast.LENGTH_LONG).show();
    }

    public void compute(View v)
    {
        Intent intent = new Intent(this,Main2Activity.class);
        int i;
        intent.putExtra("sizer",r);
        intent.putExtra("sizec",c);
        for(i=0; i<mat.length; i++)
            intent.putExtra("row"+i,mat[i]);
        finish();
        startActivity(intent);
    }
}