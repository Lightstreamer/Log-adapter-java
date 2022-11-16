/*
 *  Copyright (c) Lightstreamer Srl
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package com.lightstreamer.log;


class Log implements Logger {
    private static Logger placeholder = new LogEmpty();

    private Logger wrappedLogger = placeholder;

    public Log() {
        //empty constructor
    }

    public Log(Logger iLogger) {
        this.wrappedLogger = iLogger;
    }

    //always called from under the lock of the LogManager class.
    public final void setWrappedInstance(Logger iLogger) {
        if (iLogger == null) {
            this.wrappedLogger = placeholder;
        } else {
            this.wrappedLogger = iLogger;
        }
    }

    //implement the interface:

    public final void error(String p) {
        this.wrappedLogger.error(p);
    }

    public final void error(String p, Throwable e) {
        this.wrappedLogger.error(p, e);
    }

    public final void warn(String p) {
        this.wrappedLogger.warn(p);
    }

    public final void warn(String p, Throwable e) {
        this.wrappedLogger.warn(p, e);
    }

    public final void info(String p) {
        this.wrappedLogger.info(p);
    }

    public final void info(String p, Throwable e) {
        this.wrappedLogger.info(p, e);
    }

    public final void debug(String p) {
        this.wrappedLogger.debug(p);
    }

    public final void debug(String p, Throwable e) {
        this.wrappedLogger.debug(p, e);
    }

    public final void fatal(String p) {
        this.wrappedLogger.fatal(p);
    }

    public final void fatal(String p, Throwable e) {
        this.wrappedLogger.fatal(p, e);
    }


    public final boolean isDebugEnabled() {
        return this.wrappedLogger.isDebugEnabled();
    }

    public final boolean isInfoEnabled() {
        return this.wrappedLogger.isInfoEnabled();
    }

    public final boolean isWarnEnabled() {
        return this.wrappedLogger.isWarnEnabled();
    }

    public final boolean isErrorEnabled() {
        return this.wrappedLogger.isErrorEnabled();
    }

    public final boolean isFatalEnabled() {
        return this.wrappedLogger.isFatalEnabled();
    }


}