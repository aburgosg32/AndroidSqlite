package com.appmovil.medicosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="BDMedicos.db"; //Nombre base de datos
    private static final int DATABASE_VERSION = 1; //Version de Data

    //Definimos tablas y columnas
    public static final String NAME_TABLE = "medicos";
    public static final String ID_MEDICO = "idmedico";
    public static final String APELLIDO_MEDICO = "ape_medico";
    public static final String NOMBRE_MEDICO = "nom_medico";
    public static final  String TELEFONO_MEDICO = "tel_medico";
    public static final String ESPECIALIDAD = "especialidad";
    public static final String CMP_MEDICO = "cmp_medico";

    //crear base de datos y tablas

    private static final String CREATE_TABLE_MEDICO =
            "CREATE TABLE " + NAME_TABLE + " (" +
                    ID_MEDICO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    APELLIDO_MEDICO + " TEXT, " +
                    NOMBRE_MEDICO + " TEXT, " +
                    TELEFONO_MEDICO + " TEXT, " +
                    CMP_MEDICO + " TEXT, " +
                    ESPECIALIDAD + " TEXT);";

    //create table medicos (idmedico int primary key autoincremental,
    //ape_medico text , nombre_medico text, tel_medico text,

    //crear DB
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_MEDICO); //crear la tabla
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion){
        db.execSQL("DROP TABLE IF EXISTS " + NAME_TABLE);
        onCreate(db);
    }



}
