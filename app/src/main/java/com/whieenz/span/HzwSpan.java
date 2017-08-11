package com.whieenz.span;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


/**
 * Created by heziwen on 2017/8/11.
 */

public class HzwSpan {
    private List<SpanBean> spanBeans;
    private int tag;



    private TextView textView;

    public HzwSpan(){
        spanBeans = new ArrayList<>();
        tag = 0;
    }


    public HzwSpan addSpan(String str, final OnClickListener listener) {

        SpannableString spannableString = new SpannableString(str + "×");
        SpanClickableSpan clickableSpan = new SpanClickableSpan(new ClickableSpanNoUnderline.OnClickListener<SpanClickableSpan>() {
            @Override
            public void onClick(View widget,SpanClickableSpan span) {
                deleteSpan(span);
                updateText();
                listener.onClick(widget,span);
            }
        });
        spannableString.setSpan(clickableSpan, str.length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(0.8f);
        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ffffff"));
        spannableString.setSpan(bgColorSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(subscriptSpan, 0, spannableString.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(colorSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan, str.length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(superscriptSpan, str.length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickableSpan.setTag(tag);
        SpanBean spanBean = new SpanBean(spannableString,tag++);
        spanBeans.add(spanBean);
        return this;
    }
    private void deleteSpan(SpanClickableSpan span) {
        for (int i = 0; i < spanBeans.size(); i++) {
            if (spanBeans.get(i).getTag() == span.getTag()){
                spanBeans.remove(spanBeans.get(i));
            }
        }
    }
    private void updateText() {
        SpannableStringBuilder ss = new SpannableStringBuilder();
        for (SpanBean sb:
                spanBeans) {
            ss.append(sb.getSpan());
            ss.append(" ");
        }
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void create(){
        this.updateText();
    }
    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    /**
     * 回调接口，回调自身的onClick事件
     * 告诉外部 是否被点击
     */
    public interface OnClickListener {
        /**
         * ClickableSpan被点击
         *
         * @param widget widget
         */
        void onClick(View widget,SpanClickableSpan span);
    }
}
