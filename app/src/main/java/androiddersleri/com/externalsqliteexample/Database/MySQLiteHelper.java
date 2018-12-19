package androiddersleri.com.externalsqliteexample.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

class MySQLiteHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "country.db"; //veritabanı ismi
    private static final int DATABASE_VERSION = 1; //veritabanı versiyon numarası

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
