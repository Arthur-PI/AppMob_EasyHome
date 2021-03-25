package fr.appmob.easyhome.fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.adapters.MyAdvertsAdapter;
import fr.appmob.easyhome.models.Advert;
import fr.appmob.easyhome.models.Criteria;
import fr.appmob.easyhome.models.DataHandler;
import fr.appmob.easyhome.models.SessionManagement;


public class HomeFragment extends Fragment {

	private RecyclerView recyclerView;
	private RelativeLayout likeLayout;
	private static final String TAG = "HOME FRAGMENT";

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		recyclerView = view.findViewById(R.id.advert_recycler_view);
		likeLayout = view.findViewById(R.id.advert_like_button);

		List<Advert> adverts = getAdverts();
		List<String> likes = DataHandler.getInstance().getLikesId();
		Log.i(TAG, Arrays.toString(likes.toArray()));

		MyAdvertsAdapter myAdapter = new MyAdvertsAdapter(adverts, likes);
		recyclerView.setAdapter(myAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

		criterias = view.findViewById(R.id.home_criteres_button);
		criterias.setOnClickListener(v -> {
			String tag = "criteria";
			FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.main_fragment, new CriteriasFragment(), tag).addToBackStack(null).commit();
		});

		return view;
	}

	private List<Advert> getAdverts() {
		Criteria c = new Criteria("75002","", "paris", "25", "150", "100000", null, false, false, true, false);
		DataHandler dh = DataHandler.getInstance();
		dh.setCriteres(c);
		return dh.getAdverts();
	}

}
