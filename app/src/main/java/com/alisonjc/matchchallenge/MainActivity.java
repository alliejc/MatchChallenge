package com.alisonjc.matchchallenge;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.alisonjc.matchchallenge.adapter.MatchAdapter;
import com.alisonjc.matchchallenge.callback.IMatchSelected;
import com.alisonjc.matchchallenge.model.Datum;
import com.alisonjc.matchchallenge.model.MatchSample;
import com.alisonjc.matchchallenge.network.MatchService;
import com.alisonjc.matchchallenge.util.SharedPrefHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TabLayout mTabLayout;
    private MatchAdapter mAdapter;
    private MatchService mMatchService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMatchService = MatchService.getMatchService();

        setUpToolbar();
        setUpTabs();
        setUpRecyclerView();
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

    private void getMatches(){
    Call call = mMatchService.getMatches();
    call.enqueue(new Callback<MatchSample>() {
        @Override
        public void onResponse(Call<MatchSample> call, Response<MatchSample> response) {
            if(response.isSuccessful()){
                mAdapter.updateAdapter(response.body().getData());
            }
        }

        @Override
        public void onFailure(Call call, Throwable t) {
            Log.e(TAG, t.getMessage());
        }
    });
    }
    private void setUpTabs(){
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getMatches();
                Toast.makeText(MainActivity.this, String.valueOf(tab.getText()), Toast.LENGTH_LONG).show();

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
                SharedPrefHandler.writeDatumToPrefs(MainActivity.this, datum);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }
}
