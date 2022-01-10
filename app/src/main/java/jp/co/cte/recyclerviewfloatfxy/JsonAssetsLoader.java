package jp.co.cte.recyclerviewfloatfxy;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author xiaoyun.fangfenrir-inc.com.cn
 * @date 2022/1/10
 */
public class JsonAssetsLoader {

    private AssetManager assetManager;
    private Gson gson;

    public JsonAssetsLoader(Context context) {
        assetManager = context.getResources().getAssets();
        gson = new Gson();
    }

    public List<Club> getClubTestData(String fileName, Type type) {
        try {
            //The file must be under 'assets' folder, otherwise AssetManager cannot open it.
            return gson.fromJson(new BufferedReader(new InputStreamReader(assetManager.open(fileName))), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

