package pt.iade.projetomobile.lazuli.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import pt.iade.projetomobile.lazuli.R;
import pt.iade.projetomobile.lazuli.models.Evento;

public class EventoView extends LinearLayout {
    protected Evento evento;

    protected TextView titleText;
    protected TextView participantsText;
    private View view;

    public EventoView(Context context, Evento evento) {
        this(context);
        this.evento = evento;

        titleText = (TextView)view.findViewById(R.id.titleLabel);
        participantsText = (TextView)view.findViewById(R.id.participantsLabel);

        populateView();
    }

    public EventoView(Context context) {
        super(context);
        view = inflate(getContext(), R.layout.layout_evento, this);
    }

    public EventoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = inflate(getContext(), R.layout.layout_evento, this);
    }

    public EventoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = inflate(getContext(), R.layout.layout_evento, this);
    }

    public void populateView() {
        titleText.setText(evento.getTitle());
        participantsText.setText(evento.getParticipants() + " participants");
    }
}
