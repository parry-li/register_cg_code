package com.tdr.registrationV3.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tdr.registrationV3.ui.activity.scan.QRCodeScanActivity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanUtil {

    public static final int SCANNIN_QR_CODE = 1001;

    public static void Scan(Activity activity) {
        Scan(activity,  "");
    }

    public static void Scan(Activity activity, String ButtonName) {
        Bundle bundle = new Bundle();
        bundle.putString("ButtonName", ButtonName);
        ActivityUtil.goActivityForResultWithBundle(activity, QRCodeScanActivity.class, bundle,
                SCANNIN_QR_CODE);
    }

    public static Intent ScanForFragment(Activity activity) {
        return ScanForFragment(activity,  "");
    }

    public static Intent ScanForFragment(Activity activity, String ButtonName) {
        Bundle bundle = new Bundle();
        bundle.putString("ButtonName", ButtonName);
        Intent intent = ActivityUtil.goActivityForResultForFragment(activity, QRCodeScanActivity.class, bundle);
        return intent;
    }


    public static boolean checkTheft(List<String> eqTypeList, String labelName, String labelNumber) {
        boolean check = false;
        String msg1 = "";
        String msg2 = "";

        msg1 = "请输入" + labelName + "号";
        msg2 = "输入的" + labelName + "号格式错误";

        if (labelNumber.equals("") || labelNumber == null) {
            ToastUtil.showWX(msg1);
        } else {


            if (labelNumber.length() == 14) {
                String labelType = labelNumber.substring(0, 4).toUpperCase();
                boolean b = false;
                for (int i = 0; i < eqTypeList.size(); i++) {
                    String type = eqTypeList.get(i);
                    LogUtil.i("REGULAR=" + type + "     labelNumber=" + labelNumber);
                    if (labelType.equals(type.toUpperCase())) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    check = true;
                } else {
                    ToastUtil.showWX(msg2);
                }
            } else {
                ToastUtil.showWX(msg2);
            }

        }
        return check;
    }

    /**
     * @param isScan      是否手动输入
     * @param carRegular
     * @param labelNumber
     * @return
     */
    public static String checkPlateNumber(boolean isScan, String carRegular, String labelNumber) {
        String num = "";
//        boolean isScan = bundle.getBoolean("isScan");
        if (isScan) {

            Pattern pattern = Pattern.compile(carRegular);
            Matcher matcher = pattern.matcher(labelNumber + "");
            if (!matcher.matches()) {
                LogUtil.i("车牌正则不匹配:" + carRegular + "-" + labelNumber);
                ToastUtil.showWX("输入的车牌有误，请重新确认");
                return null;
            }
            num = labelNumber;
        } else {
            num = plateNumber(labelNumber);
        }
        if (!num.equals("-1")) {
            return num;
        } else {
            ToastUtil.showWX("二维码不属于车牌");
            return null;
        }
    }

    /**
     * 带字母的二维码
     *
     * @param scanResult
     * @return
     */
    public static String plateNumber(String scanResult) {
        try {
            int i = scanResult.indexOf("?ba");
            String re = scanResult.substring(i + 3);
            String decryptResult = TendencyEncrypt.decrypt(re);
            int len = decryptResult.length();
            try {
                if (len <= 4) {
                    return "-1";
                }
                String code = decryptResult.substring(0, len - 4);
                String verifyCode = Base64.encode(UIUtils.shortToBytes(CRC16M.CalculateCrc16(code.getBytes())));
                if ((code + verifyCode).equals(decryptResult)) {
                    String content = new String(Base64.decode(code));
                    String plateNumber = content.substring(4);
                    return plateNumber;
                } else {
                    return "-1";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "-1";
            }
        } catch (Exception e) {
            return "-1";
        }

    }

}
