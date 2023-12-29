package pt.iade.projetomobile.lazuli.views;

import android.view.View;
import android.widget.TextView;
import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.adapters.HorarioAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class HorarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final ArrayList<LocalDate> days;
    public final View parentView;
    public final TextView dayOfMonth;
    private final HorarioAdapter.OnItemListener onItemListener;

    public HorarioViewHolder(@NonNull View itemView, HorarioAdapter.OnItemListener onItemListener, ArrayList<LocalDate> days) {
        super(itemView);
        this.parentView = itemView.findViewById(R.id.parentView);

        dayOfMonth = itemView.findViewById(R.id.cellDayText);

        this.onItemListener = onItemListener;

        itemView.setOnClickListener(this);

        this.days = days;
    }


    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition(), days.get(getAdapterPosition()));
    }
}
