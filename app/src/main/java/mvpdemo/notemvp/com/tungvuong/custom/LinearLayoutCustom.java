package mvpdemo.notemvp.com.tungvuong.custom;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

public class LinearLayoutCustom extends LinearLayoutManager {

    public LinearLayoutCustom(Context context) {
        super(context, LinearLayoutManager.VERTICAL, false);
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
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new Scroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    private class Scroller extends LinearSmoothScroller {

        private Scroller(Context context) {
            super(context);
        }
    }

    @Override
    public PointF computeScrollVectorForPosition(int targetPosition) {
        return LinearLayoutCustom.this.computeScrollVectorForPosition(targetPosition);
    }
}