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

package cn.quark.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

import cn.quark.R;
import cn.quark.core.IMaterialTitlebar;

/**
 * @author timpkins
 */
public class MaterialTitlebar extends Toolbar implements IMaterialTitlebar {
    private TextView tvTitle;
    private Activity activity;

    public MaterialTitlebar(Context context) {
        super(context);
    }

    public MaterialTitlebar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialTitlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @RequiresApi(api = VERSION_CODES.N)
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setContentInsetsAbsolute(0, 0);
        setContentInsetsRelative(0, 0);
        if (Build.VERSION_CODES.N == VERSION.SDK_INT) {
            setContentInsetStartWithNavigation(0);
        }
        setPadding(0, 0, 0, 0);

        tvTitle = findViewById(R.id.tvTitle);
    }

    @Override
    public void setTitleMenu(int menuRes) {
        inflateMenu(menuRes);
    }

    @Override
    public void setTitleBack() {
        setTitleBack(R.drawable.ic_arrow_back, new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

        View view = getView("mNavButtonView");
        int navi_width = getResources().getDimensionPixelOffset(R.dimen.titlebarHeight);
        LayoutParams params = (LayoutParams) view.getLayoutParams();
        params.width = navi_width;
        view.setMinimumWidth(navi_width);
        view.setLayoutParams(params);
    }

    @Override
    public void setTitleBack(int drawableRes) {
        setTitleBack(drawableRes, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null){
                    activity.finish();
                }
            }
        });

        View view = getView("mNavButtonView");
        int navi_width = getResources().getDimensionPixelOffset(R.dimen.titlebarHeight);
        LayoutParams params = (LayoutParams) view.getLayoutParams();
        params.width = navi_width;
        view.setMinimumWidth(navi_width);
        view.setLayoutParams(params);
    }

    @Override
    public void setTitleBack(int drawbleRes, @NonNull OnClickListener listener) {
        setNavigationIcon(drawbleRes);
        setNavigationOnClickListener(listener);
    }

    @Override
    public void setTitleBackground(int colorRes) {
        setBackgroundResource(colorRes);
    }


    @Override
    public void setTitleName(int stringRes) {
        setTitleName(stringRes, Gravity.START);
    }

    @Override
    public void setTitleName(int stringRes, int gravity) {
        setTitle("");
        tvTitle.setText(stringRes);
        LayoutParams params = (LayoutParams) tvTitle.getLayoutParams();
        params.gravity = gravity;
        if (getNavigationIcon() == null) {
            params.leftMargin = getResources().getDimensionPixelOffset(R.dimen.titlebarLeftMargin);
        }
        tvTitle.setLayoutParams(params);
    }

    @Override
    public void setTitleName(int stringRes, OnClickListener listener) {
        setTitleName(stringRes);
        tvTitle.setOnClickListener(listener);
    }

    private View getView(String name) {
        View view = null;
        try {
            Field field = getClass().getSuperclass().getDeclaredField(name);
            field.setAccessible(true);
            view = (View) field.get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
