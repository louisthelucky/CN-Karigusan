package com.example.karigusan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private TextView textView;
    private DBHelper dbHelper;
    private String resortName;
    private Uri gmmIntentUri;

    public SecondFragment() {
        // Required empty public constructor
    }


    public static SecondFragment newInstance(String text) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString("text", text);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            resortName = getArguments().getString("resortName");
        }
        dbHelper = new DBHelper(requireContext());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void saveFavoriteResort(String resortName) {
        dbHelper.addFavoriteResort(resortName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_fragment, container, false);



        textView = view.findViewById(R.id.textView);



        ArrayList<SlideModel> imageList = new ArrayList<>();
        ImageButton favButton = view.findViewById(R.id.favButton);
        ImageButton location = getActivity().findViewById(R.id.gobutton);


        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments() != null) {
                    String text = getArguments().getString("text");
                    List<String> favoriteResorts = dbHelper.getAllFavoriteResorts();
                    if (!favoriteResorts.contains(text)) {
                        saveFavoriteResort(text); // Save the favorite resort
                        Toast.makeText(requireContext(), "Added to Favorites: " + text, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(requireContext(), "Already in Favorites: " + text, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



        Bundle args = getArguments();
        if (args != null) {
            String text = args.getString("text");

            if ("Cabana Beach Bar and Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.cabana_desc));
                imageList.add(new SlideModel(R.drawable.cabana,"Cabana Beach Bar and Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.cabana2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.cabana3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.cabana4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Cabana+Beach+Bar+and+Resort+Camarines+Norte+Philippines");
            } else if ("ZOILO’s SEASIDE PRIVATE RESORT".equals(text)) {
                textView.setText(getResources().getString(R.string.zoilo_desc));
                imageList.add(new SlideModel(R.drawable.zoilos,"ZOILO’s SEASIDE PRIVATE RESORT", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Zoilo's+Seaside+Private+Resort+Camarines+Norte+Philippines");

            } else if ("Vieness Beach Fron Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.vieness_desc));
                imageList.add(new SlideModel(R.drawable.vieness,"Vieness Beach Fron Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.vieness2,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Vieness+Beach+Front+Resort+Camarines+Norte+Philippines");

            } else if ("Don Mariano Beach House Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.donmariano_desc));
                imageList.add(new SlideModel(R.drawable.donmariano,"Don Mariano Beach House Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.donmariano2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.donmariano3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.donmariano4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Don+Mariano+Beach+House+Resort+Camarines+Norte+Philippines");

            } else if ("Pambuhan Glamping".equals(text)) {
                textView.setText(getResources().getString(R.string.pambuhan_desc));
                imageList.add(new SlideModel(R.drawable.pambuhan,"Pambuhan Glamping", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pambuhan2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pambuhan3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pambuhan4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Pambuhan+Glamping+Camarines+Norte+Philippines");

            } else if ("Palms Farm Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.palms_desc));
                imageList.add(new SlideModel(R.drawable.palms,"Palms Farm Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.palms2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.palms3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Palms+Farm+Resort+Camarines+Norte+Philippines");

            } else if ("Casanayon Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.casanayon_desc));
                imageList.add(new SlideModel(R.drawable.casanayon,"Casanayon Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.casanayon2,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=&destination=Casanayon+Resort+Camarines+Norte+Philippines");

            } else if ("Dome Place".equals(text)) {
                textView.setText(getResources().getString(R.string.domeplace_desc));
                imageList.add(new SlideModel(R.drawable.domeplace,"Dome Place", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.domeplace2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.domeplace3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.domeplace4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Dome+Place,+Labo,+Camarines+Norte+4604,+Philippines");


            } else if ("Maria Fatima Farm Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.maria_desc));
                imageList.add(new SlideModel(R.drawable.maria,"Maria Fatima Farm Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.maria2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.maria3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Maria+Fatima+Farm+Resort+Camarines+Norte+Philippines");

            } else if ("Gardenn's Garden".equals(text)) {
                textView.setText(getResources().getString(R.string.garden_desc));
                imageList.add(new SlideModel(R.drawable.garden,"Gardenn's Garden", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.garden2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.garden3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=4W6M+QM2, San Vicente Rd, Daet, Camarines Norte, Philippines");

            } else if ("Pook Mirasol".equals(text)) {
                textView.setText(getResources().getString(R.string.pook_desc));
                imageList.add(new SlideModel(R.drawable.pook,"Pook Mirasol", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pook2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pook3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pook4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Sitio+Mandulungan+Barangay+Gubat+Daet+4600+Camarines+Norte+Philippines");

            } else if ("Zam’s Garden Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.zams_desc));
                imageList.add(new SlideModel(R.drawable.zams,"Zam’s Garden Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zams2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zams3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Zam's+Garden+Resort+Camarines+Norte+Philippines");

            } else if ("Selfie Beach Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.selfie_desc));
                imageList.add(new SlideModel(R.drawable.selfie,"Selfie Beach Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.selfie2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.selfie3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Selfie+Beach+Resort+Camarines+Norte+Philippines");

            } else if ("Greenland Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.greenland_desc));
                imageList.add(new SlideModel(R.drawable.greenland,"Greenland Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.greenland2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.greenland3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.greenland4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Greenland+Resort+Camarines+Norte+Philippines");

            } else if ("Candelaria Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.candelaria_desc));
                imageList.add(new SlideModel(R.drawable.candelaria,"Candelaria Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.candelaria2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.candelaria3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Candelaria+Resort+Camarines+Norte+Philippines");

            } else if ("Gumaus Bay Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.gumaus_desc));
                imageList.add(new SlideModel(R.drawable.gumaus,"Gumaus Bay Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.gumaus2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.gumaus3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Gumaus+Bay+Resort+Camarines+Norte+Philippines");

            } else if ("Mambulao Pacific Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.mambulao_desc));
                imageList.add(new SlideModel(R.drawable.mambulao,"Mambulao Pacific Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.mambulao2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.mambulao3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.mambulao4,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Mambulao+Pacific+Resort+Camarines+Norte+Philippines");

            } else if ("Altheas Dreamland’s Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.althea_desc));
                imageList.add(new SlideModel(R.drawable.althea,"Altheas Dreamland’s Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.althea2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.althea3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.althea4,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.altheas,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Althea's+Dreamland+Resort+Camarines+Norte+Philippines");

            } else if ("Club noah Eco- Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.noah_desc));
                imageList.add(new SlideModel(R.drawable.noah,"Club noah Eco- Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah4,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah5,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Club+Noah+Eco-Resort+Camarines+Norte+Philippines");

            } else if ("D’ GARDEN AGRI RESORT".equals(text)) {
                textView.setText(getResources().getString(R.string.agri_desc));
                imageList.add(new SlideModel(R.drawable.agri,"D’ GARDEN AGRI RESORT", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.agri2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.agri3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=D'+Garden+Agri+Resort+Camarines+Norte+Philippines");

            } else if ("The Jars Hotel and Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.jars_desc));
                imageList.add(new SlideModel(R.drawable.jars,"The Jars Hotel and Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.jars2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.jars3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=The+Jars+Hotel+and+Resort+Camarines+Norte+Philippines");

            } else if ("Calaguas Paradise Resort".equals(text)) {
                textView.setText(getResources().getString(R.string.calaguas_desc));
                imageList.add(new SlideModel(R.drawable.calaguas,"Calaguas Paradise Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas4,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas5,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=Calaguas+Paradise+Resort+Camarines+Norte+Philippines");


            } else if ("Mananap Falls".equals(text)) {
                textView.setText(getResources().getString(R.string.mananap_desc));
                imageList.add(new SlideModel(R.drawable.mananap,"Mananap Falls", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos3,ScaleTypes.CENTER_CROP));
                gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Mananap+Falls+Camarines+Norte+Philippines");


            }
            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    startActivity(mapIntent);
                }
            });

        }
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        return view;

    }
}