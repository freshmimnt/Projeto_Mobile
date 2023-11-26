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
import pt.iade.projetomobile.lazuli.models.UcItem;
public class UcItemRowAdapter extends RecyclerView.Adapter<UcItemRowAdapter.ViewHolder> {


    private ArrayList<UcItem> items;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public UcItemRowAdapter(Context context, ArrayList<UcItem> items){
        inflater = LayoutInflater.from(context);
        this.items = items;
    }


}
