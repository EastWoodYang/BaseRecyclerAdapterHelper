# BaseRecyclerAdapterHelper
make RecyclerView.Adapter more convenient


# Usage
**Only One Item View Type**
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
        // add item type type and its layout
        addItemType(1, R.layout.list_item);
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
