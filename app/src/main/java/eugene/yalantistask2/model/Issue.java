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

package eugene.yalantistask2.model;

/**
 * Basic, abstract model with partly realization of IssueBase.
 */
public abstract class Issue implements IssueBase {

    private int mLikesCount;
    private int mDays;
    private String mDate;
    private String mAddress;

    public Issue(int likesCount, int days, String date, String address) {
        mLikesCount = likesCount;
        mDays = days;
        mDate = date;
        mAddress = address;
    }

    /**
     * Get address of this issue.
     *
     * @return String address.
     */
    @Override
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get date when a post was posted.
     * Date is in String format, just because I am lazy.
     *
     * @return String date
     */
    @Override
    public String getDate() {
        return mDate;
    }

    /**
     * Get days. Example: "-14 дiв" in RecyclerView item
     *
     * @return int Count of days.
     */
    @Override
    public int getDays() {
        return mDays;
    }

    /**
     * Get number this issue likes.
     *
     * @return int number of likes.
     */
    @Override
    public int getLikesCount() {
        return mLikesCount;
    }
}
