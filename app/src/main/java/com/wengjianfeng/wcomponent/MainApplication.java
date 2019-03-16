package com.wengjianfeng.wcomponent;

import android.app.Application;

import com.wengjianfeng.componentlib.service.AppConfig;
import com.wengjianfeng.componentlib.service.IComponentApp;

/**
 * Created by wengjianfeng on 2019/3/16.
 */

public class MainApplication extends Application implements IComponentApp{

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
        for (String component : AppConfig.COMPONENTS) {
            try {
                Class<?> clazz = Class.forName(component);
                Object object = clazz.newInstance();
                if (object instanceof IComponentApp){
                    ((IComponentApp)object).initializal(application);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
