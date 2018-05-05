/*
 *
 *  * Copyright (C) 2018 timpkins(timpkins@163.com)
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package cn.quark.util;

import android.util.Log;

import cn.quark.Constants;

/**
 * @author timpkins
 */
public final class LogUtils {
    /**
     * 输出级别为{@link Log#VERBOSE}的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     */
    public static void v(String tag, String msg) {
        print(Log.VERBOSE, tag, msg, null);
    }

    /**
     * 输出级别为{@link Log#VERBOSE}，异常的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     * @param tr Log日志的异常信息
     */
    public static void v(String tag, String msg, Throwable tr) {
        print(Log.VERBOSE, tag, msg, tr);
    }

    /**
     * 输出级别为{@link Log#DEBUG}的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     */
    public static void d(String tag, String msg) {
        print(Log.DEBUG, tag, msg, null);
    }

    /**
     * 输出级别为{@link Log#DEBUG}，异常的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     * @param tr Log日志的异常信息
     */
    public static void d(String tag, String msg, Throwable tr) {
        print(Log.DEBUG, tag, msg, tr);
    }

    /**
     * 输出级别为{@link Log#INFO}的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     */
    public static void i(String tag, String msg) {
        print(Log.INFO, tag, msg, null);
    }

    /**
     * 输出级别为{@link Log#INFO}，异常的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     * @param tr Log日志的异常信息
     */
    public static void i(String tag, String msg, Throwable tr) {
        print(Log.INFO, tag, msg, tr);
    }

    /**
     * 输出级别为{@link Log#WARN}的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     */
    public static void w(String tag, String msg) {
        print(Log.WARN, tag, msg, null);
    }

    /**
     * 输出级别为{@link Log#WARN}，异常的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     * @param tr Log日志的异常信息
     */
    public static void w(String tag, String msg, Throwable tr) {
        print(Log.WARN, tag, msg, tr);
    }

    /**
     * 输出级别为{@link Log#ERROR}的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     */
    public static void e(String tag, String msg) {
        print(Log.ERROR, tag, msg, null);
    }

    /**
     * 输出级别为{@link Log#ERROR}，异常的日志
     * @param tag Log日志的tag
     * @param msg Log日志的message
     * @param tr Log日志的异常信息
     */
    public static void e(String tag, String msg, Throwable tr) {
        print(Log.ERROR, tag, msg, tr);
    }

    private static void print(int priority, String tag, String msg, Throwable tr) {
        if (tr != null) {
            msg = msg.concat("\n").concat(Log.getStackTraceString(tr));
        }
        tag = MetaDataUtils.application(Constants.LOG_PREFIX).concat(tag);
        Log.println(priority, tag, msg);
    }
}
