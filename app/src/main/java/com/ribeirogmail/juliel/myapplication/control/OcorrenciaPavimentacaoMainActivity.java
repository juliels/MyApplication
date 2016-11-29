package com.ribeirogmail.juliel.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.ribeirogmail.juliel.myapplication.R;
import com.ribeirogmail.juliel.myapplication.model.ModelBD;
import com.ribeirogmail.juliel.myapplication.model.ModelOcorrencia;

public class OcorrenciaPavimentacaoMainActivity extends AppCompatActivity {

    private static final String TAG = "contatosbd";
    private ModelOcorrencia modelOcorrencia;
    private ModelBD modelBD;

    private EditText etComentario;
    private Spinner spnPavimentacao;

    private ArrayAdapter<String> adpTipoOcPavimentacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencia_pavimentacao_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spnPavimentacao = (Spinner) findViewById(R.id.spn_pavimentacao);
        adpTipoOcPavimentacao = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoOcPavimentacao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPavimentacao.setAdapter(adpTipoOcPavimentacao);
        adpTipoOcPavimentacao.add("buraco desgaste");
        adpTipoOcPavimentacao.add("buraco infra-estrutura");

        modelOcorrencia = new ModelOcorrencia();
        modelBD =  ModelBD.getInstance(this);

        etComentario = (EditText) findViewById(R.id.txt_comentario);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ocorrencia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_gravar: {

                modelOcorrencia.pavimentacao = String.valueOf(spnPavimentacao.getSelectedItem());
                modelOcorrencia.comentario = etComentario.getText().toString();

                Log.d(TAG, modelOcorrencia.toString());
                modelBD.save(modelOcorrencia);
                limparFormulario();


                Toast.makeText(this, "Gravado", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Dados digitados: " + modelOcorrencia.comentario, Toast.LENGTH_SHORT).show();

            }
                break;

            case R.id.menuitem_abortar:
                limparFormulario();
                Toast.makeText(this, "Abortado", Toast.LENGTH_SHORT).show();

                Intent itpv = new Intent(this, TelaInicialMainActivity.class);

                startActivity(itpv);



                break;
        }


        return true;
    }

    private void limparFormulario() {
        etComentario.setText(null);

    }
}
// teste de commit classe OcorrenciaPavimentaçãoMainActivity