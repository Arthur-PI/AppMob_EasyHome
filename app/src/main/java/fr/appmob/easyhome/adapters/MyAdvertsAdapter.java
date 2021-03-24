package fr.appmob.easyhome.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.models.Advert;

import java.util.List;

public class MyAdvertsAdapter extends RecyclerView.Adapter<MyAdvertsAdapter.ViewHolder> {
    private final List<Advert> adverts;

    public MyAdvertsAdapter(List<Advert> items) {
        this.adverts = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row, parent, false);

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_product, parent, false);
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
    }

    @Override
    public int getItemCount() {
        return adverts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        TextView website, bedrooms, rooms, price, area, location, published_date;
        ImageView image;

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
//            published_date =  itemView.findViewById(R.id.advert_area);
        }
    }
}