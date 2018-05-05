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

package cn.quark.core;

import android.support.annotation.StringRes;

/**
 * 显示进度的操作
 * @author timpkins
 */
public interface ILoadingProgress {

    /**
     * 显示加载进度条
     * @param resId 加载提示信息
     */
    void show(@StringRes int resId);

    /**
     * 显示加载进度条
     */
    void show();

    /**
     * 隐藏加载进度条
     */
    void dismiss();
}
