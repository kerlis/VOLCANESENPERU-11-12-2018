package peru.volcanes.volcanesper;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import retrofit2.http.Url;
public class Pdfmetodologia extends FragmentActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    TextView titulo_trayectorias;
    RelativeLayout blocke1a;
    RelativeLayout blocke2a;
    RelativeLayout blocke4a;
    RelativeLayout blocke5a;
    RelativeLayout blocke9;
    RelativeLayout blocke6a;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    ImageView sliderz;
    private CharSequence mTitle;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    private RelativeLayout mDrawerBlock;
    private CharSequence mDrawerTitle;
    WebView webView;
    private ProgressBar spinner;
    String ShowOrHideWebViewInitialUse = "show";
    @SuppressLint({"WrongViewCast", "SetJavaScriptEnabled"})
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_pdfmetodologia);
        titulo_trayectorias = (TextView) findViewById(R.id.titulo_trayectorias);
        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);
        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfmetodologia.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfmetodologia.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfmetodologia.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfmetodologia.this,Convenciones.class);
                startActivity(intent);
            }
        });

        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfmetodologia.this,Listadoredessociales.class);
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

        /// String de = "https://stackoverflow.com/questions/4623508/how-to-set-the-font-style-to-bold-italic-and-underlined-in-an-android-textview";
        Intent i = this.getIntent();
        String valor = i.getExtras().getString("ENLACE");
        String  valor2 = i.getExtras().getString("ENLACE");
        pdfView = (PDFView) findViewById(R.id.pdfView);
        new RetrevePDFStream().execute(valor);
      //  webView = (WebView)findViewById(R.id.vistaweb);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
      ////  webView.setWebViewClient(new CustomWebViewClient());
      //  webView.getSettings().setJavaScriptEnabled(true);
       // webView.getSettings().setDomStorageEnabled(true);
      //  webView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);

      //  webView.loadUrl(valor);
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            if (ShowOrHideWebViewInitialUse.equals("show")) {
                webview.setVisibility(webview.INVISIBLE);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            ShowOrHideWebViewInitialUse = "hide";
            spinner.setVisibility(View.GONE);
            view.setVisibility(webView.VISIBLE);
            super.onPageFinished(view, url);
        }
    }


    class RetrevePDFStream extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try{
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if (urlConnection.getResponseCode() == 200){
                    inputStream =  new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch(IOException e){
                return null;
            }
            return  inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            spinner.setVisibility(View.GONE);
        }
    }


    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }
}
