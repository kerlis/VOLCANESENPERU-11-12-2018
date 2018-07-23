package peru.volcanes.volcanesper;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class Alertando extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    TextView pueblos;
    TextView volcan;
    TextView tipodeevento;
    TextView direccion;
    TextView radio;
    TextView fecha;
    TextView hora;
    TextView observacicones;
    TextView recomendaciones;
    TextView simulacro;
    String pueblos_dat;
    String volcan_dat;
    String tipodeevento_dat;
    String direccion_dat;
    String radio_dat;
    String fecha_dat;
    String hora_dat;
    String observacicones_dat;
    String recomendaciones_dat;
    String simulacro_dat;
    String horautc_dat;
    String nobrevolcan;
    String fin_dato;
    String inicio_dato;
    String tiempo_dato;
    String volcan_dato;
    String codigo_dato;
    String estado_dato;
    String itemcodigo_dato;
    String tipodenotificacion_dat;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerBlock;
    ImageView sliderz;
    RelativeLayout blocke1a;
    RelativeLayout blocke2a;
    RelativeLayout blocke4a;
    RelativeLayout blocke5a;
    RelativeLayout blocke9;
    RelativeLayout blocke6a;
    RelativeLayout compartirfile;
    TextView compartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datosalertadecenizas);
        compartirfile= (RelativeLayout) findViewById(R.id.b6);
        compartir = (TextView) findViewById(R.id.compartir);
        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);

        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertando.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertando.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertando.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertando.this,Convenciones.class);
                startActivity(intent);
            }
        });

        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertando.this,Listadoredessociales.class);
                startActivity(intent);
            }
        });

        blocke6a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        pueblos = (TextView) findViewById(R.id.pueblos);
        volcan = (TextView) findViewById(R.id.volcan);
        tipodeevento = (TextView) findViewById(R.id.tipodeevento);
        direccion = (TextView) findViewById(R.id.direccion);
        radio = (TextView) findViewById(R.id.radio);
        fecha = (TextView) findViewById(R.id.fecha);
        hora = (TextView) findViewById(R.id.hora);
        observacicones = (TextView) findViewById(R.id.observacicones);
        recomendaciones = (TextView) findViewById(R.id.recomendaciones);
        simulacro = (TextView) findViewById(R.id.simulacro);
        Intent i=this.getIntent();

        tipodenotificacion_dat = i.getExtras().getString("TIPODENOTIFICACION");
        volcan_dat = i.getExtras().getString("VOLCAN");
        pueblos_dat = i.getExtras().getString("PUEBLOS");
        tipodeevento_dat = i.getExtras().getString("TIPODEEVENTO");
        direccion_dat = i.getExtras().getString("DIRECCION");
        radio_dat = i.getExtras().getString("RADIO");
        fecha_dat = i.getExtras().getString("FECHA");
        hora_dat = i.getExtras().getString("HORA");
        recomendaciones_dat = i.getExtras().getString("RECOMENDACIONES");
        observacicones_dat = i.getExtras().getString("OBSERVACIONES");
        simulacro_dat = i.getExtras().getString("SIMULACRO");
        horautc_dat = i.getExtras().getString("HORAUTC");
        String hora_subs = hora_dat.substring(0, hora_dat.length() - 1);
        String hora_subs2 = hora_subs.substring(1);
        String pueblos_subs = pueblos_dat.substring(0, pueblos_dat.length() - 1);
        String tipodeevento_subs = tipodeevento_dat.substring(0, tipodeevento_dat.length() - 1);
        String tipodeevento_subs2 = tipodeevento_subs.substring(1);
        String direccion_subs = direccion_dat.substring(0, direccion_dat.length() - 1);
        String direccion_subs2 = direccion_subs.substring(1);
        String radio_subs = radio_dat.substring(0, radio_dat.length() - 1);
        String radio_subs2 = radio_subs.substring(1);
        String fecha_subs = fecha_dat.substring(0, fecha_dat.length() - 1);
        String fecha_subs2 = fecha_subs.substring(1);
        String simulacro_subs = simulacro_dat.substring(0, simulacro_dat.length() - 1);
        String simulacro_subs2 = simulacro_subs.substring(1);
        String observaciones_subs = observacicones_dat.substring(0, observacicones_dat.length() - 1);
        String observaciones_subs2 = observaciones_subs.substring(1);
        String recomendaciones_subs = recomendaciones_dat.substring(0, recomendaciones_dat.length() - 1);
        String recomendaciones_subs2 = recomendaciones_subs.substring(1);
        //String horautc_subs = horautc_dat.substring(0, horautc_dat.length() - 1);
        String horautc_subs2 = horautc_dat.substring(1);
        //String simulacro_subs = simulacro_dat.substring(0, simulacro_dat.length() - 1);
        String va =  String.valueOf(volcan_dat);

        if(va.equals(",1493157379002,")){
            nobrevolcan = "Volcán Ubinas";
            volcan.setText("Volcán Ubinas");

        }
        else if(va.equals(",1493157381161,")) {
            nobrevolcan = "Volcán Sabancaya";
            volcan.setText("Volcán Sabancaya");

        }
        else if(va.equals(",1506454510537,")) {
            nobrevolcan = "Volcán Sara Sara";
            volcan.setText("Volcán Sara Sara");

        }
        else if(va.equals(",1506455245814,")) {
            nobrevolcan = "Volcán Cerro Auquihuato";
            volcan.setText("Volcán Cerro Auquihuato");

        }
        else if(volcan_dat.equals(",1506455248101,")) {
            volcan.setText("Volcán Andahua");

            nobrevolcan = "Volcán Andahua";
        }
        else if(va.equals(",1506455249661,")) {
            nobrevolcan = "Volcán Coropuna";
            volcan.setText("Volcán Coropuna");

        }
        else if(va.equals(",1506455251429,")) {
            nobrevolcan = "Volcán Huambo";
            volcan.setText("Volcán Huambo");

        }
        else if(va.equals(",1506455253382,")) {
            nobrevolcan = "Volcán Chachani";
            volcan.setText("Volcán Chachani");

        }
        else if(va.equals(",1506455254838,")) {
            nobrevolcan = "Volcán Tutupaca";
            volcan.setText("Volcán Tutupaca");

        }
        else if(va.equals(",1506455256229,")) {
            nobrevolcan = "Volcán Huaynaputina";
            volcan.setText("Volcán Huaynaputina");

        }
        else if(va.equals(",1506455257749,")) {
            nobrevolcan = "Volcán Ticsani";
            volcan.setText("Volcán Ticsani");

        }
        else if(va.equals(",1506455257753,")) {
            nobrevolcan = "Volcán Casiri";
            volcan.setText("Volcán Casiri");
        }
        else if(volcan_dat.equals(",1506455257755,")) {
            nobrevolcan = "Volcán Cerros Purupuruni";
            volcan.setText("Volcán Cerros Purupuruni");

        }
        else if(volcan_dat.equals(",1506455257757,")) {
            nobrevolcan = "Volcán Quimsachata";
            volcan.setText("Volcán Quimsachata");

        }
        else if(volcan_dat.equals(",1506455259126,")) {
            nobrevolcan = "Volcán Yucamane";
            volcan.setText("Volcán Yucamane");

        }
        else if(volcan_dat.equals(",1506455259128,")) {
            nobrevolcan = "Volcán Misti";
            volcan.setText("Volcán Misti");

        }
        else {
            nobrevolcan = "Volcán";
        }

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        compartir.setTypeface(fontAwesomeFont);
        String substraccionpueblos= pueblos_subs.substring(1);
        pueblos.setText("Pueblos: " + substraccionpueblos);
        tipodeevento.setText("Tipo de Evento: " + tipodeevento_subs2);
        direccion.setText("Dirección: " + direccion_subs2);
        radio.setText("Radio de Dispersión: " + "mayor a " + radio_subs2 + " km");
        String asubstring = fecha_subs2.substring(0, 10);
        fecha.setText("Fecha: " + asubstring);

        hora.setText("Hora: " + hora_subs2 + "/ Hora UTC: " + horautc_subs2);
        observacicones.setText(observaciones_subs2);
        recomendaciones.setText(recomendaciones_subs2);
        volcan.setText(nobrevolcan);
        simulacro.setText("Simulacro: " + simulacro_subs2);

        sliderz = (ImageView) findViewById(R.id.sliderz);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerBlock = (RelativeLayout) findViewById(R.id.mDrawerBlock);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
        sliderz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        compartirfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pueblos_subs = pueblos_dat.substring(0, pueblos_dat.length() - 1);
                String substraccionpueblos= pueblos_subs.substring(1);
                String tipodeevento_subs = tipodeevento_dat.substring(0, tipodeevento_dat.length() - 1);
                String tipodeevento_subs2 = tipodeevento_subs.substring(1);
                String fecha_subs = fecha_dat.substring(0, fecha_dat.length() - 1);
                String fecha_subs2 = fecha_subs.substring(1);
                String asubstring = fecha_subs2.substring(0, 10);
                String hora_subs = hora_dat.substring(0, hora_dat.length() - 1);
                String hora_subs2 = hora_subs.substring(1);
                String horautc_subs2 = horautc_dat.substring(1);
                String observaciones_subs = observacicones_dat.substring(0, observacicones_dat.length() - 1);
                String observaciones_subs2 = observaciones_subs.substring(1);
                String simulacro_subs = simulacro_dat.substring(0, simulacro_dat.length() - 1);
                String simulacro_subs2 = simulacro_subs.substring(1);
                String recomendaciones_subs = recomendaciones_dat.substring(0, recomendaciones_dat.length() - 1);
                String recomendaciones_subs2 = recomendaciones_subs.substring(1);
                String radio_subs = radio_dat.substring(0, radio_dat.length() - 1);
                String radio_subs2 = radio_subs.substring(1);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String direccion_subs = direccion_dat.substring(0, direccion_dat.length() - 1);
                String direccion_subs2 = direccion_subs.substring(1);
                String shareBody  = "Alerta de dispersión de cenizas  " +
                        "\n\n" + "Pueblos: " + substraccionpueblos+
                        "\n\n" + "Tipo de evento: " + tipodeevento_subs2 +
                        "\n\n" + "Dirección: " + direccion_subs2 +
                        "\n\n" + "Radio de dispersión: " + radio_subs2 +
                        "\n\n" + "Fecha: " + asubstring +
                        "\n\n" + "Hora: " + hora_subs2 + "/ Hora UTC: " + horautc_subs2 +
                        "\n\n" + "Simulacro: " + simulacro_subs2 +
                        "\n\n" +  "Observaciones: " +
                        "\n\n" +  observaciones_subs2 +
                        "\n\n" + "Recomendaciones: " +
                        "\n\n" +  recomendaciones_subs2;
                String shareSub = "Alerta de dispersión de cenizas  " +
                        "\n\n" + "Pueblos: " + substraccionpueblos+
                        "\n\n" + "Tipo de evento: " + tipodeevento_subs2 +
                        "\n\n" + "Dirección: " + direccion_subs2 +
                        "\n\n" + "Radio de dispersión: " + radio_subs2 +
                        "\n\n" + "Fecha: " + asubstring +
                        "\n\n" + "Hora: " + hora_subs2 + "/ Hora UTC: " + horautc_subs2 +
                        "\n\n" + "Simulacro: " + simulacro_subs2 +
                        "\n\n" +  "Observaciones: " +
                        "\n\n" +  observaciones_subs2 +
                        "\n\n" + "Recomendaciones: " +
                        "\n\n" +  recomendaciones_subs2;
               // sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareBody);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
    }
    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}