package pt.iade.projetomobile.lazuli.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.utils.HorarioUtils;
import pt.iade.projetomobile.lazuli.views.HorarioViewHolder;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioViewHolder> {
    private OnItemListener onItemListener;
    private final ArrayList<LocalDate> days;

    public HorarioAdapter(ArrayList<LocalDate> days, OnItemListener onItemListener) {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent,false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        if(days.size() > 15){
            layoutParams.height = (int) (parent.getHeight() * 0.1666);
        }else{
            layoutParams.height = (int) (parent.getHeight());
        }

        layoutParams.height = (int) (parent.getHeight() * 0.1666666);

        return new HorarioViewHolder(view, onItemListener, days);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        final LocalDate date = days.get(position);
        if(date == null) {
            holder.dayOfMonth.setText("");
        }
        else {
            holder.dayOfMonth.setText(String.valueOf( date.getDayOfMonth()));
            if(date.equals(HorarioUtils.selectDate) )
                holder.parentView.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public interface OnItemListener{
        void onItemClick(int position, LocalDate date);
    }
}
