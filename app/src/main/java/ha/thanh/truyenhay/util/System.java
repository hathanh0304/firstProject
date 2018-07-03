package ha.thanh.truyenhay.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by VCCORP on 7/3/2018.
 */

public class System {
    public static int height = 0;
    public static int width = 0;
    public static int READ_MODE = 1;
    public static int PREVIEW_MODE = 0;

    public static int dpToPx(Activity context,  int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int pxToDp(Activity context,int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
