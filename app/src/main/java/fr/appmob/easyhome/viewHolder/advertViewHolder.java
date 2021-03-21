package fr.appmob.easyhome.viewHolder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.appmob.easyhome.Interface.itemClickListener;
import fr.appmob.easyhome.R;

public class advertViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView Title, Description,Price;
    public ImageView image;
    public itemClickListener listener;

    public advertViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.advert_image);
        Title = itemView.findViewById(R.id.advert_title);
        Description = itemView.findViewById(R.id.advert_description);
        Price =  itemView.findViewById(R.id.advert_price);
    }

    public void setItemClicjListener(itemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        listener.onClick(v,getAdapterPosition(),false);
    }
}
