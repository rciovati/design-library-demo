package it.rciovati.designlibrarydemo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AppBarLayoutActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app_bar_layout);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    setupRecyclerView();
  }
}
