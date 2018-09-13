package peru.volcanes.volcanesper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class SplashScreen extends Activity {
    private DatabaseReference mFirebaseDatabase3;
    private FirebaseDatabase mFirebaseInstance;
    private static DatabaseReference mFirebaseDatabase;
    private static FirebaseDatabase database;
    TextView lema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      if(database == null) {
            database = FirebaseDatabase.getInstance();
            Firebase.getDefaultConfig().setPersistenceEnabled(true);
            database.setPersistenceEnabled(true);
      }
        mFirebaseDatabase = database.getReference("actividadvolcanica");
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        mFirebaseDatabase.keepSynced(true);
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);setContentView(R.layout.splash);
        lema = (TextView) findViewById(R.id.lema);
        lema.setText(Html.fromHtml("<b>CIENCIA PARA PROTEGERNOS <b>"+"<br>"+"<b>CIENCIA PARA AVANZAR</b>"));
        Thread timerThread = new Thread(){
            public void run(){
                try{
                   sleep(3000);
                    //  sleep(50000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
//                  Intent intent7 = new Intent(SplashScreen.this,pagedivisor.class);

                   Intent intent7 = new Intent(SplashScreen.this,pagedivisor.class);

                    //     Intent intent7 = new Intent(SplashScreen.this,Youtubevideos.class);

                    //  Intent intent7 = new Intent(SplashScreen.this,Alertando.class);
                    startActivity(intent7);
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}