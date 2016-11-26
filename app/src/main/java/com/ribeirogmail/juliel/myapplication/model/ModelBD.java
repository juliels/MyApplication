package com.ribeirogmail.juliel.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ModelBD extends SQLiteOpenHelper {

    private static String TAG = "up_bd";
    private static final String NOME_BD = "utilidadepublicateste.sqlite";
    private static final int VERSAO = 3;
    private static ModelBD modelBD; //Singleton

    private ModelBD(Context context) {
        super(context, NOME_BD  , null, VERSAO);
        getWritableDatabase();
    }

    public static ModelBD getInstance(Context context){
        if(modelBD == null){
            modelBD = new ModelBD(context);
            return modelBD;
        }else{
            return modelBD;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


             String sql = "create table if not exists cadastro" +
                    "( _id integer primary key autoincrement, " +
                    " nome text, " +
                    " telefone text, " +
                    " email text, " +
                    " usuario text, " +
                    " senha text" +
                    ");";
            Log.d(TAG, "Criando a tabela cadastro. Aguarde ...");
            db.execSQL(sql);
            Log.d(TAG, "Tabela cadastro criada");


            String sqlOc = "create table if not exists ocorrencias" +
                    "( _id integer primary key autoincrement, " +
                    " comentario text " +
                    " pavimentacao text " +
                    ");";
            Log.d(TAG, "Criando a tabela ocorrencias. Aguarde ...");
            db.execSQL(sqlOc);
            Log.d(TAG, "Tabela ocorrencias criada");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
        Métodos CRUD.
     */
    public long save(Model model){

        SQLiteDatabase db = getWritableDatabase(); //abre a conexão com o banco

        try{
            //tupla com: chave, valor
            ContentValues values = new ContentValues();
            values.put("nome", model.nome);
            values.put("telefone", model.telefone);
            values.put("email", model.email);
            values.put("usuario", model.usuario);
            values.put("senha", model.senha);

            //realiza a operação
            if(model.id == 0){
                //insere no banco de dados
                return db.insert("cadastro", null, values);
            }else{
                //altera no banco de dados
                values.put("_id", model.id);
                return db.update("cadastro", values, "_id=" + model.id, null);
            }

        }finally

        {
            db.close(); //não esquecer de liberar o recurso
        }

        //return 0; //caso não realize as operações
    }



    /*
        Métodos CRUD.
     */
    public long save(ModelOcorrencia modelOcorrencia){

        SQLiteDatabase db = getWritableDatabase(); //abre a conexão com o banco

        try{
            //tupla com: chave, valor
            ContentValues values = new ContentValues();
            values.put("ocpavimentacao", modelOcorrencia.pavimentacao);
            values.put("comentario", modelOcorrencia.comentario);


            //realiza a operação
            if(modelOcorrencia.id == 0)
            {
                //insere no banco de dados
                return db.insert("ocorrencias", null, values);
            }else{
                //altera no banco de dados
                values.put("_id", modelOcorrencia.id);
                return db.update("ocorrencias", values, "_id=" + modelOcorrencia.id, null);
            }

        }finally

        {
            db.close(); //não esquecer de liberar o recurso
        }

    }

}

