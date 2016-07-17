package com.nice.jzb.ui.main;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;

import com.nice.jzb.R;
import com.nice.jzb.background.ConfigValue;
import com.nice.jzb.background.JICHEShareModel;
import com.nice.jzb.background.ShareUtil;
import com.nice.jzb.core.AbstractActivity;
import com.nice.jzb.ui.webview.NiceJavaScriptInterface;
import com.nice.jzb.ui.webview.NiceWebChromeClient;
import com.nice.jzb.ui.webview.NiceWebviewClient;
import com.nice.jzb.ui.webview.WebViewSettingUtil;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by nice on 16/4/13.
 */

@EActivity(R.layout.activity_webview)
public class ActivityWebView extends AbstractActivity {


    @Extra
    String desc;

    @Extra
    String url;

    @Extra
    JICHEShareModel share;


    @ViewById(R.id.webiew)
    WebView webView;

    NiceJavaScriptInterface javaScriptInterface;
    NiceWebChromeClient webChromeClient;
    NiceWebviewClient webviewClient;


    @AfterViews
    void init() {

        if (share != null&&!TextUtils.isEmpty(share.getShare_url())) {
            setTitleRightImageButton(R.drawable.icon_wechat_timeline, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShareUtil shareUtil = new ShareUtil();
                    shareUtil.shareToWeChat(ActivityWebView.this,share.getShare_title(),share.getShare_desc(),share.getShare_url(),share.getShare_pic(),true);
                }
            });

            setTitleRightImageButtonTwo(R.drawable.icon_wechat_session, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShareUtil shareUtil = new ShareUtil();
                    shareUtil.shareToWeChat(ActivityWebView.this, share.getShare_title(), share.getShare_desc(), share.getShare_url(), share.getShare_pic(), false);
                }
            });
        }

        initWebView();

        if (!TextUtils.isEmpty(desc)) {
            webView.loadDataWithBaseURL(null, desc, "text/html", "utf-8", null);
        }

        if (!TextUtils.isEmpty(url)) {
            webView.loadUrl(url);
        }
    }

    private void initWebView() {
        javaScriptInterface = new NiceJavaScriptInterface(this, webView);
        webChromeClient = new NiceWebChromeClient(this);
        webviewClient = new NiceWebviewClient(this);

        WebViewSettingUtil.Builder builder = new WebViewSettingUtil.Builder();
        builder.setWebView(webView).setJavaScriptInterface(javaScriptInterface).setWebChromeClient(webChromeClient).setWebClient(webviewClient);
        WebViewSettingUtil.initWebViewSetting(builder);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConfigValue.kHTML_JS_LOGIN_REQUEST_CODE && resultCode == RESULT_OK) {
            if (javaScriptInterface != null) {
                javaScriptInterface.loginSucessAndPostUserInfo();
            }
        }
    }

    @Override
    protected void onClickBack() {
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
    }
}
