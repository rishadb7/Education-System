package pk.edu.bisedik.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pk.edu.bisedik.Contect_us.RecyclerViewExample;
import pk.edu.bisedik.DummyFragment;
import pk.edu.bisedik.Online_App.OnlineAppActivity;
import pk.edu.bisedik.R;
import pk.edu.bisedik.RollNo.Roll_No_Slip_Activity;

public class Hom_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;*/

    public Hom_Fragment() {
        // Required empty public constructor
    }


    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_hom_, container, false);
         rootview=view;
        view.findViewById(R.id.imgNews).setOnClickListener(mListener);
        view.findViewById(R.id.imgResult).setOnClickListener(mListener);
        view.findViewById(R.id.imgRollNo).setOnClickListener(mListener);
        view.findViewById(R.id.imgOnlineApp).setOnClickListener(mListener);
        view.findViewById(R.id.imgAffiliated).setOnClickListener(mListener);
        view.findViewById(R.id.imgFeeInfo).setOnClickListener(mListener);
        view.findViewById(R.id.imgContect).setOnClickListener(mListener);
        view.findViewById(R.id.imgGallery).setOnClickListener(mListener);
        view.findViewById(R.id.imgFaq).setOnClickListener(mListener);



        return view;
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imgNews:
                    Toast.makeText(getContext(), "That now", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imgResult:

                    AppCompatActivity activity=(AppCompatActivity)rootview.getContext();
                    Fragment fragment = new DummyFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder,fragment).addToBackStack(null).commit();


                   /* FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentHolder, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*/
                    break;
                case R.id.imgRollNo:
                    Intent intent2=new Intent(getActivity(),Roll_No_Slip_Activity.class);
                    getActivity().startActivity(intent2);
                    break;
                case R.id.imgOnlineApp:
                    Toast.makeText(getContext(), "Thats was clicked", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(getActivity(),OnlineAppActivity.class);
                    getActivity().startActivity(intent4);
                    break;
                case R.id.imgContect:

                    Toast.makeText(getContext(), "Contect Us is Clicked", Toast.LENGTH_SHORT).show();
                   Intent intent5 = new Intent(getActivity(),RecyclerViewExample.class);
                   startActivity(intent5);
            }
        }
    };




    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/


   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
