package jp.co.cte.recyclerviewfloatfxy.recyclerviewitemdecoration;

import android.view.View;

import java.util.List;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author xiaoyun.fangfenrir-inc.com.cn
 * @date 2022/1/10
 */
public class ClickInfo {
    public int mBottom;
    public int mGroupId = View.NO_ID;

    /**
     * 详细信息
     * 对应的子view坐标信息
     */
    public List<DetailInfo> mDetailInfoList;

    public ClickInfo(int bottom) {
        this.mBottom = bottom;
    }

    public ClickInfo(int bottom, List<DetailInfo> detailInfoList) {
        mBottom = bottom;
        mDetailInfoList = detailInfoList;
    }

    public static class DetailInfo {

        public int id;
        public int left;
        public int right;
        public int top;
        public int bottom;

        public DetailInfo(int id, int left, int right, int top, int bottom) {
            this.id = id;
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
        }
    }
}
