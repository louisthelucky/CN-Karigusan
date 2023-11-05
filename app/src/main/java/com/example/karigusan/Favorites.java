package com.example.karigusan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Favorites extends Fragment implements FavoriteResortAdapter.OnItemClickListener,FavoriteResortAdapter.OnItemLongClickListener{

    private RecyclerView favoritesRecyclerView;
    private DBHelper dbHelper;
    private String resortName;

    private FavoriteResortAdapter adapter;
    private List<String> savedFavorites;

    public Favorites() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        favoritesRecyclerView = view.findViewById(R.id.favoritesRecyclerView);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        dbHelper = new DBHelper(requireContext());

        savedFavorites = dbHelper.getAllFavoriteResorts();


        adapter = new FavoriteResortAdapter(requireContext(), savedFavorites);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
        favoritesRecyclerView.setAdapter(adapter);

        TextView title = getActivity().findViewById(R.id.title_app);
        title.setText("FAVORITE");

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            resortName = getArguments().getString("resortName");
        }
        dbHelper = new DBHelper(requireContext());
    }

    @Override
    public void onItemClick(String resortName) {
        SecondFragment secondFragment = SecondFragment.newInstance(resortName);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView2, secondFragment); // Replace fragment_container with your actual container ID
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemLongClick(String resortName) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), favoritesRecyclerView);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.remove_favorite) {
                dbHelper.removeFavoriteResort(resortName);
                savedFavorites.remove(resortName); // Remove from the list
                adapter.notifyDataSetChanged(); // Notify the adapter that the data has changed
                return true;
            }
            return false;
        });
        popupMenu.show();
    }

}
