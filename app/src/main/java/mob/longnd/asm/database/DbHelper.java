package mob.longnd.asm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "AND102", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qNguoiDung ="create table NGUOIDUNG(tendangnhap text primary key,matkhau text, hoten TEXT)";
        db.execSQL(qNguoiDung);
        String qSanPham = "create table SANPHAM(masp INTEGER PRIMARY KEY AUTOINCREMENT,tensp TEXT,giaban INTEGER,soluong INTEGER)";
        db.execSQL(qSanPham);

        String dNguoiDung = "insert into NGUOIDUNG values('longnn','123','Long Nguyen'),('huongng','123','Cao Huong')";
        db.execSQL(dNguoiDung);
        String dSanPham=
                "insert into SANPHAM values(1,'bánh', 5000,20),(2, 'kẹo',10000,19),(3,'bút',15000,10)";
        db.execSQL(dSanPham);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("drop table if exists NGUOIDUNG");
            db.execSQL("drop table if exists SANPHAM");
            onCreate(db);
        }
    }
}
