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