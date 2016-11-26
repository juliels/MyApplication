package com.ribeirogmail.juliel.myapplication.control;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.ribeirogmail.juliel.myapplication.R;
import com.ribeirogmail.juliel.myapplication.model.Model;
import com.ribeirogmail.juliel.myapplication.model.ModelBD;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "contatosbd";
    private Model model;
    private ModelBD modelBD;
    private EditText etNome;
    private EditText etTelefone;
    private EditText etEmail;
    private EditText etUsuario;
    private EditText etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        model = new Model();
        modelBD =  ModelBD.getInstance(this);


        etNome = (EditText) findViewById(R.id.txt_nome);
        etTelefone = (EditText) findViewById(R.id.txt_telefone);
        etEmail = (EditText) findViewById(R.id.txt_email);
        etUsuario = (EditText) findViewById(R.id.txt_novo_usuario);
        etSenha = (EditText) findViewById(R.id.txt_nova_senha);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_salvar:
                if(     !etNome.getText().toString().isEmpty() &&
                        !etTelefone.getText().toString().isEmpty() &&
                        !etEmail.getText().toString().isEmpty() &&
                        !etUsuario.getText().toString().isEmpty() &&
                        !etSenha.getText().toString().isEmpty())
                {
                    model.nome = etNome.getText().toString();
                    model.telefone = etTelefone.getText().toString();
                    model.email = etEmail.getText().toString();
                    model.usuario = etUsuario.getText().toString();
                    model.senha = etSenha.getText().toString();
                    Log.d(TAG, model.toString());
                    modelBD.save(model);
                    limparFormulario();


                    Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Dados digitados: "+model.nome +" "+model.telefone+ " "
                            +model.email +" "+model.usuario + " " +model.senha, Toast.LENGTH_SHORT).show();


                }

        else
        {
            Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
        }
                break;

            case R.id.menuitem_cancelar:
                limparFormulario();
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
                break;
        }


        return true;
    }

    private void limparFormulario() {
        etNome.setText(null);
        etTelefone.setText(null);
        etEmail.setText(null);
        etUsuario.setText(null);
        etSenha.setText(null);
    }

    }
