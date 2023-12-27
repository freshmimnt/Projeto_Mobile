package pt.iade.projetomobile.lazuli.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.models.Horario;
import pt.iade.projetomobile.lazuli.utils.HorarioUtils;

public class NovoHorarioAdapter extends ArrayAdapter<Horario>{

    public NovoHorarioAdapter(@NonNull Context context, List<Horario> horarios) {
        super(context, 0, horarios);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Horario horario = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.uc_add, parent, false);

        }

        TextView textView = convertView.findViewById(R.id.ucText);

        String title = horario.getDesc() + " " + HorarioUtils.formattedTime(horario.getHoraInicio()) + " até " + HorarioUtils.formattedTime(horario.getHoraFim());

        textView.setText(title);

        return convertView;

    }

}
