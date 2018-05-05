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

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import cn.quark.BaseApplication;

/**
 * 获取meta-data
 * @author timpkins
 */
public final class MetaDataUtils {

    public static String application(String key){
        String value = null;
        try {
            BaseApplication application = BaseApplication.getInstance();
            ApplicationInfo appInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(key);
        } catch (NameNotFoundException e) {
            value = "QUARK__";
        }
        return value;
    }
}
