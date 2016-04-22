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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eugene.yalantistask2.R;
import eugene.yalantistask2.listeners.ItemOnClickListener;
import eugene.yalantistask2.models.Issue;

/**
 * Adapter for ListView in "not done" status tab
 */
public class ListViewAdapter extends ArrayAdapter<Issue> {
    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public ListViewAdapter(Context context, int resource, List<Issue> objects) {
        super(context, resource, objects);
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate view with custom ListView item
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.recycler_view_item, null);
        }

        // Get current item
        Issue issueItem = getItem(position);

        return setupViewItem(convertView, issueItem);
    }

    /**
     *
     * @param convertView
     * @param issueItem
     * @return
     */
    private View setupViewItem(View convertView, Issue issueItem) {
        ImageView iconIssue = (ImageView) convertView.findViewById(R.id.iv_icon_issue);
        TextView likesValue = (TextView) convertView.findViewById(R.id.tv_likes_value);
        TextView headerIssue = (TextView) convertView.findViewById(R.id.tv_header_issue);
        TextView address = (TextView) convertView.findViewById(R.id.tv_address);
        TextView date = (TextView) convertView.findViewById(R.id.tv_date);

        // Show details after click on an item.
        convertView.setOnClickListener(new ItemOnClickListener(getContext()));

        // Bind issue icon via Picasso lib
        Picasso.with(getContext())
                .load(issueItem.getResIcon())
                .resizeDimen(R.dimen.issue_icon_width, R.dimen.issue_icon_height)
                .centerInside()
                .into(iconIssue);

        // Bind likes value in text field
        likesValue.setText(Integer.toString(issueItem.getLikesCount()));

        // Bind issue header
        headerIssue.setText(issueItem.getResName());

        // Bind address value
        address.setText(issueItem.getAddress());

        // Bind date value
        date.setText(issueItem.getDate());

        return convertView;
    }
}
