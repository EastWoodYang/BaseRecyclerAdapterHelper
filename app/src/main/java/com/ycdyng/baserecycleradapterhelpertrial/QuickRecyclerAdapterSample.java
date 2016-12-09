/*
 * Copyright 2016 EastWood Yang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ycdyng.baserecycleradapterhelpertrial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ycdyng.baserecycleradapterhelper.QuickRecyclerAdapter;
import com.ycdyng.baserecycleradapterhelper.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class QuickRecyclerAdapterSample extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private QuickRecyclerAdapter<SampleModel> mQuickRecyclerAdapter;
    private List<SampleModel> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 20; i++) {
            SampleModel sampleMode = new SampleModel();
            sampleMode.setValues("RecyclerView item_" + i);
            mDataList.add(sampleMode);
        }

        mQuickRecyclerAdapter = new QuickRecyclerAdapter<SampleModel>(this, R.layout.list_item, mDataList) {
            @Override
            protected void convert(int position, RecyclerAdapterHelper helper, SampleModel item) {
                helper.setText(R.id.textView1, item.getValues());
            }
        };

        setContentView(R.layout.sample_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mQuickRecyclerAdapter);
    }

}
