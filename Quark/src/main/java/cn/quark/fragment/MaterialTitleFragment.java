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

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;

import cn.quark.R;
import cn.quark.core.IMaterialTitlebar;
import cn.quark.view.MaterialTitlebar;

/**
 * @author timpkins
 */
public abstract class MaterialTitleFragment extends BaseTitleFragment<MaterialTitlebar> implements IMaterialTitlebar {

    @Override
    protected int initTitlebarView() {
        return R.layout.common_material_titlebar;
    }

    @Override
    public void setTitleMenu(int menuRes) {
        getTitlebar().setTitleMenu(menuRes);
        getTitlebar().setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onMenuClick(item.getItemId());
                return true;
            }
        });
    }

    @Override
    public void setTitleBack() {
        getTitlebar().setActivity(getActivity());
        getTitlebar().setTitleBack();
    }

    @Override
    public void setTitleBack(int drawbleRes) {
        getTitlebar().setActivity(getActivity());
        getTitlebar().setTitleBack(drawbleRes);
    }

    @Override
    public void setTitleBack(int drawbleRes, @NonNull View.OnClickListener listener) {
        getTitlebar().setActivity(getActivity());
        getTitlebar().setTitleBack(drawbleRes, listener);
    }

    protected void onMenuClick(int itemId) {
    }
}

