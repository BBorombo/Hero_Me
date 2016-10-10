package com.borombo.herome.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.borombo.herome.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button accidentButton;
    private Button geneticButton;
    private Button bornButton;
    private Button chooseButotn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        accidentButton = (Button) view.findViewById(R.id.accident_button);
        geneticButton = (Button) view.findViewById(R.id.genetic_button);
        bornButton = (Button) view.findViewById(R.id.born_button);
        chooseButotn = (Button) view.findViewById(R.id.chosse_button);

        accidentButton.setOnClickListener(this);
        geneticButton.setOnClickListener(this);
        bornButton.setOnClickListener(this);

        chooseButotn.setEnabled(false);
        chooseButotn.getBackground().setAlpha(128);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        chooseButotn.setEnabled(true);
        chooseButotn.getBackground().setAlpha(255);

        accidentButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        geneticButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);
        bornButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);
        
        Button button = (Button) view;
        int leftDrawable = 0;

        if (button == accidentButton){
            leftDrawable = R.drawable.lightning;
        }else if(button == geneticButton){
            leftDrawable = R.drawable.atomic;
        }else if (button == bornButton){
            leftDrawable = R.drawable.rocket;
        }
        button.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.itemselected,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
