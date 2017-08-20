package tw.ming.app.helloworid.mywebview;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText name;
    private LocationManager lmgr;
    private MyListener myListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lmgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        myListener = new MyListener();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }else{
            init();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        init();
    }

    private void init(){
        webView = (WebView)findViewById(R.id.webview);
        name = (EditText)findViewById(R.id.name);
        initWebView();
        lmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,myListener);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class MyListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        lmgr.removeUpdates(myListener);
    }
    private void initWebView(){
        webView.setWebViewClient(new WebViewClient());//將網頁包在app裡面

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//將javascript打開

        webView.loadUrl("file:///android_asset/ming01.html");//asset代表一個檔案沒加s
        //第三個/代表根目錄
    }
    public void test1(View view) {
        //webView.goBack();//返回上一個網頁
        //String myname = name.getText().toString();
        //webView.loadUrl("javascript:test3("+myname+")");//執行此網頁的test3方法
        webView.loadUrl("javascript:goto(23,123)");
    }

    public void test2(View view) {

    }

    public void test3(View view) {

    }

    public void test4(View view) {

    }
}
