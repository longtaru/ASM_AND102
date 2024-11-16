package mob.longnd.asm.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import mob.longnd.asm.database.DbHelper;
import mob.longnd.asm.model.Product;

public class SanPhamDAO {
    DbHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

public ArrayList<Product> getDS() {
    SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
    ArrayList<Product> list = new ArrayList<>();
    Cursor cursor = sqLiteDatabase.rawQuery("select * from sanpham", null);
    if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        do {
            list.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
        } while ((cursor.moveToNext()));
    }

    return list;
    }
}
