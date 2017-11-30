package com.sha.kamel.andrutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by sha on 22/10/16.
 */

public final class DiskStorageUtil {

    // TODO: Add this to Manifest
//    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
//    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

    private static final String NAME_OF_DIRECTORY = "profile_pic";
    private static String IMG_EXTENSION_JPEG = ".jpeg";

    public static void save(String fileName, Bitmap imageStream) {
        try {
            File imgFile = new File(getCacheDir(), fileName + IMG_EXTENSION_JPEG);
            imgFile.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(imgFile);
            imageStream.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap load(String fileName) {
        try {
            File cacheDir = getCacheDir();
            if (cacheDir == null) return null;

            File imageFile = new File(cacheDir, fileName + IMG_EXTENSION_JPEG);
            if (!imageFile.exists()) return null;

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean delete(String fileName) {
       return new File(getCacheDir(), fileName + IMG_EXTENSION_JPEG).delete();
    }

    private static File getCacheDir() {
        if (!isExternalStorageWritable()) return null;
        File dir = new File(Environment.getExternalStorageDirectory() + NAME_OF_DIRECTORY);
        if (!dir.exists()) dir.mkdir();
        return dir;
    }

    private static boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                Environment.MEDIA_SHARED.equals(Environment.getExternalStorageState());
    }
    
}
