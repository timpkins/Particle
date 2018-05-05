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

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.quark.core.IUIHandler;

/**
 * Fragment基类
 * @author timpkins
 */
public abstract class BaseFragment extends Fragment implements IUIHandler{
    private View view;
    protected static String KEY_NAME = "kname";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return view;
    }

    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(LayoutInflater.from(getContext()).inflate(layoutResID, null));
    }

    public void setContentView(View view) {
        this.view = view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public <T extends View> T $(int resId) {
        return (T)view.findViewById(resId);
    }

    @Override
    public <T extends AppCompatActivity> void startActivity(Class<T> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        getActivity().startActivity(intent);
    }
}
