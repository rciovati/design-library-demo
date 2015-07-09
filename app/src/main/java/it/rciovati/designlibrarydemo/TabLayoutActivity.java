package it.rciovati.designlibrarydemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabLayoutActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tab_layout);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DummyPagerAdapter adapter = new DummyPagerAdapter(getSupportFragmentManager());

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setAdapter(adapter);

    final Resources res = getResources();

    int normalColor = res.getColor(R.color.dark_grey);
    int selectedColor = res.getColor(android.R.color.white);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
    tabLayout.setTabTextColors(normalColor, selectedColor);
    tabLayout.setupWithViewPager(viewPager);
  }

  static class DummyPagerAdapter extends FragmentPagerAdapter {

    public DummyPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {
      return DummyFragment.newInstance(position + 1);
    }

    @Override public int getCount() {
      return 4;
    }

    @Override public CharSequence getPageTitle(int position) {
      return "Title " + (position + 1);
    }
  }

  static class DummyFragment extends Fragment {

    private static final String KEY = "key";

    public static DummyFragment newInstance(int number) {
      Bundle b = new Bundle();
      b.putInt(KEY, number);
      DummyFragment f = new DummyFragment();
      f.setArguments(b);
      return f;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

      TextView tv = new AppCompatTextView(container.getContext());
      tv.setText("Item " + getArguments().getInt(KEY));
      tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
          ViewGroup.LayoutParams.MATCH_PARENT));
      tv.setGravity(Gravity.CENTER);

      return tv;
    }
  }
}
