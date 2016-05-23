package bit.dickaj1.teleporterplus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by doglitbug on 23-May-16.
 */
public class ShowMapFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View fragmentView = inflater.inflate(R.layout.fragment_map, container, false);

        //TODO Get bundled location
        //TODO Do all the set up to show a google map in this fragment

        return fragmentView;
    }
}
