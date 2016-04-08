package bit.dickaj1.sqlite;

import android.content.Context;
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
     */
    private void createAndPopulateDatabase(){
        //Hold query before execution
        String query;

        //Create database
        demoDb=localContext.openOrCreateDatabase("demoDb", localContext.MODE_PRIVATE, null);

        //Drop table
        query="DROP TABLE tblCity";
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
     * @return Arraylist of Countries
     */
    public ArrayList<String> getAllCountries(){
        //TODO finish
        return null;
    }
}
