package com.m2i.layoutavance;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInscription extends Fragment {
    DrawerActivity parentActivity;
    EditText userNameEditText;

    public FragmentInscription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_inscription, container, false);

        // récupération d'une référence de l'activité
        parentActivity = (DrawerActivity) getActivity();

        // Récupération de la référence au champ du formulaire

        userNameEditText  = view.findViewById(R.id.edtUserName);
        userNameEditText.setText(parentActivity.getUser().getUserName());



        // Gestion du click sur le bouton valider

        Button btValid = view.findViewById(R.id.btnValid);
        btValid.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               String username = userNameEditText.getText().toString();
               parentActivity.getUser().setUserName(username);

               parentActivity.goToFragmentB();
           }
        });
        return view;
    }

}
