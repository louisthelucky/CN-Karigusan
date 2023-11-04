package com.example.karigusan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment second_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(int imageResId, String text) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("imageResId", imageResId);
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

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        TextView title = view.findViewById(R.id.image_title);



        Bundle args = getArguments();
        if (args != null) {
            int imageResId = args.getInt("imageResId");
            String text = args.getString("text");
            imageView.setImageResource(imageResId);
            title.setText(text);

            if (text == "Cabana Beach Bar and Resort") {
                textView.setText(getResources().getString(R.string.cabana_desc));
            } else if (text == "ZOILO’s SEASIDE PRIVATE RESORT") {
                textView.setText(getResources().getString(R.string.zoilo_desc));
            } else if (text == "Vieness Beach Fron") {
                textView.setText(getResources().getString(R.string.vieness_desc));
            }


        }

        return view;
    }
}