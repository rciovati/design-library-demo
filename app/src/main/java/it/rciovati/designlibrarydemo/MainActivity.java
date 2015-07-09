package it.rciovati.designlibrarydemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    setupRecyclerView();
  }

  private void setupRecyclerView() {
    List<Item> items = Arrays.asList(
        new Item(R.string.title_activity_fab, FloatingActionButtonActivity.class),
        new Item(R.string.title_activity_snackbar, SnackbarActivity.class),
        new Item(R.string.title_activity_text_input_layout, TextInputLayoutActivity.class),
        new Item(R.string.title_activity_navigationview, NavigationViewActivity.class),
        new Item(R.string.title_activity_tab_layout, TabLayoutActivity.class),
        new Item(R.string.title_activity_app_bar_layout, AppBarLayoutActivity.class),
        new Item(R.string.title_activity_collapsing_toolbar_layout, CollapsingToolbarLayoutActivity.class)
    );

    DummyAdapter adapter = new DummyAdapter(this);
    adapter.addAll(items);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
    recyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(layoutManager);
  }

  static class Item {
    private int mNameRes;
    private Class<?> mActivityClass;

    public Item(@StringRes int nameRes, @NonNull Class<?> activityClass) {
      mNameRes = nameRes;
      mActivityClass = activityClass;
    }

    public int getNameRes() {
      return mNameRes;
    }

    public Class<?> getActivityClass() {
      return mActivityClass;
    }
  }

  static class DummyAdapter extends RecyclerView.Adapter<DummyHolder> {

    private List<Item> mItemList;

    private LayoutInflater mInflater;

    private Context mContext;

    public DummyAdapter(Context context) {

      mContext = context;
      mInflater = LayoutInflater.from(context);
      mItemList = new ArrayList<>();
    }

    @Override
    public DummyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
      View v = mInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
      //we bind the default selectable item background, fetching it from the theme attribute
      v.setBackgroundResource(getBackgroundResourceId());
      return new DummyHolder(v);
    }

    @Override
    public void onBindViewHolder(final DummyHolder dummyHolder, int position) {
      final Item item = mItemList.get(position);
      dummyHolder.textView.setText(item.getNameRes());
      dummyHolder.textView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          Intent i = new Intent(mContext, item.getActivityClass());
          mContext.startActivity(i);
        }
      });
    }

    @Override
    public int getItemCount() {
      return mItemList.size();
    }

    public void addAll(List<Item> items) {
      int startIndex = mItemList.size();
      mItemList.addAll(items);
      notifyItemRangeInserted(startIndex, items.size());
    }

    private int getBackgroundResourceId() {
      TypedValue typedValue = new TypedValue();
      int[] backgroundAttr = new int[] { R.attr.selectableItemBackground };

      int index = 0;

      TypedArray a = mContext.obtainStyledAttributes(typedValue.data, backgroundAttr);
      int resourceId = a.getResourceId(index, -1);

      a.recycle();

      return resourceId;
    }
  }

  static class DummyHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public DummyHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }
}
