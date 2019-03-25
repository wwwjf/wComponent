package com.wengjianfeng.wcomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wengjianfeng.componentlib.service.ILoginService;
import com.wengjianfeng.componentlib.service.IMineService;
import com.wengjianfeng.componentlib.service.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private NetworkChangeReceiver receiver;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");
        Bundle bundle = new Bundle();
        findViewById(R.id.goLogin).setOnClickListener(v ->
                ServiceFactory.getInstance().getLoginService()
                        .launch(MainActivity.this, bundle));

        findViewById(R.id.goMine).setOnClickListener(v ->
                ServiceFactory.getInstance().getMineService()
                        .launch(MainActivity.this, 123));

        findViewById(R.id.showUI).setOnClickListener(v -> {

            mLocalBroadcastManager.sendBroadcast(new Intent("com.wengjianfeng.broadcast"));
                    ServiceFactory.getInstance().getMineService()
                            .newUserInfoFragment(getSupportFragmentManager(),
                                    R.id.container, new Bundle());
                }
        );
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("com.wengjianfeng.broadcast");
        receiver = new NetworkChangeReceiver();
//        registerReceiver(receiver,filter);

        //
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastManager.registerReceiver(receiver, filter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
//        unregisterReceiver(receiver);
        mLocalBroadcastManager.unregisterReceiver(receiver);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "onReceive: 网络变化");
            Toast.makeText(context, "网络变化", Toast.LENGTH_SHORT).show();
        }
    }
}
