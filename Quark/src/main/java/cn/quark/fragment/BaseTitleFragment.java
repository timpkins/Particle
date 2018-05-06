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

package cn.quark.fragment;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import cn.quark.core.ITitlebar;
import cn.quark.core.IUITitleHandler;

/**
 * @author timpkins
 */
public abstract class BaseTitleFragment<T extends ITitlebar> extends BaseFragment implements IUITitleHandler, ITitlebar{
    private LinearLayout llContent; // 真实布局
    private ITitlebar titlebar; // 标题栏接口
    private LayoutInflater inflater;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        llContent = new LinearLayout(context);
        llContent.setOrientation(LinearLayout.VERTICAL);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void setContentView(View view) {
        View titlebarView = inflater.inflate(initTitlebarView(), llContent, false);
        titlebar = (ITitlebar) titlebarView;
        llContent.addView(titlebarView);
        llContent.addView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
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

