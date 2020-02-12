package com.tdr.registration.ui.activity.scan;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parry.utils.code.KeyboardUtils;
import com.parry.zxing.activity.CaptureFragment;
import com.parry.zxing.activity.CodeUtils;
import com.tdr.registration.R;
import com.tdr.registration.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registration.utils.Base64;
import com.tdr.registration.utils.LogUtil;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.utils.UIUtils;
import com.tdr.registration.view.ScanDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * 二维码扫描
 */

public class QRCodeScanActivity extends NoLoadingBaseActivity implements View.OnClickListener{

    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.TV_Prompt)
    TextView TVPrompt;
    @BindView(R.id.IV_Back)
    ImageView IVBack;
    @BindView(R.id.scan_input)
    LinearLayout scanInput;
    @BindView(R.id.scan_light)
    LinearLayout scanLight;
    @BindView(R.id.scan_light_iv)
    ImageView scanLightIv;
    private Activity mActivity;
    private int ScanType = 0;
    private boolean isShow;
    private String ButtonName;

    private boolean Light = false;
    private String ChangeDialogText;
    private ScanDialog scanDialog;
    private static final int PERMISSION_CODE = 124;
    private static final String[] PERMISSION_CONTENT =
            {Manifest.permission.CAMERA, Manifest.permission.VIBRATE};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan_ewm;
    }

    @Override
    protected void submitRequestData() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            initview();
            setInputDialog();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setInputDialog() {
        scanDialog = new ScanDialog(QRCodeScanActivity.this);
        scanDialog.setOnCustomDialogClickListener(new ScanDialog.OnItemConfirmClickListener() {
            @Override
            public void onCustomDialogClickListener(String content) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", content);
                resultIntent.putExtra("isPlateNumber", "0");
                resultIntent.putExtra("isScan", true);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private void initview() {
        mActivity = this;
        IVBack.setOnClickListener(this);
        scanLight.setOnClickListener(this);
        scanInput.setOnClickListener(this);

        CaptureFragment captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.scan_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();

//        ZXV_ScanQRCode.setDelegate(this);
        try {
            KeyboardUtils.clickBlankArea2HideSoftInput();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            ButtonName = bundle.getString("ButtonName");
            ChangeDialogText = bundle.getString("ChangeDialogText", "1");
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    public static boolean isOpen = false;

    public void AutoLight() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 8) {
            Light = false;
            //早上
        } else if (hour >= 8 && hour < 11) {
            Light = false;
            //上午
        } else if (hour >= 11 && hour < 13) {
            Light = false;
            //中午
        } else if (hour >= 13 && hour < 18) {
            Light = false;
            //下午
        } else {
            Light = true;
            //晚上
        }
        if (Light) {
            CodeUtils.isLightEnable(true);//开灯
            isOpen = true;
        } else {
            if (isOpen) {
                CodeUtils.isLightEnable(false);//关灯
                isOpen = false;
            }
        }
        scanLightIv.setImageResource(Light ? R.mipmap.light_open : R.mipmap.light_close);

    }

    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    private String labelDecode(String labelContent) {
        try {
            int i = labelContent.toUpperCase().indexOf("?AB");
            if (i > 0) {//数据加密过
                String re = labelContent.substring(i + 3);
                String baseContent = Base64.base64Decode16(re);//解析数据
                String reType = baseContent.substring(0, 4);

                Integer content10 = Integer.parseInt(baseContent.substring(4, baseContent.length() - 4), 16);//转10进制
                String reContent = UIUtils.autoGenericCode(content10 + "", 10);

                labelContent = reType + reContent;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtil.showWX("数据解析异常，请重新输入");
            return "";
        }
        return labelContent;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            result = labelDecode(result);
            Intent intent = new Intent();
            intent.putExtra("result", result);
            intent.putExtra("isPlateNumber", "1");
            setResult(RESULT_OK, intent);
            finish();
        }

        @Override
        public void onAnalyzeFailed() {
            ToastUtil.showWX("二维码解析异常，请重新扫码");

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.IV_Back:
                finish();
                break;
            case R.id.scan_light:
                if (!isOpen) {
                    lightEnadleOpen(true);
                    isOpen = true;
                } else {
                    lightEnadleOpen(false);
                    isOpen = false;
                }
                scanLightIv.setImageResource(isOpen ? R.mipmap.light_open : R.mipmap.light_close);
                break;
            case R.id.scan_input:
                dialogShow();

                break;
        }
    }

    private void dialogShow() {
        if (scanDialog == null || scanDialog.isShowing()) {
            return;
        }
        scanDialog.showCustomWindowDialog(ButtonName);
    }

    /**
     * 开关灯光
     *
     * @param ble
     */
    private void lightEnadleOpen(boolean ble) {
        try {
            CodeUtils.isLightEnable(ble);
        } catch (Exception e) {
            ToastUtil.showWX("温馨提示：由于设备原因，灯光异常");
        }

    }

}
