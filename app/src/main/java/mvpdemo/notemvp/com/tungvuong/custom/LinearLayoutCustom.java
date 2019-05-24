package mvpdemo.notemvp.com.tungvuong.custom;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class LinearLayoutCustom extends LinearLayoutManager {

    public LinearLayoutCustom(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return LayoutSize(super.generateLayoutParams(lp));
    }

    private RecyclerView.LayoutParams LayoutSize(RecyclerView.LayoutParams layoutParams) {
        if (getOrientation() == VERTICAL) {
            layoutParams.height =getHeight();
        }
        return layoutParams;
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int delta = -dy;

        offsetChildrenHorizontal(delta);

        return -delta / 2;
    }
}