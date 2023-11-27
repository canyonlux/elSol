package com.example.el_sol;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SolarImageAdapter extends RecyclerView.Adapter<SolarImageAdapter.ViewHolder> {

    private List<SolarImage> solarImages; // La lista de datos

    // Constructor
    public SolarImageAdapter(List<SolarImage> solarImages) {
        this.solarImages = solarImages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SolarImage solarImage = solarImages.get(position);
        holder.imageView.setImageResource(solarImage.getImageResourceId());
        holder.textViewTitle.setText(solarImage.getTitle());
        // Aquí podrías también configurar el título en el Toolbar si es necesario
    }

    @Override
    public int getItemCount() {
        return solarImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public Toolbar toolbar;
        public TextView textViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textView);
            toolbar = itemView.findViewById(R.id.toolbar);
            toolbar.inflateMenu(R.menu.menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int position = getBindingAdapterPosition();
                    if (position == RecyclerView.NO_POSITION) return false;

                    int itemId = item.getItemId();
                    if (itemId == R.id.action_copy) {
                        // Acción para copiar el ítem
                        SolarImage copiedImage = solarImages.get(position);
                        solarImages.add(position, copiedImage); // Copiar el ítem
                        notifyItemInserted(position);
                        return true;
                    } else if (itemId == R.id.action_delete) {
                        // Acción para eliminar el ítem
                        solarImages.remove(position);
                        notifyItemRemoved(position);
                        return true;
                    }
                    return false;
                    }

            });
        }
    }
}
