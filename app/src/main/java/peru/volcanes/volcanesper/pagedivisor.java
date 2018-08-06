package peru.volcanes.volcanesper;

        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.view.ViewPager;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.FrameLayout;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

      //  import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class pagedivisor extends AppCompatActivity {

    RelativeLayout titulopantalla_detalles;
    SupportMapFragment sMapFragment;
    Button mk;
    private FirebaseDatabase database;
    private static final int REQUEST_PERMISSION = 1;
    private static String[] PERMISSIONS = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION};
    FrameLayout contenedor;
    RelativeLayout tituloscolor;
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
    TextView opcion1;
    TextView opcion2;
    RelativeLayout celda1;
    RelativeLayout celda2;
    TextView iconomapas;
    TextView iconolistados;
    RelativeLayout cell1;
    RelativeLayout cell2;
    Context mContext;

    RelativeLayout cell1border;
    RelativeLayout cell2border;

    private DatabaseReference mFirebaseDatabase;
    private DatabaseReference mFirebaseDatabasex;
    private DatabaseReference mFirebaseDatabase4;
    private FirebaseDatabase mFirebaseInstance;
    RelativeLayout blocke6a;




    private static Context context;
    FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagedivisor);

        /*
        FirebaseDatabase.getInstance();
        if (mFirebaseDatabase == null) {
            FirebaseDatabase.getInstance();
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            mFirebaseDatabase = database.getReference("actividadvolcanica").child("volcanes");
        }
        else{
            FirebaseDatabase.getInstance();
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            mFirebaseDatabase = database.getReference("actividadvolcanica").child("volcanes");
        }
        */

        pagedivisor.context = getApplicationContext();

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        iconomapas = (TextView) findViewById(R.id.iconomapa);
        iconolistados = (TextView) findViewById(R.id.iconolistado);
        iconomapas.setTypeface(fontAwesomeFont);
        iconolistados.setTypeface(fontAwesomeFont);
        opcion1 = (TextView) findViewById(R.id.opcion1);
        opcion2 = (TextView) findViewById(R.id.opcion2);
        celda1 = (RelativeLayout) findViewById(R.id.cell1);
        celda2 = (RelativeLayout) findViewById(R.id.cell2);

        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

     //   vpPager.setPageTransformer(true, new RotateUpTransformer());
        cell1border = (RelativeLayout) findViewById(R.id.cell1border);
        cell2border = (RelativeLayout) findViewById(R.id.cell2border);

        vpPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            public void onPageSelected(int pageNumber) {
                if(pageNumber == 0){
                    cell1border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
                    cell2border.setBackgroundColor(getResources().getColor(R.color.igp));
                }
                else if(pageNumber == 1) {
                    cell2border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
                    cell1border.setBackgroundColor(getResources().getColor(R.color.igp));
                }
                else{
                    cell2border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
                    cell1border.setBackgroundColor(getResources().getColor(R.color.igp));
                }
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });



        if(vpPager.getCurrentItem() == 0) {
            cell1border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
            cell2border.setBackgroundColor(getResources().getColor(R.color.igp));
        }
        else if(vpPager.getCurrentItem() == 1) {
            cell2border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
            cell1border.setBackgroundColor(getResources().getColor(R.color.igp));
        }
        else{
            cell2border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
            cell1border.setBackgroundColor(getResources().getColor(R.color.igp));
        }

        celda2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                vpPager.setCurrentItem(1, true);
                cell1border.setBackgroundColor(getResources().getColor(R.color.igp));
                cell2border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
               // FragmentWithOneImage.newInstance("", R.drawable.volcan_amarillo_sm);

            }
        });

        celda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpPager.setCurrentItem(0, true);
                cell2border.setBackgroundColor(getResources().getColor(R.color.igp));
                cell1border.setBackgroundColor(getResources().getColor(R.color.celesteigp));
              //  FragmentWithTwoImages.newInstance("", R.drawable.volcan_amarillo_sm, R.drawable.volcan_amarillo_sm);
            }
        });

        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);

        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(pagedivisor.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(pagedivisor.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(pagedivisor.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(pagedivisor.this,Convenciones.class);
                startActivity(intent);
            }
        });


        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(pagedivisor.this,Listadoredessociales.class);
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
    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/
    public   class MyPagerAdapter extends FragmentPagerAdapter {
        private   int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {

            return NUM_ITEMS;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                  //  return FragmentWithOneImage.newInstance("", R.drawable.volcan_amarillo_sm);
                return FragmentWithTwoImages.newInstance("",  R.drawable.volcan_amarillo_sm,  R.drawable.volcan_amarillo_sm);

                case 0:
                    return FragmentWithOneImage.newInstance("",  R.drawable.volcan_amarillo_sm);

                //  return FragmentWithTwoImages.newInstance("", R.drawable.volcan_amarillo_sm, R.drawable.volcan_amarillo_sm);

                default:return null;
            }
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + position;
        }
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }
}
