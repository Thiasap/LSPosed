package org.lsposed.lspd.hooker;

import android.app.ActivityThread;

import de.robv.android.xframe.XframeInit;
import io.github.libxframe.api.XframeInterface;
import io.github.libxframe.api.annotations.AfterInvocation;
import io.github.libxframe.api.annotations.XframeHooker;

@XframeHooker
public class AttachHooker implements XframeInterface.Hooker {

    @AfterInvocation
    public static void afterHookedMethod(XframeInterface.AfterHookCallback callback) {
        XframeInit.loadModules((ActivityThread) callback.getThisObject());
    }
}
