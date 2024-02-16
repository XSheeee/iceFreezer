package io.github.xsheeee.icefreezer.hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookMain implements IXposedHookLoadPackage {
    public void isActive(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable{
        if(lpparam.packageName.equals("io.github.xsheeee.icefreezer")) {

            // don't use YourActivity.class here

            XposedHelpers.findAndHookMethod("io.github.xsheeee.icefreezer.tools.TestAbout",lpparam.classLoader,

                    "isModuleActive", new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                            param.setResult(true);
                        }
                    });

        }
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // 执行Hook
        isActive(lpparam);
    }

}
