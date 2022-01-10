package jp.co.cte.recyclerviewfloatfxy;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author xiaoyun.fangfenrir-inc.com.cn
 * @date 2022/1/10
 */
public class GolfClubSettingRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Club> listOfClubData = new ArrayList<>();

    private Context context;
    private ClubCount clubCount;

    public GolfClubSettingRecyclerViewAdapter(Context _context, ClubCount _clubCount){
        this.context = _context;
        this.clubCount = _clubCount;
    }

    class SwitchViewHolder extends RecyclerView.ViewHolder{
        TextView clubNameTitleLabel;
        SwitchMaterial clubSwitch;
        public SwitchViewHolder(View view){
            super(view);
            clubNameTitleLabel = view.findViewById(R.id.clubNameTitleLabel);
            clubSwitch = view.findViewById(R.id.clubSwitch);
        }

        public TextView getClubNameTitleLabel() {
            return clubNameTitleLabel;
        }

        public SwitchMaterial getClubSwitch() {
            return clubSwitch;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SwitchViewHolder holder = new SwitchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club, parent, false));
        holder.getClubSwitch().setOnCheckedChangeListener((buttonView, isChecked) -> {
            int position = holder.getLayoutPosition();
            boolean isOverMaxCount = getCheckedCount() > (13);
            if (isChecked && isOverMaxCount){// In this Listener, when checkChanged, the current switch's checkValue will changed behind of this function.
                buttonView.setChecked(false);
                listOfClubData.get(position).setChecked(false);
                showOverMaxNum14Dialog();
            } else {
                listOfClubData.get(position).setChecked(isChecked);
            }
            clubCount.updateClubCount(getCheckedCount());// update the selected clubs count
        });
        return  holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Club golfClubData = listOfClubData.get(position);
        SwitchViewHolder switchViewHolder = (SwitchViewHolder) holder;
        switchViewHolder.getClubNameTitleLabel().setText(golfClubData.getClubName());
        switchViewHolder.getClubSwitch().setChecked(golfClubData.isChecked());
    }

    @Override
    public int getItemCount() {
        return listOfClubData.size();
    }

    public void initData(List<Club> listGolfClubData){
        if (listGolfClubData != null && !listGolfClubData.isEmpty()){
            listOfClubData.clear();
            listOfClubData.addAll(listGolfClubData);
            notifyDataSetChanged();
        }
    }

    // Check the data is over Ｍaximum number: 14
    private int getCheckedCount(){
        int currentChoosedNumber = 0;
        for (Club golfClubData : listOfClubData){
            if (golfClubData.isChecked()){
                currentChoosedNumber++;
            }
        }
        return currentChoosedNumber;
    }

    // Show the overMaxNum-14 Dialog
    private void showOverMaxNum14Dialog(){
        Toast.makeText(context, "ERROR You can only set 14 clubs CLOSE", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<String> getListClub(){
        ArrayList<String> listStrClubName = new ArrayList<>();
        for (Club club : listOfClubData){
            if (club.isChecked()){
                listStrClubName.add(club.getClubName());
            }
        }
        return listStrClubName;
    }

    interface ClubCount{
        void updateClubCount(int count);
    }
}
