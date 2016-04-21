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

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import eugene.yalantistask2.DetailsActivity;

/**
 * OnClick for each item in RecyclerView and ListView
 */
public class ItemOnClickListener implements View.OnClickListener {
    Context mContext;

    public ItemOnClickListener(Context context) {
        mContext = context;
    }


    /**
     * Show details activity
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, DetailsActivity.class);
        mContext.startActivity(intent);
    }
}
