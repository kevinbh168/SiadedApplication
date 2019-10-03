package com.brena.siadedapplication.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.brena.siadedapplication.R;
import com.brena.siadedapplication.model.Social;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataGenerator {
    public static List<Social> getSocialData(Context ctx) {
        List<Social> items = new ArrayList<>();
        String name_arr[] = ctx.getResources().getStringArray(R.array.social_names);

        for (int i = 0; i < name_arr.length; i++) {
            Social obj = new Social();
            obj.name = name_arr[i];
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }
}
