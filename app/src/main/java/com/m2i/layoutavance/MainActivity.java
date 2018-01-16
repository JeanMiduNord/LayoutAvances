package com.m2i.layoutavance;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFragment(View view) {
        //  Instanciation du fragment
        TestFragmentB fragmentB = new TestFragmentB();
        //Récupération  d'une instance du gestionnaire de fragment
        FragmentManager manager = getFragmentManager();
        //début de la transaction
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragmentContainer, fragmentB);
        transaction.commit();
    }

    public void updateFragment(View view) {
        // même méthode que dans Add mais plus courte pour le remplacement
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment2,new TestFragmentB())
                .commit();
    }
}
