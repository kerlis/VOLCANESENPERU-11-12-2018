package peru.volcanes.volcanesper;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;


public class Alertadecenizasdatos extends FragmentActivity {
    TextView pueblos;
    TextView volcan;
    TextView tipodeevento;
    TextView direccion;
    TextView radio;
    TextView fecha;
    TextView hora;
    TextView observacicones;
    TextView recomendaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datosalertadeceniza);

    }
}