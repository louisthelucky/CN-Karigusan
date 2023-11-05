package com.example.karigusan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoriteResortAdapter extends RecyclerView.Adapter<FavoriteResortAdapter.FavoriteResortsViewHolder> {

    private Context context;
    private List<String> resortNames;
    private OnItemClickListener onItemClickListener;

    private OnItemLongClickListener onItemLongClickListener;


    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(String resortName);
    }

    public interface OnItemClickListener {
        void onItemClick(String resortName);
    }

    public FavoriteResortAdapter(Context context, List<String> resortNames) {
        this.context = context;
        this.resortNames = resortNames;
    }

    @NonNull
    @Override
    public FavoriteResortsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favorite_view, parent, false);
        return new FavoriteResortsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteResortsViewHolder holder, int position) {
        String resortName = resortNames.get(position);
        holder.resortNameTextView.setText(resortName);
        holder.itemView.setOnClickListener(v -> {

            onItemClickListener.onItemClick(resortName);

        });

        holder.itemView.setOnLongClickListener(v -> {
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLongClick(resortName);
                return true;
            }
            return false;
        });


        // Set the image based on the resort name
        if (resortName.equals("Cabana Beach Bar and Resort")) {
            holder.resortImageView.setImageResource(R.drawable.cabana2);
        } else if (resortName.equals("ZOILO’s SEASIDE PRIVATE RESORT")) {
            holder.resortImageView.setImageResource(R.drawable.zoilos2);
        } else if (resortName.equals("Vieness Beach Fron Resort")) {
            holder.resortImageView.setImageResource(R.drawable.vieness);
        } else if (resortName.equals("Don Mariano Beach House Resort")) {
            holder.resortImageView.setImageResource(R.drawable.donmariano3);
        } else if (resortName.equals("Pambuhan Glamping")) {
            holder.resortImageView.setImageResource(R.drawable.pambuhan2);
        } else if (resortName.equals("Palms Farm Resort")) {
            holder.resortImageView.setImageResource(R.drawable.palms2);
        } else if (resortName.equals("Casanayon Resort")) {
            holder.resortImageView.setImageResource(R.drawable.casanayon);
        } else if (resortName.equals("Dome Place")) {
            holder.resortImageView.setImageResource(R.drawable.domeplace2);
        } else if (resortName.equals("Maria Fatima Farm Resort")) {
            holder.resortImageView.setImageResource(R.drawable.maria2);
        } else if (resortName.equals("Gardenn's Garden")) {
            holder.resortImageView.setImageResource(R.drawable.garden2);
        } else if (resortName.equals("Pook Mirasol")) {
            holder.resortImageView.setImageResource(R.drawable.pook3);
        } else if (resortName.equals("Zam’s Garden Resort")) {
            holder.resortImageView.setImageResource(R.drawable.zams2);
        } else if (resortName.equals("Selfie Beach Resort")) {
            holder.resortImageView.setImageResource(R.drawable.selfie3);
        } else if (resortName.equals("Greenland Resort")) {
            holder.resortImageView.setImageResource(R.drawable.greenland);
        } else if (resortName.equals("Candelaria Resort")) {
            holder.resortImageView.setImageResource(R.drawable.candelaria2);
        } else if (resortName.equals("Gumaus Bay Resort")) {
            holder.resortImageView.setImageResource(R.drawable.gumaus);
        } else if (resortName.equals("Mambulao Pacific Resort")) {
            holder.resortImageView.setImageResource(R.drawable.mambulao2);
        } else if (resortName.equals("Altheas Dreamland’s Resort")) {
            holder.resortImageView.setImageResource(R.drawable.althea2);
        } else if (resortName.equals("Club noah Eco- Resort")) {
            holder.resortImageView.setImageResource(R.drawable.noah);
        } else if (resortName.equals("D’ GARDEN AGRI RESORT")) {
            holder.resortImageView.setImageResource(R.drawable.agri);
        } else if (resortName.equals("The Jars Hotel and Resort")) {
            holder.resortImageView.setImageResource(R.drawable.jars);
        } else if (resortName.equals("Calaguas Paradise Resort")) {
            holder.resortImageView.setImageResource(R.drawable.calaguas2);
        } else if (resortName.equals("Mananap Falls")) {
            holder.resortImageView.setImageResource(R.drawable.mananap);
        }
        // Add more conditions for the rest of the resorts

    }

    @Override
    public int getItemCount() {
        return resortNames.size();
    }

    public static class FavoriteResortsViewHolder extends RecyclerView.ViewHolder {
        ImageView resortImageView;
        TextView resortNameTextView;

        public FavoriteResortsViewHolder(@NonNull View itemView) {
            super(itemView);
            resortImageView = itemView.findViewById(R.id.img);
            resortNameTextView = itemView.findViewById(R.id.brief);
        }
    }
}

