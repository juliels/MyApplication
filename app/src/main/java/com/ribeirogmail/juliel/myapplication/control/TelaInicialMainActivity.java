package com.ribeirogmail.juliel.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ribeirogmail.juliel.myapplication.R;

public class TelaInicialMainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_pavimentacao;
    private Button btn_saneamento;
    private Button btn_iluminacao;
    private Button btn_telefonia;
    private Button btn_seguranca;
    private Button btn_limpeza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_main);

        btn_pavimentacao = (Button)findViewById(R.id.btn_Pavimentacao);
        btn_saneamento = (Button)findViewById(R.id.btn_saneamento);
        btn_iluminacao = (Button)findViewById(R.id.btn_iluminacao);
        btn_telefonia = (Button) findViewById(R.id.btn_telefonia);
        btn_seguranca = (Button) findViewById(R.id.btn_seguranca);
        btn_limpeza = (Button) findViewById(R.id.btn_limpeza);

    }

    @Override
    public void onClick(View v) {

        Intent it = new Intent(this, OcorrenciaPavimentacaoMainActivity.class);
        startActivity(it);
    }

}
