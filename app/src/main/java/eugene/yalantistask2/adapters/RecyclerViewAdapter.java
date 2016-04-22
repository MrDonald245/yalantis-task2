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

package eugene.yalantistask2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eugene.yalantistask2.R;
import eugene.yalantistask2.listeners.ItemOnClickListener;
import eugene.yalantistask2.models.Issue;

/**
 * Adapter to provide data for RecyclerView in "In Work" tab item.
 */
public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.InWorkViewHolder> {

    private List<Issue> mIssues;

    /**
     * A ViewHolder describes an item view and
     * metadata about its place within the RecyclerView.
     */
    public static class InWorkViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconIssue;
        public ImageView likesIcon;
        public TextView likesValue;
        public TextView headerIssue;
        public TextView address;
        public TextView date;
        public TextView days;

        public InWorkViewHolder(View itemView) {
            super(itemView);

            iconIssue = (ImageView) itemView.findViewById(R.id.iv_icon_issue);
            likesValue = (TextView) itemView.findViewById(R.id.tv_likes_value);
            headerIssue = (TextView) itemView.findViewById(R.id.tv_header_issue);
            address = (TextView) itemView.findViewById(R.id.tv_address);
            date = (TextView) itemView.findViewById(R.id.tv_date);
            days = (TextView) itemView.findViewById(R.id.tv_days);
        }
    }

    /**
     * Constructor of InWorkRecyclerViewAdapter
     *
     * @param issues List<Issue> issues to setup an adapter.
     */
    public RecyclerViewAdapter(List<Issue> issues) {
        mIssues = issues;
    }

    @Override
    public InWorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        // Show details after click on an item.
        itemView.setOnClickListener(new ItemOnClickListener(parent.getContext()));

        return new InWorkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InWorkViewHolder holder, int position) {
        Issue issue = mIssues.get(position);

        // Bind issue icon via Picasso lib
        Picasso.with(holder.itemView.getContext())
                .load(issue.getResIcon())
                .resizeDimen(R.dimen.issue_icon_width, R.dimen.issue_icon_height)
                .centerInside()
                .into(holder.iconIssue);

        // Bind likes value in text field
        holder.likesValue.setText(Integer.toString(issue.getLikesCount()));

        // Bind issue header
        holder.headerIssue.setText(issue.getResName());

        // Bind address value
        holder.address.setText(issue.getAddress());

        // Bind date value
        holder.date.setText(issue.getDate());

        // Bind days value
        String daysValue = "- "
                + Integer.toString(issue.getDays())
                + " "
                + holder.itemView.getResources().getString(R.string.days);

        holder.days.setText(daysValue);
    }

    @Override
    public int getItemCount() {
        return mIssues.size();
    }


}
