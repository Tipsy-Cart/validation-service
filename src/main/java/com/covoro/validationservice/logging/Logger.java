package com.covoro.validationservice.logging;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.StackWalker.StackFrame;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class Logger {

    private final RequestAttributes requestAttributes;
    private static final org.slf4j.Logger appLogger = LoggerFactory.getLogger("Service-Application");
    private static final org.slf4j.Logger exceptionLogger = LoggerFactory.getLogger("Service-Exception");
    private static final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    private static final ConcurrentHashMap<String, String> classNameCache = new ConcurrentHashMap<>();

    public Logger(RequestAttributes requestAttributes) {
        this.requestAttributes = requestAttributes;
    }

    public void info(String message) {
        if (appLogger.isInfoEnabled())
            appLogger.info(logString(message));
    }

    public void debug(String message) {
        if (appLogger.isDebugEnabled())
            appLogger.debug(logString(message));
    }

    public void error(String message) {
        if (appLogger.isErrorEnabled())
            appLogger.error(logString(message));
    }

    public void error(String message, Throwable t) {
        if (appLogger.isErrorEnabled())
            appLogger.error(logString(message, t.getStackTrace()[0]));
    }

    public void warn(String message) {
        if (appLogger.isWarnEnabled())
            appLogger.warn(logString(message));
    }

    public void trace(String message, Throwable t) {
        if (exceptionLogger.isTraceEnabled())
            exceptionLogger.trace(logString(message), t);
    }

    private String logString(String message) {
        StackFrame stackFrame = walker.walk(s -> s.skip(2).findFirst()).orElse(null);
        String loggedInUser = getLoggedInUser();
        String logMessage = getLogLocation(stackFrame) + " | " + message;
        if (null != getLoggedInUser())
            return loggedInUser + " | " + logMessage;
        return logMessage;
    }

    private String logString(String message, StackTraceElement stackTraceElement) {
        String loggedInUser = getLoggedInUser();
        String logMessage = getLogLocation(stackTraceElement) + " | " + message;
        if (null != getLoggedInUser())
            return loggedInUser + " | " + logMessage;
        return logMessage;
    }

    private String getLoggedInUser() {
        if (null != requestAttributes.getUserId() && null != requestAttributes.getUserName())
            return requestAttributes.getUserId() + " :: " + requestAttributes.getUserName();
        return null;
    }

    private String getLogLocation(StackFrame frame) {
        if (null == frame) return "ClassName :: LineNumber";
        return getClassName(frame.getClassName()) + " :: " + frame.getLineNumber();
    }

    private String getLogLocation(StackTraceElement stackTraceElement) {
        if (null == stackTraceElement) return "ClassName :: LineNumber";
        return getClassName(stackTraceElement.getClassName()) + " :: " + stackTraceElement.getLineNumber();
    }

    private String getClassName(String fullName) {
        return classNameCache.computeIfAbsent(fullName,
                className -> className.substring(className.lastIndexOf('.') + 1));
    }

}
