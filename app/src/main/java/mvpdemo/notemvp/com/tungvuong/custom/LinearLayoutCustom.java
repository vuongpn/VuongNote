package mvpdemo.notemvp.com.tungvuong.custom;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LinearLayoutCustom extends LinearLayoutManager {

    public LinearLayoutCustom(Context context) {
        super(context);
    }

    @Override
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int delta=-dy;
        offsetChildrenVertical(delta);
        return dy;
    }

}