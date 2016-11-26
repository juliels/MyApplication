package com.ribeirogmail.juliel.myapplication.model;

import android.widget.Spinner;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Invent on 17/11/2016.
 */

public class ModelOcorrencia  {

    public long id;
    public String pavimentacao;
    public String comentario;

    @Override
    public String toString() {
        return "ModelOcorrencia{" +
                "id="
                + id +
                ", comentario='"
                + comentario +
                "pavimentacao="
                + pavimentacao +
                '\'' +
                '}';
    }
}
