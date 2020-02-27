package com.example.savenews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsListAdapter.FragmentButtonListener,
SavesListAdapter.FragmentLikeListener{
    private ViewPager pager;

    private PagerAdapter pagerAdapter;
    Fragment f1 = new NewsList();
    Fragment f2 = new SavesList();
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(f1);
        list.add(f2);
        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);
    }

    @Override
    public void myClick(News news, int option) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.pager);
        if (option==1)
            ((SavesList)fragment).saveNews(news);
        else
            ((SavesList)fragment).removeNews(news);
    }

    @Override
    public void removeItemLike(News news) {
        myClick(news, 2);
        ((NewsList)f1).removeLike(news);
    }
}
