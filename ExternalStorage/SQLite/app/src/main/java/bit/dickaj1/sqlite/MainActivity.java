package bit.dickaj1.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase demoDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up database
        createAndPopulateDatabase();

        //TODO Set up button handlers

    }

    /**
     * Creates and populates the database
     * Will drop it if it already exists
     */
    private void createAndPopulateDatabase(){
        //Hold query before execution
        String query;

        //Create database
        demoDb=openOrCreateDatabase("demoDb",MODE_PRIVATE,null);

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
}
