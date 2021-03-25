package fr.appmob.easyhome.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.models.Criteria;
import fr.appmob.easyhome.models.DataHandler;
import fr.appmob.easyhome.models.SessionManagement;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CriteriasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CriteriasFragment extends Fragment {
    private Activity activity;
    private EditText rooms,area_max,area_min,price_min,price_max,postal_code;
    private CheckBox search_type_buy,search_type_rent,property_type_house,property_type_apartment;
    private Button buttonValider;
    private View view;
    private static final String TAG = "CriteriaFragmaent";

    public CriteriasFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CriteriasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CriteriasFragment newInstance() {
        CriteriasFragment fragment = new CriteriasFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public void initCriteria(Criteria criteria){
        rooms.setText(criteria.getRooms());
        area_max.setText(criteria.getArea_max());
        area_min.setText(criteria.getArea_min());
        price_min.setText(criteria.getPrice_min());
        price_max.setText(criteria.getPrice_max());
        postal_code.setText(criteria.getPostal_codes());
        search_type_buy.setChecked(criteria.getSearch_type().equals("buy")||criteria.getSearch_type().equals(""));
        search_type_rent.setChecked(criteria.getSearch_type().equals("rent")||criteria.getSearch_type().equals(""));
        property_type_house.setChecked(criteria.getProperty_type().equals("House")||criteria.getProperty_type().equals(""));
        property_type_apartment.setChecked(criteria.getProperty_type().equals("Apartment")||criteria.getProperty_type().equals(""));

    }
    public void saveCriteria(){
        Criteria criteria = new Criteria();

        criteria.setRooms(String.valueOf(rooms.getText()));
        criteria.setArea_max(String.valueOf(area_max.getText()));
        criteria.setArea_min(String.valueOf(area_min.getText()));
        criteria.setPrice_min(String.valueOf(price_min.getText()));
        criteria.setPrice_max(String.valueOf(price_max.getText()));
        criteria.setPostal_codes(String.valueOf(postal_code.getText()));
        if (this.search_type_buy.isChecked() == search_type_rent.isChecked())
            criteria.setSearch_type("");
        else if(this.search_type_rent.isChecked()) criteria.setSearch_type("rent");
        else if (this.search_type_buy.isChecked()) criteria.setSearch_type("buy");

        if (this.property_type_apartment.isChecked()==this.property_type_apartment.isChecked())
            criteria.setProperty_type("");
        else if (this.property_type_apartment.isChecked()) criteria.setProperty_type("Apartment");
        else if (this.property_type_apartment.isChecked()) criteria.setProperty_type("House");

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String userId = new SessionManagement(getContext()).getSession();
        DataHandler handler = DataHandler.getInstance();
        Gson gson = new Gson();
        db.collection("criterias").document(userId).update("criteria",(String) gson.toJson(criteria));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_criterias, container, false);
        activity = getActivity();
        rooms = view.findViewById(R.id.rooms);
        area_max= (EditText) view.findViewById(R.id.area_max);
        area_min= (EditText) view.findViewById(R.id.area_min);
        price_min= (EditText) view.findViewById(R.id.price_min);
        price_max= (EditText) view.findViewById(R.id.price_max);
        postal_code= (EditText) view.findViewById(R.id.postal_code);
        search_type_buy= (CheckBox) view.findViewById(R.id.search_type_buy);
        search_type_rent= (CheckBox) view.findViewById(R.id.search_type_rent);
        property_type_house= (CheckBox) view.findViewById(R.id.property_type_house);
        property_type_apartment = (CheckBox) view.findViewById(R.id.property_type_apartment);

        String userId = new SessionManagement(getContext()).getSession();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("criterias")
                .document(userId)
                .get()
                .addOnSuccessListener(s -> {
                        String critere = (String) s.get("criteria");
                        DataHandler handler = DataHandler.getInstance();
                        Gson gson = new Gson();
                        handler.setCriteres(gson.fromJson(critere, Criteria.class));
                        String type = new String();
                        initCriteria(handler.getCriteres());

                });

        buttonValider = (Button) view.findViewById(R.id.criteres_envoyer_button);
        buttonValider.setOnClickListener(v -> {
            Log.w(TAG,"Je suis dans le save");
            saveCriteria();
            String tag = "home";
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_fragment, new HomeFragment(), tag).addToBackStack(null).commit();
        });

        return view;
    }
}