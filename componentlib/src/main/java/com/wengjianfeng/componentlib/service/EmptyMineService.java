package com.wengjianfeng.componentlib.service;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by wengjianfeng on 2019/3/16.
 */

public class EmptyMineService implements IMineService {
    @Override
    public void launch(Context context, int userId) {

    }

    @Override
    public Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        return null;
    }
}
