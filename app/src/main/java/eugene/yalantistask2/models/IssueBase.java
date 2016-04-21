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

/**
 * Base model for each issue.
 */
public interface IssueBase {

    /**
     * Get name of issue.
     *
     * @return int resource name id.
     */
    int getResName();

    /**
     * Get icon resource id.
     *
     * @return int resource icon id
     */
    int getResIcon();

    /**
     * Get number this issue likes.
     *
     * @return int number of likes.
     */
    int getLikesCount();

    /**
     * Get days. Example: "-14 дiв" in RecyclerView item
     *
     * @return int Count of days.
     */
    int getDays();

    /**
     * Get date when a post was posted.
     * Date is in String format, just because I am lazy.
     *
     * @return String date
     */
    String getDate();

    /**
     * Get address of this issue.
     *
     * @return String address.
     */
    String getAddress();
}
