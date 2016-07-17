package com.nice.jzb.ui.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.core.bean.BaseBean;
import com.core.util.CoreUtil;
import com.core.util.DisplayUtil;
import com.core.util.ToastUtil;
import com.nice.jzb.BuildConfig;
import com.nice.jzb.R;
import com.nice.jzb.background.AppInfo;
import com.nice.jzb.background.CommonPreference;
import com.nice.jzb.background.ConfigValue;
import com.nice.jzb.background.JICHEApplication;
import com.nice.jzb.background.RequestAPI;
import com.nice.jzb.background.account.Account;
import com.nice.jzb.core.AbstractActivity;
import com.nice.jzb.utils.IntentParseUtil;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by sufun_job on 2016/1/19.
 *
 * @desctiption 项目的首页
 */
@EActivity(R.layout.home_main_layout)
public class MainActivity extends AbstractActivity {

    @ViewById(R.id.splashImageOne)
    ImageView splashImageOne;

    @ViewById(R.id.splashLayout)
    View splashLayout;

    private static int TIME_LONG = 3 * 1000;
    private long lastTime;
    private final int SPLASH_TIME = 2500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.isTemplate = false;
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            IntentParseUtil.getInstance().parseIntentType(intent, MainActivity.this);
        }
        registerBroadCastReceiver();
        initPushSDK();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            IntentParseUtil.getInstance().parseIntentType(intent, MainActivity.this);
        }
    }

    public void parseIntentInMainActivity(Intent intent) {

        String type = intent.getStringExtra(ConfigValue.kLaunchMainAcKey);
        if (ConfigValue.kLaunchMainAcTypeShowHome.equals(type)) {
        }
    }

    private void initPushSDK() {
        // 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
        // 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
        // 具体可参考详细的开发指南
        // 传递的参数为ApplicationContext
        Context context = getApplicationContext();
        XGPushManager.registerPush(context);
        // 开启logcat输出，方便debug，发布时请关闭
        if (BuildConfig.LOG_DEBUG) {
            XGPushConfig.enableDebug(context, true);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
        }
    }

    @Override
    protected void onClickBack() {

    }

    @AfterViews
    void init() {
//        initSpalshCenter();
        splashLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashLayout.setVisibility(View.GONE);
                MainActivity.this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }, SPLASH_TIME);
    }


    private void initSpalshCenter() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.splash_center, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        int screenWid = AppInfo.width;
        float scale = screenWid * 1.0f / imageWidth;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWid, (int) (imageHeight * scale));
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.bottomMargin = DisplayUtil.dip2px(MainActivity.this, 70);
        splashImageOne.setLayoutParams(layoutParams);
        splashImageOne.setImageResource(R.drawable.splash_center);
    }

    @Override
    public void onBackPressed() {
        if (isDialogShowing()) {
            return;
        }
        if (isImageViewShowing()) {
            return;
        }
        long t = System.currentTimeMillis();
        if (t - lastTime < TIME_LONG) {
            CoreUtil.exitApp();
        } else {
            ToastUtil.showToastMessage(MainActivity.this, "再按一次返回键退出");
            lastTime = t;
            return;
        }
        super.onBackPressed();
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ConfigValue.kPushTokenUpdate.equals(action)) {
                setPushToken();
            }
        }
    };

    public void registerBroadCastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConfigValue.kPushTokenUpdate);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    private void setPushToken() {
//        String push_token = CommonPreference.getToken();
//        Map<String, String> params = new HashMap<>();
//        params.put("xinge_token", push_token);
//        Account account = JICHEApplication.getInstance().getAccount();
//        String token = "";
//        if (account != null) {
//            token = account.token;
//        }
//        if (!TextUtils.isEmpty(token)) {
//            params.put("token", token);
//        }
//
//        new NiceAsyncTask(false) {
//
//            @Override
//            public void loadSuccess(BaseBean bean) {
//
//            }
//
//            @Override
//            public void exception() {
//
//            }
//        }.post(false, RequestAPI.API_MEMBER_PUSH_TOKEN, params, BaseBean.class);
    }

}
