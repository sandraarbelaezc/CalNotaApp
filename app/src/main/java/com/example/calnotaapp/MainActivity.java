package com.example.calnotaapp;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ePracticas, eAvance1, eAvance2, eAvance3, eAppf, eNotaf;
    Button bCalcular;
    Double NotaF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ePracticas = (EditText) findViewById(R.id.ePracticas);
        eAvance1 = (EditText) findViewById(R.id.eAvance1);
        eAvance2 = (EditText) findViewById(R.id.eAvance2);
        eAvance3 = (EditText) findViewById(R.id.eAvance3);
        eAppf = (EditText) findViewById(R.id.eAppf);
        eNotaf = (EditText) findViewById(R.id.eNotaf);
        bCalcular = (Button) findViewById(R.id.bCalcular);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotaF=Double.parseDouble(ePracticas.getText().toString())*60/100+
                        Double.parseDouble(eAvance1.getText().toString())*5/100+
                        Double.parseDouble(eAvance2.getText().toString())*7/100+
                        Double.parseDouble(eAvance3.getText().toString())*8/100+
                        Double.parseDouble(eAppf.getText().toString())*20/100;

                String Nota = String.format("%.2f", NotaF);
                eNotaf.setText(String.valueOf(Nota));

                if(NotaF>=0 && NotaF<=1){
                    Toast.makeText(getApplicationContext(),"Estás en el lugar equivocado", Toast.LENGTH_SHORT).show();
                }
                else if(NotaF>=1.1 && NotaF<=2){
                    Toast.makeText(getApplicationContext(),"Remal", Toast.LENGTH_SHORT).show();
                }
                else if(NotaF>=2.1 && NotaF<=3){
                    Toast.makeText(getApplicationContext(),"Es posible recuperarse", Toast.LENGTH_SHORT).show();
                }
                else if(NotaF>=3.1 && NotaF<=4){
                    Toast.makeText(getApplicationContext(),"Normalito", Toast.LENGTH_SHORT).show();
                }
                else if(NotaF>=4.1 && NotaF<=4.5){
                    Toast.makeText(getApplicationContext(),"Muy bien", Toast.LENGTH_SHORT).show();
                }
                else if(NotaF>=4.6 && NotaF<=5){
                    Toast.makeText(getApplicationContext(),"Excelente estudiante", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
