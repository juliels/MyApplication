package com.ribeirogmail.juliel.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ribeirogmail.juliel.myapplication.R;

public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_adicionar_usuario;
    private Button btn_entrar;
    private EditText txt_usuario;
    private EditText txt_senha;
    private boolean camposValidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        btn_adicionar_usuario = (ImageButton) findViewById(R.id.btn_adicionar_usuario);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);
        txt_usuario = (EditText) findViewById(R.id.txt_usuario);
        txt_senha = (EditText) findViewById(R.id.txt_senha);

        camposValidos = true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_adicionar_usuario:

//Muda de Tela
                Intent it = new Intent(this, MainActivity.class);

                startActivity(it);

                break;


            case R.id.btn_entrar:

                camposValidos = true;
//validar campo usuario
                if (!txt_usuario.getText().toString().equals("jr")) {
                    Toast.makeText(getApplication(), "Informe login válido!",
                            Toast.LENGTH_LONG).show();
                    camposValidos = false;
                }
//validar campo senha
                if (!txt_senha.getText().toString().equals("30")) {
                    Toast.makeText(getApplication(), "Informe senha válida!",
                            Toast.LENGTH_LONG).show();
                    camposValidos = false;
                }


                if (camposValidos) {
                    Toast.makeText(getApplication(), "Usuário autenticado com sucesso!",
                            Toast.LENGTH_LONG).show();

                    Intent it2 = new Intent(this, TelaInicialMainActivity.class);

                    startActivity(it2);

                    finish();

                } else {

                    Toast.makeText(getApplication(), "Dados Invalidos!",
                            Toast.LENGTH_LONG).show();
                }
//limpa campos preenchidos na tela atual
                txt_usuario.setText("");
                txt_senha.setText("");
                break;
        }
    }

}
