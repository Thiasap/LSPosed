package org.lsposed.lspd.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import io.github.libxframe.api.XframeInterface;
import io.github.libxframe.api.errors.HookFailedError;

public class LSPosedHelper {

    @SuppressWarnings("UnusedReturnValue")
    public static <T> XframeInterface.MethodUnhooker<Method>
    hookMethod(Class<? extends XframeInterface.Hooker> hooker, Class<T> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            var method = clazz.getDeclaredMethod(methodName, parameterTypes);
            return LSPosedBridge.doHook(method, XframeInterface.PRIORITY_DEFAULT, hooker);
        } catch (NoSuchMethodException e) {
            throw new HookFailedError(e);
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    public static <T> Set<XframeInterface.MethodUnhooker<Method>>
    hookAllMethods(Class<? extends XframeInterface.Hooker> hooker, Class<T> clazz, String methodName) {
        var unhooks = new HashSet<XframeInterface.MethodUnhooker<Method>>();
        for (var method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                unhooks.add(LSPosedBridge.doHook(method, XframeInterface.PRIORITY_DEFAULT, hooker));
            }
        }
        return unhooks;
    }

    @SuppressWarnings("UnusedReturnValue")
    public static <T> XframeInterface.MethodUnhooker<Constructor<T>>
    hookConstructor(Class<? extends XframeInterface.Hooker> hooker, Class<T> clazz, Class<?>... parameterTypes) {
        try {
            var constructor = clazz.getDeclaredConstructor(parameterTypes);
            return LSPosedBridge.doHook(constructor, XframeInterface.PRIORITY_DEFAULT, hooker);
        } catch (NoSuchMethodException e) {
            throw new HookFailedError(e);
        }
    }
}
