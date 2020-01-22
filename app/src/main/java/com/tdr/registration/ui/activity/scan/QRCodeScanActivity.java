package com.tdr.registration.ui.activity.scan;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.KeyboardUtils;
import com.parry.utils.code.KeyboardUtils;
import com.parry.zxing.activity.CaptureFragment;
import com.parry.zxing.activity.CodeUtils;
import com.tdr.kingja.view.NullMenuEditText;
import com.tdr.registration.R;
import com.tdr.registration.ui.activity.base.NoLoadingBaseActivity;
import com.tdr.registration.util.AllCapTransformationMethod;
import com.tdr.registration.util.Base64;
import com.tdr.registration.util.SharedPreferencesUtils;
import com.tdr.registration.util.ToastUtil;
import com.tdr.registration.util.UIUtils;
import com.tdr.registration.util.Utils;
import com.tdr.registration.util.mLog;
import com.tdr.registration.utils.ToastUtil;
import com.tdr.registration.utils.UIUtils;
import com.tdr.registration.view.niftydialog.NiftyDialogBuilder;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;


/**
 * 二维码扫描
 */

public class QRCodeScanActivity extends NoLoadingBaseActivity implements View.OnClickListener {
    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.TV_Prompt)
    TextView TVPrompt;
    @BindView(R.id.TV_Input)
    TextView TV_Input;
    @BindView(R.id.IV_Back)
    ImageView IV_Back;
    @BindView(R.id.IV_Light)
    ImageView IV_Light;


    private Activity mActivity;
    private int ScanType = 0;
    private boolean isShow;
    private boolean isPlateNumber;
    private String ButtonName;

    private boolean Light = false;
    private String ChangeDialogText;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan_ewm;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        try {
            initview();
//            AutoLight();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private void initview() {
        mActivity = this;
        IV_Back.setOnClickListener(this);
        IV_Light.setOnClickListener(this);
        TV_Input.setOnClickListener(this);

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
            ScanType = bundle.getInt("ScanType");
            isShow = bundle.getBoolean("isShow");
            isPlateNumber = bundle.getBoolean("isPlateNumber");
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
        IV_Light.setBackgroundResource(Light ? R.mipmap.light_on : R.mipmap.light_off);

    }

    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    private void dialogShow(int flag) {
        if (dialogBuilder != null && dialogBuilder.isShowing())
            return;

        dialogBuilder = NiftyDialogBuilder.getInstance(this);

        if (flag == 0) {
            effectstype = NiftyDialogBuilder.Effectstype.Fadein;
            LayoutInflater mInflater = LayoutInflater.from(this);
            View inputView = mInflater.inflate(R.layout.layout_input_plate, null);
            final TextView textPlateNumber = (TextView) inputView.findViewById(R.id.text_plateNumber);
            final NullMenuEditText editPlateNumber = (NullMenuEditText) inputView.findViewById(R.id.edit_plateNumber);
            final TextView textPlateNumberConfirm = (TextView) inputView.findViewById(R.id.text_plateNumberConfirm);
            final NullMenuEditText editPlateNumberConfirm = (NullMenuEditText) inputView.findViewById(R.id.edit_plateNumberConfirm);
            if (!isPlateNumber) {
                textPlateNumber.setText("标签ID");
                textPlateNumberConfirm.setText("确认标签ID");
            }


            if (ChangeDialogText != null && !ChangeDialogText.equals("1")) {
                textPlateNumber.setText(ChangeDialogText);
                textPlateNumberConfirm.setText("确认" + ChangeDialogText);
            }

            editPlateNumber.setTransformationMethod(new AllCapTransformationMethod(true));
            editPlateNumberConfirm.setTransformationMethod(new AllCapTransformationMethod(true));
            dialogBuilder.withTitle("提示").withTitleColor("#333333").withMessage(null)
                    .isCancelableOnTouchOutside(false).withEffect(effectstype).withButton1Text("取消")
                    .setCustomView(inputView, mActivity).withButton2Text("确认").setButton1Click(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogBuilder.dismiss();
                }
            }).setButton2Click(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        KeyboardUtils.hideSoftInput(QRCodeScanActivity.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    dialogBuilder.dismiss();
                    if (editPlateNumber.getText().toString().trim().equals("") || editPlateNumberConfirm.getText().toString().trim().equals("")) {
                        Utils.myToast(mActivity, "请输入信息");
                    } else if (editPlateNumber.getText().toString().toUpperCase().trim().equals(editPlateNumberConfirm.getText().toString().toUpperCase().trim())) {


                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("result", editPlateNumber.getText().toString().toUpperCase().trim());
                        resultIntent.putExtra("isPlateNumber", "0");
                        resultIntent.putExtra("isScan", true);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {
                        Utils.myToast(mActivity, "两次信息输入不一致，请重新输入");
                    }
                }
            }).show();
        }
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
            ToastUtil.showToast("数据解析异常，请重新输入");
            return "";
        }
        return labelContent;
    }

    @Override
    protected void onStart() {
        super.onStart();
//        ZXV_ScanQRCode.startCamera();
//        ZXV_ScanQRCode.showScanRect();
    }

    @Override
    protected void onStop() {
//        ZXV_ScanQRCode.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
//        ZXV_ScanQRCode.onDestroy();
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
//        Log.e("Pan","扫描结果="+result);
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
            case R.id.IV_Light:
                mLog.e("Light=" + Light);
                if (!isOpen) {
                    lightEnadleOpen(true);
                    isOpen = true;
                } else {
                    lightEnadleOpen(false);
                    isOpen = false;
                }
                IV_Light.setBackgroundResource(isOpen ? R.mipmap.light_on : R.mipmap.light_off);
                break;
            case R.id.TV_Input:
                dialogShow(0);
                break;
        }
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
