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

import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.view.View.OnClickListener;

/**
 * material design风格标题栏操作
 * @author timpkins
 */
public interface IMaterialTitlebar extends ITitlebar {

    /**
     * 设置标题栏的菜单选项
     * @param menuRes 菜单项的资源ID
     */
    void setTitleMenu(@MenuRes int menuRes);

    /**
     * 设置默认的返回图片和点击事件监听
     */
    void setTitleBack();

    /**
     * 设置返回图片和点击事件监听
     * @param drawbleRes 返回图片资源ID
     */
    void setTitleBack(@DrawableRes int drawbleRes);

    /**
     * 设置返回图片和点击事件监听
     * @param drawbleRes 返回图片资源ID
     * @param listener   点击事件监听
     */
    void setTitleBack(@DrawableRes int drawbleRes, @NonNull OnClickListener listener);
}
