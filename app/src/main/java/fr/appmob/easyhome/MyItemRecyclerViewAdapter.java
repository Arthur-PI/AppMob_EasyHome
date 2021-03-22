package fr.appmob.easyhome;

import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fr.appmob.easyhome.dummy.DummyContent.DummyItem;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<String[]> listItems;

    public MyItemRecyclerViewAdapter(List<String[]> items) {
        listItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        Uri imageURL = new URI(listItems.get(position)[0]);
//        holder.Image.setImageURI(imageURL);
        holder.Website.setText(listItems.get(position)[1]);
        holder.Rooms.setText(listItems.get(position)[2]);
        holder.Bedrooms.setText(listItems.get(position)[3]);
        holder.Price.setText(listItems.get(position)[4]);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView Website,Bedrooms, Rooms,Price;
        public ImageView Image;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            Image = itemView.findViewById(R.id.advert_image);
            Website = itemView.findViewById(R.id.advert_website);
            Rooms = itemView.findViewById(R.id.advert_rooms);
            Bedrooms = itemView.findViewById(R.id.advert_bedrooms);
            Price =  itemView.findViewById(R.id.advert_price);
        }
    }
}