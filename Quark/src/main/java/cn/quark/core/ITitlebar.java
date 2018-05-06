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

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.view.View.OnClickListener;

/**
 * 标题栏接口
 * @author timpkins
 */
public interface ITitlebar {

    /**
     * 设置标题栏背景色
     * @param colorRes 待设置的颜色
     */
    void setTitleBackground(@ColorRes int colorRes);

    /**
     * 设置标题栏名称
     * @param stringRes 待设置的名字
     */
    void setTitleName(@StringRes int stringRes);

    /**
     * 设置标题栏名称
     * @param stringRes 待设置的名字
     * @param gravity 标题在标题栏的位置
     */
    void setTitleName(int stringRes, int gravity);

    /**
     * 设置标题栏名称和其点击事件监听
     * @param stringRes 待设置的名字
     * @param listener 待设置的点击事件监听
     */
    void setTitleName(@StringRes int stringRes, OnClickListener listener);
}