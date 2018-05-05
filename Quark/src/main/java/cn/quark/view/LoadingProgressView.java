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
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.quark.R;
import cn.quark.core.ILoadingProgress;

/**
 * Activity和Fragment加载时显示进度
 * @author timpkins
 */
public class LoadingProgressView extends RelativeLayout implements OnClickListener, ILoadingProgress{
    private ViewGroup decorView;
    private TextView tvMsg;

    public LoadingProgressView(Context context) {
        super(context);
    }

    public LoadingProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LoadingProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvMsg = findViewById(R.id.tvMsg);
        tvMsg.setVisibility(GONE);

        if (getContext() instanceof Activity) {
            decorView = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        }
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

    @Override
    public void show(@StringRes int resId) {
        tvMsg.setText(resId);
        tvMsg.setVisibility(VISIBLE);
        show();
    }

    @Override
    public void show() {
        if (decorView != null) {
            decorView.addView(this);
        }
    }

    @Override
    public void dismiss() {
        if (decorView != null) {
            decorView.removeView(this);
        }
    }
}
