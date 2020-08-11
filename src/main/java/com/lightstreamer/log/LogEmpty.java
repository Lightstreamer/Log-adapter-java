/*
 * Copyright (c) 2004-2015 Weswit s.r.l., Via Campanini, 6 - 20124 Milano, Italy.
 * All rights reserved.
 * www.lightstreamer.com
 *
 * This software is the confidential and proprietary information of
 * Weswit s.r.l.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered
 * into with Weswit s.r.l.
 */
package com.lightstreamer.log;

class LogEmpty implements Logger {
    public final void error(String p) {
    }

    public final void error(String p, Throwable e) {
    }

    public final void warn(String p) {
    }

    public final void warn(String p, Throwable e) {
    }

    public final void info(String p) {
    }

    public final void info(String p, Throwable e) {
    }

    public final void debug(String p) {
    }

    public final void debug(String p, Throwable e) {
    }

    public final void fatal(String p) {
    }

    public final void fatal(String p, Throwable e) {
    }


    public final boolean isDebugEnabled() {
        return false;
    }

    public final boolean isInfoEnabled() {
        return false;
    }

    public final boolean isWarnEnabled() {
        return false;
    }

    public final boolean isErrorEnabled() {
        return false;
    }

    public final boolean isFatalEnabled() {
        return false;
    }
}