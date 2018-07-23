package peru.volcanes.volcanesper;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
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
public class Alertareporteactividad extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
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
    String nobrevolcan;
    String tipodenotificacion_dat;
    String horautc_dat;
    String reporteactividad_dat;
    String fin_dato;
    String inicio_dato;
    String tiempo_dato;
    String volcan_dato;
    String codigo_dato;
    String estado_dato;
    String itemcodigo_dato;
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
    TextView visualizar;
    TextView compartirte;
    TextView descargar;
    RelativeLayout compartirfile;
    RelativeLayout visualizaerfile;
    RelativeLayout descargarfile;
    DownloadManager descarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datosalertareporteactividad);

        compartirfile= (RelativeLayout) findViewById(R.id.b6);
        visualizaerfile= (RelativeLayout) findViewById(R.id.bb7);
        descargarfile= (RelativeLayout) findViewById(R.id.b5);

        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);

        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertareporteactividad.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertareporteactividad.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertareporteactividad.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertareporteactividad.this,Convenciones.class);
                startActivity(intent);
            }
        });


        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Alertareporteactividad.this,Listadoredessociales.class);
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

        volcan = (TextView) findViewById(R.id.volcan);
        tipodeevento = (TextView) findViewById(R.id.tipodeevento);
        fecha = (TextView) findViewById(R.id.fecha);
        hora = (TextView) findViewById(R.id.hora);
        simulacro = (TextView) findViewById(R.id.simulacro);
        Intent i=this.getIntent();
        tipodenotificacion_dat = i.getExtras().getString("TIPODENOTIFICACION");
        volcan_dat = i.getExtras().getString("VOLCAN");
        tipodeevento_dat = i.getExtras().getString("TIPODEEVENTO");
        fecha_dat = i.getExtras().getString("FECHA");
        hora_dat = i.getExtras().getString("HORA");
        simulacro_dat = i.getExtras().getString("SIMULACRO");
        horautc_dat = i.getExtras().getString("HORAUTC");
        reporteactividad_dat = i.getExtras().getString("REPORTEACTIVIDAD");
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        visualizar = (TextView) findViewById(R.id.visualizar);
        compartirte = (TextView) findViewById(R.id.compartir);
        descargar = (TextView) findViewById(R.id.descargar);
        visualizar.setTypeface(fontAwesomeFont);
        compartirte.setTypeface(fontAwesomeFont);
        descargar.setTypeface(fontAwesomeFont);
        String hora_subs = hora_dat.substring(0, hora_dat.length() - 1);
        String hora_subs2 = hora_subs.substring(1);
        String tipodeevento_subs = tipodeevento_dat.substring(0, tipodeevento_dat.length() - 1);
        String tipodeevento_subs2 = tipodeevento_subs.substring(1);
        ///String fecha_subs = fecha_dat.substring(0, 10);
        //String fecha_subs2 = fecha_subs.substring(0, fecha_subs.length() - 1);
        //String fecha_subs3 = fecha_subs.substring(1);
        String fecha_subs3 = fecha_dat.substring(1);
        String fecha_subs = fecha_subs3.substring(0, 10);
        String simulacro_subs1 = simulacro_dat.substring(0, simulacro_dat.length() - 1);
        String simulacro_subs2 = simulacro_subs1.substring(1);
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

        String reportesubscrosubs2 = reporteactividad_dat.substring(1);
        String horautc2 = horautc_dat.substring(0, horautc_dat.length() - 1);
        String horautc3 = horautc2.substring(1);
        //String horautc2 = horautc_dat.substring(1);
        tipodeevento.setText("Tipo de Evento: " + tipodeevento_subs2);
        //fecha.setText("Fecha: " + fecha_subs3);
        fecha.setText("Fecha: " + fecha_subs);
        hora.setText("Hora: " + hora_subs2 + "/ Hora UTC:" + horautc3);
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

        visualizaerfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veralerta(reporteactividad_dat);
            }
        });

        descargarfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlpdf = reporteactividad_dat.substring(1);

                descarga = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri =  Uri.parse(urlpdf);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = descarga.enqueue(request);
            }
        });

        compartirfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlpdf = reporteactividad_dat.substring(1);
                String tipodeevento_subs = tipodeevento_dat.substring(0, tipodeevento_dat.length() - 1);
                String tipodeevento_subs2 = tipodeevento_subs.substring(1);
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String fecha_subs3 = fecha_dat.substring(1);
                String fecha_subs = fecha_subs3.substring(0, 10);
               // String shareBody = "Reporte de actividad volcanica " + " - " + tipodeevento_subs2;
              //  String shareSub = urlpdf;
                String simulacro_subs1 = simulacro_dat.substring(0, simulacro_dat.length() - 1);
                String simulacro_subs2 = simulacro_subs1.substring(1);
                String hora_subs = hora_dat.substring(0, hora_dat.length() - 1);
                String hora_subs2 = hora_subs.substring(1);
                String horautc2 = horautc_dat.substring(0, horautc_dat.length() - 1);
                String horautc3 = horautc2.substring(1);
                String shareBody =   "Reporte de actividad volcanica - "   + nobrevolcan + "\n" +
                        "Tipo de evento: " + tipodeevento_subs2 + "\n" +
                        "Fecha: " +  fecha_subs + "\n" +
                        "Hora: " + hora_subs2 + " / Hora UTC: " + horautc3 + "\n" +
                        "URL reporte PDF: " + urlpdf + "\n" +
                        "Simulacro: " + simulacro_subs2 + "\n";
                String shareSub =   "Reporte de actividad volcanica - "   + nobrevolcan + "\n" +
                        "Tipo de evento: " + tipodeevento_subs2 + "\n" +
                        "Fecha: " +  fecha_subs + "\n" +
                        "Hora: " + hora_subs2 + " / Hora UTC: " + horautc3 + "\n" +
                        "URL reporte PDF: " + urlpdf + "\n" +
                        "Simulacro: " + simulacro_subs2 + "\n";
                //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareBody);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
    }

    private void veralerta(String...details) {
        Intent i=new Intent(this,Pdfviewreportedeactividad.class);
        i.putExtra("PDFREPORTE",details[0]);
        startActivity(i);
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
