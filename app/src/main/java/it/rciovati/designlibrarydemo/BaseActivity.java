package it.rciovati.designlibrarydemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

  protected void setupRecyclerView() {
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
    recyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setAdapter(new DummyAdapter(this));
    recyclerView.setLayoutManager(layoutManager);
  }

  static class DummyAdapter extends RecyclerView.Adapter<DummyHolder> {

    private LayoutInflater mInflater;

    public DummyAdapter(Context context) {
      mInflater = LayoutInflater.from(context);
    }

    @Override public DummyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
      View v = mInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
      return new DummyHolder(v);
    }

    @Override public void onBindViewHolder(DummyHolder dummyHolder, int position) {
      dummyHolder.textView.setText("Item " + (position + 1));
    }

    @Override public int getItemCount() {
      return 20;
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
