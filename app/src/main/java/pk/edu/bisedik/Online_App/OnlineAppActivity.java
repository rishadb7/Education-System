package pk.edu.bisedik.Online_App;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import pk.edu.bisedik.Contect_us.ExapandableListView_Adapter;
import pk.edu.bisedik.R;

public class OnlineAppActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_app);

        expandableListView = (ExpandableListView)findViewById(R.id.expendibleListView);

        ExapandableListView_Adapter adapter = new ExapandableListView_Adapter(this);
        expandableListView.setAdapter(adapter);
        
        expandableListView.getExpandableListAdapter();
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                
                switch (groupPosition){
                    case 0:
                        Toast.makeText(OnlineAppActivity.this, "Track Your Application", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(),TrackingActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(OnlineAppActivity.this, "Document Verification", Toast.LENGTH_SHORT).show();
                        break;
                }
                
                return false;
            }
        });
    }
}
