package androiddersleri.com.externalsqliteexample.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import androiddersleri.com.externalsqliteexample.Modals.Country;

public class MyDatabase {
    private static MyDatabase INSTANCE;
    private static Context context;

    private static SQLiteDatabase database;
    private static MySQLiteHelper mySQLiteHelper;

    public MyDatabase() {
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public static MyDatabase getInstance(Context context) {
        MyDatabase.context = context;
        if (INSTANCE == null) { //eğer bir veritabanı oluşturulmamış ise veritabanı oluştur.
            INSTANCE = new MyDatabase();
        }
        return INSTANCE;
    }

    public List<Country> getAllData() {
        List<Country> countryList = new ArrayList<Country>();
        openDB();
        String sqlCumlesi = "SELECT * FROM countrytable"; //gerekli olan sql cümlesi(countrytable tablosundaki tüm verileri çek)
        Cursor cursor = database.rawQuery(sqlCumlesi, null);
        Country country;
        if (cursor != null && cursor.getCount() != 0) { //boş değilse ve veri sayısı 0'a eşit değilse
            while (cursor.moveToNext()) {
                country = new Country();
                country.setCountryId(cursor.getInt(cursor.getColumnIndex("countryId")));
                country.setCountry(cursor.getString(cursor.getColumnIndex("country")));
                country.setCapital(cursor.getString(cursor.getColumnIndex("capital")));
                countryList.add(country);
            }
        }
        closeDB();
        return countryList;
    }

    private void closeDB() {
        database.close();
    }

    private void openDB() {
        database = mySQLiteHelper.getWritableDatabase(); //veritabanının okunabilir olduğunu belirttik..
    }
}
