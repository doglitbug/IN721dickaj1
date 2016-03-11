package bit.dickaj1.fragmentsintro;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ShowListViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View fragmentView= inflater.inflate(R.layout.show_listview_fragment,container,false);

        // Do any required setup for thr fragment view here...
        //TODO load up listview

        return fragmentView;
    }
}
