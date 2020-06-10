package com.e.aplikasiadabakhlak.conf;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.support.annotation.Nullable;

import com.e.aplikasiadabakhlak.model.user;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sql";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_STATUS = "CREATE TABLE IF NOT EXISTS sql_tblstatus (id_status INTEGER PRIMARY KEY AUTOINCREMENT, status TEXT);";
    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS sql_tbluser(id_user INTEGER PRIMARY KEY AUTOINCREMENT, nm_user TEXT, id_status INTEGER, FOREIGN KEY (id_status) REFERENCES sql_tblstatus (id_status))";
    private static final String DELETE_TABLE_USER = "DROP TABLE IF EXISTS sql_tbluser";
    private static final String DELETE_TABLE_STATUS = "DROP TABLE IF EXISTS sql_tblstatus";
    private static final String INSERT_STATUS = "INSERT INTO sql_tblstatus (status) VALUES ('Developer'), ('Dosen'), ('Asisten Praktikum')";
    private static final String INSERT_USER = "INSERT INTO sql_tbluser (nm_user, id_status) VALUES " +
            "('Arya Abimanyu', '1')," +
            "('Laela Nurul Qomariah', '1')," +
            "('Hikmah Damasta', '1'),"+
            "('Bapak Supriyono, M.Kom', '2'),"+
            "('Lisa Aulia Umami', '3'),"+
            "('Vika Anindya Kristi', '3')";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STATUS);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(INSERT_STATUS);
        db.execSQL(INSERT_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newV) {
        db.execSQL(DELETE_TABLE_USER);
        db.execSQL(DELETE_TABLE_STATUS);
        onCreate(db);
        System.out.println("Table Dropped");
    }
    public List<user> readDeveloper() {
        List<user> arrayUser = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT sql_tbluser.id_user, sql_tbluser.nm_user, sql_tblstatus.status FROM sql_tbluser, sql_tblstatus WHERE sql_tbluser.id_status = sql_tblstatus.id_status AND sql_tbluser.id_status = 1", null);
        if (cursor.moveToFirst()) {
            do {
                user user = new user(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                arrayUser.add(user);
            } while (cursor.moveToNext());
        }

        return arrayUser;
    }
    public List<user>readDosen() {
        List<user> arrayUser = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT sql_tbluser.id_user, sql_tbluser.nm_user, sql_tblstatus.status FROM sql_tbluser, sql_tblstatus WHERE sql_tbluser.id_status = sql_tblstatus.id_status AND sql_tbluser.id_status = 2", null);
        if (cursor.moveToFirst()) {
            do {
                user user = new user(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                arrayUser.add(user);
            } while (cursor.moveToNext());
        }

        return arrayUser;
    }
    public List<user>readAsprak() {
        List<user> arrayUser = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT sql_tbluser.id_user, sql_tbluser.nm_user, sql_tblstatus.status FROM sql_tbluser, sql_tblstatus WHERE sql_tbluser.id_status = sql_tblstatus.id_status AND sql_tbluser.id_status = 3", null);
        if (cursor.moveToFirst()) {
            do {
                user user = new user(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                arrayUser.add(user);
            } while (cursor.moveToNext());
        }

        return arrayUser;
    }
}
