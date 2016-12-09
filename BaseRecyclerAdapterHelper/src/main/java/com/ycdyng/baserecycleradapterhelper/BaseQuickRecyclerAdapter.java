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

package com.ycdyng.baserecycleradapterhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseQuickRecyclerAdapter<T, VH extends RecyclerAdapterHelper> extends RecyclerView.Adapter<VH> {

    protected final Context context;

    private SparseArray<Integer> layoutResIds;

    protected final List<T> data;

    protected LayoutInflater mLayoutInflater;

    BaseQuickRecyclerAdapter(Context context) {
        this(context, null);
    }

    BaseQuickRecyclerAdapter(Context context, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getItemView(getLayoutId(viewType), parent);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH viewHolder, int position) {
        convert(position, viewHolder, data.get(position));
    }

    protected View getItemView(int layoutResId, ViewGroup parent) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        return mLayoutInflater.inflate(layoutResId, parent, false);
    }

    private int getLayoutId(int viewType) {
        return layoutResIds.get(viewType);
    }

    public void addItemType(int type, int layoutResId) {
        if (layoutResIds == null) {
            layoutResIds = new SparseArray<>();
        }
        layoutResIds.put(type, layoutResId);
    }

    @SuppressWarnings("unchecked")
    private VH createViewHolder(View view) {
        return (VH) new RecyclerAdapterHelper(context, view);
    }

    public void add(T elem) {
        data.add(elem);
        notifyDataSetChanged();
    }

    public void addAll(List<T> elem) {
        data.addAll(elem);
        notifyDataSetChanged();
    }

    public void set(T oldElem, T newElem) {
        set(data.indexOf(oldElem), newElem);
    }

    public void set(int index, T elem) {
        data.set(index, elem);
        notifyDataSetChanged();
    }

    public void remove(T elem) {
        data.remove(elem);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        data.remove(index);
        notifyDataSetChanged();
    }

    public void replaceAll(List<T> elem) {
        data.clear();
        data.addAll(elem);
        notifyDataSetChanged();
    }

    public boolean contains(T elem) {
        return data.contains(elem);
    }

    /**
     * Clear data list
     */
    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected abstract void convert(int position, VH helper, T item);

    protected abstract int getItemType(int position);

}
