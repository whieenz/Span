package com.whieenz.span;


/**
 * Created by heziwen on 2017/8/11.
 */

public class SpanClickableSpan extends ClickableSpanNoUnderline {

    private String urlString;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    private int tag;

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public SpanClickableSpan(int color, OnClickListener onClickListener) {
        super(color, onClickListener);
    }

    public SpanClickableSpan(OnClickListener onClickListener) {
        super(onClickListener);
    }

}