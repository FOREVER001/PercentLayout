package client.com.percentlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class RelativeLayoutPercentLayout extends RelativeLayout {
    public RelativeLayoutPercentLayout(Context context) {
        super(context);
    }

    public RelativeLayoutPercentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RelativeLayoutPercentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取父容器的宽和高,百分比布局基于父容器
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
        //遍历子控件，根据百分比设置子控件的LayoutParams
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            ViewGroup.LayoutParams params = child.getLayoutParams();
            if(params instanceof LayoutParams){
                LayoutParams lp= (LayoutParams) params;
                 float widthPercent=lp.widthPercent;
                 float heightPercent=lp.heightPercent;
                 float leftMarginPercent=lp.leftMarginPercent;
                 float rightMarginPercent=lp.rightMarginPercent;
                 float topMarginPercent=lp.topMarginPercent;
                 float bottomMarginPercent=lp.bottomMarginPercent;
                 if(widthPercent>0){
                     params.width= (int) (widthPercent*widthSize);
                 }
                 if(heightPercent>0){
                     params.height= (int) (heightPercent*heightSize);
                 }
                 if(leftMarginPercent>0){
                     ((LayoutParams) params).leftMargin= (int) (leftMarginPercent*widthSize);
                 }
                 if(rightMarginPercent>0){
                     ((LayoutParams) params).rightMargin= (int) (rightMarginPercent*widthSize);
                 }
                 if(topMarginPercent>0){
                     ((LayoutParams) params).topMargin= (int) (topMarginPercent*heightSize);
                 }
                 if(bottomMarginPercent>0){
                     ((LayoutParams) params).bottomMargin= (int) (bottomMarginPercent*heightSize);

                 }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams{
        private float widthPercent;
        private float heightPercent;
        private float leftMarginPercent;
        private float rightMarginPercent;
        private float topMarginPercent;
        private float bottomMarginPercent;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs,
                   R.styleable.RelativeLayoutPercentLayout);
            widthPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_widthPercent,0f);
            heightPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_heightPercent,0f);
            leftMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_leftMarginPercent,0f);
            rightMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_rightMarginPercent,0f);
            topMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_topMarginPercent,0f);
            bottomMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_bottomMarginPercent,0f);
            a.recycle();
        }
    }
}
