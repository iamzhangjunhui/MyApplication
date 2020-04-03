package com.loyo.myapplication.materialDesign.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.loyo.myapplication.R
import com.loyo.myapplication.Util.RadomData
import kotlinx.android.synthetic.main.activity_snack_bar.*

class SnackBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)
        //setTextColor设置提示文字颜色，setBackgroundTint设置SnackBar的背景颜色，setActionTextColor设置点击事件文字颜色
        Snackbar.make(
            coordinator,
            "snackbar 和coordinatorLayout配合，可以支持 snackbar 的更多特性，比如右滑消失，和 FloatingActionButton的自动移动",
            //Snackbar.LENGTH_INDEFINITE不会消失,需要和setAction配合使用,Snackbar.LENGTH_SHORT、Snackbar.LONG和Toast的相似
            Snackbar.LENGTH_INDEFINITE
        ).setTextColor(Color.RED).setBackgroundTint(Color.YELLOW).setActionTextColor(Color.BLUE)
            .setAction("random", View.OnClickListener {
                Toast.makeText(this, RadomData.getRandomData(listOf("kaylee", "huihui", "honghong", "mami", "babi")), Toast.LENGTH_SHORT).show()
            })
            .show()
    }
}
