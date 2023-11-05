package com.example.karigusan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class SecondFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private static final int[] resortImages = {
            R.drawable.cabana2,
            R.drawable.zoilos2,
            R.drawable.vieness,
            // Add more image resources here
    };

    private TextView textView;

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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_fragment, container, false);



        textView = view.findViewById(R.id.textView);


        ArrayList<SlideModel> imageList = new ArrayList<>();


        Bundle args = getArguments();
        if (args != null) {
            String text = args.getString("text");

            if (text == "Cabana Beach Bar and Resort") {
                textView.setText(getResources().getString(R.string.cabana_desc));
                imageList.add(new SlideModel(R.drawable.cabana,"Cabana Beach Bar and Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.cabana2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.cabana3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.cabana4,ScaleTypes.CENTER_CROP));
            } else if (text == "ZOILO’s SEASIDE PRIVATE RESORT") {
                textView.setText(getResources().getString(R.string.zoilo_desc));
                imageList.add(new SlideModel(R.drawable.zoilos,"ZOILO’s SEASIDE PRIVATE RESORT", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos3,ScaleTypes.CENTER_CROP));
            } else if (text == "Vieness Beach Fron Resort") {
                textView.setText(getResources().getString(R.string.vieness_desc));
                imageList.add(new SlideModel(R.drawable.vieness,"Vieness Beach Fron Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.vieness2,ScaleTypes.CENTER_CROP));
            } else if (text == "Don Mariano Beach House Resort") {
                textView.setText(getResources().getString(R.string.donmariano_desc));
                imageList.add(new SlideModel(R.drawable.donmariano,"Don Mariano Beach House Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.donmariano2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.donmariano3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.donmariano4,ScaleTypes.CENTER_CROP));
            } else if (text ==  "Pambuhan Glamping") {
                textView.setText(getResources().getString(R.string.pambuhan_desc));
                imageList.add(new SlideModel(R.drawable.pambuhan,"Pambuhan Glamping", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pambuhan2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pambuhan3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pambuhan4,ScaleTypes.CENTER_CROP));
            } else if (text == "Palms Farm Resort") {
                textView.setText(getResources().getString(R.string.palms_desc));
                imageList.add(new SlideModel(R.drawable.palms,"Palms Farm Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.palms2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.palms3,ScaleTypes.CENTER_CROP));
            } else if (text ==  "Casanayon Resort") {
                textView.setText(getResources().getString(R.string.casanayon_desc));
                imageList.add(new SlideModel(R.drawable.casanayon,"Casanayon Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.casanayon2,ScaleTypes.CENTER_CROP));
            } else if (text == "Dome Place") {
                textView.setText(getResources().getString(R.string.domeplace_desc));
                imageList.add(new SlideModel(R.drawable.domeplace,"Dome Place", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.domeplace2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.domeplace3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.domeplace4,ScaleTypes.CENTER_CROP));
            } else if (text == "Maria Fatima Farm Resort") {
                textView.setText(getResources().getString(R.string.maria_desc));
                imageList.add(new SlideModel(R.drawable.maria,"Maria Fatima Farm Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.maria2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.maria3,ScaleTypes.CENTER_CROP));
            } else if (text == "Gardenn's Garden") {
                textView.setText(getResources().getString(R.string.garden_desc));
                imageList.add(new SlideModel(R.drawable.garden,"Gardenn's Garden", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.garden2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.garden3,ScaleTypes.CENTER_CROP));
            } else if (text == "Pook Mirasol") {
                textView.setText(getResources().getString(R.string.pook_desc));
                imageList.add(new SlideModel(R.drawable.pook,"Pook Mirasol", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pook2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pook3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.pook4,ScaleTypes.CENTER_CROP));
            } else if (text == "Zam’s Garden Resort") {
                textView.setText(getResources().getString(R.string.zams_desc));
                imageList.add(new SlideModel(R.drawable.zams,"Zam’s Garden Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zams2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zams3,ScaleTypes.CENTER_CROP));
            } else if (text == "Selfie Beach Resort") {
                textView.setText(getResources().getString(R.string.selfie_desc));
                imageList.add(new SlideModel(R.drawable.selfie,"Selfie Beach Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.selfie2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.selfie3,ScaleTypes.CENTER_CROP));
            } else if (text == "Greenland Resort") {
                textView.setText(getResources().getString(R.string.greenland_desc));
                imageList.add(new SlideModel(R.drawable.greenland,"Greenland Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.greenland2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.greenland3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.greenland4,ScaleTypes.CENTER_CROP));
            } else if (text == "Candelaria Resort") {
                textView.setText(getResources().getString(R.string.candelaria_desc));
                imageList.add(new SlideModel(R.drawable.candelaria,"Candelaria Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.candelaria2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.candelaria3,ScaleTypes.CENTER_CROP));
            } else if (text == "Gumaus Bay Resort") {
                textView.setText(getResources().getString(R.string.gumaus_desc));
                imageList.add(new SlideModel(R.drawable.gumaus,"Gumaus Bay Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.gumaus2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.gumaus3,ScaleTypes.CENTER_CROP));
            } else if (text == "Mambulao Pacific Resort") {
                textView.setText(getResources().getString(R.string.mambulao_desc));
                imageList.add(new SlideModel(R.drawable.mambulao,"Mambulao Pacific Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.mambulao2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.mambulao3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.mambulao4,ScaleTypes.CENTER_CROP));
            } else if (text == "Altheas Dreamland’s Resort") {
                textView.setText(getResources().getString(R.string.althea_desc));
                imageList.add(new SlideModel(R.drawable.althea,"Altheas Dreamland’s Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.althea2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.althea3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.althea4,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.altheas,ScaleTypes.CENTER_CROP));
            } else if (text == "Club noah Eco- Resort") {
                textView.setText(getResources().getString(R.string.noah_desc));
                imageList.add(new SlideModel(R.drawable.noah,"Club noah Eco- Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah4,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.noah5,ScaleTypes.CENTER_CROP));
            } else if (text == "D’ GARDEN AGRI RESORT") {
                textView.setText(getResources().getString(R.string.agri_desc));
                imageList.add(new SlideModel(R.drawable.agri,"D’ GARDEN AGRI RESORT", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.agri2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.agri3,ScaleTypes.CENTER_CROP));
            } else if (text == "The Jars Hotel and Resort") {
                textView.setText(getResources().getString(R.string.jars_desc));
                imageList.add(new SlideModel(R.drawable.jars,"The Jars Hotel and Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.jars2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.jars3,ScaleTypes.CENTER_CROP));
            } else if (text == "Calaguas Paradise Resort") {
                textView.setText(getResources().getString(R.string.calaguas_desc));
                imageList.add(new SlideModel(R.drawable.calaguas,"Calaguas Paradise Resort", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas3,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas4,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.calaguas5,ScaleTypes.CENTER_CROP));
            } else if (text == "Mananap Falls") {
                textView.setText(getResources().getString(R.string.mananap_desc));
                imageList.add(new SlideModel(R.drawable.mananap,"Mananap Falls", ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos2,ScaleTypes.CENTER_CROP));
                imageList.add(new SlideModel(R.drawable.zoilos3,ScaleTypes.CENTER_CROP));
            }


        }
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        return view;
    }


}