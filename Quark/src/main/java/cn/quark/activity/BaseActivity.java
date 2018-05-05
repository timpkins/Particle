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

package cn.quark.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import cn.quark.BaseApplication;
import cn.quark.R;
import cn.quark.core.ILoadingProgress;
import cn.quark.core.IUIHandler;
import cn.quark.view.LoadingProgressView;

/**
 * Activity基类
 * @author timpkins
 */
public abstract class BaseActivity extends AppCompatActivity implements IUIHandler, ILoadingProgress{
    protected BaseApplication mApplication;
    private LoadingProgressView mLoadingView;

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication = BaseApplication.getInstance();
        mApplication.addActivity(this);

        mLoadingView = (LoadingProgressView) LayoutInflater.from(this).inflate(R.layout.common_loading_progress, null);
        show();

        initView(savedInstanceState);
        initData();
    }

    @Override
    public <T extends View> T $(int resId) {
        return (T)super.findViewById(resId);
    }

    @Override
    public <T extends AppCompatActivity> void startActivity(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mApplication.removeActivity(this);
    }

    @Override
    public void show(int resId) {
        mLoadingView.show(resId);
    }

    @Override
    public void show() {
        mLoadingView.show();
    }

    @Override
    public void dismiss() {
        mLoadingView.dismiss();
    }
}
