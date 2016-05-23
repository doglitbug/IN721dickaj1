package bit.dickaj1.teleporterplus;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by doglitbug on 23-May-16.
 */
public class ShowMapFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap mMap;
    //Hold the location we want to visit
    private LatLng location;
    //Hold context
    private Context myContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View fragmentView= inflater.inflate(R.layout.fragment_map,container,false);
        super.onCreate(savedInstance);

        //Create/get context
        myContext=(Context)savedInstance.get("context");

        //Get location from bundled data
        location=(LatLng)savedInstance.get("LatLng");

        //Find map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) myContext.getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //Get the map
        mapFragment.getMapAsync(this);

        return fragmentView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        //move to correct location
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}