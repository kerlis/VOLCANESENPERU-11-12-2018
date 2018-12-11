package peru.volcanes.volcanesper.m_ui;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import peru.volcanes.volcanesper.R;
import peru.volcanes.volcanesper.m_model.volcanes;
import peru.volcanes.volcanesper.volcanmenu;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
public class VolcanesAdapter extends BaseAdapter {
    String estadovolcan;
    String estadodelvolcan;
    Double alerta_double;
    ImageView imageView;
    TextView tipo;
    TextView actividad;
    RelativeLayout titulo;
    RelativeLayout contenedor;
    ImageView fotoimagen;
    String nombre;
    String codigo;
    String imagen;
    TextView volcan;
    TextView asignacion;
    String riesgo, riesgo2;
    public Context c;
    private ArrayList<volcanes> objetoalertacenizas;
    public VolcanesAdapter(Context c, ArrayList<volcanes> objetoalertacenizas) {
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
            convertView= LayoutInflater.from(c).inflate(R.layout.modelovolcanes,viewGroup,false);
        }
        final volcanes s= (volcanes) this.getItem(position);
        estadovolcan =  s.getEstado();
        double w;
        try {
            w = new Double(estadovolcan);
        } catch (NumberFormatException e) {
            w = 0;
        }
        if (w == 0){
            estadodelvolcan = "0";
        }
        else
        {
            estadodelvolcan = estadovolcan;
        }
        asignacion = (TextView) convertView.findViewById(R.id.asignacion);
        volcan = (TextView) convertView.findViewById(R.id.volcan);
        contenedor = (RelativeLayout) convertView.findViewById(R.id.contenedor);
        alerta_double =  Double.parseDouble(estadodelvolcan);
        if (alerta_double <= 1) {
         //   imageView.setImageResource(R.drawable.verde_volcanes);
           // titulo.setBackgroundColor(Color.parseColor("#04B70D"));
        }
        else if (alerta_double  > 1 && alerta_double == 2) {
           // imageView.setImageResource(R.drawable.amarillo_volcanes);
            //titulo.setBackgroundColor(Color.parseColor("#FBBD08"));
        }
        else if (alerta_double  > 2 && alerta_double == 3) {
          // imageView.setImageResource(R.drawable.orange_volcanes);
          //  titulo.setBackgroundColor(Color.parseColor("#FF5500"));
        }
        else if (alerta_double  > 3 && alerta_double == 4) {
          //  imageView.setImageResource(R.drawable.red_black_volcanes);
          //  titulo.setBackgroundColor(Color.parseColor("#db2828"));
        }
        else {
        // imageView.setImageResource(R.drawable.red_black_volcanes);
       //  titulo.setBackgroundColor(Color.parseColor("#db2828"));
        }

        //evaluar dato magnitud
        riesgo = s.getRiesgo();
        double h;
        try {
            h = new Double(riesgo);
        } catch (NumberFormatException e) {
            h = 0;
        }

        if (h == 0){
            riesgo2 = "0";
           // asignacion.setText("0");
        }
        else
        {
            riesgo2 = s.getRiesgo();
           // asignacion.setText(s.getRiesgo());
        }
        Double val = Double.parseDouble(riesgo2);
        if (val == 4){
            asignacion.setText("Muy \n alto");
            asignacion.setBackgroundResource(R.drawable.circulorojos);
        }
        else if (val == 3){
            asignacion.setText("Alto");
            asignacion.setBackgroundResource(R.drawable.circulonaranja);
        }
        else if (val == 2){
            asignacion.setText("Moderado");
            asignacion.setBackgroundResource(R.drawable.circuloazul);
        }
        else if (val == 1){
            asignacion.setText("Bajo");
            asignacion.setBackgroundResource(R.drawable.circuloverdes);
        }
        tipo =  (TextView) convertView.findViewById(R.id.tipo);

      fotoimagen = (ImageView) convertView.findViewById(R.id.foto);

      fotoimagen.setImageResource(R.drawable.misti_circle);


        tipo.setText("Región " +s.getRegion());
        nombre = s.getNombre();
        codigo =s.getCodigo();
        imagen = s.getImagen();
        volcan.setText(s.getNombre());


        if(imagen != null && !imagen.isEmpty())
        {
            Picasso.with(c).load(imagen)
                    .resize(120, 100)
                    .onlyScaleDown()
                    .into(fotoimagen);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veralerta(s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getAltura(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo(),
                        s.getCodigo());
            }
        });
        return convertView;
    }
    private void veralerta(String...details)
    {
        Intent i=new Intent(c,volcanmenu.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(i);
    }
}