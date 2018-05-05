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

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author timpkins
 */
public interface IUIHandler {

    /**
     * Activity中iew的处理
     * @param savedInstanceState 重新初始化时，由最近一次{@link android.app.Activity#onSaveInstanceState(Bundle)}中提供的数据
     */
    void initView(@Nullable Bundle savedInstanceState);

    /**
     * Activity中数据处理
     */
    void initData();

    /**
     * 根据ID获取对应的View
     * @param resId ID
     * @param <T> View或其子类
     * @return View或其子类
     */
    <T extends View> T $(@IdRes int resId);

    /**
     * Activity跳转
     * @param clazz 跳转的目的地Activity
     * @param <T> AppCompatActivity子类
     */
    <T extends AppCompatActivity> void startActivity(Class<T> clazz);
}
