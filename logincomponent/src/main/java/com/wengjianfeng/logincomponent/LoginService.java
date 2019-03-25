package com.wengjianfeng.logincomponent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wengjianfeng.componentlib.service.ILoginService;

/**
 * Created by wengjianfeng on 2019/3/16.
 */

public class LoginService implements ILoginService {
    @Override
    public void launch(Context context, Bundle bundle) {
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_TARGET_CLASS,bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
