package com.wengjianfeng.wcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wengjianfeng.componentlib.service.ILoginService;
import com.wengjianfeng.componentlib.service.IMineService;
import com.wengjianfeng.componentlib.service.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.goLogin).setOnClickListener(v ->{
            ILoginService loginService = ServiceFactory.getInstance().getLoginService();
            if (loginService != null) {
                loginService.launch(MainActivity.this, "");
            }
        });
        findViewById(R.id.goMine).setOnClickListener(v -> {
            IMineService mineService = ServiceFactory.getInstance().getMineService();
            if (mineService != null) {
                mineService.launch(MainActivity.this, 123);
            }
        });
        findViewById(R.id.showUI).setOnClickListener(v -> {
            IMineService mineService = ServiceFactory.getInstance().getMineService();
            if (mineService != null){
                mineService.newUserInfoFragment(getSupportFragmentManager(),R.id.container,new Bundle());
            }
        });
    }
}
