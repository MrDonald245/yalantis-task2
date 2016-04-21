/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eugene.yalantistask2.listeners;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/**
 * OnClick Listener for Navigation Toolbar
 */
public class ToolbarNavigationOnClickListener implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;

    public ToolbarNavigationOnClickListener(DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
    }

    @Override
    public void onClick(View view) {
        if (mDrawerLayout != null) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }
}
