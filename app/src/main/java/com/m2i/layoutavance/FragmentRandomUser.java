package com.m2i.layoutavance;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.m2i.model.RandomUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRandomUser extends Fragment {

    private List<RandomUser> userList;
    private ListView userListView;


    public FragmentRandomUser() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDataFromHTTP();

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_random_user, container, false);
        userListView = view.findViewById(R.id.randomUserListView);
        return view;
    }

    private void getDataFromHTTP(){
        String url = "https://jsonplaceholder.typicode.com/users";
        // définition de la requete
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        processResponse(response);
                        Log.i("http : ",response);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.d("http error ", error.getMessage());
                    }
                }
        );
        // ajout de la requete à la file d'exécution
        Volley.newRequestQueue(this.getActivity()).add(request);
    }

    private void processResponse(String response){

        userList = responseToList(response);

        //  conversion de la liste de RandomUser en un tableau de string comportant
        // uniquement le nom des utilisateurs

        String[] data = new String[userList.size()];

        for(int i=0; i < userList.size();i++){
            data[i] = userList.get(i).getUserName();
        }

        // Définition d'un arrayAdapter pour alimenter la listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,data);
        userListView.setAdapter(adapter);
    }

    /**
     * conversion d'une réponse json en une liste de RandoUser
     * @param response
     * @return
     */
    private List<RandomUser> responseToList(String response){
        List<RandomUser> list = new ArrayList<>();
        try {
            JSONArray jsonUsers = new JSONArray(response);
            JSONObject item;
            for(int i=0; i <jsonUsers.length();i++){
                // récupération de l'occurence
                item = (JSONObject) jsonUsers.get(i);
                // Instanciation de l'utilisateur
                RandomUser user = new RandomUser();
                //Hydratation de l'utilisateur
                user.setUserName(item.getString("name"));
                user.setEmail(item.getString("email"));
                // récupération des coordonnées contenues dans un objet de l'enregistrement
                JSONObject geo = item.getJSONObject("address").getJSONObject("geo");
                user.setLatitude(geo.getDouble("lat"));
                user.setLatitude(geo.getDouble("lng"));
                list.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;

    }
}
