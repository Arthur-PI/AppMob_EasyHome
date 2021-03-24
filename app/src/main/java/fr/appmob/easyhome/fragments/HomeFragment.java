package fr.appmob.easyhome.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.appmob.easyhome.adapters.MyAdvertsAdapter;
import fr.appmob.easyhome.R;
import fr.appmob.easyhome.models.Advert;
import fr.appmob.easyhome.models.Criteria;
import fr.appmob.easyhome.models.DataHandler;

public class HomeFragment extends Fragment {

	private RecyclerView recyclerView;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		recyclerView = view.findViewById(R.id.advert_recycler_view);

		List<Advert> adverts = getAdverts();

		MyAdvertsAdapter myAdapter = new MyAdvertsAdapter(adverts);
		recyclerView.setAdapter(myAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

//        Fragment f = ItemProductFragment.newInstance();

//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().replace(R.id.main_fragment, f, "ListAdverts").commit();

		return view;
	}

	private List<Advert> getAdverts() {
		Criteria c = new Criteria("75002", "paris", "25", "150", "100000", null, false, false, true, false);
		DataHandler dh = DataHandler.getInstance();
		dh.setCriteres(c);
		return dh.getAdverts();
	}
}
