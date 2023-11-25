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
import pt.iade.projetomobile.lazuli.models.TarefaItem;

public class TarefaItemRowAdapter extends RecyclerView.Adapter<TarefaItemRowAdapter.ViewHolder> {
    private ArrayList<TarefaItem> items;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public TarefaItemRowAdapter(Context context, ArrayList<TarefaItem> items) {
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
       TarefaItem item = items.get(position);
        holder.titleLabel.setText(item.getTitle());
        holder.notesLabel.setText(item.getDescription());
        holder.doneCheck.setChecked(item.isDone());
    }

    /**
     * The RecyclerView needs to know the size of our list, this just provides that.
     *
     * @return Size of our data.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Class responsible for recycling the views as you scroll.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleLabel;
        public TextView notesLabel;
        public CheckBox doneCheck;

        /**
         * Sets up the view that was inflated.
         *
         * @param itemView Layout view that was inflated.
         */
        public ViewHolder(View itemView) {
            super(itemView);

            // Get the components in the view.
            titleLabel = itemView.findViewById(R.id.titleText);
            notesLabel = itemView.findViewById(R.id.descriptionText);
            doneCheck = itemView.findViewById(R.id.itemDone);

            // Set what happens when the view gets clicked.
            itemView.setOnClickListener(this);
        }

        /**
         * Handles the onclick event of the view.
         */
        @Override
        public void onClick(View view) {
            // Pass the event to our custom listener in the activity.
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    /**
     * Defines what to do when a list item gets clicked.
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}