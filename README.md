# BaseRecyclerAdapterHelper
make RecyclerView.Adapter more convenient


# Get it
available on Maven Central
```
    <dependency>
      <groupId>com.ycdyng.android</groupId>
      <artifactId>base-recycler-adapter-helper</artifactId>
      <version>1.0.0</version>
      <type>pom</type>
    </dependency>
```

or 

```
    compile 'com.ycdyng.android:base-recycler-adapter-helper:1.0.0'
```

# Usage
**One Item View Type**
```
mQuickRecyclerAdapter = new QuickRecyclerAdapter<DataModel>(this, R.layout.item, mDataModelList) {
    
    @Override
    protected void convert(int position, RecyclerAdapterHelper helper, DataModel data) {
        helper.setText(R.id.textView1, data.getValues());
    }
};
```

**Multiple Item View Type**
```
mQuickRecyclerMultiAdapter = new QuickRecyclerMultiAdapter<DataModel>(this, mDataModelList) {

    @Override
    protected void setItemViewType() {
        // add item view type and its layout
        addItemType(1, R.layout.list_item_1);
        addItemType(2, R.layout.list_item_2);
    }

    @Override
    protected int getItemType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    protected void convert(int position, RecyclerAdapterHelper helper, DataModel data) {
        helper.setText(R.id.textView1, data.getValues());
    }
};
```

# Thanks
[JoanZapata / base-adapter-helper](https://github.com/JoanZapata/base-adapter-helper)
