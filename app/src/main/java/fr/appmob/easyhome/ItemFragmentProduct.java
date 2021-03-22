package fr.appmob.easyhome;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import fr.appmob.easyhome.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragmentProduct extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private List<String[]> data;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragmentProduct() {
        data = new Vector<>();
        String[] a1 = {"imageUrl", "seloger.fr", "2", "4", "300000"};
        String[] a2 = {"imageUrl", "seloger.fr", "1", "10", "3021200"};
        String[] a3 = {"imageUrl", "leboncoin.fr", "2", "4", "24189421"};
        String[] a4 = {"imageUrl", "leboncoin.fr", "1", "2", "2498242"};
        data.add(a1);
        data.add(a2);
        data.add(a3);
        data.add(a4);
    }

    // TODO: Customize parameter initialization
    public static ItemFragmentProduct newInstance() {
        ItemFragmentProduct fragment = new ItemFragmentProduct();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_product_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(data));
        }
        return view;
    }
}