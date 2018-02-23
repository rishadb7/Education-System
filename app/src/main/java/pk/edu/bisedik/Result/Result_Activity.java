package pk.edu.bisedik.Result;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import pk.edu.bisedik.R;

public class Result_Activity extends Fragment {

    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter,adapter2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view;
       view = inflater.inflate(R.layout.result_activity,container,false);

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

    // @Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        spinner1=(Spinner) findViewById(R.id.spinner_examination);
        spinner2=(Spinner) findViewById(R.id.spinner_Year);

        adapter = ArrayAdapter.createFromResource(this,R.array.examination,android.R.layout.simple_spinner_item);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.years,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.setDropDownViewTheme(getTheme());
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i)+"is Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i)+"is Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }*/

}
