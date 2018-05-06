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

package cn.particle.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.particle.fragment.MainFragment;
import cn.quark.activity.MaterialTitleActivity;
import cn.timpkins.particle.R;

public class MainActivity extends MaterialTitleActivity {

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        MainFragment fragment = new MainFragment();
        transaction.add(R.id.fl, fragment);
        transaction.commit();
    }

    @Override
    public void initData() {
    }

    @Override
    public void initTitle() {
        setTitleBack();
        setTitleName(R.string.app_name);
    }
}
