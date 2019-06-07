package client.com.percentlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LinearLayoutPercent extends LinearLayout {
    public LinearLayoutPercent(Context context) {
        super(context);
    }

    public LinearLayoutPercent(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutPercent(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            ViewGroup.LayoutParams params = child.getLayoutParams();
            if(params instanceof LayoutParams){
                LayoutParams lp= (LayoutParams) params;
                 float widhtPercent=lp.widhtPercent;
                 float heightPercent=lp.heightPercent;
                 float leftMarginPercent=lp.leftMarginPercent;
                 float rightMarginPercent=lp.rightMarginPercent;
                 float topMarginPercent=lp.topMarginPercent;
                 float bottomMarginPercent=lp.bottomMarginPercent;

                 if(widhtPercent>0){
                     params.width= (int) (widthSize*widhtPercent);
                 }

                if(heightPercent>0){
                    params.height= (int) (heightSize*heightPercent);
                }
                if(leftMarginPercent>0){
                    ((LayoutParams) params).leftMargin= (int) (widthSize*leftMarginPercent);
                }
                if(rightMarginPercent>0){
                        ((LayoutParams) params).rightMargin= (int) (widthSize*rightMarginPercent);
                }
                if(topMarginPercent>0){
                    ((LayoutParams) params).topMargin= (int) (heightSize*topMarginPercent);
                }
                if(bottomMarginPercent>0){
                    ((LayoutParams) params).bottomMargin= (int) (heightSize*bottomMarginPercent);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LinearLayoutPercent.LayoutParams(getContext(),attrs);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams{
        private float widhtPercent;
        private float heightPercent;
        private float leftMarginPercent;
        private float rightMarginPercent;
        private float topMarginPercent;
        private float bottomMarginPercent;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a =
                    c.obtainStyledAttributes(attrs, R.styleable.RelativeLayoutPercentLayout);
            widhtPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_widthPercent,0f);
            heightPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_heightPercent,0f);
            leftMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_leftMarginPercent,0f);
            rightMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_rightMarginPercent,0f);
            topMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_topMarginPercent,0f);
            bottomMarginPercent=a.getFloat(R.styleable.RelativeLayoutPercentLayout_layout_bottomMarginPercent,0f);
            a.recycle();
        }
    }

}
