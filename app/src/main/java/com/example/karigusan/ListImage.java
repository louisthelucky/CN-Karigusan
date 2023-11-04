package com.example.karigusan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ListImage extends Fragment {

    private static final String[] imageNames = {
            "Altheas",
            "Bagasbas",
            "Calaguas",
            "Greenland",
            "Paradisoverde",
            "Pineapple",
            "Pulangdaga",
            "Rala",
            "Cabana Beach Bar and Resort",
            "ZOILO’s SEASIDE PRIVATE RESORT",
            "Vieness Beach Fron"
    };

    private static final int[] resortImages = {
            R.drawable.altheas,
            R.drawable.bagasbas,
            R.drawable.calaguas,
            R.drawable.greenland,
            R.drawable.paradisoverde,
            R.drawable.pineapple,
            R.drawable.pulangdaga,
            R.drawable.rala,
            R.drawable.cabana2,
            R.drawable.zoilos2,
            R.drawable.vieness
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_image, container, false);

        GridView gridView = view.findViewById(R.id.gridView);
        GridAdapter gridViewAdapter = new GridAdapter(requireContext(), resortImages, imageNames);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(requireContext(), "You Clicked on " + imageNames[position], Toast.LENGTH_SHORT).show();
                int imageResId = resortImages[position];
                String text = imageNames[position];

                openSecondFragment(imageResId, text);

            }
        });

        return view;
    }

    private void openSecondFragment(int imageResId, String text) {
        Fragment secondFragment = SecondFragment.newInstance(imageResId, text);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView2, secondFragment); // Replace fragment_container with your actual container ID
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
