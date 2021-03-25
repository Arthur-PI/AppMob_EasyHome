package fr.appmob.easyhome.adapters;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.activities.MainActivity;
import fr.appmob.easyhome.fragments.AdvertFragment;
import fr.appmob.easyhome.models.Advert;
import fr.appmob.easyhome.models.DataHandler;
import fr.appmob.easyhome.models.SessionManagement;

import java.util.List;

public class
MyAdvertsAdapter extends RecyclerView.Adapter<MyAdvertsAdapter.ViewHolder> {
	private final List<Advert> adverts;
	private final List<String> likesId;

	public MyAdvertsAdapter(List<Advert> items, List<String> likesId) {
		this.adverts = items;
		this.likesId = likesId;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.card_advert, parent, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int i) {
		Advert advert = adverts.get(i);

		Glide.with(holder.mView).load(advert.getImages_url()[0]).into(holder.image);
		holder.website.setText(advert.getWebsite());
		holder.location.setText(advert.getCity() + " - " + advert.getPostal_code());
		holder.rooms.setText(advert.getRooms() + " pieces");
		holder.bedrooms.setText(advert.getBedrooms() + " chambres");
		holder.price.setText(String.format("%,d", advert.getPrice()).replace(",", " ") + " €");
		holder.area.setText(Html.fromHtml(advert.getArea() + "m<sup>2</sup>"));
		if (likesId.contains(advert.getUnique_id())) changeLikeImage(holder.like_img, R.drawable.favorite_red_18dp);
		else changeLikeImage(holder.like_img, R.drawable.favorite_white_18dp);

		holder.like.setOnClickListener(v -> {
			String userId = new SessionManagement(holder.mView.getContext()).getSession();
			if (holder.like_img.getTag().equals(R.drawable.favorite_white_18dp)) {
				DataHandler.getInstance().likeAdvert(userId, advert.getUnique_id());
				changeLikeImage(holder.like_img, R.drawable.favorite_red_18dp);
			} else {
				DataHandler.getInstance().unlikeAdvert(userId, advert.getUnique_id());
				changeLikeImage(holder.like_img, R.drawable.favorite_white_18dp);
			}
		});

		holder.card.setOnClickListener((track) -> {
			((FragmentActivity) holder.mView.getContext())
					.getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.main_fragment, new AdvertFragment(advert), "ADVERT")
					.commit();
			MainActivity.setCurFrag(R.id.advert_card);
		});
	}

	@Override
	public int getItemCount() {
		return adverts.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		final View mView;
		TextView website, bedrooms, rooms, price, area, location;
		ImageView image, like_img;
		RelativeLayout like;
		CardView card;

		public ViewHolder(View view) {
			super(view);
			mView = view;
			image = itemView.findViewById(R.id.advert_image);
			website = itemView.findViewById(R.id.advert_website);
			rooms = itemView.findViewById(R.id.advert_rooms);
			bedrooms = itemView.findViewById(R.id.advert_bedrooms);
			price =  itemView.findViewById(R.id.advert_price);
			area =  itemView.findViewById(R.id.advert_area);
			location =  itemView.findViewById(R.id.advert_city);
			like = itemView.findViewById(R.id.advert_like_button);
			like_img = itemView.findViewById(R.id.advert_like_img);
			card = itemView.findViewById(R.id.advert_card);
			;
		}
	}

	private void changeLikeImage(ImageView img, int drawable) {
		img.setTag(drawable);
		img.setImageResource(drawable);
	}

}