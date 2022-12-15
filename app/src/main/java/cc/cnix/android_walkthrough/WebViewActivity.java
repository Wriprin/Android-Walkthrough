package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.wv_01);

        // 引入本地 HTML 文件
//        mWebView.loadUrl("file:///android_asset/index.html");

        // 访问 URL HTML 文件
        // 支持 js
        // Using setJavaScriptEnabled can introduce XSS vulnerabilities into your application, review carefully
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.google.com/");

        mWebView.setWebViewClient(new MyWebViewClient());

        mWebView.setWebChromeClient(new MyWebChromeClient());
    }

    class MyWebViewClient extends WebViewClient {
        /**
         * 使得 WebView 内部访问目标 URL 页面
         * @param view
         * @param request
         * @return
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d(url,"The page is loading...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d(url, "The page is loaded...");

            // 调用 JavaScript 方式一
//            view.loadUrl("javascript:alert('Hello, World.')");
            // 调用 JavaScript 方式二
//            view.evaluateJavascript("javascript:alert('Hello, World.')", null);
        }
    }

    /**
     * 实现内部回退功能
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            Log.d("Current Progress: ", String.valueOf(newProgress));
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle("Hello World");
        }
    }
}