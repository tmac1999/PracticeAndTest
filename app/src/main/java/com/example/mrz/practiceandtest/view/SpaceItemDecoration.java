package com.example.mrz.practiceandtest.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mrz on 18/7/5.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;

    /**
     * Retrieve any offsets for the given item. Each field of <code>outRect</code> specifies
     * the number of pixels that the item view should be inset by, similar to padding or margin.
     * The default implementation sets the bounds of outRect to 0 and returns.
     * <p>
     * <p>
     * If this ItemDecoration does not affect the positioning of item views, it should set
     * all four fields of <code>outRect</code> (left, top, right, bottom) to zero
     * before returning.
     * <p>
     * <p>
     * If you need to access Adapter for additional data, you can call
     * {@link RecyclerView#getChildAdapterPosition(View)} to get the adapter position of the
     * View.
     *
     * @param outRect Rect to receive the output.
     * @param view    The child view to decorate
     * @param parent  RecyclerView this ItemDecoration is decorating
     * @param state   The current state of RecyclerView.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        mSpace = 40;
//        if (parent.getChildAdapterPosition(view) % 5 == 4) {
//            outRect.right = mSpace;
//            outRect.left = mSpace / 2;
//        } else if (parent.getChildAdapterPosition(view) % 5 == 0) {
//            outRect.left = mSpace;
//            outRect.right = mSpace / 2;
//        } else {
//
//        }
        outRect.left = mSpace / 2;
        outRect.right = mSpace / 2;
//        if (parent.getChildAdapterPosition(view) % 5 == 0) {
//            outRect.left = mSpace;
//            Log.i("getItemOffsets", "outRect.left" + outRect.left);
//            outRect.right = mSpace;
//        } else {
//            outRect.right = mSpace;
//            outRect.left = 0;
//            Log.i("getItemOffsets", "outRect.right" + outRect.right);
//        }
//        switch (parent.getChildAdapterPosition(view)) {
//            case 0:
//                outRect.left = 0;
//                Log.i("getItemOffsets", "outRect.left" + outRect.left);
//                outRect.right = 0;
//
//                break;
//            case 1:
//                outRect.right = 0;
//                outRect.left = 0;
//                Log.i("getItemOffsets", "outRect.right" + outRect.right);
//                break;
//            case 2:
//                outRect.right = mSpace;
//                outRect.left = mSpace;
//                Log.i("getItemOffsets", "outRect.right" + outRect.right);
//                break;
//            case 3:
//                outRect.right = 0;
//                outRect.left = 0;
//                Log.i("getItemOffsets", "outRect.right" + outRect.right);
//                break;
//            case 4:
//                outRect.right = 0;
//                outRect.left = 0;
//                Log.i("getItemOffsets", "outRect.right" + outRect.right);
//                break;
//        }
//        outRect.bottom = mSpace;
//        if (parent.getChildAdapterPosition(view)==2){
//            outRect.right = mSpace;
//            outRect.left = mSpace;
//        }
//        outRect.left = mSpace;
//        outRect.right = mSpace;
//        outRect.top = 0;
//            if (parent.getChildAdapterPosition(view) == 0) {
//                outRect.bottom = 0;
//            }
//            if (parent.getChildAdapterPosition(view) == lessonOnHomePageList.size() + 1) {
//                //最后一条 loadmore 不设置 offset
//                outRect.top = 0;
//                outRect.bottom = 0;
//            }
    }

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }
}
