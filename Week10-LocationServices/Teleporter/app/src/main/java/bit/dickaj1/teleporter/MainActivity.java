package bit.dickaj1.teleporter;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public String testString ="{\"photos\":{\"page\":1,\"pages\":1199,\"perpage\":100,\"total\":\"119833\",\"photo\":[{\"id\":\"26316867984\",\"owner\":\"115460474@N02\",\"secret\":\"d06415b15a\",\"server\":\"7352\",\"farm\":8,\"title\":\"Napping\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26649059160\",\"owner\":\"115460474@N02\",\"secret\":\"c88f3f0859\",\"server\":\"7586\",\"farm\":8,\"title\":\"Stretching\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26842936801\",\"owner\":\"8500742@N03\",\"secret\":\"3ef53b6233\",\"server\":\"7289\",\"farm\":8,\"title\":\"The Little Dancer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26908372845\",\"owner\":\"57328404@N08\",\"secret\":\"4286d2c39b\",\"server\":\"7177\",\"farm\":8,\"title\":\"Dunedin Railway Station, Dunedin, Otago, New Zealand.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298456804\",\"owner\":\"44842144@N03\",\"secret\":\"602c1d7308\",\"server\":\"7651\",\"farm\":8,\"title\":\"Lucas Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903665715\",\"owner\":\"44842144@N03\",\"secret\":\"a6ca81a180\",\"server\":\"7347\",\"farm\":8,\"title\":\"Freddy Rodriguez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26631005530\",\"owner\":\"44842144@N03\",\"secret\":\"833bb48182\",\"server\":\"7683\",\"farm\":8,\"title\":\"Christian Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903648985\",\"owner\":\"44842144@N03\",\"secret\":\"67687552fd\",\"server\":\"7376\",\"farm\":8,\"title\":\"Christian Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836393421\",\"owner\":\"44842144@N03\",\"secret\":\"fd87329116\",\"server\":\"7066\",\"farm\":8,\"title\":\"Christian Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26870186736\",\"owner\":\"44842144@N03\",\"secret\":\"a97fe4c0f3\",\"server\":\"7534\",\"farm\":8,\"title\":\"Christian Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903596475\",\"owner\":\"44842144@N03\",\"secret\":\"76545fa4ab\",\"server\":\"7649\",\"farm\":8,\"title\":\"Josh Reavis\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836307841\",\"owner\":\"44842144@N03\",\"secret\":\"c6d345099c\",\"server\":\"7435\",\"farm\":8,\"title\":\"Yeltsin Gudino\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26810125752\",\"owner\":\"44842144@N03\",\"secret\":\"6bfdd89d36\",\"server\":\"7419\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836283151\",\"owner\":\"44842144@N03\",\"secret\":\"5382bcc54d\",\"server\":\"7286\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298357994\",\"owner\":\"44842144@N03\",\"secret\":\"6c3d7e3c1e\",\"server\":\"7469\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26299647823\",\"owner\":\"44842144@N03\",\"secret\":\"f35e847252\",\"server\":\"7177\",\"farm\":8,\"title\":\"Ronaldo Marrero\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836237731\",\"owner\":\"44842144@N03\",\"secret\":\"e1d0ac1bc8\",\"server\":\"7560\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26870121016\",\"owner\":\"44842144@N03\",\"secret\":\"7235ba4bae\",\"server\":\"7660\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26299605363\",\"owner\":\"44842144@N03\",\"secret\":\"3932cedae9\",\"server\":\"7095\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630824290\",\"owner\":\"44842144@N03\",\"secret\":\"d847413fd8\",\"server\":\"7375\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26810061912\",\"owner\":\"44842144@N03\",\"secret\":\"f149b84ce8\",\"server\":\"7220\",\"farm\":8,\"title\":\"Jeff Singer\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26870069926\",\"owner\":\"44842144@N03\",\"secret\":\"79bc6ceceb\",\"server\":\"7383\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26870064636\",\"owner\":\"44842144@N03\",\"secret\":\"4de2538374\",\"server\":\"7396\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298259434\",\"owner\":\"44842144@N03\",\"secret\":\"1ac02d7df7\",\"server\":\"7395\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298246094\",\"owner\":\"44842144@N03\",\"secret\":\"4e8cdf7cde\",\"server\":\"7194\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836129901\",\"owner\":\"44842144@N03\",\"secret\":\"4b802d9dc6\",\"server\":\"7218\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26299494093\",\"owner\":\"44842144@N03\",\"secret\":\"b99e412cdd\",\"server\":\"7577\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809979052\",\"owner\":\"44842144@N03\",\"secret\":\"297410d80d\",\"server\":\"7499\",\"farm\":8,\"title\":\"Jackson Lowery\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26299472273\",\"owner\":\"44842144@N03\",\"secret\":\"d899500066\",\"server\":\"7479\",\"farm\":8,\"title\":\"Earl Burl III\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809956362\",\"owner\":\"44842144@N03\",\"secret\":\"9135a20641\",\"server\":\"7078\",\"farm\":8,\"title\":\"Earl Burl III\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903331505\",\"owner\":\"44842144@N03\",\"secret\":\"5e1b939a0c\",\"server\":\"7773\",\"farm\":8,\"title\":\"Earl Burl III\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809945722\",\"owner\":\"44842144@N03\",\"secret\":\"90711d7402\",\"server\":\"7151\",\"farm\":8,\"title\":\"Earl Burl III\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809935252\",\"owner\":\"44842144@N03\",\"secret\":\"19d5ee9b44\",\"server\":\"7778\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26869939636\",\"owner\":\"44842144@N03\",\"secret\":\"f909874172\",\"server\":\"7592\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903306815\",\"owner\":\"44842144@N03\",\"secret\":\"f649a3b863\",\"server\":\"7547\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836027751\",\"owner\":\"44842144@N03\",\"secret\":\"619ac2f4a2\",\"server\":\"7692\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26836019821\",\"owner\":\"44842144@N03\",\"secret\":\"c4b848b043\",\"server\":\"7632\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903267485\",\"owner\":\"44842144@N03\",\"secret\":\"49a3de70d3\",\"server\":\"7752\",\"farm\":8,\"title\":\"Christian Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298080844\",\"owner\":\"44842144@N03\",\"secret\":\"3179149041\",\"server\":\"7683\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298076284\",\"owner\":\"44842144@N03\",\"secret\":\"e0630e8ec8\",\"server\":\"7090\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298070804\",\"owner\":\"44842144@N03\",\"secret\":\"bba169b381\",\"server\":\"7777\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903210135\",\"owner\":\"44842144@N03\",\"secret\":\"8af3f59dde\",\"server\":\"7160\",\"farm\":8,\"title\":\"Sixto Sanchez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630533460\",\"owner\":\"44842144@N03\",\"secret\":\"14b8788961\",\"server\":\"7478\",\"farm\":8,\"title\":\"Luis Espiritu, Jr\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809757102\",\"owner\":\"44842144@N03\",\"secret\":\"86de62c037\",\"server\":\"7223\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26299306083\",\"owner\":\"44842144@N03\",\"secret\":\"526f0b4bce\",\"server\":\"7155\",\"farm\":8,\"title\":\"Luis Espiritu, Jr\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630478560\",\"owner\":\"44842144@N03\",\"secret\":\"180d2dd7e7\",\"server\":\"7477\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26903076825\",\"owner\":\"44842144@N03\",\"secret\":\"8ff2f8f753\",\"server\":\"7379\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26299226933\",\"owner\":\"44842144@N03\",\"secret\":\"492073e873\",\"server\":\"7591\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630405330\",\"owner\":\"44842144@N03\",\"secret\":\"14332747f2\",\"server\":\"7471\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630401000\",\"owner\":\"44842144@N03\",\"secret\":\"081bc3d302\",\"server\":\"7595\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26297885194\",\"owner\":\"44842144@N03\",\"secret\":\"4699e1bd9e\",\"server\":\"7693\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630181820\",\"owner\":\"44842144@N03\",\"secret\":\"340b00169f\",\"server\":\"7425\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26630175470\",\"owner\":\"44842144@N03\",\"secret\":\"ee3b105c42\",\"server\":\"7487\",\"farm\":8,\"title\":\"Danny Young\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26835421351\",\"owner\":\"44842144@N03\",\"secret\":\"9e3147ec1d\",\"server\":\"7227\",\"farm\":8,\"title\":\"Yeltsin Gudino\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809178772\",\"owner\":\"44842144@N03\",\"secret\":\"1525fb4bd6\",\"server\":\"7156\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26902489945\",\"owner\":\"44842144@N03\",\"secret\":\"06786e81ae\",\"server\":\"7537\",\"farm\":8,\"title\":\"Enger Jimenez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26809150662\",\"owner\":\"44842144@N03\",\"secret\":\"7a1649ac50\",\"server\":\"7223\",\"farm\":8,\"title\":\"Luis Encarnacion\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26869114766\",\"owner\":\"44842144@N03\",\"secret\":\"ebda6958f6\",\"server\":\"7410\",\"farm\":8,\"title\":\"Luis Encarnacion\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629851160\",\"owner\":\"44842144@N03\",\"secret\":\"1aecffb9fb\",\"server\":\"7562\",\"farm\":8,\"title\":\"Luis Encarnacion\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629844420\",\"owner\":\"44842144@N03\",\"secret\":\"02e8e0804e\",\"server\":\"7787\",\"farm\":8,\"title\":\"Luis Encarnacion\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298650793\",\"owner\":\"44842144@N03\",\"secret\":\"ef7ea96785\",\"server\":\"7614\",\"farm\":8,\"title\":\"Luis Encarnacion\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629801220\",\"owner\":\"44842144@N03\",\"secret\":\"3833914f6a\",\"server\":\"7507\",\"farm\":8,\"title\":\"Griffin Glaude\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629791540\",\"owner\":\"44842144@N03\",\"secret\":\"d17313db69\",\"server\":\"7188\",\"farm\":8,\"title\":\"Griffin Glaude\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629785470\",\"owner\":\"44842144@N03\",\"secret\":\"74fd429848\",\"server\":\"7554\",\"farm\":8,\"title\":\"Enger Jimenez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26835212881\",\"owner\":\"44842144@N03\",\"secret\":\"792e155398\",\"server\":\"7263\",\"farm\":8,\"title\":\"Griffin Glaude\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298566003\",\"owner\":\"44842144@N03\",\"secret\":\"738d7690b4\",\"server\":\"7450\",\"farm\":8,\"title\":\"Griffin Glaude\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26834952471\",\"owner\":\"44842144@N03\",\"secret\":\"7074e16de2\",\"server\":\"7520\",\"farm\":8,\"title\":\"Lucas Williams\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26834928931\",\"owner\":\"44842144@N03\",\"secret\":\"60d2cc14e1\",\"server\":\"7078\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298206383\",\"owner\":\"44842144@N03\",\"secret\":\"9674f9b62b\",\"server\":\"7314\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26296983794\",\"owner\":\"44842144@N03\",\"secret\":\"c585b8f01c\",\"server\":\"7251\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298196263\",\"owner\":\"44842144@N03\",\"secret\":\"b99a2159f5\",\"server\":\"7165\",\"farm\":8,\"title\":\"Javier Hernandez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26902120855\",\"owner\":\"44842144@N03\",\"secret\":\"ba754a0480\",\"server\":\"7077\",\"farm\":8,\"title\":\"Javier Hernandez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26902115675\",\"owner\":\"44842144@N03\",\"secret\":\"dbdf5b5cbd\",\"server\":\"7442\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26296970054\",\"owner\":\"44842144@N03\",\"secret\":\"5e6aa7825a\",\"server\":\"7715\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26902102105\",\"owner\":\"44842144@N03\",\"secret\":\"283c50f546\",\"server\":\"7649\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26296959954\",\"owner\":\"44842144@N03\",\"secret\":\"725ccc4331\",\"server\":\"7504\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26902085605\",\"owner\":\"44842144@N03\",\"secret\":\"789ed0fb4e\",\"server\":\"7107\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26808763792\",\"owner\":\"44842144@N03\",\"secret\":\"9992cbf9de\",\"server\":\"7665\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26296940814\",\"owner\":\"44842144@N03\",\"secret\":\"03311b14a4\",\"server\":\"7533\",\"farm\":8,\"title\":\"Will Stewart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26808734552\",\"owner\":\"44842144@N03\",\"secret\":\"c7b04fb607\",\"server\":\"7065\",\"farm\":8,\"title\":\"Manuel Herazo\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26296878404\",\"owner\":\"44842144@N03\",\"secret\":\"deb550cbe6\",\"server\":\"7634\",\"farm\":8,\"title\":\"Vladimir Guerrero Jr.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26902018925\",\"owner\":\"44842144@N03\",\"secret\":\"1e57206c7f\",\"server\":\"7352\",\"farm\":8,\"title\":\"Vladimir Guerrero Jr.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26296848994\",\"owner\":\"44842144@N03\",\"secret\":\"892514f3eb\",\"server\":\"7429\",\"farm\":8,\"title\":\"Vladimir Guerrero Jr.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298045543\",\"owner\":\"44842144@N03\",\"secret\":\"c12cd91554\",\"server\":\"7466\",\"farm\":8,\"title\":\"Vladimir Guerrero Jr.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26298039603\",\"owner\":\"44842144@N03\",\"secret\":\"3e1d89cf02\",\"server\":\"7568\",\"farm\":8,\"title\":\"Vladimir Guerrero Jr.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629326890\",\"owner\":\"44842144@N03\",\"secret\":\"376d7bca3a\",\"server\":\"7139\",\"farm\":8,\"title\":\"Yorman Rodriguez\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629299510\",\"owner\":\"44842144@N03\",\"secret\":\"391a134f06\",\"server\":\"7738\",\"farm\":8,\"title\":\"Jesus Navarro watches his foul\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26297965553\",\"owner\":\"44842144@N03\",\"secret\":\"82d7cc2fdf\",\"server\":\"7467\",\"farm\":8,\"title\":\"Jesus Navarro\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26629293970\",\"owner\":\"44842144@N03\",\"secret\":\"d80cf579d4\",\"server\":\"7676\",\"farm\":8,\"title\":\"Jesus Navarro\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26834658221\",\"owner\":\"44842144@N03\",\"secret\":\"c9a061f965\",\"server\":\"7483\",\"farm\":8,\"title\":\"Rundown continues\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26868485846\",\"owner\":\"44842144@N03\",\"secret\":\"8a4f5a263b\",\"server\":\"7151\",\"farm\":8,\"title\":\"Blue Jay Rundown\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26901865155\",\"owner\":\"44842144@N03\",\"secret\":\"8fa7e427cf\",\"server\":\"7204\",\"farm\":8,\"title\":\"Vladimir Guerrero Jr.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26808462692\",\"owner\":\"44842144@N03\",\"secret\":\"94d25a3683\",\"server\":\"7134\",\"farm\":8,\"title\":\"Antony Fuentes\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26901762025\",\"owner\":\"44842144@N03\",\"secret\":\"855f6b5f9a\",\"server\":\"7762\",\"farm\":8,\"title\":\"Miguel Burgos\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26297758883\",\"owner\":\"44842144@N03\",\"secret\":\"32b4a3cd33\",\"server\":\"7299\",\"farm\":8,\"title\":\"Juandy Mendoza\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26901728105\",\"owner\":\"44842144@N03\",\"secret\":\"7b120a07f1\",\"server\":\"7738\",\"farm\":8,\"title\":\"Juandy Mendoza\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26901724655\",\"owner\":\"44842144@N03\",\"secret\":\"f14f7075ce\",\"server\":\"7466\",\"farm\":8,\"title\":\"Juandy Mendoza\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26808403802\",\"owner\":\"44842144@N03\",\"secret\":\"316fbedaf1\",\"server\":\"7606\",\"farm\":8,\"title\":\"Gabriel Clark\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26808398072\",\"owner\":\"44842144@N03\",\"secret\":\"8ce6bb2e1e\",\"server\":\"7489\",\"farm\":8,\"title\":\"Gabriel Clark\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"26901487615\",\"owner\":\"44842144@N03\",\"secret\":\"b1fea8afc9\",\"server\":\"7149\",\"farm\":8,\"title\":\"Miguel Burgos\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0}]},\"stat\":\"ok\"}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handlers
        setUpButtons();
    }

    /**
     * Sets up the on click handler for button(s)
     */
    private void setUpButtons() {
        //Get reference to button
        Button btnTeleport = (Button) findViewById(R.id.btnTeleport);

        //Set onclick handler
        btnTeleport.setOnClickListener(new btnTeleportHandler());
    }

    private class btnTeleportHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Get a new location
            Location testLocation = getCoords();

            //Get geoplugin data
            AsyncGetLocationData thread=new AsyncGetLocationData();
            thread.execute(testLocation);

            //TODO Get an image
            AsyncSearchFlickrWithCityName thread2 = new AsyncSearchFlickrWithCityName();
            thread2.execute("Dunedin");
        }
    }

    /**
     * Updates the screen to show the current location and city name
     *
     * @param newLocation Location to show
     * @param cityName Name of the city to show
     */
    private void updateLocationCoords(Location newLocation,String cityName) {
        //Get references
        TextView latitude = (TextView) findViewById(R.id.tvLatitude);
        TextView longitude = (TextView) findViewById(R.id.tvLongitude);
        TextView tvClosestCity=(TextView)findViewById(R.id.tvClosestCity);

        //Set text
        latitude.setText(String.format("%.3f", newLocation.getLatitude()));
        longitude.setText(String.format("%.3f", newLocation.getLongitude()));
        tvClosestCity.setText(cityName);
    }

    /**
     * Gets/generates a location
     *
     * @return Location requested
     */
    private Location getCoords() {
        Location output = new Location("Randomization");
        Random rng = new Random();
        //Generate a random latitude between -90 and +90
        output.setLatitude(rng.nextDouble() * 180 - 90);
        //Generate a random longitude between -180 and +180
        output.setLongitude(rng.nextDouble() * 360 - 180);

        return output;
    }

    /**
     * Downloads data from geoplugin.net
     */
    public class AsyncGetLocationData extends AsyncTask<Location, Integer, String> {
        //Create progressDialog
        ProgressDialog pDialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute(){
            //Set up dialog
            pDialog.setMessage(getString(R.string.dialog_title));
            pDialog.show();
        }
        @Override
        protected String doInBackground(Location... params) {
            //Hold location to check
            Location toCheck=params[0];
            //Hold result
            String JSONString="[[]]";
            //Hold number of locations checked
            int locationsChecked=0;

            do{
                //Create url string
                String urlString = "http://www.geoplugin.net/extras/location.gp?lat=" + toCheck.getLatitude() +
                        "&long=" + toCheck.getLongitude() +
                        "&format=json";
                //Increment number of locations checked
                locationsChecked++;

                //Let user know that app hasn't hung
                publishProgress(locationsChecked);

                try {
                    //Convert string to URL object
                    URL URLObject = new URL(urlString);
                    //Create HttpUrlConnection
                    HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
                    //Send the URL
                    con.connect();
                    //If it doesn't return 200, you don't have data
                    int response = con.getResponseCode();
                    //TODO Do something if response isn't 200
                    //Get an inputstream and set up a reader etc
                    InputStream is = con.getInputStream();
                    InputStreamReader ir = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(ir);
                    //Read input
                    String responseString;
                    StringBuilder sb = new StringBuilder();
                    while ((responseString = br.readLine()) != null) {
                        sb = sb.append(responseString);
                    }
                    JSONString = sb.toString();
                } catch (MalformedURLException e) {
                    //TODO Deal with malformed URL
                    e.printStackTrace();
                } catch (IOException e) {
                    //TODO Deal with IO exception
                    e.printStackTrace();

                }
                //Get a new location to check next loop
                toCheck=getCoords();
                //TODO Replace [[]] with a constant...
            }while(JSONString.equals("[[]]"));

            return JSONString;
        }

        protected void onProgressUpdate(Integer... locationsChecked){
            //Build message to show
            String message=String.format(getString(R.string.dialog_message),locationsChecked[0],locationsChecked[0]==1?"":"s");
            //Show message
            pDialog.setMessage(message);
        }

        @Override
        protected void onPostExecute(String fetchedString){
            //Dismiss progress dialog
            pDialog.dismiss();
            //Deal with results
            decodeJSON(fetchedString);
        }
    }

    /**
     * Decodes a JSON string from geoplugin and update form
     * @param input Downloaded JSON string
     */
    public void decodeJSON(String input){
        //Hold data to return
        String cityName;

        try {
            //Get the JSON object
            JSONObject allData=new JSONObject(input);
            //Get the name of the city
            cityName=allData.getString("geoplugin_place");
            //Get location data
            Double latitude=allData.getDouble("geoplugin_latitude");
            Double longitude=allData.getDouble("geoplugin_longitude");

            //Create new location
            Location newLocation=new Location("Randomization");
            newLocation.setLatitude(latitude);
            newLocation.setLongitude(longitude);

            //Update on form
            updateLocationCoords(newLocation,cityName);

        } catch (JSONException e) {
            //TODO Deal with gracefully
            e.printStackTrace();
        }
    }

    //////////// Methods to produce an image from a city name
    public class AsyncSearchFlickrWithCityName extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            //Hold name of city to search for
            String cityName = params[0];
            //Hold result
            String JSONString = "";

            //Create request string
            String urlString = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + getString(R.string.flickr_apikey) +
                    "&tags=" + cityName +
                    "&format=json&nojsoncallback=1";

            try {
                //Convert string to URL object
                URL URLObject = new URL(urlString);
                //Create HttpUrlConnection
                HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
                //Send the URL
                con.connect();
                //If it doesn't return 200, you don't have data
                int response = con.getResponseCode();
                //TODO Do something if response isn't 200
                if (response!=200) {
                    Log.i("ABC123", "doInBackground: responseCode: " + response);
                    return null;
                }
                //Get an inputstream and set up a reader etc
                InputStream is = con.getInputStream();
                InputStreamReader ir = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(ir);
                //Read input
                String responseString;
                StringBuilder sb = new StringBuilder();
                while ((responseString = br.readLine()) != null) {
                    sb = sb.append(responseString);
                }
                JSONString = sb.toString();
            } catch (MalformedURLException e) {
                //TODO Deal with malformed URL
                e.printStackTrace();
            } catch (IOException e) {
                //TODO Deal with IO exception
                e.printStackTrace();

            }

            //Decode JSON string and form image URL
            URL downloadedImage=decodeJSONForImage(JSONString);

            //Download image
            Bitmap theImage = downloadBitmap(downloadedImage);

            return theImage;
        }

        @Override
        protected void onPostExecute(Bitmap theImage) {
            //Get reference to imageView
            ImageView ivClosestCity = (ImageView) findViewById(R.id.ivClosestCity);

            //Check we actually got something
            if (theImage != null) {
                ivClosestCity.setImageBitmap(theImage);
            }
        }
    }

    /**
     * Turns JSON string into an image URL
     * @param fetchedString JSON string
     * @return image URL
     */
    private URL decodeJSONForImage(String fetchedString) {
        URL imageURL = null;
        try {
            Log.i("ABC123", "onPostExecute: " + fetchedString);
            //Get the JSON object
            JSONObject allData = new JSONObject(fetchedString);
            //Get the photo object
            JSONObject photos = allData.getJSONObject("photos");
            //Get the photo array
            JSONArray photoArray = photos.getJSONArray("photo");
            //TODO Look through a few photos and choose one that is actually of the city?

            //Get a photo object
            JSONObject currentPhoto = photoArray.getJSONObject(0);
            //Get required data
            String farmID = currentPhoto.getString("farm");
            String serverID = currentPhoto.getString("server");
            String photoID = currentPhoto.getString("id");
            String secret = currentPhoto.getString("secret");
            //TODO Place this in string.xml or choose filesize dependant on device size?
            String size = "m";

            // Build image URL
            String imageString = String.format(getString(R.string.flickr_imageString), farmID, serverID, photoID, secret, size);
            imageURL = new URL(imageString);

        } catch (JSONException e) {
            //TODO Deal with gracefully
            e.printStackTrace();
        } catch (MalformedURLException e) {
            //TODO Deal with this gracefully
            e.printStackTrace();
        }

        return imageURL;
    }
    /**
     * Download an image from a given URL
     * @param imageURL
     * @return Bitmap of requested image
     */
    public Bitmap downloadBitmap(URL imageURL) {
        //Hold downloaded image
        Bitmap output=null;

        try {
            //Get the URL we want
            URL URLObject = imageURL;

            //Create HttpUrlConnection
            HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
            //Send the URL
            con.connect();
            //If it doesn't return 200, you don't have data
            int response=con.getResponseCode();
            //TODO Do something if response isn't 200
            if (response==200) {
                output = BitmapFactory.decodeStream(con.getInputStream());
            } else {
                //TODO ???
                Log.i("ABC123", "downloadBitmap: response code: "+response);
                return null;
            }
        } catch (MalformedURLException e){
            //TODO Deal with malformed URL
            e.printStackTrace();
        } catch (IOException e){
            //TODO Deal with IO exception
            e.printStackTrace();
        }
        return output;
    }
}