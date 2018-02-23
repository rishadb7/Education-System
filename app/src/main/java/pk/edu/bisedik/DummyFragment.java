package pk.edu.bisedik;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DummyFragment extends Fragment {

    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter,adapter2;

    public DummyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_dummy,container,false);

        spinner1=(Spinner) view.findViewById(R.id.spinner_examination);
        spinner2=(Spinner) view.findViewById(R.id.spinner_Year);

        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.examination,android.R.layout.simple_spinner_item);
        adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.years,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.setDropDownViewTheme(getTheme());
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),adapterView.getItemIdAtPosition(i)+"is Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),adapterView.getItemIdAtPosition(i)+"is Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return  view;
    }

}
