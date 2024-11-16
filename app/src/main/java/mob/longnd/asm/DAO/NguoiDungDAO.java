package mob.longnd.asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mob.longnd.asm.database.DbHelper;

public class NguoiDungDAO {
    DbHelper dbHelper;

    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //Dang nhap
    public boolean CheckLogin(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery
                ("select * from NGUOIDUNG where tendangnhap = ? and matkhau = ?",
                        new String[]{username, password});
        if (cursor.getCount() > 0) {
            return  true;
        }
        return false;
    }

    //Sign Up

    public boolean Register(String username, String password, String hoten) {
        SQLiteDatabase sqLiteDatabase =dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tendangnhap",username);
        contentValues.put("matkhau", password);
        contentValues.put("hoten", hoten);

        long check = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);
        return check != -1;
    }

    //forgot pass
    public String ForgotPass(String email) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery
                ("select matkhau from NGUOIDUNG where tendangnhap = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return  cursor.getString(0);
        } else{
            return "";
        }
    }

}