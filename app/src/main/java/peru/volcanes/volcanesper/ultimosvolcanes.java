package peru.volcanes.volcanesper;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import peru.volcanes.volcanesper.m_model.volcanes;
import peru.volcanes.volcanesper.m_ui.VolcanesAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Collections;
public class ultimosvolcanes extends Activity {
    Button mk;
    int mWidthScreen;
    int mHeightScreen;
    int tamano;
    DatabaseReference mFirebaseDatabase5;
    FirebaseDatabase database;
    ArrayList<volcanes> objetosismos=new ArrayList<volcanes>();
    VolcanesAdapter adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_two_images);

        ConnectivityManager cmanager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo info = cmanager.getActiveNetworkInfo();
        if(info!= null && info.isConnected()){
            if(info.getType() == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(ultimosvolcanes.this, "Conexión Establecida", Toast.LENGTH_LONG).show();
            }
            else if(info.getType() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(ultimosvolcanes.this, "Conexión Establecida", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(ultimosvolcanes.this, "Su Equipo ha Bloquedo la Conexión", Toast.LENGTH_LONG).show();
        }
        database = FirebaseDatabase.getInstance();
        //  FirebaseDatabase.getInstance();
        mFirebaseDatabase5 = database.getReference("actividadvolcanica").child("volcanes");
        mFirebaseDatabase5.keepSynced(true);
        lv = (ListView) findViewById(R.id.listado_volcanes);
        adapter=new VolcanesAdapter(ultimosvolcanes.this,retrieve());
        lv.setAdapter(adapter);
        mk= (Button) findViewById(R.id.button);
    }

    public ArrayList<volcanes> retrieve() {
        FirebaseDatabase.getInstance();
        mFirebaseDatabase5.keepSynced(true);
        // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mFirebaseDatabase5.orderByKey().limitToLast(20).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                volcanes objetosismo = dataSnapshot.getValue(volcanes.class);
                objetosismos.add(objetosismo);
                int iSwapCount = objetosismos.size() - 1;
                int iPosition = objetosismos.size()- 1;
                for (int j = 0; j < iSwapCount; j++)
                {
                    Collections.swap(objetosismos, iPosition, iPosition - 1);
                    iPosition = iPosition - 1;
                }
                lv.setAdapter(adapter);
                //  Toast.makeText(Ultimosismoslist.this,"dddd" + h, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                volcanes objetosismo = dataSnapshot.getValue(volcanes.class);
                objetosismos.add(objetosismo);
                int iSwapCount = objetosismos.size() - 1;
                int iPosition = objetosismos.size()- 1;
                for (int j = 0; j < iSwapCount; j++)
                {
                    Collections.swap(objetosismos, iPosition, iPosition - 1);
                    iPosition = iPosition - 1;
                }
                lv.setAdapter(adapter);
                 /*
                for(int i = 19, j = objetosismos.size() - 1; i == j; i++) {
                    objetosismos.add(i, objetosismos.remove(j));
                     Collections.reverse(objetosismos);
                }*/
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
        mFirebaseDatabase5.keepSynced(true);
        return objetosismos;
    }
}