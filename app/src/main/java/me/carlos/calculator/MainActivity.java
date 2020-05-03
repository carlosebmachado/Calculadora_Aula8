package me.carlos.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int ADICAO = 0, SUBTRACAO = 1, MULTIPLICACAO = 2, DIVISAO = 3;

    private EditText num1;
    private EditText num2;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNumber1);
        num2 = findViewById(R.id.etNumber2);
        res = findViewById(R.id.tvResult);
    }

    private void selecionarOperacao(int op){
        String n1Str = num1.getText().toString().trim();
        String n2Str = num2.getText().toString().trim();

        if(n1Str.equals("") || n2Str.equals("")){
            Toast.makeText(this, "Informe os dois números.", Toast.LENGTH_SHORT).show();
        }else{
            String mensagemFinal = "Calculado com sucesso.";
            float r = 0F;
            float n1 = Float.valueOf(n1Str);
            float n2 = Float.valueOf(n2Str);
            switch (op){
                case ADICAO:
                    r = n1 + n2;
                    break;
                case SUBTRACAO:
                    r = n1 - n2;
                    break;
                case MULTIPLICACAO:
                    r = n1 * n2;
                    break;
                case DIVISAO:
                    if(n2 == 0F){
                        mensagemFinal = "Não é possível dividir por zero!";
                    } else {
                        r = n1 / n2;
                    }
                    break;
                default:
                    r = -1;
                    mensagemFinal = "Erro desconhecido!";
            }
            res.setText("" + r);
            Toast.makeText(this, mensagemFinal, Toast.LENGTH_LONG).show();
        }
    }

    public void adicao(View v){

    }

    public void subtracao(View v){

    }

    public void multiplicacao(View v){

    }

    public void divisao(View v){
        
    }
}
