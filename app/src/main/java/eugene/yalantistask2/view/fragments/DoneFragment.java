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

package eugene.yalantistask2.view.fragments;

import java.util.List;

import eugene.yalantistask2.model.Issue;
import eugene.yalantistask2.presenter.DoneFragmentPresenter;

/**
 * Shows screen with RecyclerView that contain all of data in "done" status
 */
public class DoneFragment extends RecyclerFragmentBase {

    private DoneFragmentPresenter mPresenter;

    public DoneFragment() {
        mPresenter = new DoneFragmentPresenter(this);
    }

    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    /**
     * Set data for recycler view.
     *
     * @return List<Issue> data for recycler view.
     */
    @Override
    protected List<Issue> recyclerViewData() {
        return mPresenter.getIssues();
    }
}
