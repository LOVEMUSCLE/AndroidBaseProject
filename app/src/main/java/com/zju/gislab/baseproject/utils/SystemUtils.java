package com.zju.gislab.baseproject.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

import com.zju.gislab.baseproject.ProjectApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/6 16:32
 * 邮箱：18768117560@163.com
 */
public class SystemUtils {
    /**
     * 获取手机型号
     * @return
     */
    public static String getLocalModel() {
        String model = android.os.Build.MODEL;
        if(null == model) {
            model = "";
        }
        return model;
    }


    /**
     * 获取手机系统版本
     * @return
     */
    public static String getLocalSystemVersion() {
        String version = Build.VERSION.RELEASE;
        if (version == null) {
            version = "";
        }
        return version;
    }

    /**
     * 获取手机厂商
     * @return
     */
    public static String getLocalManufacturer() {
        String manufacturer = android.os.Build.MANUFACTURER;
        if (manufacturer == null) {
            manufacturer = "";
        }
        return manufacturer;
    }


    /**
     * 获取ip地区
     * @return
     */
    public static String getIpCountry() {
        String ipCountry = "460";
        try {
            TelephonyManager mTelephonyManager = (TelephonyManager) ProjectApplication
                    .getInstance().getSystemService(Context.TELEPHONY_SERVICE);
            if (mTelephonyManager != null) {
                String IMSI = mTelephonyManager.getSubscriberId();
                if (IMSI != null && !IMSI.equals("") && IMSI.length() >= 3) {
                    // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
                    ipCountry = IMSI.substring(0, 3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipCountry;
    }


    /**
     * 获取ip运营商
     * @return
     */
    public static String getIpName() {
        String ipName = null;
        try {
            TelephonyManager mTelephonyManager = (TelephonyManager) ProjectApplication
                    .getInstance().getSystemService(Context.TELEPHONY_SERVICE);
            if (mTelephonyManager != null) {
                String IMSI = mTelephonyManager.getSubscriberId();
                if (IMSI != null && !IMSI.equals("") && IMSI.length() >= 5) {
                    // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
                    ipName = IMSI.substring(3, 5);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipName;
    }

    /**
     * 获取ip基站
     * @return
     */
    public static String getIpBaseStation() {
        TelephonyManager telMgr = (TelephonyManager) ProjectApplication
                .getInstance().getSystemService(Context.TELEPHONY_SERVICE);
        int cid = 0;
        int lac = 0;
        try {
            if (telMgr != null) {
                GsmCellLocation gc = (GsmCellLocation) telMgr.getCellLocation();
                if (null == gc) {
                    return "0_0";
                }
                cid = gc.getCid();
                lac = gc.getLac();
            }
        } catch (Exception e) {
            if (telMgr != null) {
                CdmaCellLocation location = (CdmaCellLocation) telMgr
                        .getCellLocation();
                if (null == location) {
                    return "0_0";
                }
                lac = location.getNetworkId();
                cid = location.getBaseStationId();
                cid /= 16;
            }
        }
        return lac + "_" + cid;
    }

    /**
     * 获取Android_id
     * @return
     */
    public static String getAndroidId() {

        return Settings.Secure.getString(ProjectApplication.getInstance()
                .getContentResolver(), Settings.Secure.ANDROID_ID);
    }


    /**
     * 获取手机硬件属性
     * @return
     */
    public static String[] getTotalHardwareMessage() {
        String result[] = new String[3];
        String str1 = "/proc/cpuinfo";
        String str2 = null;
        FileReader localFileReader = null;
        BufferedReader localBufferedReader = null;
        try {
            localFileReader = new FileReader(str1);
            localBufferedReader = new BufferedReader(localFileReader);
            while ((str2 = localBufferedReader.readLine()) != null) {
                if (str2.contains("Processor")) {
                    if (str2.contains(":")) {
                        String[] arrayOfString = str2.split(":");
                        if (arrayOfString.length == 2) {
                            result[0] = arrayOfString[1];
                            if (result[0].length() > 32 && result[0] != null) {
                                result[0] = result[0].substring(0, 32);
                            }
                        }
                    }
                }
                if (str2.contains("Features")) {
                    if (str2.contains(":")) {
                        String[] arrayOfString = str2.split(":");
                        if (arrayOfString.length == 2) {
                            result[1] = arrayOfString[1];
                            if (result[1].length() > 50 && result[1] != null) {
                                result[1] = result[1].substring(0, 50);
                            }
                        }
                    }
                }
                if (str2.contains("Hardware")) {
                    if (str2.contains(":")) {
                        String[] arrayOfString = str2.split(":");
                        if (arrayOfString.length == 2) {
                            result[2] = arrayOfString[1];
                            if (result[2].length() > 32 && result[2] != null) {
                                result[2] = result[2].substring(0, 32);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (localBufferedReader != null) {
                try {
                    localBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (localFileReader != null) {
                try {
                    localFileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    /**
     * 获取用户的IPd
     * @return
     */
    public static int getIpAddress() {
        int ipAddress = 0;
        WifiManager wifiManager = (WifiManager) ProjectApplication
                .getInstance().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo == null || wifiInfo.equals("")) {
            return ipAddress;
        } else {
            ipAddress = wifiInfo.getIpAddress();
        }
        return ipAddress;
    }

    /**
     * 获取用户设备IP
     * @return
     */
    public static String getUserIp() {
        int ipAddress = getIpAddress();
        return String.format("%d.%d.%d.%d", (ipAddress & 0xff),
                (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff),
                (ipAddress >> 24 & 0xff));
    }

    /**
     * 获取时区
     * @return
     */
    public static String getTimeArea() {
        return String.valueOf(
                TimeZone.getDefault().getOffset(new Date().getTime() / 1000))
                .toString();
    }

}
