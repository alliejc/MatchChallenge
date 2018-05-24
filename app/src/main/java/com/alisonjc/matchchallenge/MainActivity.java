package com.alisonjc.matchchallenge;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alisonjc.matchchallenge.adapter.MatchAdapter;
import com.alisonjc.matchchallenge.callback.IMatchSelected;
import com.alisonjc.matchchallenge.model.Datum;
import com.alisonjc.matchchallenge.network.MatchService;
import com.alisonjc.matchchallenge.viewmodel.MatchViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TabLayout mTabLayout;
    private MatchAdapter mAdapter;
    private MatchViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        setUpTabs();
        setUpRecyclerView();
        setUpObservers();
    }


    private void setUpObservers(){
        mModel = ViewModelProviders.of(this).get(MatchViewModel.class);

        final Observer<List<Datum>> datumObserver = new Observer<List<Datum>>() {
            @Override
            public void onChanged(@Nullable final List<Datum> newDatumList) {
                mAdapter.updateAdapter(newDatumList);
            }
        };

        mModel.getDatumList().observe(this, datumObserver);

        final Observer<Integer> tabObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer tabIndex) {
                if(tabIndex != null) {
                    switch (tabIndex) {
                        case 0:
                            mTabLayout.getTabAt(tabIndex).select();
                            mAdapter.updateAdapter(mModel.getDatumList().getValue());
                            break;
                        case 1:
                            mTabLayout.getTabAt(tabIndex).select();
                            mAdapter.updateAdapter(mModel.getTopSixMatches());
                            break;
                        default:
                            break;
                    }
                }
            }
        };
        mModel.getSelectedTab().observe(this, tabObserver);
    }

    private void setUpToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(false);
            bar.setTitle(R.string.search);
        }
    }

    private void setUpTabs(){
        mTabLayout = findViewById(R.id.tab_layout);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        mModel.setSelectedTab(tab.getPosition());
                        break;
                    case 1:
                        mModel.setSelectedTab(tab.getPosition());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MatchAdapter(MainActivity.this, new IMatchSelected() {
            @Override
            public void onSelected(Datum datum) {
                if(!datum.getLiked()){
                    datum.setLiked(true);
                    mAdapter.notifyDataSetChanged();
                } else {
                    datum.setLiked(false);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
        recyclerView.setAdapter(mAdapter);
    }
}
