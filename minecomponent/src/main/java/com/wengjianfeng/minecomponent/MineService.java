package com.wengjianfeng.minecomponent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wengjianfeng.componentlib.service.IMineService;

/**
 * Created by wengjianfeng on 2019/3/16.
 */

public class MineService implements IMineService {
    @Override
    public void launch(Context context, int userId) {
        Intent intent = new Intent(context,MineActivity.class);
        intent.putExtra("ID",userId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        UserInfoFragment userInfoFragment = UserInfoFragment.newInstance(bundle);
        fragmentManager.beginTransaction().add(viewId,userInfoFragment).commit();
        return userInfoFragment;
    }
}
