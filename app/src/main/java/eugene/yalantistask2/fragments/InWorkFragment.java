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

package eugene.yalantistask2.fragments;

import java.util.Arrays;
import java.util.List;

import eugene.yalantistask2.models.DebtIssue;
import eugene.yalantistask2.models.DismantlingIssue;
import eugene.yalantistask2.models.Issue;
import eugene.yalantistask2.models.LiftIssue;
import eugene.yalantistask2.models.SanitaryIssue;

/**
 * Shows screen with RecyclerView that contain all of data in "work" status
 */
public class InWorkFragment extends RecyclerFragmentBase {

    /**
     * Set data for recycler view.
     *
     * @return List<Issue> data for recycler view.
     */
    @Override
    protected List<Issue> recyclerViewData() {
        Issue[] issues = new Issue[]{
                new DismantlingIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42"),
                new DebtIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42"),
                new LiftIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42"),
                new SanitaryIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42")
        };

        return Arrays.asList(issues);
    }
}
