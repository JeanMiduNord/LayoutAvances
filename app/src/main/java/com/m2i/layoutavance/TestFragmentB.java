package com.m2i.layoutavance;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragmentB extends Fragment {
    private Fragment myself = this;

    public TestFragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_fragment_b, container, false);
        Button btDelete = view.findViewById(R.id.btnSup);
        btDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getActivity()
                        .getFragmentManager()
                        .beginTransaction().remove(myself).commit();
            }
        });
        return view;
    }

}
