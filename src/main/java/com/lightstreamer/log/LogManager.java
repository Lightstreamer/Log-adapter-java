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