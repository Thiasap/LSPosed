package io.github.libxframe.api.errors;

/**
 * Thrown to indicate that the Xposed framework function is broken.
 */
public class XframeFrameworkError extends Error {

    public XframeFrameworkError(String message) {
        super(message);
    }

    public XframeFrameworkError(String message, Throwable cause) {
        super(message, cause);
    }

    public XframeFrameworkError(Throwable cause) {
        super(cause);
    }
}
