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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public /* @exclude */ class LogManager {
    private static Map<String, Log> logInstances = new HashMap<>();

    private static LoggerProvider currentLoggerProvider = null;

    public static void setLoggerProvider(LoggerProvider ilp) {
        synchronized (logInstances) {
            currentLoggerProvider = ilp;

            Set<Entry<String, Log>> entries = logInstances.entrySet();
            for (Map.Entry<String, Log> aLog : entries) {
                if (ilp == null) {
                    aLog.getValue().setWrappedInstance(null);
                } else {
                    aLog.getValue().setWrappedInstance(currentLoggerProvider.getLogger(aLog.getKey()));
                }
            }
        }
    }

    public static Log getLogger(String category) {
        synchronized (logInstances) {
            if (!logInstances.containsKey(category)) {
                if (currentLoggerProvider != null) {
                    logInstances.put(category, new Log(currentLoggerProvider.getLogger(category)));
                } else {
                    logInstances.put(category, new Log());
                }

            }
            return logInstances.get(category);
        }
    }


}