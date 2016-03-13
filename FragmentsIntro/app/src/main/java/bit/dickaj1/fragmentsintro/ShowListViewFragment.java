package bit.dickaj1.fragmentsintro;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ShowListViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View fragmentView = inflater.inflate(R.layout.show_listview_fragment, container, false);

        //1 .Get a reference to the list view with fragmentView.findViewbyId
        ListView lvCities = (ListView) fragmentView.findViewById(R.id.lvCities);
        //2. Get your array of string from Res
        Resources res = getResources();
        String[] cityNamesArray = res.getStringArray(R.array.city_names_array);
        //3. Create the adapter
        ArrayAdapter<String> cityNamesAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,cityNamesArray);
        //4. Pass it to setAdapter to bind it
        lvCities.setAdapter(cityNamesAdapter);
        //Return finished view
        return fragmentView;
    }
}
