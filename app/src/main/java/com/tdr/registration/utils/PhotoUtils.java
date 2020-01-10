package com.tdr.registration.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.WindowManager;


import com.parry.utils.code.SDCardUtils;
import com.parry.utils.code.ToastUtils;
import com.tdr.registration.R;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//import id.zelory.compressor.Compressor;


/**
 * 处理照片工具类
 */

public class PhotoUtils {
    public final static int CAMERA_REQESTCODE = 2017;//照相机回调值
    public final static int REQUEST_CODE_CHOOSE = 2300;//照相机回调值
    public static File imageFile;//照片临时文件
    public static String mCurrentPhotoPath;//临时文件地址
    public static String mPicName;
    public static String photoStr;
    public static int CurrentapiVersion = Build.VERSION.SDK_INT;
    private static String photoPath;

    public static void TakePicture(Activity mActivity, String picName) {
        mPicName = picName;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(mActivity.getPackageManager()) != null) {//判断是否有相机应用
            try {

                imageFile = createImageFile(mActivity, mPicName);//创建临时图片文件
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (imageFile != null) {

                Uri photoURI = FileProvider.getUriForFile(mActivity, "com.tdr.chongwu", imageFile);
                List<ResolveInfo> resInfoList = mActivity.getPackageManager().queryIntentActivities(takePictureIntent, PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo resolveInfo : resInfoList) {
                    String packageName = resolveInfo.activityInfo.packageName;
                    mActivity.grantUriPermission(packageName, photoURI,
                            Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                mActivity.startActivityForResult(takePictureIntent, CAMERA_REQESTCODE);
            }
        }
    }

    public static void TakePicture2(Activity mActivity, String picName) {
        mPicName = picName;
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        mActivity.startActivityForResult(intent, CAMERA_REQESTCODE);

        Intent intentToCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intentToCamera.resolveActivity(mActivity.getPackageManager()) != null) {//判断是否有相机应用
            try {
//                photoPath = Environment.getExternalStorageDirectory() + "/registration/+"+picName+".jpg"; //拍照文件保存路径

                imageFile = createImageFile(mActivity, mPicName);//创建临时图片文件
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (SDCardUtils.isSDCardEnable()) {
//                Uri uri = Uri.fromFile(imageFile);
//                intentToCamera.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intentToCamera.setDataAndType(uri, "application/vnd.android.package-archive");

                intentToCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
                mActivity.startActivityForResult(intentToCamera, CAMERA_REQESTCODE);
            } else {
                ToastUtils.showShort("温馨提示：请检查sdcard是否存在");
            }
        }

    }

    public static void doPhotoSelectAlbum(Activity mActivity) {
        Matisse.from(mActivity)
                .choose(MimeType.ofImage(), false)
                .theme(R.style.Matisse_Zhihu)
                .countable(true)
                .capture(true)
                .captureStrategy(new CaptureStrategy(true, "com.tdr.registration"))
                .maxSelectable(3)
                //                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(UIUtils.dp2px(120))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }

    public static void sevephoto(final Bitmap bitmap) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File f = new File(Environment.getExternalStorageDirectory()
                        + "/Registration/" + mPicName + ".jpg");


                FileOutputStream fOut = null;
                try {
                    fOut = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private static File createImageFile(Activity mActivity, String picName) throws Exception {
        File storageDir = mActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = new File(storageDir, picName + ".jpg");
        try {
            mCurrentPhotoPath = image.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return image;
    }

    /**
     * 读取图片属性：旋转的角度
     *
     * @return degree旋转的角度
     */
    public static int readPictureDegree() {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(mCurrentPhotoPath);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 旋转图片
     *
     * @param angle
     * @param bitmap
     * @return Bitmap
     */
    public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
        // 旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        System.out.println("angle2=" + angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }

    public static Bitmap getBitmapFromFile(File dst) {
        return getBitmapFromFile(dst, 1300f, 1300f);//(720*1280)
    }

    /**
     * 读取本地图片
     *
     * @param dst
     * @param width
     * @param height
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Bitmap getBitmapFromFile(File dst, float width, float height) {
        if (null != dst && dst.exists()) {
            BitmapFactory.Options opts = null;
            if (width > 0 && height > 0) {
                opts = new BitmapFactory.Options();
                opts.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(dst.getPath(), opts);


                int originalWidth = opts.outWidth;
                int originalHeight = opts.outHeight;
                if ((originalWidth == -1) || (originalHeight == -1))
                    return null;

                //图片分辨率标准
                float hh = width;//这里设置高度
                float ww = height;//这里设置宽度
                //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
                int be = 1;//be=1表示不缩放
                if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
                    be = (int) (originalWidth / ww);

                } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
                    be = (int) (originalHeight / hh);

                }
                if (be <= 0)
                    be = 1;


                // 计算图片缩放比例
//                final int minSideLength = Math.min(width, height);
//                opts.inSampleSize = computeSampleSize(opts, minSideLength, width * height);
                opts.inSampleSize = be;
                opts.inJustDecodeBounds = false;
                opts.inInputShareable = true;
                opts.inPurgeable = true;
                opts.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional

            }
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(dst.getPath(), opts);

                return compressImage(bitmap);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);

        int roundedSize;
        if (initialSize <= 8) {
            roundedSize = 1;
            while (true) {
                if (roundedSize >= initialSize)
                    return roundedSize;
                roundedSize <<= 1;
            }
        }

        return 8 * ((initialSize + 7) / 8);
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        double w = options.outWidth;
        double h = options.outHeight;

        int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == -1) ? 128
                : (int) Math.min(Math.floor(w / minSideLength), Math.floor(h / minSideLength));

        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
            return 1;
        } else if (minSideLength == -1) {
            return lowerBound;
        } else {
            return upperBound;
        }
    }

    public static void DeletePhoto(File file) {
        if (file.isFile()) {
            if (isphoto(file.getName())) {
                file.delete();
            }
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                if (isphoto(file.getName())) {
                    file.delete();
                }
                return;
            }
            for (File f : childFile) {
                DeletePhoto(f);
            }
            if (isphoto(file.getName())) {
                file.delete();
            }
        }
    }

    private static boolean isphoto(String fName) {
        boolean isPhoto = false;
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("jpg") || FileEnd.equals("png") || FileEnd.equals("gif")
                || FileEnd.equals("jpeg") || FileEnd.equals("bmp") || FileEnd.equals("webp")) {
            isPhoto = true;
        }
        return isPhoto;
    }

    public static Bitmap getPhotoBitmap() {
//        try {
//            mLog.e("PhotoUtils.imageFile.getAbsolutePath()=" + PhotoUtils.imageFile.getAbsolutePath());
        int degree = readPictureDegree();
        Bitmap b = getBitmapFromFile(imageFile);


        Bitmap bitmap = rotaingImageView(degree, b);
//        mPicName = Utils.getFileName(imageFile.getPath());

        return bitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
    }



    public static void seve(final Bitmap bitmap, final String Name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File f = new File(Environment.getExternalStorageDirectory()
                        + "/Registration/" + Name + ".webp");
                FileOutputStream fOut = null;
                try {
                    fOut = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.WEBP, 100, fOut);
                    fOut.flush();
                    fOut.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static Bitmap getPhotoBitmap(Intent data) {
//        Bundle bundle = data.getExtras();
        Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
//        Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
//        Bitmap b = zoomImg(bitmap, 600, 800);

        bitmap = compressImage(bitmap);
//        photoStr = Utils.Byte2Str(Utils.Bitmap2Bytes(bitmap));

        return bitmap;
    }

    /**
     * 图片与屏幕的宽高差距比例
     *
     * @param mActivity
     * @param options
     * @return
     */
    public static int calculateInSampleSize(Activity mActivity, Bitmap options) {
        // 源图片的高度和宽度
        int bitmapheight = options.getHeight();
        int bitmapwidth = options.getWidth();
        int inSampleSize = 1;
        WindowManager wm = (WindowManager) mActivity.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        if (bitmapheight > height || bitmapwidth > width) {
            // 计算出实际宽高和目标宽高的比率
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > height && (halfWidth / inSampleSize) > width) {
                inSampleSize *= 2;
            }
        } else {

            int heightRatio = Math.round(height / bitmapheight);
            int widthRatio = Math.round(width / bitmapwidth);

            if (heightRatio > widthRatio) {
                inSampleSize = widthRatio;
            } else {
                inSampleSize = heightRatio;
            }
        }

        return inSampleSize;
    }

    public static long getFileSize(File file) throws Exception {
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        } else {
            file.createNewFile();

        }
        return size;
    }

    public static Bitmap zoomImg(File F, int newWidth, int newHeight) {
        Bitmap bm = BitmapFactory.decodeFile(F.getAbsolutePath());

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return zoomImg(bm, newWidth, newHeight);
    }

    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {

        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }

    /**
     * 得到bitmap的大小
     */
    public static int getBitmapSize(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {    //API 19
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {//API 12
            return bitmap.getByteCount();
        }
        // 在低版本中用一行的字节x高度
        return bitmap.getRowBytes() * bitmap.getHeight();                //earlier version
    }

    public static int getRatioSize(int bitWidth, int bitHeight) {
        // 图片最大分辨率
        int imageHeight = 800;
        int imageWidth = 600;
        // 缩放比
        int ratio = 1;
        // 缩放比,由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        if (bitWidth > bitHeight && bitWidth > imageWidth) {
            // 如果图片宽度比高度大,以宽度为基准
            ratio = bitWidth / imageWidth;
        } else if (bitWidth < bitHeight && bitHeight > imageHeight) {
            // 如果图片高度比宽度大，以高度为基准
            ratio = bitHeight / imageHeight;
        }
        // 最小比率为1
        if (ratio <= 0)
            ratio = 1;
        return ratio;
    }

    public static void compressImageToFile(Bitmap bmp, File file) {
        // 0-100 100为不压缩
        int options = 100;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Bitmap compressBitmap(File F) {
        return compressBitmap(BitmapFactory.decodeFile(F.getAbsolutePath()));
    }

    public static Bitmap compressBitmap(Bitmap image) {
        // 最大图片大小 100KB
        int maxSize = 50;
        // 获取尺寸压缩倍数
        int ratio = getRatioSize(image.getWidth(), image.getHeight());
        // 压缩Bitmap到对应尺寸
        Bitmap result = Bitmap.createBitmap(image.getWidth() / ratio, image.getHeight() / ratio, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, image.getWidth() / ratio, image.getHeight() / ratio);
        canvas.drawBitmap(image, null, rect, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 70;
        result.compress(Bitmap.CompressFormat.JPEG, options, baos);
        // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
        int l = baos.toByteArray().length;
        while (baos.toByteArray().length / 400 > maxSize) {
            // 重置baos即清空baos
            baos.reset();
            // 每次都减少10
//            options -= 10;
            // 这里压缩options%，把压缩后的数据存放到baos中
            result.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        }
        // JNI调用保存图片到SD卡 这个关键
//        saveBitmap(result, options, filePath, true);
        // 释放Bitmap
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ImageView设置优化内存使用后的Bitmap
     * 返回一个等同于ImageView宽高的bitmap
     *
     * @param
     * @param imgPath 图像路径
     * @param
     */
    public static Bitmap imageViewSetThreadPic(final String imgPath) {


        // 设置参数
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 只获取图片的大小信息，而不是将整张图片载入在内存中，避免内存溢出
        BitmapFactory.decodeFile(imgPath, options);
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 2; // 默认像素压缩比例，压缩为原图的1/2
        int minLen = Math.min(height, width); // 原图的最小边长
        if (minLen > 700) { // 如果原始图像的最小边长大于100dp（此处单位我认为是dp，而非px）
            float ratio = (float) minLen / 700.0f; // 计算像素压缩比例
            inSampleSize = (int) ratio;
        }
        options.inJustDecodeBounds = false; // 计算好压缩比例后，这次可以去加载原图了
        options.inSampleSize = inSampleSize; // 设置为刚才计算的压缩比例
        Bitmap bm = BitmapFactory.decodeFile(imgPath, options); // 解码文件
        try {
            Log.w("TAG", "size: " + bm.getByteCount() + " width: " + bm.getWidth() + " heigth:" + bm.getHeight()); // 输出图像数据
//            photoStr = Utils.Byte2Str(Utils.Bitmap2Bytes(bm));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bm;
    }


    /**
     * 通过uri获取图片并进行压缩
     *
     * @param uri
     */
    public static Bitmap getBitmapFormUri(Activity ac, Uri uri) throws FileNotFoundException, IOException {
        InputStream input = ac.getContentResolver().openInputStream(uri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        onlyBoundsOptions.inPurgeable = true;// 允许可清除
        onlyBoundsOptions.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果

        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;
        //图片分辨率标准
        float hh = 1300f;//这里设置高度
        float ww = 1300f;//这里设置宽度
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
//        bitmapOptions.outWidth = 1300;
//        bitmapOptions.outHeight =
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = ac.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return compressImage(bitmap);


    }

    /**
     * 通过uri获取图片并进行压缩
     *
     * @param
     */
    public static Bitmap getBitmapFormUri(File dst) throws FileNotFoundException, IOException {
//        InputStream input = ac.getContentResolver().openInputStream(uri);
        FileInputStream stream = new FileInputStream(dst);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        onlyBoundsOptions.inPurgeable = true;// 允许可清除
        onlyBoundsOptions.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果

        BitmapFactory.decodeStream(stream, null, onlyBoundsOptions);
        stream.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;
        //图片分辨率标准
        float hh = 1200f;//这里设置高度
        float ww = 1200f;//这里设置宽度
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
//        bitmapOptions.outWidth = 1300;
//        bitmapOptions.outHeight =
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        stream = new FileInputStream(dst);
        Bitmap bitmap = BitmapFactory.decodeStream(stream, null, bitmapOptions);
        stream.close();

        try {
//            LogUtilP.i("size:11== " + bitmap.getByteCount() +
//                    "==outHeight===" + bitmapOptions.outHeight + "==outWidth===" + bitmapOptions.outWidth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return compressImage(bitmap);


    }

    /**
     * 通过bitmap获取图片并进行压缩
     *
     * @param
     */
    public static Bitmap getBitmapFormBitmap(Activity ac,Bitmap fromBitmap) throws FileNotFoundException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        fromBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        InputStream input = new ByteArrayInputStream(baos .toByteArray());


        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        onlyBoundsOptions.inPurgeable = true;// 允许可清除
        onlyBoundsOptions.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果

        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;
        //图片分辨率标准
        float hh = 1300f;//这里设置高度
        float ww = 1300f;//这里设置宽度
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
//        bitmapOptions.outWidth = 1300;
//        bitmapOptions.outHeight =
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
//        input = ac.getContentResolver().openInputStream(uri);
//        InputStream input = new ByteArrayInputStream(fromBitmap .toByteArray());
//        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();


        baos = new ByteArrayOutputStream();
        fromBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        input = new ByteArrayInputStream(baos .toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return compressImage(bitmap);


    }


//    /**
//     * 通过uri获取图片并进行压缩
//     *
//     * @param uri
//     */
//    public static Bitmap getBitmapFormUri(Activity ac, Uri uri) throws FileNotFoundException, IOException {
//        InputStream input = ac.getContentResolver().openInputStream(uri);
//
//        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
//        onlyBoundsOptions.inJustDecodeBounds = true;
//        onlyBoundsOptions.inDither = true;//optional
//        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
//        onlyBoundsOptions.inPurgeable = true;// 允许可清除
//        onlyBoundsOptions.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果
//
//        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
//        input.close();
//        int originalWidth = onlyBoundsOptions.outWidth;
//        int originalHeight = onlyBoundsOptions.outHeight;
//        if ((originalWidth == -1) || (originalHeight == -1))
//            return null;
//        //图片分辨率标准
//        float hh = 650f;//这里设置高度
//        float ww = 700f;//这里设置宽度
//        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
//        int be = 1;//be=1表示不缩放
//        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
//            be = (int) (originalWidth / ww);
//        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
//            be = (int) (originalHeight / hh);
//        }
//        if (be <= 0)
//            be = 1;
//        //比例压缩
//        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//        bitmapOptions.inSampleSize = be;//设置缩放比例
//        bitmapOptions.inDither = true;//optional
//        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
//        input = ac.getContentResolver().openInputStream(uri);
//        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
//        input.close();
////        bitmap=ImageUtils.compressByQuality(bitmap,50);
//        try {
//            LogUtilP.i("size:11== " + bitmap.getByteCount() +
//                    "==outHeight===" + bitmapOptions.outHeight + "==outWidth===" + bitmapOptions.outWidth);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return compressImage(bitmap);//再进行质量压缩
//
//
//    }


    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，把压缩后的数据存放到baos中
        int options = 100;
        int bosLen = baos.toByteArray().length;
        while (options > 45 && baos.toByteArray().length / 1024 > 250) {  //循环判断如果压缩后图片是否大于200kb,大于继续压缩

            baos.reset();
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 5;//每次都减少5
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        photoStr = Base64.encode(baos.toByteArray());
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }


    //改变拍完照后图片方向不正的问题
    public static Bitmap ImgUpdateDirection(String filepath, Bitmap mBitmap) {
        int digree = 0;//图片旋转的角度
        //根据图片的URI获取图片的绝对路径
        Log.i("tag", ">>>>>>>>>>>>>开始");
        //String filepath = ImgUriDoString.getRealFilePath(getApplicationContext(), uri);
        Log.i("tag", "》》》》》》》》》》》》》》》" + filepath);
        //根据图片的filepath获取到一个ExifInterface的对象
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filepath);
            Log.i("tag", "exif》》》》》》》》》》》》》》》" + exif);
            if (exif != null) {

                // 读取图片中相机方向信息
                int ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);

                // 计算旋转角度
                switch (ori) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        digree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        digree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        digree = 270;
                        break;
                    default:
                        digree = 0;
                        break;

                }

            }
            //如果图片不为0
            if (digree != 0) {
                // 旋转图片
                Matrix m = new Matrix();
                m.postRotate(digree);
                mBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(),
                        mBitmap.getHeight(), m, true);
            }

        } catch (IOException e) {
            e.printStackTrace();
            exif = null;
        }
        return mBitmap;
    }


}
