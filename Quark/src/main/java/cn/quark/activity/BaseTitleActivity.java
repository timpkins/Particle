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

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import cn.quark.core.ITitlebar;
import cn.quark.core.IUITitleHandler;

/**
 * 带标题栏Activity基类
 * @author timpkins
 */
public abstract class BaseTitleActivity<T extends ITitlebar> extends BaseActivity implements IUITitleHandler, ITitlebar {
    private LinearLayout llContent; // 真实布局
    private ITitlebar titlebar; // 标题栏接口
    private LayoutInflater inflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        llContent = new LinearLayout(this);
        llContent.setOrientation(LinearLayout.VERTICAL);

        inflater = LayoutInflater.from(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(inflater.inflate(layoutResID, llContent, false));
    }

    @Override
    public void setContentView(View view) {
        View titlebarView = inflater.inflate(initTitlebarView(), llContent, false);
        titlebar = (ITitlebar) titlebarView;
        llContent.addView(titlebarView);
        llContent.addView(view);
        super.setContentView(llContent);
        initTitle();
    }

    protected abstract int initTitlebarView();

    public T getTitlebar() {
        return (T) titlebar;
    }

    @Override
    public void setTitleBackground(@ColorRes int colorRes) {
        titlebar.setTitleBackground(colorRes);
    }

    @Override
    public void setTitleName(@StringRes int stringRes) {
        titlebar.setTitleName(stringRes);
    }

    @Override
    public void setTitleName(int stringRes, int gravity) {
        titlebar.setTitleName(stringRes, gravity);
    }

    @Override
    public void setTitleName(@StringRes int stringRes, OnClickListener listener) {
        titlebar.setTitleName(stringRes, listener);
    }
}
