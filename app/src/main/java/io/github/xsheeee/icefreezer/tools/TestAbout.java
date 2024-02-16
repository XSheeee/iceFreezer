package io.github.xsheeee.icefreezer.tools;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;

public class TestAbout {
    private static Context context;
    public TestAbout(Context context){
        this.context=context;
    }
    public static boolean is_root() {
        boolean res = false;
        try {
            res = (new File("/system/bin/su").exists()) ||
                    (new File("/system/xbin/su").exists());
        } catch (Exception e) {
            TestAbout.showToast("检测root权限失败，无法使用本模块");
        }
        return res;
    }
    public static void showToast(String str) {
        Toast makeText = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        makeText.setGravity(Gravity.CENTER, 0, 0);
        makeText.show();
    }
    public static boolean isModuleActive() {
        return false;
    }
}
