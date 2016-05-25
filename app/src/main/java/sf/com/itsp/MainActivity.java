package sf.com.itsp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

import sf.com.itsp.adapter.TabPageIndicatorAdapter;
import sf.com.itsp.fragment.OtherFragment;
import sf.com.itsp.fragment.TaskFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_paper);
        TabPageIndicatorAdapter tabpageIndicatorAdapter = initFragment();
        viewPager.setAdapter(tabpageIndicatorAdapter);

        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }

    private TabPageIndicatorAdapter initFragment() {
        TabPageIndicatorAdapter tabpageIndicatorAdapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
        TaskFragment taskFragment = new TaskFragment();
        OtherFragment testFragment = new OtherFragment();
        tabpageIndicatorAdapter.addFragment("执行任务", taskFragment);
        tabpageIndicatorAdapter.addFragment("其他", testFragment);
        return tabpageIndicatorAdapter;
    }
}