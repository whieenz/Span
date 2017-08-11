package com.whieenz.span;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    HzwSpan hzwSpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        hzwSpan = new HzwSpan();
        hzwSpan.setTextView(textView);
    }
//    SpannableStringBuilder s = new SpannableStringBuilder();
    public void click(View view){

        hzwSpan.addSpan("测试库", new HzwSpan.OnClickListener() {
            @Override
            public void onClick(View widget, SpanClickableSpan span) {
                Toast.makeText(MainActivity.this,"点击了"+span.getTag(),Toast.LENGTH_SHORT).show();
            }
        }).create();
    }

//    private void updateText() {
//        SpannableStringBuilder ss = new SpannableStringBuilder();
//        for (SpanBean sb:
//                spanBeans) {
//            ss.append(sb.getSpan());
//            ss.append(" ");
//        }
//        textView.setText(ss);
//        textView.setMovementMethod(LinkMovementMethod.getInstance());
//    }
//
//    private SpannableString mode() {
//        SpannableString spannableString = new SpannableString("你有新消息了" + "×");
//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "请不要点我", Toast.LENGTH_SHORT).show();
//            }
//        };
//        SpanClickableSpan clickableSpan1 = new SpanClickableSpan(new ClickableSpanNoUnderline.OnClickListener() {
//            @Override
//            public void onClick(View widget, ClickableSpanNoUnderline span) {
//                Toast.makeText(MainActivity.this, "点击了第", Toast.LENGTH_SHORT).show();
//            }
//        });
//        spannableString.setSpan(clickableSpan1, 6, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
//        SubscriptSpan subscriptSpan = new SubscriptSpan();
//        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(0.8f);
//        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ffffff"));
//        spannableString.setSpan(bgColorSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(subscriptSpan, 0, spannableString.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(colorSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(sizeSpan, 6, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(superscriptSpan, 6, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return spannableString;
//    }
//    int tag = 0;
//    List<SpannableString> spans = new ArrayList<>();
//    List<SpanBean> spanBeans = new ArrayList<>();
//    private SpannableString mode(String str) {
//
//        SpannableString spannableString = new SpannableString(str + "×");
//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "请不要点我", Toast.LENGTH_SHORT).show();
//            }
//        };
//        SpanClickableSpan clickableSpan1 = new SpanClickableSpan(new ClickableSpanNoUnderline.OnClickListener<SpanClickableSpan>() {
//            @Override
//            public void onClick(View widget,SpanClickableSpan span) {
//                deleteSpan(span);
//                updateText();
//            }
//        });
//        spannableString.setSpan(clickableSpan1, str.length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
//        SubscriptSpan subscriptSpan = new SubscriptSpan();
//        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(0.8f);
//        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ffffff"));
//        spannableString.setSpan(bgColorSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(subscriptSpan, 0, spannableString.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(colorSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(sizeSpan, str.length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(superscriptSpan, str.length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        clickableSpan1.setTag(tag);
//        spans.add(spannableString);
//        SpanBean spanBean = new SpanBean(spannableString,tag++);
//        spanBeans.add(spanBean);
//        return spannableString;
//    }
//
//    private void deleteSpan(SpanClickableSpan span) {
//        for (int i = 0; i < spanBeans.size(); i++) {
//            if (spanBeans.get(i).getTag() == span.getTag()){
//                spanBeans.remove(spanBeans.get(i));
//            }
//        }
//    }
//
//    SpannableStringBuilder builder = new SpannableStringBuilder();
//    List<String> strs = new ArrayList<>();
}

