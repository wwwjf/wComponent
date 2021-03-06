package com.wengjianfeng.componentlib.service;

/**
 * Created by wengjianfeng on 2019/3/16.
 */

public class ServiceFactory {

    public static final ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }

    private ILoginService mLoginService;
    private IMineService mMineService;


    public ILoginService getLoginService() {

        if (mLoginService == null){
            mLoginService = new EmptyLoginService();
        }
        return mLoginService;
    }

    public void setLoginService(ILoginService loginService) {
        mLoginService = loginService;
    }

    public IMineService getMineService() {
        if (mMineService == null){
            mMineService = new EmptyMineService();
        }
        return mMineService;
    }

    public void setMineService(IMineService mineService) {
        mMineService = mineService;
    }

}
