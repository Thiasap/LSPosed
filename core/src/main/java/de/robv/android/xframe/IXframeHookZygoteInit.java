package de.robv.android.xframe;

/**
 * Hook the initialization of Zygote process(es), from which all the apps are forked.
 *
 * <p>Implement this interface in your module's main class in order to be notified when Android is
 * starting up. In {@link IXframeHookZygoteInit}, you can modify objects and place hooks that should
 * be applied for every app. Only the Android framework/system classes are available at that point
 * in time. Use {@code null} as class loader for {@link XframeHelpers#findAndHookMethod(String, ClassLoader, String, Object...)}
 * and its variants.
 *
 * <p>If you want to hook one/multiple specific apps, use {@link IXframeHookLoadPackage} instead.
 */
public interface IXframeHookZygoteInit extends IXframeMod {
    /**
     * Called very early during startup of Zygote.
     * @param startupParam Details about the module itself and the started process.
     * @throws Throwable everything is caught, but will prevent further initialization of the module.
     */
    void initZygote(StartupParam startupParam) throws Throwable;

    /** Data holder for {@link #initZygote}. */
    final class StartupParam {
        /*package*/ StartupParam() {}

        /** The path to the module's APK. */
        public String modulePath;

        /**
         * Always {@code true} on 32-bit ROMs. On 64-bit, it's only {@code true} for the primary
         * process that starts the system_server.
         */
        public boolean startsSystemServer;
    }
}
