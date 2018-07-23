package peru.volcanes.volcanesper;
import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import peru.volcanes.volcanesper.m_model.volcanes;
import peru.volcanes.volcanesper.m_ui.VolcanesAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
public class FragmentWithTwoImages extends Fragment {
    ArrayList<volcanes> objetoalertacenizas = new ArrayList<volcanes>();
    private DatabaseReference mFirebaseDatabase3;
    VolcanesAdapter adapter3;
    private static final int REQUEST_PERMISSION = 1;
    RelativeLayout titulopantalla_detalles;
    ListView losvolcanes;
    RelativeLayout blocke1a;
    RelativeLayout blocke2a;
    RelativeLayout blocke4a;
    RelativeLayout blocke5a;
    Toolbar toolbar;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    ImageView sliderz;
    private static final String TAG = FragmentWithTwoImages.class.getSimpleName();
    Button mk;
    RelativeLayout informacion;
    RelativeLayout convenciones;
    private static String[] PERMISSIONS = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION};
    private LocationManager lm;
    private Location location;
    RelativeLayout menuright;
    int count = 0;

    private ProgressBar spinner;
    String ShowOrHideWebViewInitialUse = "show";

    @SuppressLint({"WrongViewCast", "SetJavaScriptEnabled"})
    public static FragmentWithTwoImages newInstance(String title, int resMainImage, int resSecondaryImage) {
        FragmentWithTwoImages fragment = new FragmentWithTwoImages();
        Bundle args = new Bundle();
        args.putInt("imageMain", resMainImage);
        args.putInt("imageSecondary", resSecondaryImage);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_images, container, false);
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        FirebaseDatabase.getInstance();
        losvolcanes = (ListView) view.findViewById(R.id.listado_volcanes);

    //    spinner = (ProgressBar)view.findViewById(R.id.progressBar1);


        updateStuff();
        return view;
    }

    public void updateStuff(){
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            FirebaseDatabase.getInstance();
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            mFirebaseDatabase3 = database.getReference("actividadvolcanica").child("volcanes");
            adapter3 = new VolcanesAdapter(getActivity().getApplication(),retreive());
            losvolcanes.setAdapter(adapter3);
           // Toast.makeText(getActivity(), "Conexión Establecida", Toast.LENGTH_LONG).show();
        } else {
            FirebaseDatabase.getInstance();
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            mFirebaseDatabase3 = database.getReference("actividadvolcanica").child("volcanes");
            adapter3 = new VolcanesAdapter(getActivity().getApplication(),retreive());
            losvolcanes.setAdapter(adapter3);
            mFirebaseDatabase3.keepSynced(true);
           // Toast.makeText(getActivity(), "Conexión Establecida", Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<volcanes> retreive() {
        FirebaseDatabase.getInstance();
        mFirebaseDatabase3.keepSynced(true);
        mFirebaseDatabase3.orderByChild("orden").addChildEventListener(new ChildEventListener() {
            int count = 0;

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                volcanes objetosismo = dataSnapshot.getValue(volcanes.class);
                objetoalertacenizas.add(objetosismo);
                count ++;

                // int d = count++;
                //if( objetosismo == null ) {
                  //  Toast.makeText(getActivity(), d, Toast.LENGTH_LONG).show();
                //}
                //else {
                  //  Toast.makeText(getActivity(), "no se cargaron los datos", Toast.LENGTH_LONG).show();
                //}


                Toast.makeText(getActivity(), "Info window clicked : "+count,Toast.LENGTH_SHORT).show();

                if(count >= dataSnapshot.getChildrenCount()) {

                    spinner.setVisibility(View.GONE);
                    //stop progress bar here
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                volcanes objetosismo = dataSnapshot.getValue(volcanes.class);
                objetoalertacenizas.add(objetosismo);
             //   int d = count++;
               // if( objetosismo == null ) {
                //    Toast.makeText(getActivity(), d, Toast.LENGTH_LONG).show();
                //}
                //else {
                 //   Toast.makeText(getActivity(), "se cargaron los datos", Toast.LENGTH_LONG).show();
                //}
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
        //mFirebaseDatabase.keepSynced(true);
        return objetoalertacenizas;
    }
}