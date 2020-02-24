package com.tdr.registrationV3.view.CityPicker.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.tdr.registrationV3.view.CityPicker.model.City;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author Bro0cL on 2016/1/26.
 */
public class DBManager {
    private static final String ASSETS_NAME = "ylmom.db";
    private static final String DB_NAME = "ylmom.db";
    private static final String NAME = "d_name";
    private static final String TABLE_NAME = "t_city";
    private static final String PINYIN = "d_pingyin";
    private static final String ISCITY = "d_iscity";
    private static final int BUFFER_SIZE = 1024;
    private String DB_PATH;
    private Context mContext;

    public DBManager(Context context) {
        this.mContext = context;
        DB_PATH = File.separator + "data"
                + Environment.getDataDirectory().getAbsolutePath() + File.separator
                + context.getPackageName() + File.separator + "databases" + File.separator;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void copyDBFile(){
        File dir = new File(DB_PATH);
        if (!dir.exists()){
            dir.mkdirs();
        }
        File dbFile = new File(DB_PATH + DB_NAME);
        if (!dbFile.exists()){
            InputStream is;
            OutputStream os;
            try {
                is = mContext.getResources().getAssets().open(ASSETS_NAME);
                os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int length;
                while ((length = is.read(buffer, 0, buffer.length)) > 0){
                    os.write(buffer, 0, length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<City> getAllCities(){

          /*select * from t_city where (d_level='1' and d_iscity='1') or (d_level='2' and d_parentid!='0') order by d_letter asc*/


        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH + DB_NAME, null);
//        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        Cursor cursor = db.rawQuery("select * from t_city where (d_level='1' and d_iscity='1') or (d_level='2' and d_parentid!='0') order by d_letter asc", null);
        List<City> result = new ArrayList<>();
        City city;
        while (cursor.moveToNext()){

            String isCity = cursor.getString(cursor.getColumnIndex(ISCITY));
//            if(isCity.equals("1")){
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                String pinyin = cursor.getString(cursor.getColumnIndex(PINYIN));
                city = new City(name, pinyin);
                result.add(city);
//            }

        }
        cursor.close();
        db.close();
        Collections.sort(result, new CityComparator());
        return result;
    }

    public List<City> searchCity(final String keyword){



        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH + DB_NAME, null);
        Cursor cursor = db.rawQuery("select * from " + "(select * from t_city where (d_level='1' and d_iscity='1') or" +
                " (d_level='2' and d_parentid!='0') order by d_letter asc) as t" +" where t.d_pingyin like \"%" + keyword
                + "%\" or t.d_letter like \"%" + keyword + "%\" or t.d_name like \"%" + keyword + "%\"", null);
        List<City> result = new ArrayList<>();
        City city;
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            String pinyin = cursor.getString(cursor.getColumnIndex(PINYIN));
            city = new City(name, pinyin);
            result.add(city);
        }
        cursor.close();
        db.close();
        Collections.sort(result, new CityComparator());
        return result;
    }

    /**
     * sort by a-z
     */
    private class CityComparator implements Comparator<City>{
        @Override
        public int compare(City lhs, City rhs) {
            String a = lhs.getPinyin().substring(0, 1);
            String b = rhs.getPinyin().substring(0, 1);
            return a.compareTo(b);
        }
    }
}
