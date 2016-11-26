package com.ribeirogmail.juliel.myapplication.model;

/**
 * Created by Invent on 09/11/2016.
 */

public class Model {

    public long id;
    public String nome;
    public String telefone;
    public String email;
    public String usuario;
    public String senha;

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
