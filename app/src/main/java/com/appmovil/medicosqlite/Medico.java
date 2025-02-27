package com.appmovil.medicosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Lambda;

public class Medico {

    //agregamos clases del helper
    private SQLiteDatabase db;
    private DatabaseHelper dbhelper;

    public Medico(Context context){
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    //GENERAMOS EL PROCESO CRUD.

    //insertar medico
    public long insertarMedico(String apellido, String nombre, String telefono, String cmp, String especialidad){
        ContentValues contenido = new ContentValues();
        contenido.put(DatabaseHelper.APELLIDO_MEDICO, apellido);
        contenido.put(DatabaseHelper.NOMBRE_MEDICO, nombre);
        contenido.put(DatabaseHelper.TELEFONO_MEDICO, telefono);
        contenido.put(DatabaseHelper.CMP_MEDICO, cmp);
        contenido.put(DatabaseHelper.ESPECIALIDAD,especialidad);
        return db.insert(DatabaseHelper.NAME_TABLE, null, contenido);
    }

    //listar medicos
    public List<String> obtenerMedicos(){
        List<String> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.NAME_TABLE, null);

        while(cursor.moveToNext()){
            String medico = cursor.getInt(0) + " - " +
                    cursor.getString(1) + " - " +
                    cursor.getString(2) +  " - " +
                    cursor.getInt(3) + " - " +
                    cursor.getInt(4) + " - " +
                    cursor.getString(5);
            lista.add(medico);
        }
        cursor.close();
        return lista;

    }

}
