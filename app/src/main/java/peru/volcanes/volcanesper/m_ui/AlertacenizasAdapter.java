package peru.volcanes.volcanesper.m_ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import peru.volcanes.volcanesper.R;
import peru.volcanes.volcanesper.Veralertacenizas;
import peru.volcanes.volcanesper.m_model.alertacenizas;

import java.util.ArrayList;

public class AlertacenizasAdapter extends BaseAdapter {
    TextView fecha_hora;
    TextView evento;
    TextView alerta;
    public Context c;
    private ArrayList<alertacenizas> objetoalertacenizas;
    public AlertacenizasAdapter(Context c, ArrayList<alertacenizas> objetoalertacenizas) {
        this.c = c;
        this.objetoalertacenizas = objetoalertacenizas;
    }
    @Override
    public int getCount() {
        return objetoalertacenizas.size();
    }
    @Override
    public Object getItem(int pos) {
        return objetoalertacenizas.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        return pos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.modelalertacenizas,viewGroup,false);
        }
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.parseColor("#F0EFF5"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        fecha_hora = (TextView) convertView.findViewById(R.id.fecha_hora);
        evento = (TextView) convertView.findViewById(R.id.evento);
        alerta = (TextView) convertView.findViewById(R.id.alerta);
        Typeface fontAwesomeFont = Typeface.createFromAsset(c.getAssets(),
                "fontawesome-webfont.ttf");
        alerta.setTypeface(fontAwesomeFont);
        final alertacenizas s= (alertacenizas) this.getItem(position);
        fecha_hora.setText(s.getFecha()+"  "+s.getHora());
        evento.setText("Tipo de Evento : \n" + s.getTipo_evento());
        convertView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            veralerta(s.getCodigoalerta(),
                s.getCodigoalerta(),
                s.getFecha(),
                s.getFecha(),
                s.getHora(),
                s.getFecha_detalle(),
                s.getHora_detalle(),
                s.getZonas_afectadas(),
                s.getTipo_evento(),
                s.getDireccion_dispersion(),
                s.getAltura(),
                s.getRadio_dispersion_ceniza(),
                s.getObservaciones(),
                s.getRecomendaciones(),
                s.getCodigovolcan());
            }
        });
        return convertView;
    }

    private void veralerta(String...details) {
        Intent i=new Intent(c,Veralertacenizas.class);
        i.putExtra("CODIGOALERTA",details[0]);
        i.putExtra("ALERTA",details[1]);
        i.putExtra("ESTADOVOLCAN",details[2]);
        i.putExtra("FECHA",details[3]);
        i.putExtra("HORA",details[4]);
        i.putExtra("FECHADETALLE",details[5]);
        i.putExtra("HORADETALLE",details[6]);
        i.putExtra("ZONASAFECTADAS",details[7]);
        i.putExtra("TIPOEVENTO",details[8]);
        i.putExtra("DISPERSION",details[9]);
        i.putExtra("ALTURA",details[10]);
        i.putExtra("RADIODISPERSIONCENIZA",details[11]);
        i.putExtra("OBSERVACIONES",details[12]);
        i.putExtra("RECOMENDACIONES",details[13]);
        i.putExtra("CODIGOVOLCAN",details[14]);
        c.startActivity(i);
    }
}