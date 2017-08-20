package tw.ming.app.helloworid.mywebview;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webview);
        name = (EditText)findViewById(R.id.name);
        initWebView();
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
        String myname = name.getText().toString();
        webView.loadUrl("javascript:test3("+myname+")");//執行此網頁的test3方法
    }

    public void test2(View view) {

    }

    public void test3(View view) {

    }

    public void test4(View view) {

    }
}
