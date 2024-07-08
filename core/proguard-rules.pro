-keep class de.robv.android.xframe.** {*;}
-keep class io.github.libxframe.** {*;}
-keepattributes RuntimeVisibleAnnotations
-keep class android.** { *; }
-keepclasseswithmembers,includedescriptorclasses class * {
    native <methods>;
}
-keepclassmembers class org.lsposed.lspd.impl.LSPosedContext {
    public <methods>;
}
-keepclassmembers class org.lsposed.lspd.impl.LSPosedHookCallback {
    public <methods>;
}
-keep,allowoptimization,allowobfuscation @io.github.libxframe.api.annotations.* class * {
    @io.github.libxframe.api.annotations.BeforeInvocation <methods>;
    @io.github.libxframe.api.annotations.AfterInvocation <methods>;
}
-keepclassmembers class org.lsposed.lspd.impl.LSPosedBridge$NativeHooker {
    <init>(java.lang.reflect.Executable);
    callback(...);
}
-keepclassmembers class org.lsposed.lspd.impl.LSPosedBridge$HookerCallback {
    final *** beforeInvocation;
    final *** afterInvocation;
    HookerCallback(...);
}
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** d(...);
}
-repackageclasses
-allowaccessmodification
-dontwarn org.slf4j.impl.StaticLoggerBinder
