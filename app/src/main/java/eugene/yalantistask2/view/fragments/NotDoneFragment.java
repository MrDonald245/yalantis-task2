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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import eugene.yalantistask2.R;
import eugene.yalantistask2.presenter.NotDoneFragmentPresenter;
import eugene.yalantistask2.utils.adapters.ListViewAdapter;
import eugene.yalantistask2.model.Issue;

/**
 * Shows screen with RecyclerView that contain all of data in "not done" status
 */
public class NotDoneFragment extends Fragment {

    private NotDoneFragmentPresenter mPresenter;

    public NotDoneFragment() {
        mPresenter = new NotDoneFragmentPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    /**
     * When view were created, setup RecyclerView.
     *
     * @param view               root view.
     * @param savedInstanceState previous saved state.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setupListView(view);
    }

    /**
     * Setup recycler view from view that was inflated in onCreateView() method
     *
     * @param view from onCreateView method.
     */
    private void setupListView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.listView);

        listView.setAdapter(new ListViewAdapter(
                getContext(), R.layout.list_fragment, getIssues()));

        // Attach FAB to RecycleView to provide animation in further
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.attachToListView(listView);
    }

    /**
     * Get data of "in work" issues.
     * needed to provide List<Issue> for InWorkRecyclerViewAdapter class.
     *
     * @return List<Issue> object with issues "in work".
     */
    private List<Issue> getIssues() {
        return mPresenter.getIssues();
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
}
