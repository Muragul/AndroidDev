package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bsqrt,bsqr,bper,bclear,bsum,bdif,bmult,bdiv,bdel,bdot,bres;
    TextView input, oper;
    String operation = null;
    Double a = null, b = null, res = null;
    Boolean isOper = false, isDot = false, isFirstZero = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        oper = findViewById(R.id.oper);
        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().equals("")){
                    input.setText("0");
                    isFirstZero = true;
                }
                else
                if (!isFirstZero || (isFirstZero && isDot))input.setText(input.getText()+"0");
            }
        });

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"1");
            }
        });

        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"2");
            }
        });

        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"3");
            }
        });

        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"4");
            }
        });

        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"5");
            }
        });

        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"6");
            }
        });

        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"7");
            }
        });

        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"8");
            }
        });

        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"9");
            }
        });

        bsqrt = findViewById(R.id.bsqrt);
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "sqrt";
                isOper = true;
                oper.setText("sqrt(");
            }
        });

        bsqr = findViewById(R.id.bsqr);
        bsqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "sqr";
                isOper = true;
                oper.setText("sqr(");
            }
        });

        bper = findViewById(R.id.bper);
        bper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "per";
                isOper = true;
                oper.setText("%");
                if (!input.getText().toString().equals("")) {
                    a = Double.parseDouble(input.getText().toString());
                }
            }
        });

        bclear = findViewById(R.id.bclear);
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                a = null;
                b = null;
                res = null;
                operation = null;
                oper.setText("");
                isOper = false;
                isDot = false;
            }
        });

        bsum = findViewById(R.id.bsum);
        bsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "sum";
                oper.setText("+");
                if (!isOper && !input.getText().equals(""))
                a = Double.parseDouble(input.getText().toString());
                input.setText("");
                isOper = true;
            }
        });

        bdif = findViewById(R.id.bdif);
        bdif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "dif";
                oper.setText("-");
                if (!isOper && !input.getText().equals(""))
                    a = Double.parseDouble(input.getText().toString());
                input.setText("");
                isOper = true;
            }
        });

        bmult = findViewById(R.id.bmult);
        bmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "mult";
                oper.setText("*");
                if (!isOper && !input.getText().equals(""))
                    a = Double.parseDouble(input.getText().toString());
                input.setText("");
                isOper = true;
            }
        });

        bdiv = findViewById(R.id.bdiv);
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "div";
                oper.setText("/");
                if (!isOper && !input.getText().equals(""))
                    a = Double.parseDouble(input.getText().toString());
                input.setText("");
                isOper = true;
            }
        });

        bdel = findViewById(R.id.bdel);
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oper.setText("");
                operation = null;
                isOper = false;
                if (!input.getText().equals("")){
                    String s = input.getText().toString();
                    String s1 = s.substring(0,s.length()-1);
                    input.setText(s1);
                    if (isDot && !s1.contains("."))isDot = false;
                }
            }
        });

        bdot = findViewById(R.id.bdot);
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isDot && !input.getText().equals("")){
                    input.setText(input.getText()+".");
                } else if (input.getText().equals("")){
                    input.setText("0.");
                }
                isDot = true;
            }
        });

        bres = findViewById(R.id.bres);
        bres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().equals(""))
                {
                    if (!isOper)
                        res = Double.parseDouble(input.getText().toString()); else {
                        if (operation.equals("sum") || operation.equals("dif") || operation.equals("mult")
                                || operation.equals("div"))
                            b = Double.parseDouble(input.getText().toString());
                        else {
                            a = Double.parseDouble(input.getText().toString());
                        }
                        switch (operation) {
                            case "sum":
                                res = a + b;
                                break;
                            case "dif":
                                res = a - b;
                                break;
                            case "mult":
                                res = a * b;
                                break;
                            case "div":
                                res = a / b;
                                break;

                            case "per":
                                res = a / 100;
                                break;
                            case "sqr":
                                res = a * a;
                                break;
                            case "sqrt":
                                res = Math.sqrt(a);
                                break;
                        }
                    }
                    oper.setText("");
                    input.setText(res.toString());
                    if (res.toString().contains("."))isDot=true;
                    a = res;
                    //b = null;
                }
            }
        });


    }
}
