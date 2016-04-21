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

package eugene.yalantistask2.models;

import eugene.yalantistask2.R;

/**
 * Lift issue model with name and icon, which are getting form resources.
 */
public class LiftIssue extends Issue {

    public LiftIssue(int likesCount, int days, String date, String address) {
        super(likesCount, days, date, address);
    }

    /**
     * Get name of issue.
     *
     * @return int resource name id.
     */
    @Override
    public int getResName() {
        return R.string.lift_issue;
    }

    /**
     * Get icon resource id.
     *
     * @return int resource icon id
     */
    @Override
    public int getResIcon() {
        // TODO: it's not lift icon. Set original icon.
        return R.drawable.ic_address;
    }
}
