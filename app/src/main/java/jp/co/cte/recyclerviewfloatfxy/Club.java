package jp.co.cte.recyclerviewfloatfxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author xiaoyun.fangfenrir-inc.com.cn
 * @date 2022/1/10
 */
public class Club implements Serializable {
    @SerializedName("club_id")
    @Expose
    private int clubId;

    @SerializedName("club_name")
    @Expose
    private String clubName;

    @SerializedName("is_checked")
    @Expose
    private boolean isChecked;

    @SerializedName("club_type")
    @Expose
    private String clubType;

    public Club(int clubId, String clubName, boolean isChecked, String clubType) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.isChecked = isChecked;
        this.clubType = clubType;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getClubType() {
        return clubType;
    }

    public void setClubType(String clubType) { this.clubType = clubType; }
}
