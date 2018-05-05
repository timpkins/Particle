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

package cn.quark;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

/**
 * Application基类
 * @author timpkins
 */
public class BaseApplication extends Application {
        private static BaseApplication mInstance;
        private final Set<AppCompatActivity> mActivities = new HashSet<>();

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler());
    }

    public static <T extends BaseApplication> T getInstance() {
        return (T)mInstance;
    }

    /**
     * 在{@link #mActivities}中添加当前Activity， 便于统一管理
     * @param activity 当前运行中的Activity
     */
    public void addActivity(AppCompatActivity activity) {
        mActivities.add(activity);
    }

    /**
     * 在{@link #mActivities}中移除当前Activity
     * @param activity 当前准备关闭的Activity
     */
    public void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (Activity activity : mActivities) {
            activity.finish();
        }
        mActivities.clear();
        System.exit(0);
    }
}
