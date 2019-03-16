package com.wengjianfeng.minecomponent;

import android.app.Application;

import com.wengjianfeng.componentlib.service.IComponentApp;
import com.wengjianfeng.componentlib.service.ServiceFactory;

/**
 * Created by wengjianfeng on 2019/3/16.
 */

public class MineApplication extends Application implements IComponentApp{

    private static Application sApplication;

    public static Application getApplication(){
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializal(this);
    }

    @Override
    public void initializal(Application application) {
        sApplication = application;
        ServiceFactory.getInstance().setMineService(new MineService());
    }
}
