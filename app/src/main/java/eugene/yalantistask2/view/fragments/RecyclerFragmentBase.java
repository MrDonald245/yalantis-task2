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
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import eugene.yalantistask2.R;
import eugene.yalantistask2.utils.adapters.RecyclerViewAdapter;
import eugene.yalantistask2.model.Issue;

/**
 * Base Fragment for RecyclerView
 */
public abstract class RecyclerFragmentBase extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_fragment, container, false);
    }

    /**
     * When view were created, setup RecyclerView.
     *
     * @param view               root view.
     * @param savedInstanceState previous saved state.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setupRecyclerView(view);
    }

    /**
     * Setup recycler view from view that was inflated in onCreateView() method
     *
     * @param view from onCreateView method.
     */
    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RecyclerViewAdapter(recyclerViewData()));

        // Attach FAB to RecycleView to provide animation in further
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);
    }

    /**
     * Set data for recycler view.
     *
     * @return List<Issue> data for recycler view.
     */
    protected abstract List<Issue> recyclerViewData();

}
