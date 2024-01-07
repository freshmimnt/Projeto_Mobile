package pt.iade.projetomobile.lazuli.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.models.LembreteItem;
import pt.iade.projetomobile.lazuli.models.TesteItem;
import pt.iade.projetomobile.lazuli.models.TarefaItem;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {

    private ArrayList<Object> items;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public AgendaAdapter(Context context, ArrayList<Object> items) {
        inflater = LayoutInflater.from(context);
        this.items = items;
        clickListener = null;
    }

    public void setOnClickListener(ItemClickListener listener) {
        clickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.todo_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object obj = items.get(position);
        if (obj instanceof TesteItem) {
            TesteItem item = (TesteItem) obj;
            holder.titleLabel.setText(item.getTitle());
            holder.notesLabel.setText(item.getDescription());
            holder.doneCheck.setChecked(item.isDone());
        } else if (obj instanceof TarefaItem) {
            TarefaItem item = (TarefaItem) obj;
            holder.titleLabel.setText(item.getTitle());
            holder.notesLabel.setText(item.getDescription());
            holder.doneCheck.setChecked(item.isDone());
        }else if(obj instanceof LembreteItem){
            LembreteItem item = (LembreteItem) obj;
            holder.titleLabel.setText(item.getName());
            holder.notesLabel.setText(item.getDesc());
            holder.doneCheck.setChecked(item.isFinished());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleLabel;
        public TextView notesLabel;
        public CheckBox doneCheck;

        public ViewHolder(View itemView) {
            super(itemView);

            titleLabel = itemView.findViewById(R.id.titleText);
            notesLabel = itemView.findViewById(R.id.descriptionText);
            doneCheck = itemView.findViewById(R.id.itemDone);

            // Set what happens when the view gets clicked.
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public void removeItem(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, items.size());
        }

    }
}

