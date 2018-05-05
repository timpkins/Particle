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

package cn.particle.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.quark.fragment.BaseFragment;
import cn.timpkins.particle.R;

/**
 * @author timpkins
 */
public class MainFragment extends BaseFragment {

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.fragment_main_layout);
    }

    @Override
    public void initData() {

    }
}
