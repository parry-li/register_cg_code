package com.tdr.registration.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.WindowManager;


import com.parry.utils.code.LogUtils;
import com.parry.utils.code.SDCardUtils;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


/**
 * 处理照片工具类
 */

public class PhotoUtils {
    public final static int CAMERA_REQESTCODE = 2017;//照相机回调值
    public final static int ALBUM_REQESTCODE = 2018;//照相机回调值
    public final static int REQUEST_CODE_CHOOSE = 2300;//照相机回调值
    public static File imageFile;//照片临时文件
    public static String mCurrentPhotoPath;//临时文件地址
    public static String mPicName;
    public static String photoStr;
    public static int CurrentapiVersion = Build.VERSION.SDK_INT;
    private static String photoPath;
    private static final String FILE_PROVIDER_AUTHORITY = "com.tdr.registration";
    public static Uri mImageUri, mImageUriFromFile;

    private static Activity mActivity;


    public static void getPhotoByCamera(Activity activity) {
        mActivity = activity;
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//打开相机的Intent
        if (takePhotoIntent.resolveActivity(mActivity.getPackageManager()) != null) {//这句作用是如果没有相机则该应用不会闪退，要是不加这句则当系统没有相机应用的时候该应用会闪退
            File imageFile = createImageFile(mActivity);//创建用来保存照片的文件
            if (imageFile != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    /*7.0以上要通过FileProvider将File转化为Uri*/
                    mImageUri = FileProvider.getUriForFile(mActivity, FILE_PROVIDER_AUTHORITY, imageFile);
                } else {
                    /*7.0以下则直接使用Uri的fromFile方法将File转化为Uri*/
                    mImageUri = Uri.fromFile(imageFile);
                }
                takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);//将用于输出的文件Uri传递给相机
                mActivity.startActivityForResult(takePhotoIntent, CAMERA_REQESTCODE);//打开相机
            }
        }
    }
    public static Intent getPhotoByCameraForFragment(Activity activity) {
        mActivity = activity;
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//打开相机的Intent
        if (takePhotoIntent.resolveActivity(mActivity.getPackageManager()) != null) {//这句作用是如果没有相机则该应用不会闪退，要是不加这句则当系统没有相机应用的时候该应用会闪退
            File imageFile = createImageFile(mActivity);//创建用来保存照片的文件
            if (imageFile != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    /*7.0以上要通过FileProvider将File转化为Uri*/
                    mImageUri = FileProvider.getUriForFile(mActivity, FILE_PROVIDER_AUTHORITY, imageFile);
                } else {
                    /*7.0以下则直接使用Uri的fromFile方法将File转化为Uri*/
                    mImageUri = Uri.fromFile(imageFile);
                }
                takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);//将用于输出的文件Uri传递给相机

            }
        }
        return takePhotoIntent;
    }

    public static Bitmap getResultCameraPhoto() {
        try {
            /*如果拍照成功，将Uri用BitmapFactory的decodeStream方法转为Bitmap*/
            InputStream bitmapIs = mActivity.getContentResolver().openInputStream(PhotoUtils.mImageUri);
//            Bitmap bitmapResult = BitmapFactory.decodeStream(mActivity.getContentResolver().openInputStream(PhotoUtils.mImageUri));
            Bitmap bitmap = null;
            try {
                bitmap =getFitSampleBitmap(bitmapIs);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  static  Bitmap  getFitSampleBitmap(InputStream  inputStream) throws Exception{
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        byte[] bytes = readStream(inputStream);
        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
    }

    /**
     * 从inputStream中获取字节流 数组大小
     **/
    public static byte[] readStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    public static Bitmap getResultCameraPhotoCompress(Bitmap bitmap) {

        try {
            Bitmap bitmapResult = getBitmapFormBitmap(mActivity, bitmap);
            return bitmapResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存并处理图片
     *
     * @param imgUriCrop
     */
    public static MultipartBody.Part getRequestFile(Bitmap imgUriCrop) {

        Bitmap b = imgUriCrop;//获取一个bitmap
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        RequestBody body = RequestBody.create(MediaType.parse("image/png"), byteArray);//content-type为image/png，其中byteArray中的数据对应图中(5)处
        MultipartBody.Part file = MultipartBody.Part.createFormData("imgFile", "imgFile.png", body);//分别对应图中(3)、(4)

        return file;
    }

    /**
     * 创建用来存储图片的文件，以时间来命名就不会产生命名冲突
     *
     * @return 创建的图片文件
     */
    private static File createImageFile(Activity mActivity) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = mActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = null;
        try {
            imageFile = File.createTempFile(imageFileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }


//    public static void getPhotoByCamera(Activity mActivity) {
//        if (PhotoUtils.CurrentapiVersion > 20) {
//            TakePicture(mActivity, "tdrPhoto");
//        } else {
//         TakePicture2(mActivity, "tdrPhoto");
//        }
//    }



    public static void getPhotoByAlbum(Activity mActivity) {
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
                .forResult(ALBUM_REQESTCODE);
    }

    public static void sevephoto(final Bitmap bitmap) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File f = new File(Environment.getExternalStorageDirectory()
                        + "/Registration/" + mPicName + ".jpg");

                LogUtil.e("name=" + f.getName());
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

        LogUtil.e("mCurrentPhotoPath:" + mCurrentPhotoPath);
//        MobclickAgent.reportError(mActivity, "PhotoPath：" + mCurrentPhotoPath);
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

                opts.inSampleSize = be;
                opts.inJustDecodeBounds = false;
                opts.inInputShareable = true;
                opts.inPurgeable = true;
                opts.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional

            }
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(dst.getPath(), opts);
                LogUtils.i("size:11== " + bitmap.getByteCount() +
                        "==outHeight===" + opts.outHeight + "==outWidth===" + opts.outWidth);
                return compressImage(bitmap);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static Bitmap getPhotoBitmap(Intent data) {
        Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
        bitmap = compressImage(bitmap);


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
        LogUtils.d("bitmapheight=" + bitmapheight + "   bitmapwidth=" + bitmapwidth);
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
            LogUtils.d("h缩放比=" + heightRatio);
            LogUtils.d("w缩放比=" + widthRatio);
            if (heightRatio > widthRatio) {
                inSampleSize = widthRatio;
            } else {
                inSampleSize = heightRatio;
            }
        }
        LogUtils.d("缩放比=" + inSampleSize);
        return inSampleSize;
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
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = ac.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();

        try {
            LogUtils.i("size:11== " + bitmap.getByteCount() +
                    "==outHeight===" + bitmapOptions.outHeight + "==outWidth===" + bitmapOptions.outWidth);
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
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        stream = new FileInputStream(dst);
        Bitmap bitmap = BitmapFactory.decodeStream(stream, null, bitmapOptions);
        stream.close();


        return compressImage(bitmap);


    }

    /**
     * 通过bitmap获取图片并进行压缩
     *
     * @param
     */
    public static Bitmap getBitmapFormBitmap(Activity ac, Bitmap fromBitmap) throws FileNotFoundException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        fromBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        InputStream input = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = false;

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

//        if (be <= 0)
//            be = 1;
//        //比例压缩
//        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//        bitmapOptions.inSampleSize = be;//设置缩放比例
////        bitmapOptions.outWidth = 1300;
////        bitmapOptions.outHeight =
//        bitmapOptions.inDither = true;//optional
//        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
////        input = ac.getContentResolver().openInputStream(uri);
////        InputStream input = new ByteArrayInputStream(fromBitmap .toByteArray());
////        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
//        input.close();
//
//
//        baos = new ByteArrayOutputStream();
//        fromBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        input = new ByteArrayInputStream(baos .toByteArray());
//        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
//
//        try {
//            LogUtil.i("size:11== " + bitmap.getByteCount() +
//                    "==outHeight===" + bitmapOptions.outHeight + "==outWidth===" + bitmapOptions.outWidth);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return compressImage(bitmap);
//
//
//    }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inJustDecodeBounds = false;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input.close();


        baos = new ByteArrayOutputStream();
        fromBitmap.compress(Bitmap.CompressFormat.JPEG, 40, baos);
        input = new ByteArrayInputStream(baos.toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);


        try {
            LogUtil.i("size:11== " + bitmap.getByteCount() +
                    "==outHeight===" + bitmapOptions.outHeight + "==outWidth===" + bitmapOptions.outWidth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;


    }


    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，把压缩后的数据存放到baos中
        int options = 60;
        int bosLen = baos.toByteArray().length;
        while (options > 45 && baos.toByteArray().length / 1024 > 250) {  //循环判断如果压缩后图片是否大于200kb,大于继续压缩
            baos.reset();
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 5;//每次都减少5
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        try {
            LogUtil.i("compressImage==size: " + bitmap.getByteCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImageBySmile(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        image.compress(Bitmap.CompressFormat.JPEG, 20, baos);//质量压缩方法，把压缩后的数据存放到baos中
        int be = 15;
        if (baos.toByteArray().length / 1024 < 250) {
            be = 10;
        }
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inJustDecodeBounds = false;
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, bitmapOptions);//把ByteArrayInputStream数据生成图片
        try {
            LogUtil.i("compressImage==size: " + bitmap.getByteCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }


}
