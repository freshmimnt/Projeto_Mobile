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
import pt.iade.projetomobile.lazuli.models.TesteItem;
public class TesteItemRowAdapter extends RecyclerView.Adapter<TesteItemRowAdapter.ViewHolder> {

    private ArrayList<TesteItem> items;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public TesteItemRowAdapter(Context context, ArrayList<TesteItem> items){
        inflater = LayoutInflater.from((context));
        this.items = items;
        clickListener = null;
    }

    public void setOnClickListener(TesteItemRowAdapter.ItemClickListener listener) {

        clickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.todo_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TesteItemRowAdapter.ViewHolder holder, int position) {
        TesteItem item = items.get(position);
        holder.titleLabel.setText(item.getTitle());
        holder.notesLabel.setText(item.getDescription());
        holder.doneCheck.setChecked(item.isDone());
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

}
