package com.loyo.myapplication.common_class

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.util.AttributeSet
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatTextView
import com.loyo.myapplication.R
import com.loyo.myapplication.common_class.TextViewShowMore.ButtonSpan

class ShowMoreInfoTextView : AppCompatTextView {
    private val content = "查看全文"

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    fun setShowAllText(isShowAll: Boolean, text: String) {
        if (isShowAll || text.length <= 50) {
            setText(text)
        } else {
            setText(text.substring(0, 50))
            val ELLIPSIS = SpannableString(content)
            val span = ButtonSpan(context, OnClickListener {
                setText(text)
            }, R.color.colorAccent)
            ELLIPSIS.setSpan(span, 0, content.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            append("...")
            append(ELLIPSIS)
            movementMethod = LinkMovementMethod.getInstance()


        }
    }

}