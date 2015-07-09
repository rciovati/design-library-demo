package it.rciovati.designlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

public class CollapsingToolbarLayoutActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_collapsing_toolbar_layout);

    final CollapsingToolbarLayout collapsingToolbar =
        (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
    collapsingToolbar.setTitle(getTitle());

    setupRecyclerView();
  }
}
