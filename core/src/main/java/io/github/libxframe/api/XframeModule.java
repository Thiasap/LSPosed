package io.github.libxframe.api;

import androidx.annotation.NonNull;

/**
 * Super class which all Xposed module entry classes should extend.<br/>
 * Entry classes will be instantiated exactly once for each process.
 */
@SuppressWarnings("unused")
public abstract class XframeModule extends XframeInterfaceWrapper implements XframeModuleInterface {
    /**
     * Instantiates a new Xposed module.<br/>
     * When the module is loaded into the target process, the constructor will be called.
     *
     * @param base  The implementation interface provided by the framework, should not be used by the module
     * @param param Information about the process in which the module is loaded
     */
    public XframeModule(@NonNull XframeInterface base, @NonNull ModuleLoadedParam param) {
        super(base);
    }
}
