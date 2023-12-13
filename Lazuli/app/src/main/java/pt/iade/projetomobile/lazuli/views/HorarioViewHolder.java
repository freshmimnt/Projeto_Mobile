package pt.iade.projetomobile.lazuli.views;

import android.view.View;
import android.widget.TextView;
import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.adapters.HorarioAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final TextView dayOfMonth;
    private final HorarioAdapter.OnItemListener onItemListener;

    public HorarioViewHolder(@NonNull View itemView, HorarioAdapter.OnItemListener onItemListener) {
        super(itemView);

        dayOfMonth = itemView.findViewById(R.id.cellDayText);

        this.onItemListener = onItemListener;

        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText());
    }
}
