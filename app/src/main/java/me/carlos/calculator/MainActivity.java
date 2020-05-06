package me.carlos.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final int ADICAO = 0, SUBTRACAO = 1, MULTIPLICACAO = 2, DIVISAO = 3;
    private EditText num1;
    private EditText num2;
    private TextView res;
    private ListView historico;
    private List listaHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNumero1);
        num2 = findViewById(R.id.etNumero2);
        res = findViewById(R.id.tvResultado);
        historico = findViewById(R.id.lvHistorico);
        listaHistorico = new ArrayList<String>();
        setHistorico();
    }

    private void setHistorico(){
        ArrayAdapter<List> arrayAdapter = new ArrayAdapter<List>(this, android.R.layout.simple_list_item_1, listaHistorico);
        historico.setAdapter(arrayAdapter);
    }

    private void selecionarOperacao(int op){
        String n1Str = num1.getText().toString().trim();
        String n2Str = num2.getText().toString().trim();
        if(n1Str.equals("") || n2Str.equals("")) {
            Toast.makeText(this, "É necessário informar os dois números.", Toast.LENGTH_SHORT).show();
        } else {
            String mensagemFinal = "Calculado com sucesso.";
            float r = 0F;
            float n1 = Float.valueOf(n1Str);
            float n2 = Float.valueOf(n2Str);
            switch (op) {
                case ADICAO:
                    r = n1 + n2;
                    listaHistorico.add(n1Str + " + " + n2Str + " = " + r);
                    break;
                case SUBTRACAO:
                    r = n1 - n2;
                    listaHistorico.add(n1Str + " - " + n2Str + " = " + r);
                    break;
                case MULTIPLICACAO:
                    r = n1 * n2;
                    listaHistorico.add(n1Str + " * " + n2Str + " = " + r);
                    break;
                case DIVISAO:
                    if(n2 == 0F){
                        mensagemFinal = "Não é possível dividir por zero!";
                    } else {
                        r = n1 / n2;
                        listaHistorico.add(n1Str + " / " + n2Str + " = " + r);
                    }
                    break;
                default:
                    r = -1;
                    mensagemFinal = "Erro desconhecido!";
            }
            res.setText("" + r);
            Toast.makeText(this, mensagemFinal, Toast.LENGTH_LONG).show();
            setHistorico();
        }
    }

    public void adicao(View v) { selecionarOperacao(ADICAO); }
    public void subtracao(View v) { selecionarOperacao(SUBTRACAO); }
    public void multiplicacao(View v) { selecionarOperacao(MULTIPLICACAO); }
    public void divisao(View v) { selecionarOperacao(DIVISAO); }

    public void limparHistorico(View v) {
        setHistorico();
        listaHistorico.clear();
    }
}
