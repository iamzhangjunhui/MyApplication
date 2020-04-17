package com.loyo.myapplication.android_q;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveImageUtil {
    public static void saveToSystemGallery(Bitmap bmp, AppCompatActivity activity) {
        // 首先保存图片
        File fileDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String fileName = System.currentTimeMillis() + ".jpg";
        //存储路径：手机存储/Android/data/com.loyo.myapplication/files/Pictures/xxx.jpg
        File file = new File(fileDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 其次把文件插入到系统图库（需要写权限）
//        try {
//            MediaStore.Images.Media.insertImage(activity.getContentResolver(),
//                    file.getAbsolutePath(), fileName, null);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 最后通知图库更新
//        //sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(file.getAbsolutePath())));
//        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        Uri uri = Uri.fromFile(file);
//        intent.setData(uri);
//        context.sendBroadcast(intent);
//        //图片保存成功，图片路径：
//        Toast.makeText(context,
//                "图片保存路径：" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
    }

}
