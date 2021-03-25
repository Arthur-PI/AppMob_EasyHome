package fr.appmob.easyhome.fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class FavouritesFragment extends Fragment {

	private RecyclerView recyclerView;
	private static final String TAG = "FAV FRAGMENT";

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_favourites, container, false);

		recyclerView = view.findViewById(R.id.advert_likes_recycler_view);

		List<Advert> adverts = getLikedAdverts();
		List<String> likes = DataHandler.getInstance().getLikesId();
		Log.i(TAG, Arrays.toString(likes.toArray()));

		MyAdvertsAdapter myAdapter = new MyAdvertsAdapter(adverts, likes);
		recyclerView.setAdapter(myAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

		return view;
	}

	private List<Advert> getLikedAdverts() {
		return DataHandler.getInstance().getLikedAdvert();
	}
}
