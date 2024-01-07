package pt.iade.projetomobile.lazuli.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.models.UCItem;

public class UCAdapter extends RecyclerView.Adapter<UCAdapter.ViewHolder> {

    private ArrayList<UCItem> items;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public UCAdapter(Context context, ArrayList<UCItem> items) {

        inflater = LayoutInflater.from(context);
        this.items = items;
        clickListener = null;

    }

    public void setOnClickListener(ItemClickListener listener) {



        clickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.uc_add, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        UCItem item = items.get(position);
        holder.ucName.setText(item.getName());
    }

    @Override
    public int getItemCount(){
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView ucName;

        public ViewHolder(View itemView){
            super(itemView);

            ucName = itemView.findViewById(R.id.ucText);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if(clickListener != null){
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

}
