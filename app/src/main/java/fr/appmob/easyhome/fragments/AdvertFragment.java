package fr.appmob.easyhome.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.models.Advert;

public class AdvertFragment extends Fragment {

	private Button redirect, share;
	private ImageView image;
	private TextView location, price, rooms, bedrooms, area, description;
	private Advert advert;

	public AdvertFragment(Advert advert) {
		this.advert = advert;
	}


	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_advert, container, false);

		image = view.findViewById(R.id.single_advert_img);
		location = view.findViewById(R.id.single_advert_location);
		price = view.findViewById(R.id.single_advert_price);
		rooms = view.findViewById(R.id.single_advert_rooms);
		bedrooms = view.findViewById(R.id.single_advert_bedrooms);
		area = view.findViewById(R.id.single_advert_area);
		description = view.findViewById(R.id.single_advert_description);
		redirect = view.findViewById(R.id.single_advert_redirect_btn);
		share = view.findViewById(R.id.single_advert_share_btn);

		Glide.with(view).load(advert.getImages_url()[0]).into(image);
		location.setText(advert.getCity() + " - " + advert.getPostal_code());
		price.setText(String.format("%,d", advert.getPrice()).replace(",", " ") + " €");
		rooms.setText(advert.getRooms() + " pieces");
		bedrooms.setText(advert.getBedrooms() + " chambres");
		area.setText(Html.fromHtml(advert.getArea() + "m<sup>2</sup>"));
		description.setText(advert.getDescription());
		redirect.setText("Voir l'annonce sur " + advert.getWebsite());
		redirect.setOnClickListener((c) -> {
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(advert.getUrl()));
			startActivity(browserIntent);
		});
		share.setOnClickListener((c) -> {
			Intent sendIntent = new Intent()
					.setAction(Intent.ACTION_SEND)
					.putExtra(Intent.EXTRA_TEXT, "Hey !, I found an advert on EasyHome check it out:\n" + advert.getUrl())
					.setType("text/plain");

			Intent shareIntent = Intent.createChooser(sendIntent, null);
			startActivity(shareIntent);
		});


		return view;
	}
}
