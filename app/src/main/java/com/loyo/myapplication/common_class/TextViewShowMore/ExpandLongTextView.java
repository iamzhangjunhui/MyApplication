package com.loyo.myapplication.common_class.TextViewShowMore;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;

import com.loyo.myapplication.R;

/**
 * Created by 祥祥 on 2016/8/15.
 */
public class ExpandLongTextView extends androidx.appcompat.widget.AppCompatTextView {

    private String originText;
    private int initWidth = 0;
    String content = "全部内容\t";//这里测试发现当ExpandLongTextView设置的text全为英文或大部分为英文的时候Android 9或Android10的手机需要在末尾添加一个"\t"才能显示完整
    public ExpandLongTextView(Context context) {
        super(context);
    }

    public ExpandLongTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandLongTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private SpannableString ELLIPSIS = null;

    private void init() {


        ELLIPSIS = new SpannableString(content);
        ButtonSpan span = new ButtonSpan(getContext(), new OnClickListener() {
            @Override
            public void onClick(View v) {
                setMaxLines(Integer.MAX_VALUE);
                setText(originText);
            }
        }, R.color.colorAccent);
        ELLIPSIS.setSpan(span, 0, content.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }


    /**
     * 初始化TextView的宽度
     *
     * @param width
     */
    public void initWidth(int width) {
        initWidth = width;
    }

    public void setExpandText(String text) {

        if (null == ELLIPSIS) {
            init();
        }

        originText = text;

        boolean appendShowAll = false;

        int maxLines = getMaxLines();

        String workingText = originText;
        if (maxLines != -1) {
            Layout layout = createWorkingLayout(workingText);
            if (layout.getLineCount() > maxLines) {
                //获取一行显示字符个数，然后截取字符串数
                workingText = originText.substring(0, layout.getLineEnd(maxLines)).trim();
                String showText =workingText+ "..." +content;
                Layout layout2 = createWorkingLayout(showText);
                while (layout2.getLineCount() > maxLines) {
                    int lastSpace = workingText.length() - 1;
                    if (lastSpace == -1) {
                        break;
                    }
                    workingText = workingText.substring(0, lastSpace);
                    layout2 = createWorkingLayout(workingText + "..." + content);
                }
                appendShowAll = true;
                workingText = workingText+ "...";
            }
        }

        setText(workingText);

        if (appendShowAll) {
            // 必须使用append，不能在上面使用+连接，否则spannable会无效
            append(ELLIPSIS);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }


    //返回textview的显示区域的layout，该textview的layout并不会显示出来，只是用其宽度来比较要显示的文字是否过长
    private Layout createWorkingLayout(String workingText) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return StaticLayout.Builder.obtain(workingText, 0, workingText.length(), getPaint(), initWidth - getPaddingStart() - getPaddingEnd())
                    .setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier())
                    .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                    // 注意，在textview里需要设置这两个参数，否则显示会不正常
                    .setBreakStrategy(Layout.BREAK_STRATEGY_HIGH_QUALITY)
                    .setHyphenationFrequency(Layout.HYPHENATION_FREQUENCY_FULL)
                    .build();
        } else {
            return new StaticLayout(workingText, getPaint(), initWidth- getPaddingStart() - getPaddingEnd(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);

        }
    }

}