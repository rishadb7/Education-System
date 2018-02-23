package pk.edu.bisedik.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abdul Basit Danish on 11/27/2017.
 */

public class DatabBase_Class extends SQLiteOpenHelper {
    //it is the main db to all the work stored in there
    public static final String DB_Name="DIKB.db";

    //Table first is generac table...and connect to other all
    public static final String TABLE_Name1="tbl_based_results";
    public static final String COL_1="ID";
    public static final String COL_2="Select_Examination";
    public static final String COL_3="Select_Year";

    //second table for results.....


    public DatabBase_Class(Context context){
        super(context,DB_Name,null,1);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_Name1+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+"TEXT,"+COL_3+"INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_Name1);
        onCreate(sqLiteDatabase);

    }
}
