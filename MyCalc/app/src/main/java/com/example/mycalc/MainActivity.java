package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bsqrt,bsqr,bper,bclear,bsum,bdif,bmult,bdiv,bdel,bdot,bres;
    Button bsqrn, bsqrtn, blog, bln, bfact, bsin, bcos, btan;
    TextView input, oper;
    Double a = 0.0, b = 0.0, res = 0.0;
    Boolean sec = false, complete = false;
    String error = "", mono = "", bi = "";
    int entermode = 1, f;

    protected void Mono_function(String operation){
        double k;
        if (entermode == 1)
            k = a;
        else
            k = b;
        switch (operation){
            case "sqr":
                res = k * k;
                break;
            case "sqrt":
                if (k > 0) res = Math.sqrt(k);
                else error = "impossible";
                break;
            case "per":
                res = k / 100;
                break;
            case "!":
                if (k < 0) error = "impossible";
                else try {
                    if (isPossibleToConvert(k)){
                        f = (int)k;
                        res = Double.parseDouble(findFact(f)+"");
                    }
                } finally {
                }
                break;
            case "ln":
                if (k > 0)res = Math.log(k);
                else
                    error = "impossible";
                break;
            case "sin":
                res = Math.sin(k);
                break;
            case "cos":
                res = Math.cos(k);
                break;
            case "tan":
                res = Math.tan(k);
                break;
        }
        if (entermode == 1)
            a = res;
        else
            b = res;
    }

    protected void Bi_function(String operation){
        switch (operation){
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
                if (b!=0) res = a / b;
                else error = "impossible";
                break;
            case "a^n":
                res = Math.pow(a,b);
                break;
            case "log":
                res = Math.log10(b) / Math.log10(a);
                break;
            case "sqrtn":
                if (a%2 == 0 && b < 0)
                    error = "impossible";
                else
                    res = Math.pow(a, (1/b));
                break;
        }
    }

    protected boolean isPossibleToConvert(double res){
        if (res%1==0)return true;
        return false;
    }

    protected int findFact (int x)
    {
        if (x != 0) return x * findFact(x - 1);
        else return 1;
    }

    protected void buttonClicked(int n){
        String s = n+"";
        if (n == 0 && input.getText().equals("0")){}
        else {
            if (input.getText().equals("") || input.getText().equals("0") ||
                    input.getText().equals("impossible") || input.getText().equals("NaN")
                    || input.getText().equals("Infinity") || complete){
                input.setText(s);
                complete = false;
            } else
                input.setText(input.getText()+s);
            if (bi!="") sec = true;
            if (entermode == 1) a = Double.parseDouble(input.getText().toString()); else
                b = Double.parseDouble(input.getText().toString());
        }
    }

    protected void monoFunctionClicked(String operation){
        if (input.getText().equals("impossible") || input.getText().equals("Infinity") ||
                input.getText().equals("NaN") || input.getText().toString().contains("E"))
            input.setText("0");
        Mono_function(operation);
        if (error!=""){
            input.setText(error);
            error = "";
        } else
        {
            if (isPossibleToConvert(res)){
                String s = res.toString();
                s = res.toString().substring(0, s.length()-2);
                input.setText(s);
            } else
                input.setText(res.toString());
        }
        complete = true;
    }

    protected void biFunctionClicked(String operation){
        if (input.getText().equals("impossible") || input.getText().equals("Infinity") ||
                input.getText().equals("NaN") || input.getText().toString().contains("E"))
            input.setText("0");
        if (entermode ==1 && input.getText().toString().contains(".")){
            if (input.getText().equals("0.0"))input.setText("0");
            else
                while ((input.getText().charAt(input.getText().length()-1)=='0')){
                    String s = input.getText().toString();
                    String s1 = s.substring(0,s.length()-1);
                    input.setText(s1);
                }
        }
        entermode = 2;
        b = Double.parseDouble(input.getText().toString());
        if (!bi.equals("") && sec == true){
            Bi_function(bi);
            if (!error.equals("")){
                input.setText(error);
                error = "";
            } else
            {
                if (isPossibleToConvert(res)){
                    String s = res.toString().substring(0, res.toString().length()-2);
                    input.setText(s);
                }
                else
                    input.setText(res.toString());
            }
            a = res;
            b = res;
        }
        bi = operation;
        complete = true;
        sec = false;
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("input", input.getText());
        outState.putCharSequence("oper", oper.getText());
        outState.putString("error", error);
        outState.putString("mono", mono);
        outState.putString("bi", bi);
        outState.putDouble("res", res);
        outState.putDouble("a", a);
        outState.putDouble("b", b);
        outState.putInt("mode", entermode);
        outState.putBoolean("sec", sec);
        outState.putBoolean("complete", complete);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        oper = findViewById(R.id.oper);
        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence("input");
            input.setText(savedText);
            CharSequence sText = savedInstanceState.getCharSequence("oper");
            oper.setText(sText);
            bi = savedInstanceState.getString("bi");
            a = savedInstanceState.getDouble("a");
            b = savedInstanceState.getDouble("b");
            res = savedInstanceState.getDouble("res");
            entermode = savedInstanceState.getInt("mode");
            sec = savedInstanceState.getBoolean("sec");
            complete = savedInstanceState.getBoolean("complete");
        }
        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(0);
            }
        });

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(1);
            }
        });

        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(2);
            }
        });

        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(3);
            }
        });

        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(4);
            }
        });

        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(5);
            }
        });

        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(6);
            }
        });

        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(7);
            }
        });

        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(8);
            }
        });

        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(9);
            }
        });

        bsqrt = findViewById(R.id.bsqrt);
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monoFunctionClicked("sqrt");
                oper.setText("sqrt(");
            }
        });

        bsqr = findViewById(R.id.bsqr);
        bsqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monoFunctionClicked("sqr");
                oper.setText("sqr(");
            }
        });

        bper = findViewById(R.id.bper);
        bper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monoFunctionClicked("per");
                oper.setText("%");
            }
        });

        bclear = findViewById(R.id.bclear);
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("0");
                a = 0.0;
                b = 0.0;
                res = 0.0;
                error = "";
                sec = false;
                complete = false;
                mono = "";
                bi = "";
                entermode = 1;
            }
        });

        bsum = findViewById(R.id.bsum);
        bsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biFunctionClicked("sum");
                oper.setText("+");
            }
        });

        bdif = findViewById(R.id.bdif);
        bdif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biFunctionClicked("dif");
                oper.setText("-");
            }
        });

        bmult = findViewById(R.id.bmult);
        bmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biFunctionClicked("mult");
                oper.setText("*");
            }
        });

        bdiv = findViewById(R.id.bdiv);
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biFunctionClicked("div");
                oper.setText("/");
            }
        });


        bdel = findViewById(R.id.bdel);
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().equals("impossible") || input.getText().equals("Infinity") ||
                        input.getText().equals("NaN") ||
                        input.getText().toString().contains("E")){
                    input.setText("0");
                } else
                    if (input.getText().toString().contains("-") && input.getText().length()==2){
                        input.setText("0");
                    }
                    else
                if (input.getText().length()!=1){
                    String s = input.getText().toString();
                    String s1 = s.substring(0,s.length()-1);
                    input.setText(s1);
                }
                else input.setText("0");
                if (entermode == 1)
                    a = Double.parseDouble(input.getText().toString());
                else
                    b = Double.parseDouble(input.getText().toString());
            }
        });

        bdot = findViewById(R.id.bdot);
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().equals(""))input.setText("0.");
                else
                if (!input.getText().toString().contains(".") && !input.getText().equals("impossible"))
                    input.setText(input.getText()+".");
            }
        });

        bres = findViewById(R.id.bres);
        bres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entermode == 1 && input.getText().toString().contains(".")){
                    if (input.getText().equals("0.0"))input.setText("0");
                    else
                        while ((input.getText().charAt(input.getText().length()-1)=='0')){
                            String s = input.getText().toString();
                            String s1 = s.substring(0,s.length()-1);
                            if (s1.charAt(s1.length()-1)=='.')
                                s1 = s1.substring(0, s1.length()-1);
                            input.setText(s1);
                        }
                }
                if (!bi.equals("")){
                    Bi_function(bi);
                    if (!error.equals("")){
                        input.setText(error);
                        error = "";
                    }
                    else
                    {
                        if (isPossibleToConvert(res)){
                            String s = res.toString().substring(0, res.toString().length()-2);
                            input.setText(s);
                        }
                        else
                            input.setText(res.toString());
                    }
                    a = res;
                    entermode = 1;
                    complete = true;
                    sec = false;
                }
            }
        });

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            bsqrn = findViewById(R.id.bsqrn);
            bsqrtn = findViewById(R.id.bsqrtn);
            bsin = findViewById(R.id.bsin);
            bcos = findViewById(R.id.bcos);
            btan = findViewById(R.id.btan);
            bln = findViewById(R.id.bln);
            bfact = findViewById(R.id.bfact);
            blog = findViewById(R.id.blog);

            bsqrn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    biFunctionClicked("a^n");
                    oper.setText("a^n");
                }
            });

            bsqrtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    biFunctionClicked("sqrtn");
                    oper.setText("a^(1/n)");
                }
            });

            bsin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monoFunctionClicked("sin");
                    oper.setText("sin");
                }
            });

            bcos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monoFunctionClicked("cos");
                    oper.setText("open");
                }
            });

            btan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monoFunctionClicked("tan");
                    oper.setText("tan");
                }
            });

            bln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monoFunctionClicked("ln");
                    oper.setText("ln");
                }
            });

            bfact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monoFunctionClicked("!");
                    oper.setText("x!");
                }
            });

            blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    biFunctionClicked("log");
                    oper.setText("logaB");
                }
            });
        }
    }
}