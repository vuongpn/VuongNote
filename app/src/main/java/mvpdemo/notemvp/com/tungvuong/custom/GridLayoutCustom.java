package mvpdemo.notemvp.com.tungvuong.custom;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

public class GridLayoutCustom extends GridLayoutManager {

    public GridLayoutCustom(Context context, int spanCount) {
        super(context, spanCount);
    }

    @Override
    protected boolean isLayoutRTL() {
        return true;
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public boolean canScrollHorizontally() {
        return false;
    }
}
