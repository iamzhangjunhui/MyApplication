package com.loyo.myapplication.netStatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.loyo.myapplication.R
import com.loyo.myapplication.databinding.ActivityNetStatusBinding

class NetStatusActivity : AppCompatActivity() {
    var netCount: ObservableInt = ObservableInt(0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityNetStatusBinding>(this, R.layout.activity_net_status).also {

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectManager.registerNetworkCallback(
                NetworkRequest.Builder().build(),
                connectionCallback
            )
        } else {
            val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            registerReceiver(baseReceiver, intentFilter)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectManager.unregisterNetworkCallback(connectionCallback)
        } else {
            unregisterReceiver(baseReceiver)
        }
    }

    //Android5.0及以上的话，使用回调方式监听网络状态
    private val connectManager: ConnectivityManager by lazy { getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    private val connectionCallback: ConnectivityManager.NetworkCallback by lazy {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        object : ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                super.onLost(network)
                netCount.set(netCount.get() - 1)
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                netCount.set(netCount.get() + 1)

            }
        }
    }
    //Android 5.0以下的，使用广播接收器获取网络状态
    private val baseReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            if (TextUtils.equals(action, ConnectivityManager.CONNECTIVITY_ACTION)) {
                val manager: ConnectivityManager =
                    context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetWorkInfo = manager.activeNetworkInfo
                if (activeNetWorkInfo != null && activeNetWorkInfo.isAvailable && activeNetWorkInfo.isConnected) {
                    netCount.set(1)
                } else {
                    netCount.set(0)
                }

            }
        }
    }

}
