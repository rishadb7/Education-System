package pk.edu.bisedik.Contect_us;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Abdul Basit Danish on 1/3/2018.
 */

public class ExapandableListView_Adapter extends BaseExpandableListAdapter {


    String[] groupName = {"Track Your Application","Document Verification","Migration Certificate",
            "Duplicate Marksheet","Result Cancellation","Rechecking of Answer Book","Roll No.Slip Correction",
    "change Subject/Group","Online Appointment"};
    String[][] childNames = {{"Boxing","Kick Boxing","Judo","Football","BasketBall"},
            {"Desktop computer","Laptop computer","Samartphone computer"},
            {"Ice Cream","Banana"},{"Mercedes Benz"},{"Samsung TV","LG TV"}};


    Context context;
    public ExapandableListView_Adapter(Context context){
        this.context=context;
    }

    @Override
    public int getGroupCount() {
        //number of elements that are inside of group have contains
        return groupName.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //number of childrens
        return childNames[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        //it returns object in this we put the group name along with positions..or specific index
        return groupName[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childNames[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupId) {
        //returns the
        return groupId;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


        TextView textView = new TextView(context);
        textView.setText(groupName[groupPosition]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(20);



        return textView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastPosition, View view, ViewGroup parent) {

        final TextView textView = new TextView(context);
        textView.setText(childNames[groupPosition][childPosition]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);


        //anonymous inner class
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, textView.getText().toString()+"", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
