package peru.volcanes.volcanesper.m_ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import peru.volcanes.volcanesper.MapsActivity;
import peru.volcanes.volcanesper.R;
import peru.volcanes.volcanesper.m_model.trayectorias;

import java.util.ArrayList;

public class TrayectoriaAdapter extends BaseAdapter {
    TextView parametrohoras;
    TextView text_valor_inicio;
    TextView text_valor_fin;
    RelativeLayout opciones;
    public Context c;
    String p;
    private ArrayList<trayectorias> objetosismos;
    public TrayectoriaAdapter(Context c, ArrayList<trayectorias> objetosismos) {
        this.c = c;
        this.objetosismos = objetosismos;
    }
    @Override
    public int getCount() {
        return objetosismos.size();
    }
    @Override
    public Object getItem(int pos) {
        return objetosismos.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        return pos;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.modelotrayectorias,viewGroup,false);
        }

        final int g = position;

        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.parseColor("#F0EFF5"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        parametrohoras = (TextView) convertView.findViewById(R.id.parametrohoras);
        final trayectorias s= (trayectorias) this.getItem(position);
        parametrohoras.setText(s.getTiempo());
        text_valor_inicio = (TextView) convertView.findViewById(R.id.text_valor_inicio);
        text_valor_fin = (TextView) convertView.findViewById(R.id.text_valor_fin);
        text_valor_inicio.setText(s.getInicio());
        text_valor_fin.setText(s.getFin());
        opciones  = (RelativeLayout) convertView.findViewById(R.id.opciones);
        Typeface fontAwesomeFont = Typeface.createFromAsset(c.getAssets(),"fontawesome-webfont.ttf");
        p = String.valueOf(g);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(s.getFin(),
                        s.getInicio(),
                        s.getTiempo(),
                        s.getVolcan(),
                        s.getCodigo(),
                        s.getEstadovolcan(),
                        p);
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(s.getFin(),
                        s.getInicio(),
                        s.getTiempo(),
                        s.getVolcan(),
                        s.getCodigo(),
                        s.getEstadovolcan(),
                        p);
            }
        });
        return convertView;
    }
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,MapsActivity.class);
        i.putExtra("FIN",details[0]);
        i.putExtra("INICIO",details[1]);
        i.putExtra("TIEMPO",details[2]);
        i.putExtra("VOLCAN",details[3]);
        i.putExtra("CODIGO",details[4]);
        i.putExtra("ESTADO",details[5]);
        i.putExtra("ITEMCODIGO",details[6]);
        c.startActivity(i);
    }
}