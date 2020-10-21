package com.loyo.myapplication

import android.app.AppOpsManager
import android.app.AsyncNotedAppOp
import android.app.SyncNotedAppOp
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.loyo.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    lateinit var attributionContext: Context
    lateinit var  locationManager:LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.click = MainActivityClick(this)
            var data = ObservableField<String>()
            data.set("KAYLEE")
            it.data = data
            it.item = "kaylee"
            btnEmail.setOnClickListener{
                val uri = Uri.parse("mailto:1126238932@qq.com")
                //使用Intent.ACTION_SEND的会调起非邮箱应用
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                startActivity(intent)
            }
            /**
             * 以下讲解的是加载lottie动画的几种方式
             */
            //动态加载assets文件json动画
//            lottie_view.setAnimation("raw/loader.json")
            //动态加载raw中的动画
//            lottie_view.setAnimation(R.raw.loader)
            //加载json字符串
//            val s="{\"v\":\"5.5.7\",\"meta\":{\"g\":\"LottieFiles AE \",\"a\":\"\",\"k\":\"\",\"d\":\"\",\"tc\":\"\"},\"fr\":18,\"ip\":0,\"op\":73,\"w\":600,\"h\":600,\"nm\":\"loopate\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":3,\"nm\":\"NULL CONTROL \",\"parent\":4,\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":0,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[-10,0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[50,50,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"ip\":0,\"op\":73,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"dotR\",\"parent\":1,\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":180,\"ix\":10},\"p\":{\"a\":0,\"k\":[60,50,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[10,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"d\":1,\"ty\":\"el\",\"s\":{\"a\":0,\"k\":[71,71],\"ix\":2},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":3},\"nm\":\"Ellipse Path 1\",\"mn\":\"ADBE Vector Shape - Ellipse\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.494118006089,0.517646998985,0.56470600203,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":0,\"ix\":5},\"lc\":1,\"lj\":1,\"ml\":4,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[0.113725490196,0.207843137255,0.341176470588,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"Fill 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[-75,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Ellipse 1\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":73,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"dotL\",\"parent\":2,\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":-180,\"ix\":10},\"p\":{\"a\":0,\"k\":[10.25,0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[10,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"d\":1,\"ty\":\"el\",\"s\":{\"a\":0,\"k\":[90,90],\"ix\":2,\"x\":\"var \$bm_rt;\\n\$bm_rt = thisComp.layer('dotR').content('Ellipse 1').content('Ellipse Path 1').size;\"},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":3},\"nm\":\"Ellipse Path 1\",\"mn\":\"ADBE Vector Shape - Ellipse\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.494118006089,0.517646998985,0.56470600203,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":0,\"ix\":5},\"lc\":1,\"lj\":1,\"ml\":4,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[0.113725490196,0.207843137255,0.341176470588,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"Fill 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[-75,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Ellipse 1\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":73,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"8\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"t\":72,\"s\":[-720]}],\"ix\":10},\"p\":{\"a\":0,\"k\":[310,280,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,-47.225],[-47.225,0],[0,47.225],[47.225,0],[0,-47.225],[47.225,0],[0,47.225],[-47.225,0]],\"o\":[[0,47.225],[47.225,0],[0,-47.225],[-47.225,0],[0,47.225],[-47.225,0],[0,-47.225],[47.225,0]],\"v\":[[0,0],[85.509,85.509],[171.018,0],[85.509,-85.509],[0,0],[-85.509,85.509],[-171.018,0],[-85.509,-85.509]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.901960784314,0.223529411765,0.274509803922,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":71,\"ix\":5},\"lc\":1,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":0,\"k\":50,\"ix\":1},\"e\":{\"a\":0,\"k\":75,\"ix\":2},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"t\":72,\"s\":[720]}],\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false}],\"ip\":0,\"op\":73,\"st\":0,\"bm\":0}],\"markers\":[]}"
//            lottie_view.setAnimationFromJson(s)
            //加载url
            lottie_view.setAnimationFromUrl("https://cqz-1256838880.cos.ap-shanghai.myqcloud.com/bird1.json")

        }
        /**
         * android  11 (数据访问审核（每次访问运行时权限的时候的回调） https://blog.csdn.net/u014540814/article/details/107178890/)
         */
        //创建归因（attribute）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            attributionContext = createAttributionContext("shareLocation")
            //监听事件
            val appOpsCallback = object : AppOpsManager.OnOpNotedCallback() {
                private fun logPrivateDataAccess(
                    opCode: String, attributionTag: String, trace: String
                ) {
                    Log.i(
                        TAG, "Private data accessed. " +
                                "Operation: $opCode\n " +
                                "Attribution Tag:$attributionTag\nStack Trace:\n$trace"
                    )
                }

                override fun onNoted(syncNotedAppOp: SyncNotedAppOp) {
                    syncNotedAppOp.attributionTag?.let {
                        logPrivateDataAccess(
                            syncNotedAppOp.op,
                            it,
                            Throwable().stackTrace.toString()
                        )
                    }
                }

                override fun onSelfNoted(syncNotedAppOp: SyncNotedAppOp) {
                    syncNotedAppOp.attributionTag?.let {
                        logPrivateDataAccess(
                            syncNotedAppOp.op,
                            it,
                            Throwable().stackTrace.toString()
                        )
                    }
                }

                override fun onAsyncNoted(asyncNotedAppOp: AsyncNotedAppOp) {
                    asyncNotedAppOp.attributionTag?.let {
                        logPrivateDataAccess(
                            asyncNotedAppOp.op,
                            it,
                            asyncNotedAppOp.message
                        )
                    }
                }
            }

            //开启私密数据监听
            val appOpsManager =
                getSystemService(AppOpsManager::class.java) as AppOpsManager
            appOpsManager.setOnOpNotedCallback(mainExecutor, appOpsCallback)

            btnOp.setOnClickListener {
                getLocation()
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun getLocation() {

        locationManager = attributionContext.getSystemService(
            LocationManager::class.java
        ) as LocationManager
        if (PackageManager.PERMISSION_GRANTED != checkPermission(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.os.Process.myPid(),
                android.os.Process.myUid()
            )
        ) {

            //activity中申请权限
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                1
            )

        }else {
            val location: Location? =
                locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (location != null) {
                Log.i(TAG, "${location.latitude}")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==1&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            val location: Location? =
                locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (location != null) {
                Log.i(TAG, "${location.latitude}")
            }
        }

    }

}
