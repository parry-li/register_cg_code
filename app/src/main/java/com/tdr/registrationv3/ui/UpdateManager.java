package com.tdr.registrationv3.ui;

/**
 * Created by parry
 */

public class UpdateManager {
//    private Activity mContext;
//
//    private static String savePath;
//    private String saveFileName;
//    private ProgressBar mProgress; //下载进度条控件
//    private static final int DOWNLOADING = 1; //表示正在下载
//    private static final int DOWNLOADED = 2; //下载完毕
//    private static final int DOWNLOAD_FAILED = 3; //下载失败
//    private int progress; //下载进度
//    private boolean cancelFlag = false; //取消下载标志位
//
//    private String serverVersion; //从服务器获取的版本号
//    private String apkUrl;
//    //    private String apkUrl = "http://liuliu.lejuhuyu.com/AndroidApk/liuliu-dashou-app-1.0.2.apk";
//    private String clientVersionName; //客户端当前的版本号
//    private String updateDescription = "请更新当前最新版本"; //更新内容描述信息
//    private String forceUpdate; //是否强制更新
//    private String update;
//    private MeUpdateBean.DataBean mVersionBean;
//
//    private AlertDialog alertDialog1, alertDialog2; //表示提示对话框、进度条对话框
//    private File apkFile;
//
//    public UpdateManager(Activity activity, MeUpdateBean.DataBean versionBean) {
//        this.mContext = activity;
//        this.mVersionBean = versionBean;
//        apkUrl = versionBean.getUrl();
//        savePath = Environment.DIRECTORY_DOWNLOADS;
//        saveFileName = savePath + "/ylmom-app"  + ".apk";
//    }
//
//    public CustomWindowDialog windowDialog;
//
//    /**
//     * 显示更新对话框
//     */
//    public void showNoticeDialog(String title,boolean isHideCancel) {
//        serverVersion = mVersionBean.getVersion();
//        clientVersionName = getVersion();
//        LogUtil.i("++++clientVersionName+++++"+clientVersionName);
//        LogUtil.i("++++serverVersion+++++"+serverVersion);
//        if (Integer.parseInt(clientVersionName)>=Integer.parseInt(serverVersion)) {
//
//            ToastUtils.showShort("已更新至最新版本");
//            return;
//        }
//
//        forceUpdate = mVersionBean.getIsforce();
//         windowDialog = new CustomWindowDialog(mContext);
//        windowDialog.showCustomWindowDialog(title,Html.fromHtml(mVersionBean.getContent())+"",isHideCancel);
//        windowDialog.setOnCustomDialogClickListener(new CustomWindowDialog.OnItemClickListener() {
//            @Override
//            public void onCustomDialogClickListener() {
//                downloadApk();
//            }
//        });
//
//
//
//    }
//
//    /**
//     * 下载apk的线程
//     */
//
//
//    private static final int DOWNLOAD_VERSION_SUCCESS = 2;
//    private static final int DOWNLOAD_APK_FAIL = 3;
//    private static final int DOWNLOAD_APK_SUCCESS = 4;
//
//    private ProgressDialog downloadDialog;
//
//    public void downloadApk() {
//        //初始化水平进度条的dialog
//        downloadDialog = new ProgressDialog(mContext);
//        downloadDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        downloadDialog.setCancelable(false);
//        downloadDialog.setProgressNumberFormat(" ");
//        downloadDialog.show();
//        //初始化数据要保持的位置
//        File filesDir;
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            filesDir = mContext.getExternalFilesDir("");
//        } else {
//            filesDir =App.getContext().getFilesDir();
//        }
//        apkFile = new File(filesDir, "ylmom_update" + ".apk");
//
//        //启动一个分线程联网下载数据：
//        new Thread() {
//            public void run() {
//                String path = apkUrl;
////                LogUtil.i("++updateInfo.appurl+++" + updateInfo.appurl);
//                InputStream is = null;
//                FileOutputStream fos = null;
//                HttpURLConnection conn = null;
//                try {
//                    URL url = new URL(path);
//                    conn = (HttpURLConnection) url.openConnection();
//                    conn.setRequestMethod("GET");
//                    conn.setConnectTimeout(5000);
//                    conn.setReadTimeout(5000);
//                    conn.connect();
//
//                    if (conn.getResponseCode() == 200) {
//                        downloadDialog.setMax(conn.getContentLength()/(1024));//设置dialog的最大值
//                        is = conn.getInputStream();
//                        fos = new FileOutputStream(apkFile);
//
//                        byte[] buffer = new byte[1024];
//                        int len;
//                        while ((len = is.read(buffer)) != -1) {
//                            //更新dialog的进度
//                            downloadDialog.incrementProgressBy(len/(1024));
//                            fos.write(buffer, 0, len);
//
//                        }
//                        handler.sendEmptyMessage(DOWNLOAD_APK_SUCCESS);
//                    } else {
//                        handler.sendEmptyMessage(DOWNLOAD_APK_FAIL);
//                        downloadDialog.dismiss();
//                    }
//
//                } catch (Exception e) {
//                    LogUtil.i("+++++++"+e.toString());
//                    e.printStackTrace();
//                } finally {
//                    if (conn != null) {
//                        conn.disconnect();
//                    }
//                    if (is != null) {
//                        try {
//                            is.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (fos != null) {
//                        try {
//                            fos.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }.start();
//
//
//    }
//
//
//
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//
//                case DOWNLOAD_APK_FAIL:
//                    ToastUtils.showShort("联网下载数据失败");
//
//                    break;
//                case DOWNLOAD_APK_SUCCESS:
//                    //                    UIUtils.toast("下载应用数据成功", false);
//                    downloadDialog.dismiss();
//                    installApk();//安装下载好的应用
//
//                    break;
//            }
//
//        }
//    };
//
//
//
//
//
//    private void installApk() {
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        try {
//            String[] command = {"chmod", "777", apkFile.toString()};
//            ProcessBuilder builder = new ProcessBuilder(command);
//            builder.start();
//        } catch (IOException ignored) {
//            ignored.printStackTrace();
//        }
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            Uri contentUri = FileProvider.getUriForFile(App.getContext(), "com.ylkj" , apkFile);
//            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
//
//            //兼容8.0
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                boolean hasInstallPermission = mContext.getPackageManager().canRequestPackageInstalls();
//                if (!hasInstallPermission) {
////                    ToastUtil.makeText(MyApplication.getContext(), MyApplication.getContext().getString(R.string.string_install_unknow_apk_note), false);
//                    startInstallPermissionSettingActivity();
//                    return;
//                }
//            }
//        } else {
//            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        }
//
//
//        startActivity(intent);
//    }
//
//
//
//    /**
//     * 跳转到设置-允许安装未知来源-页面
//     */
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private void startInstallPermissionSettingActivity() {
//        //注意这个是8.0新API
//        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        mContext.startActivity(intent);
//    }
//
//    public String getVersion() {
//        try {
//            PackageManager manager = mContext.getPackageManager();
//            PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), 0);
//            String version = info.versionCode+"";
//            return version;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "0";
//        }
//    }
//
//    public static String getAppVersionName(Context context) {
//        String versionName = "";
//        try {
//            // ---get the package info---
//            PackageManager pm = context.getPackageManager();
//            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
//            versionName = pi.versionName;
//            if (versionName == null || versionName.length() <= 0) {
//                return "";
//            }
//        } catch (Exception e) {
//            LogUtil.e( "Exception"+ e);
//        }
//        return versionName;
//    }




}
