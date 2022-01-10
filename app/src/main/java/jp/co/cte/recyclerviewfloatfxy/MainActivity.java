package jp.co.cte.recyclerviewfloatfxy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import jp.co.cte.recyclerviewfloatfxy.databinding.ActivityMainBinding;
import jp.co.cte.recyclerviewfloatfxy.recyclerviewitemdecoration.PowerGroupListener;
import jp.co.cte.recyclerviewfloatfxy.recyclerviewitemdecoration.PowerfulStickyDecoration;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private GolfClubSettingRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView(){
        binding.golfToolbar.setNavigationOnClickListener(view->{ onBackPressed();});

        adapter = new GolfClubSettingRecyclerViewAdapter(this, count -> {
            binding.tvCountSelectedClub.setText(String.format("%d/14", count));
        });
        List<Club> listOfClub = getListGolfClubData();
        adapter.initData(listOfClub);

        binding.rvGolfClubSetting.setAdapter(adapter);
        binding.rvGolfClubSetting.setLayoutManager(new LinearLayoutManager(this));

        PowerGroupListener listener = new PowerGroupListener() {
            @Override
            public View getGroupView(int position) {
                View view = getLayoutInflater().inflate(R.layout.item_title, null, false);
                ((TextView)view.findViewById(R.id.tvTitleGolfClubSetting)).setText(listOfClub.get(position).getClubType());
                return view;
            }

            @Override
            public String getGroupName(int position) {
                return listOfClub.get(position).getClubType();
            }
        };
        binding.rvGolfClubSetting.addItemDecoration(PowerfulStickyDecoration.Builder.init(listener).setGroupHeight(dp2px(36)).build());
    }

    private List<Club> getListGolfClubData(){
        List<Club> listGolfClubData = new JsonAssetsLoader(this)
                .getClubTestData("ClubTest.json", new TypeToken<List<Club>>() {}.getType());
        return listGolfClubData;
    }

    private int dp2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}