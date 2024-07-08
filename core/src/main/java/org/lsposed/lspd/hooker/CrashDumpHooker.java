package org.lsposed.lspd.hooker;

import android.util.Log;

import org.lsposed.lspd.impl.LSPosedBridge;

import io.github.libxframe.api.XframeInterface;
import io.github.libxframe.api.annotations.BeforeInvocation;
import io.github.libxframe.api.annotations.XframeHooker;

@XframeHooker
public class CrashDumpHooker implements XframeInterface.Hooker {

    @BeforeInvocation
    public static void beforeHookedMethod(XframeInterface.BeforeHookCallback callback) {
        try {
            var e = (Throwable) callback.getArgs()[0];
            LSPosedBridge.log("Crash unexpectedly: " + Log.getStackTraceString(e));
        } catch (Throwable ignored) {
        }
    }
}
