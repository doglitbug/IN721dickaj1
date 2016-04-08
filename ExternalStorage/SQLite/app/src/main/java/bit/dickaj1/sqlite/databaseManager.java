package bit.dickaj1.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Arron on 8/04/2016.
 */
public class databaseManager {
    //Database engine
    SQLiteDatabase demoDb;
    //Used for access to openOrCreate
    Context localContext;

    public databaseManager(Context context){
        this.localContext=context;
        createAndPopulateDatabase();
    }
    /**
     * Creates and populates the database
     * Will drop it if it already exists
     * Yes, this drops the table and repopulates every-time, this is sufficient for a demos
     * purpose because we aren't modifying the data at any point
     */
    private void createAndPopulateDatabase(){
        //Hold query before execution
        String query;

        //Create database
        demoDb=localContext.openOrCreateDatabase("demoDb", localContext.MODE_PRIVATE, null);

        //Drop table
        query="DROP TABLE IF EXISTS tblCity;";
        demoDb.execSQL(query);

        //Create table
        query=  "CREATE TABLE IF NOT EXISTS tblCity("+
                "cityID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "cityName TEXT NOT NULL, "+
                "countryName TEXT NOT NULL);";
        demoDb.execSQL(query);

        //Populate with sample data
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Kathmandu','Nepal')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Pokhara','Nepal')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Biratnagar','Nepal')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Butwal','Nepal')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Dharan','Nepal')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Cartagena','Colombia')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Bogota','Colombia')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Medellin','Colombia')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Santa Marta','Colombia')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Cali','Colombia')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Havana','Cuba')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Santiago de Cuba','Cuba')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Trinidad','Cuba')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Camaguey','Cuba')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Baracoa','Cuba')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Amman','Jordan')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Aqaba','Jordan')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Jerash','Jordan')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Irbid','Jordan')");
        demoDb.execSQL("INSERT INTO tblCity (cityName, countryName) VALUES('Zarqa','Jordan')");
    }

    /**
     * Get a list of all cities within a given country
     * @param searchString
     * @return ArrayList of results
     */
    public ArrayList<String> searchCountry(String searchString){
        //TODO Finish
        return null;
    }

    /**
     * Get a list of all countries in the database
     * @return ArrayList of Countries
     */
    public ArrayList<String> getAllCountries(){
        //Hold results
        ArrayList<String> results = new ArrayList<>();
        //Create query
        String query="SELECT DISTINCT countryName FROM tblCity;";

        //Exec query
        Cursor recordSet=demoDb.rawQuery(query,null);

        //Move to first result
        recordSet.moveToFirst();

        //Loop through all records returned
        for (int i=0;i<recordSet.getCount();i++){
            //Get country name, using first index as there should be only one column
            String countryName=recordSet.getString(0);
            //Add to results we want
            results.add(countryName);
            //Move to next record
            recordSet.moveToNext();
        }
        return results;
    }
}
