package peru.volcanes.volcanesper;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import peru.volcanes.volcanesper.m_model.pueblos;
import peru.volcanes.volcanesper.m_model.volcanes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class Veralertacenizas extends FragmentActivity implements OnMapReadyCallback {
    RelativeLayout opciones;
    String magnitud2;
    RelativeLayout titulopantalla;
    Button mk;
    SupportMapFragment sMapFragment;
    Button satelite,terreno,localizacion;
    Array latitudes;
    Double f;
    String name,name2,name3,name4;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase database;
    private DatabaseReference mFirebaseDatabase2;
    private FirebaseDatabase database2;
    LatLng POINT_A = new LatLng(-16.29938054, -71.40512266);
    LatLng POINT_B = new LatLng(-16.17511068, -71.7338562);
    LatLng POINT_C = new LatLng(12.922294704121231, 77.61939525604248);
    LatLng POINT_D = new LatLng(12.933065305628435, 77.62390136718749);
    List<LatLng> bangaloreRoute;
    List<LatLng> bangaloreRoute2;
    List<LatLng> bangaloreRoute3;
    int mWidthScreen;
    int mHeightScreen;
    int tamano;
    TextView tituloalertacenizas;
    TextView subtituloalertacenizas;
    private GoogleMap mMap;
    Double[] valoreszz;
    String fecha_actualizacion_d;
    String hora_actualizacion_d;
    String actividad_reciente_d;
    String altura_d;
    String codigo_d;
    String alertavolcanica_d;
    String diametro_crater_d;
    String estado_d;
    String glaciares_d;
    String imagen_d;
    String latitud_d;
    String longitud_d;
    String monitoreo_d;
    String nombre_d;
    String tipica_erupcion_d;
    String tipo_d;
    String ultima_erupcion_d;
    String camaraurl_d;
    String alerta_texto;
    Double alerta_double;
    String codigoalerta_v;
    String alerta_v;
    String estadovolcan_v;
    String fecha_v;
    String hora_v;
    String fecha_detalle_v;
    String hora_detalle_v;
    String zonas_afectadas_v;
    String tipo_evento_v;
    String direccion_dispersion_v;
    String altura_v;
    String radio_dispersion_ceniza_v;
    String observaciones_v;
    String recomendaciones_v;
    String codigovolcan_v;
    Double estado_valor_volcan;
    Double latitud_valor_volcan;
    Double longitud_valor_volcan;
    String refe;
    String magnitud3;
    String magni;
    Button detalles;
    TextView iconoalerta;
    String fecha_sci, hora_sci, latitud_sci, longitud_sci, magnitud_sci, profundidad_sci;
    String latitud_pue;
    String longitud_pue;
    String nombre_pue;
    String cadenaestadovolcan;
    String departamnto;
    Double latitud;
    String localidad;
    Double longitud;
    String provincia;
    String mapasismico;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private RelativeLayout mDrawerBlock;
    RelativeLayout blocke1a;
    RelativeLayout blocke2a;
    RelativeLayout blocke4a;
    RelativeLayout blocke5a;
    RelativeLayout blocke9;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    ImageView sliderz;
    SlidingDrawer slidingDrawer;
    TextView slideup;
    RelativeLayout options;
    TextView alertacenizas_text;
    TextView camara_text;
    TextView mapa_text;
    TextView trayectoria_cenizas_text;
    TextView trayectoria_cenizas_text2;
    TextView trayectoria_cenizas_text3;
    TextView camara;
    TextView mapa;
    RelativeLayout bloque1;
    RelativeLayout bloque3a;
    RelativeLayout bloque4;
    RelativeLayout bloque5;
    RelativeLayout bloque6;
    RelativeLayout bloque7;
    RelativeLayout blocke6a;
    TextView textoresena;
    String reciente_text, estado_text, nombre_text, ubicacion, urlimagenes,  altura_text, codigo_text, diametro_text, glaciares_text, imagen_text,
            latitud_text,    longitud_text,  monitoreo_text, tipo_text, tipica_erupcion_text, fecha_actualizacion_text, hora_actualizacion_text,alerta_text,
            camaraurls,sismogramaurls, resena_text;
    String proyecionsenahmi;
    RelativeLayout bloquenombre;
    RelativeLayout bloque62;
    TextView trayectoria_cenizas_text222;
    private static final String TAG = MapsActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_veralertacenizas);
        Intent i=this.getIntent();
        codigoalerta_v = i.getExtras().getString("CODIGOALERTA");
        alerta_v = i.getExtras().getString("ALERTA");
        altura_v = i.getExtras().getString("ALTURA");
        estadovolcan_v = i.getExtras().getString("ESTADOVOLCAN");
        fecha_v = i.getExtras().getString("FECHA");
        hora_v = i.getExtras().getString("HORA");
        fecha_detalle_v = i.getExtras().getString("FECHADETALLE");
        hora_detalle_v = i.getExtras().getString("HORADETALLE");
        zonas_afectadas_v = i.getExtras().getString("ZONASAFECTADAS");
        tipo_evento_v = i.getExtras().getString("TIPOEVENTO");
        direccion_dispersion_v = i.getExtras().getString("DISPERSION");
        altura_v = i.getExtras().getString("ALTURA");
        radio_dispersion_ceniza_v = i.getExtras().getString("RADIODISPERSIONCENIZA");
        observaciones_v = i.getExtras().getString("OBSERVACIONES");
        recomendaciones_v = i.getExtras().getString("RECOMENDACIONES");
        codigovolcan_v = i.getExtras().getString("CODIGOVOLCAN");
        mapasismico = i.getExtras().getString("MAPASISMICO");
        proyecionsenahmi = i.getExtras().getString("PROYECCIONSENAHMI");
        String proyecionsenahmi;
        RelativeLayout bloquenombre;
        RelativeLayout bloque62;
        TextView trayectoria_cenizas_text222;
        slideup = (TextView) findViewById(R.id.openslide);
        options = (RelativeLayout) findViewById(R.id.options);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (slidingDrawer.isOpened()) {
                    slidingDrawer.animateClose();
                } else {
                    slidingDrawer.animateOpen();
                }

            }
        });
        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened()
            {
            }
        });

        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener()
        {
            @Override
            public void onDrawerClosed()
            {
                slidingDrawer.setBackgroundColor(Color.TRANSPARENT);
            }
        });


           /*--------VISUALIZACION DE MENU----------*/
        LinearLayout pronostico_menu = (LinearLayout) findViewById(R.id.opciones3);
        LinearLayout sismogramas_menu = (LinearLayout) findViewById(R.id.opciones4);
        LinearLayout reportes_menu = (LinearLayout) findViewById(R.id.opciones5);
        LinearLayout alertas_menu = (LinearLayout) findViewById(R.id.opciones6);
        LinearLayout camara_menu = (LinearLayout) findViewById(R.id.opciones7);
        LinearLayout mapasismic_menu = (LinearLayout) findViewById(R.id.opciones8);

        String val = String.valueOf(codigovolcan_v);


        if (val.equals("1493157379002")){
            pronostico_menu.setVisibility(View.VISIBLE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.VISIBLE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.VISIBLE);
        }
        else if(val.equals("1493157381161")){
            pronostico_menu.setVisibility(View.VISIBLE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.VISIBLE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.VISIBLE);
        }
        else if(val.equals("1506454510537")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455245814")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455248101")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455249661")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455251429")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455253382")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455254838")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455256229")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257749")){
            pronostico_menu.setVisibility(View.VISIBLE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.VISIBLE);
        }
        else if(val.equals("1506455257753")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257755")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257757")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455259126")){
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455259128")){
            pronostico_menu.setVisibility(View.VISIBLE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.VISIBLE);
        }
        else{
            pronostico_menu.setVisibility(View.VISIBLE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.VISIBLE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.VISIBLE);
        }

     /*--------VISUALIZACION DE MENU----------*/

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

        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Convenciones.class);
                startActivity(intent);
            }
        });


        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Listadoredessociales.class);
                startActivity(intent);
            }
        });

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

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        slideup = (TextView) findViewById(R.id.openslide);
        camara = (TextView) findViewById(R.id.camara);
        mapa = (TextView) findViewById(R.id.mapa);
        alertacenizas_text = (TextView) findViewById(R.id.alertacenizas_text);
        camara_text = (TextView) findViewById(R.id.camara_text);
        mapa_text = (TextView) findViewById(R.id.mapa_text);
        trayectoria_cenizas_text = (TextView) findViewById(R.id.trayectoria_cenizas_text);
        trayectoria_cenizas_text2 = (TextView) findViewById(R.id.trayectoria_cenizas_text2);
        trayectoria_cenizas_text3 = (TextView) findViewById(R.id.trayectoria_cenizas_text3);
        camara.setTypeface(fontAwesomeFont);
        mapa.setTypeface(fontAwesomeFont);
        slideup.setTypeface(fontAwesomeFont);



        //alertacenizas_text.setText(" Alertas de Ceniza");
       // camara_text.setText(" Cámara en tiempo real ");
        //mapa_text.setText(" Mapa sísmico ");


        //trayectoria_cenizas_text.setText(" Pronóstico de dispersión ");
       // trayectoria_cenizas_text2.setText(" Reportes de actividad ");
       // trayectoria_cenizas_text3.setText(" Sismogramas tiempo real ");

        opciones = (RelativeLayout) findViewById(R.id.opciones);
        FirebaseDatabase.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        detalles = (Button) findViewById(R.id.botondetallees);
        sMapFragment = SupportMapFragment.newInstance();
        FragmentManager sFm = getSupportFragmentManager();
        sFm.beginTransaction().add(R.id.mapx, sMapFragment).commit();
        sMapFragment.getMapAsync(this);
        satelite = (Button) findViewById(R.id.satelite);
        terreno = (Button) findViewById(R.id.terreno);
       /// FrameLayout frame1 = (FrameLayout) findViewById(R.id.mapx);
        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        mWidthScreen = display.getWidth();
        mHeightScreen = display.getHeight();
        titulopantalla = (RelativeLayout) findViewById(R.id.titulopantalla);
        localizacion = (Button) findViewById(R.id.localizacion);


        final Button datox = (Button) findViewById(R.id.localizacion);
        final Button linea3000 = (Button) findViewById(R.id.linea_tresmiles);
        final Button linea5000 = (Button) findViewById(R.id.linea_cincomiles);
        final Button linea7000 = (Button) findViewById(R.id.linea_sietemiles);
        iconoalerta = (TextView) findViewById(R.id.iconoalerta);
        iconoalerta.setTypeface(fontAwesomeFont);
        datox.setTypeface(fontAwesomeFont);
        linea3000.setTypeface(fontAwesomeFont);
        linea5000.setTypeface(fontAwesomeFont);
        linea7000.setTypeface(fontAwesomeFont);

        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);

        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Veralertacenizas.this,Convenciones.class);
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
        createRoute();
        createRoute2();
        createRoute3();
        tituloalertacenizas = (TextView) findViewById(R.id.tituloalertacenizas);
        subtituloalertacenizas = (TextView) findViewById(R.id.subtituloalertacenizas);
        terreno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Veralertacenizas.this);
            builder.setTitle("Alerta de cenizas volcán : " + fecha_sci);
            builder.setMessage("Codigo de alerta : " + codigoalerta_v +"\n\n" +
                    "Alerta de ceniza : " + alerta_v +"\n\n" +
                    "Altura de ceniza : " + altura_v +"\n\n" +
                    "Estado de volcán : " + estadovolcan_v +"\n\n" +
                    "Fecha de volcán : " + fecha_v +"\n\n" +
                    "Hora de volcán : " + hora_v +"\n\n" +
                    "Fecha de detalle : " + fecha_detalle_v +"\n\n" +
                    "Hora de detalle : " + hora_detalle_v +"\n\n" +
                    "Zonas afectadas : " + zonas_afectadas_v +"\n\n" +
                    "Dirección de dispersión : " + direccion_dispersion_v +"\n\n" +
                    "Radio de dispersión : " + radio_dispersion_ceniza_v +"\n\n" +
                    "Observaciones : " + observaciones_v +"\n\n" +
                    "Recomendaciones : " + recomendaciones_v +"\n\n" +
                    "Codigo de volcán : " + codigovolcan_v +"\n\n"
                );
            builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setCancelable(true);
            builder.create().show();
            }
        });
        detecta_volcan();
        mostrar_ult_volcan();
    }

    /*-------------ver datos de volcan------------------------------------------------------*/
    public void detecta_volcan() {
        FirebaseDatabase.getInstance();
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        Intent i=this.getIntent();
        codigovolcan_v = i.getExtras().getString("CODIGOVOLCAN");
        mFirebaseDatabase2 = database2.getReference("actividadvolcanica").child("volcanes");
        mFirebaseDatabase2.keepSynced(true);
        mFirebaseDatabase2.orderByKey().equalTo(codigovolcan_v).addChildEventListener(new ChildEventListener() {
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void guardar_pref(volcanes sreporte) {
        SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("actividad_reciente", sreporte.getActividadreciente());
        editor.putString("ubicacion", sreporte.getLatitud());

        editor.putString("fecha_actualizacion_dto", sreporte.getFechaactualizacion());
        editor.putString("hora_actualizacion_dto", sreporte.getHoraactualizacion());
        editor.putString("actividad_reciente_dto", sreporte.getActividadreciente());
        editor.putString("altura_dto", sreporte.getAltura());
        editor.putString("codigo_dto", sreporte.getCodigo());
        editor.putString("alertavolcanica_dto", sreporte.getAlertavolcanica());
        editor.putString("diametro_crater_dto", sreporte.getDiametrocrater());
        editor.putString("estado_dto", sreporte.getEstado());
        editor.putString("glaciares_dto", sreporte.getGlaciares());
        editor.putString("imagen_dto", sreporte.getImagen());
        editor.putString("latitud_dto", sreporte.getLatitud());
        editor.putString("longitud_dto", sreporte.getLongitud());
        editor.putString("monitoreo_dto", sreporte.getMonitoreo());
        editor.putString("nombre_dto", sreporte.getNombre());
        editor.putString("tipica_erupcion_dto", sreporte.getTipicaerupcion());
        editor.putString("tipo_dto", sreporte.getTipo());
        editor.putString("ultima_erupcion_dto", sreporte.getUltimaerupcion());
        editor.putString("camaraurl_dto", sreporte.getCamaraurl());
        editor.putString("sismogra", sreporte.getSismograma());
        editor.putString("mapasismico", sreporte.getMapasismico());

        editor.apply();
        mostrar_ult_volcan();
    }
    public void mostrar_ult_volcan() {
        SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
        ubicacion = prefs.getString("inubicacion", "");

        fecha_actualizacion_d = prefs.getString("fecha_actualizacion_dto", "");
        hora_actualizacion_d = prefs.getString("hora_actualizacion_dto", "");
        actividad_reciente_d = prefs.getString("actividad_reciente_dto", "");
        altura_d = prefs.getString("altura_dto", "");
        codigo_d = prefs.getString("codigo_dto", "");
        alertavolcanica_d = prefs.getString("alertavolcanica_dto", "");
        diametro_crater_d = prefs.getString("diametro_crater_dto", "");
        estado_d = prefs.getString("estado_dto", "");
        glaciares_d = prefs.getString("glaciares_dto", "");
        imagen_d = prefs.getString("imagen_dto", "");
        latitud_d = prefs.getString("latitud_dto", "");
        longitud_d = prefs.getString("longitud_dto", "");
        monitoreo_d = prefs.getString("monitoreo_dto", "");
        nombre_d = prefs.getString("nombre_dto", "");
        tipica_erupcion_d = prefs.getString("tipica_erupcion_dto", "");
        tipo_d = prefs.getString("tipo_dto", "");
        ultima_erupcion_d = prefs.getString("ultima_erupcion_dto", "");
        camaraurl_d = prefs.getString("camaraurl_dto", "");
        sismogramaurls = prefs.getString("sismogra", "");
        mapasismico = prefs.getString("mapasismico", "");

        tituloalertacenizas.setText("Alerta de Cenizas Volcán "+nombre_d);
        subtituloalertacenizas.setText(fecha_v+" "+" "+hora_v);
        estado_valor_volcan = 3.5;
        //evaluar estado devolcan
        double estado_v;
        try {
            estado_v = new Double(estado_d);
        } catch (NumberFormatException e) {
            estado_v = 0;
        }
        if (estado_v == 0){
            cadenaestadovolcan = "0";
        }
        else
        {
            cadenaestadovolcan = estado_d;
        }
        estado_valor_volcan = Double.parseDouble(cadenaestadovolcan);

        latitud_valor_volcan = -16.35;
        longitud_valor_volcan = -70.90;

        alerta_texto = estado_d;
        //evaluar dato magnitud
        double w;

        try {
            w = new Double(alerta_texto);
        } catch (NumberFormatException e) {
            w = 0;
        }

        if (w == 0){
            magnitud2 = "0";
        }
        else
        {
            magnitud2 = alerta_texto;
        }
        alerta_double =  Double.parseDouble(magnitud2);
        if (alerta_double   <= 1) {
            titulopantalla.setBackgroundColor(getResources().getColor(R.color.verdeigp));
          //  status.setText("Status : "+"inactivo");
        }
        else if (alerta_double  > 1 && alerta_double == 2) {
            titulopantalla.setBackgroundColor(getResources().getColor(R.color.orangeyellow));
            //status.setText("Status : "+"minima actividad");
        }
        else if (alerta_double  > 2 && alerta_double == 3) {
            titulopantalla.setBackgroundColor(getResources().getColor(R.color.orange_v));
            //status.setText("Status : "+"minima actividad");
        }
        else if (alerta_double  > 3 && alerta_double == 4) {
            titulopantalla.setBackgroundColor(getResources().getColor(R.color.rojoigp));
          //  status.setText("Status : "+"mayor erupción");
        }
        else {
            titulopantalla.setBackgroundColor(getResources().getColor(R.color.rojoigp));
            //status.setText("Status :"+"Explosiva");
        }

        bloque3a = (RelativeLayout) findViewById(R.id.bloque3);
        bloque5 = (RelativeLayout) findViewById(R.id.bloque5);
        bloque1 = (RelativeLayout) findViewById(R.id.bloque1);
        bloque6 = (RelativeLayout) findViewById(R.id.bloque6);
        bloque4 = (RelativeLayout) findViewById(R.id.bloque4);
        bloque7 = (RelativeLayout) findViewById(R.id.bloque7);

        bloque5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                alerta_cenizas(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico
                );
            }
        });


        if (mapasismico.length() == 1) {
            //bloque1.setBackgroundColor(getResources().getColor(R.color.verdeigp));


            bloque1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    slidingDrawer.animateClose();
                    openmap2(reciente_text,
                            estado_text,
                            nombre_text,
                            ubicacion,
                            urlimagenes,
                            altura_text,
                            codigo_text,
                            diametro_text,
                            glaciares_text,
                            imagen_text,
                            latitud_text,
                            longitud_text,
                            monitoreo_text,
                            tipo_text,
                            tipica_erupcion_text,
                            fecha_actualizacion_text,
                            hora_actualizacion_text,
                            alerta_text,
                            camaraurls,
                            sismogramaurls,
                            mapasismico);

                }
            });


        }
        else{
            bloque1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    slidingDrawer.animateClose();

                    openmap(reciente_text,
                            estado_text,
                            nombre_text,
                            ubicacion,
                            urlimagenes,
                            altura_text,
                            codigo_text,
                            diametro_text,
                            glaciares_text,
                            imagen_text,
                            latitud_text,
                            longitud_text,
                            monitoreo_text,
                            tipo_text,
                            tipica_erupcion_text,
                            fecha_actualizacion_text,
                            hora_actualizacion_text,
                            alerta_text,
                            camaraurls,
                            sismogramaurls,
                            mapasismico);
                }
            });
        }




        bloque3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                reportes(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico);
            }
        });

        bloque4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                camara_web(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico);
            }
        });

        bloque6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                openDetailActivity(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico);
            }
        });

        bloque7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                sismograma_web(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico);
            }
        });


    }

    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,Dispersioncenizas.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }

    private void openmap(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,Sismosengeneral.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }


    private void openmap2(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,sismosengeneralgoogle.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }




    private void alerta_cenizas(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,Reportesalertascenizastwo.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }



    private void camara_web(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,Volcancamara.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }

    private void sismograma_web(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,Sismogramas.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }





    private void reportes(String...details)
    {
        Intent i=new Intent(Veralertacenizas.this,Reportesdeactividad.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        Veralertacenizas.this.startActivity(i);
    }


    /*--------------------fin ver datos de  volcan--------------------------------------------------*/

    /*------siete mil metros de altura --------------*/
    /**/
    private void createRoute() {
        if (bangaloreRoute == null) {
            bangaloreRoute = new ArrayList<>();
        }
        else
        {
            bangaloreRoute.clear();
        }

        FirebaseDatabase.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        mFirebaseDatabase = database.getReference("actividadvolcanica").child("volcanes").child(codigovolcan_v).child("alerta_cenizas_ubinas").child(codigoalerta_v).child("trayectoria").child("tresmil");
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    name = (String) messageSnapshot.child("latitud").getValue();
                    name2 = (String) messageSnapshot.child("longitud").getValue();
                    for(int i=0; i < 1; i++){
                        bangaloreRoute.add(new LatLng(Double.parseDouble(name) , Double.parseDouble(name2)));
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
/*--------------------------------*/
    /*------------cinco mil metros de altura -----------------*/

    /**/
    private void createRoute2() {
        if (bangaloreRoute2 == null) {
            bangaloreRoute2 = new ArrayList<LatLng>();
        }
        else
        {
            bangaloreRoute2.clear();
        }
        Intent i=this.getIntent();
        codigovolcan_v=i.getExtras().getString("CODIGOVOLCAN");
        FirebaseDatabase.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        mFirebaseDatabase = database.getReference("actividadvolcanica").child("volcanes").child(codigovolcan_v).child("alerta_cenizas_ubinas").child(codigoalerta_v).child("trayectoria").child("cincomil");

        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    name = (String) messageSnapshot.child("latitud").getValue();
                    name2 = (String) messageSnapshot.child("longitud").getValue();
                    f = Double.parseDouble(name);
                   // Toast.makeText(getApplicationContext(),name, Toast.LENGTH_LONG).show();
                    for(int i=0; i < 1; i++){
                        bangaloreRoute2.add(new LatLng(Double.parseDouble(name) , Double.parseDouble(name2)));
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
/*--------------------------------*/

    /*---------------tres mil metros de altura ----------------------*/

    /**/
    private void createRoute3() {
        if (bangaloreRoute3 == null) {
            bangaloreRoute3 = new ArrayList<LatLng>();
        }
        else {
            bangaloreRoute3.clear();
        }
        Intent i=this.getIntent();
        codigovolcan_v=i.getExtras().getString("CODIGOVOLCAN");
        FirebaseDatabase.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        mFirebaseDatabase = database.getReference("actividadvolcanica").child("volcanes").child(codigovolcan_v).child("alerta_cenizas_ubinas").child(codigoalerta_v).child("trayectoria").child("sietemil");

        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    name3 = (String) messageSnapshot.child("latitud").getValue();
                    name4 = (String) messageSnapshot.child("longitud").getValue();
                    f = Double.parseDouble(name3);
                   // Toast.makeText(getApplicationContext(),name3, Toast.LENGTH_LONG).show();
                    for(int i=0; i < 2; i++){
                        bangaloreRoute3.add(new LatLng(Double.parseDouble(name3) , Double.parseDouble(name4)));
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
/*---------------------*/

    @Override
    public void onMapReady(final GoogleMap map) {
        mMap = map;
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(POINT_A);
                builder.include(POINT_B);

                String valorestadovolcan;
                 double w;
                try {
                    w = new Double(alertavolcanica_d);
                } catch (NumberFormatException e) {
                    w = 0;
                }

                if (w == 0){
                    valorestadovolcan = "0";
                }
                else
                {
                    valorestadovolcan = alertavolcanica_d;
                }

                estado_valor_volcan = Double.parseDouble(valorestadovolcan);
                BitmapDescriptor icon;
                LatLng latLng = new LatLng(latitud_valor_volcan,longitud_valor_volcan);

                if (estado_valor_volcan  > 0 && estado_valor_volcan <= 2) {
                    icon = BitmapDescriptorFactory.fromResource(R.drawable.volcano_verde);
                }
                else if (estado_valor_volcan  > 2 && estado_valor_volcan <= 4) {
                    icon = BitmapDescriptorFactory.fromResource(R.drawable.volcano_amarillo);
                }
                else if (estado_valor_volcan  > 4 && estado_valor_volcan <= 6) {
                    icon = BitmapDescriptorFactory.fromResource(R.drawable.volcano_naranja);
                }
                else if (estado_valor_volcan  > 6 && estado_valor_volcan <= 8) {
                    icon = BitmapDescriptorFactory.fromResource(R.drawable.volcano_rojo);
                }
                else {
                    icon = BitmapDescriptorFactory.fromResource(R.drawable.volcano_rojo);
                }

                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 100);
                mMap.addMarker(new MarkerOptions().position(latLng).title("volcan : "+ nombre_d).snippet("Altura :"+"volcan").icon(icon).anchor(0.5f, 0.5f)).showInfoWindow();
                mMap.moveCamera(cu);
                mMap.animateCamera(CameraUpdateFactory.zoomTo(8), 1000, null);
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
                mMap.getUiSettings().setTiltGesturesEnabled(true);
                mMap.getUiSettings().setCompassEnabled(true);

                satelite.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View arg0) {
                        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    }
                });
                terreno.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View arg0) {
                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    }
                });
                localizacion.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View arg0) {
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-16.29938054, -71.40512266), 8));
                    }
                });
                startAnim();
            }
        });


        mMap.setPadding(0, 0, 0, 100);

       // loadMarker();
        //  loadMarker2();
    }

    private void startAnim(){
        if(mMap != null) {
            MapAnimator.getInstance().animateRoute(mMap, bangaloreRoute);
            MapAnimator2.getInstance().animateRoute2(mMap, bangaloreRoute2);
            MapAnimator3.getInstance().animateRoute3(mMap, bangaloreRoute3);
        } else {
          //  Toast.makeText(getApplicationContext(), "Map not ready", Toast.LENGTH_LONG).show();
        }
    }
    public void loadMarker2(){
        Intent i=this.getIntent();
        codigovolcan_v=i.getExtras().getString("CODIGOVOLCAN");
        FirebaseDatabase.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference comunidades = database.getReference("actividadvolcanica").child("volcanes").child(codigovolcan_v).child("alerta_cenizas_ubinas").child(codigoalerta_v).child("pueblos");
        comunidades.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                final Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                //  map.clear();
                for (final DataSnapshot dataSnapshot1 : dataSnapshots) {
                    final pueblos local2 = dataSnapshot1.getValue(pueblos.class);

                    final Double latis,longis;
                    latis = Double.parseDouble(local2.getLatitud());
                    longis = Double.parseDouble(local2.getLongitud());
                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.ubicacionpueblo);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(latis, longis)).title(local2.getPueblo() + " "+"Profundidad : "+local2.getPueblo()+"  >>>").snippet("Fecha : "+local2.getPueblo()+"\n  Hora"+local2.getPueblo()).icon(icon).anchor(0.5f, 0.5f));
                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                        public void onInfoWindowClick(Marker marker) {
                            final double de4 = marker.getPosition().latitude;
                            String latitudl;
                            latitudl = String.valueOf(de4);
                            mFirebaseDatabase  = database.getReference("actividadvolcanica").child("volcanes").child(codigovolcan_v).child("alerta_cenizas_ubinas").child(codigoalerta_v).child("pueblos");
                            mFirebaseDatabase.orderByChild("latitud").equalTo(latitudl).limitToLast(5).addChildEventListener(new ChildEventListener() {

                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    pueblos sreporte2 = dataSnapshot.getValue(pueblos.class);
                                    guardar_pref(sreporte2);
                                }
                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                                }
                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) {
                                }
                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }

                                public void guardar_pref(pueblos sreporte2) {
                                    SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = prefs.edit();
                                    editor.putString("sislatitud", sreporte2.getLatitud());
                                    editor.putString("sislongitud", sreporte2.getLongitud());
                                    editor.putString("sispueblo", sreporte2.getPueblo());
                                    editor.apply();
                                    mostrar_pueblo();
                                }

                                public void mostrar_pueblo() {
                                    SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
                                    latitud_pue = prefs.getString("sislatitud", "");
                                    longitud_pue = prefs.getString("sislongitud", "");
                                    nombre_pue = prefs.getString("sispueblo", "");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Veralertacenizas.this);
                                    builder.setTitle("Sismo volcan : " + nombre_pue);
                                    builder.setMessage("Referencia : " +nombre_pue + nombre_pue +"\n" +
                                            "Fecha local : " + nombre_pue +"\n" +
                                            "Hora local : " + nombre_pue + "\n" +
                                            "Profundidad : " + nombre_pue+" km"+ "\n" +
                                            "Intensidad : " + nombre_pue+ "\n" +
                                            "Magnitud : " + nombre_pue+ "\n" +
                                            "Ubicación : " + nombre_pue+ ", " + nombre_pue);
                                    builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
                                    builder.setCancelable(true);
                                    builder.create().show();
                                }
                            });
                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }



    /*salido porque es mucha data*/
    public void loadMarker(){
        Intent i=this.getIntent();
         FirebaseDatabase.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference locais = database.getReference("actividadvolcanica").child("localidades");
        locais.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                final Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                //  map.clear();
                for (final DataSnapshot dataSnapshot1 : dataSnapshots) {
                    final peru.volcanes.volcanesper.m_model.localidades local = dataSnapshot1.getValue(peru.volcanes.volcanesper.m_model.localidades.class);
                    final Double lati,longi;

                    departamnto = local.getDepatamento();
                    latitud = local.getLatitud();
                    localidad =  local.getLocalidad();
                    longitud = local.getLongitud();
                    provincia = local.getProvincia();
                    final BitmapDescriptor icon;
                    icon = BitmapDescriptorFactory.fromResource(R.drawable.ubicacionpueblo);


                    mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud)).title(local.getProvincia() + " "+"Profundidad : "+local.getLocalidad()+"  >>>").snippet("Fecha : "+local.getDepatamento()+"\n  Hora"+local.getLocalidad()).icon(icon).anchor(0.5f, 0.5f));
                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        public void onInfoWindowClick(Marker marker) {
                               mFirebaseDatabase = database.getReference("actividadvolcanica").child("localidades");
                            mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    peru.volcanes.volcanesper.m_model.localidades sreporte = dataSnapshot.getValue(peru.volcanes.volcanesper.m_model.localidades.class);
                                 }
                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                                }
                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) {
                                }
                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            });
                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void resetAnimation(View view){
        //  startAnim();
        //   startAnim2();
    }
    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }
}