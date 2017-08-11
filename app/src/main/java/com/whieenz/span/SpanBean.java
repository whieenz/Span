package com.whieenz.span;

import android.text.SpannableString;

/**
 * Created by heziwen on 2017/8/11.
 */

public class SpanBean {
    private SpannableString span;


    public SpanBean(SpannableString span, int tag) {
        this.span = span;
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public SpannableString getSpan() {
        return span;
    }

    public void setSpan(SpannableString span) {
        this.span = span;
    }

    private int tag;

}
