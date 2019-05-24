package mvpdemo.notemvp.com.tungvuong.custom;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
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
            layoutParams.height = getHeight();
        }
        return layoutParams;
    }

    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        offsetChildrenHorizontal(dx);
        return dx;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        RecyclerView.SmoothScroller smoothScroller = new Scroll(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private class Scroll extends LinearSmoothScroller {
        private Scroll(Context context) {
            super(context);
        }

        @Nullable
        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return LinearLayoutCustom.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }
}