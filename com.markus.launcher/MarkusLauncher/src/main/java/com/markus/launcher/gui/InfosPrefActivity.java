package com.markus.launcher.gui;

import android.os.Bundle;
import android.os.SystemClock;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.GuidedStepFragment;
import android.support.v17.leanback.widget.GuidanceStylist;
import android.support.v17.leanback.widget.GuidedAction;

import java.io.IOException;
import java.util.List;
import com.markus.launcher.R;
import com.markus.launcher.tools.Tools;

/**
 * Info / System view
 */
public class InfosPrefActivity extends PreferenceFragment
{
    static final long SLEEPTIME_MINIMUM = 1;
    static final long SLEEPTIME_MAXIMUM = 120;

    public InfosPrefActivity()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.infoprefactivity);

        Preference prefGoToSleep = (Preference) findPreference("prefVirtualGoToSleep");
        prefGoToSleep.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "input keyevent 223"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefReboot = (Preference) findPreference("prefVirtualRestart");
        prefReboot.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "/system/bin/svc power reboot"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefML1 = (Preference) findPreference("prefVirtualMLDevice");
        prefML1.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.amazon.tv.settings.v2");
                localIntent.setComponent(ComponentName.unflattenFromString("com.amazon.tv.settings.v2/.tv.device.DeviceActivity"));
                localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(localIntent);
                return false;
            }
        });

        Preference prefML2 = (Preference) findPreference("prefVirtualMLNet");
        prefML2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.amazon.tv.settings.v2");
                localIntent.setComponent(ComponentName.unflattenFromString("com.amazon.tv.settings.v2/.tv.network.NetworkActivity"));
                localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(localIntent);
                return false;
            }
        });
        Preference prefML3 = (Preference) findPreference("prefVirtualMLApp");
        prefML3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.amazon.device.settings.action.APPLICATIONS");
                localIntent.setComponent(ComponentName.unflattenFromString("com.amazon.tv.settings.v2/.tv.applications.ApplicationsActivity"));
                localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(localIntent);
                return false;
            }
        });

        Preference prefML4 = (Preference) findPreference("prefVirtualMLDev");
        prefML4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.amazon.tv.settings.v2");
                localIntent.setComponent(ComponentName.unflattenFromString("com.amazon.tv.settings.v2/.tv.controllers_bluetooth_devices.ControllersAndBluetoothActivity"));
                localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(localIntent);
                return false;
            }
        });
        Preference prefML5 = (Preference) findPreference("prefVirtualMLEqui");
        prefML5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.amazon.tv.devicecontrolsetting");
                localIntent.setComponent(ComponentName.unflattenFromString("com.amazon.tv.devicecontrolsettings/.screens.main_menu.OzOobeSettingsActivity"));
                localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(localIntent);
                return false;
            }
        });

        Preference prefML6 = (Preference) findPreference("prefVirtualMLSaver");
        prefML6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.amazon.ftv.screensaver");
                localIntent.setComponent(ComponentName.unflattenFromString("com.amazon.ftv.screensaver/.app.settings.ScreensaverActivity"));
                localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(localIntent);
                return false;
            }
        });

        Preference prefRL1 = (Preference) findPreference("prefVirtualRLDEVICE");
        prefRL1.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.DEVICE -n com.amazon.tv.settings.v2/.tv.device.DeviceActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL2 = (Preference) findPreference("prefVirtualRLDISPLAYSOUNDS");
        prefRL2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.DISPLAY_AND_SOUNDS -n com.amazon.tv.settings.v2/.tv.display_sounds.DisplayAndSoundsActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL3 = (Preference) findPreference("prefVirtualRLNETWORK");
        prefRL3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.ADD_NETWORK -n com.amazon.tv.settings.v2/.tv.network.NetworkActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL4 = (Preference) findPreference("prefVirtualRLDEVICES");
        prefRL4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.CONTROLLERS -n com.amazon.tv.settings.v2/.tv.controllers_bluetooth_devices.ControllersAndBluetoothActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL5 = (Preference) findPreference("prefVirtualRLACCESSIBILITY");
        prefRL5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.ACCESSIBILITY -n com.amazon.tv.settings.v2/.tv.accessibility.AccessibilityActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL6 = (Preference) findPreference("prefVirtualRLAPPS");
        prefRL6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.APPLICATIONS -n com.amazon.tv.settings.v2/.tv.applications.ApplicationsActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL7 = (Preference) findPreference("prefVirtualRLPREFERENCES");
        prefRL7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.PREFERENCES -n com.amazon.tv.settings.v2/.tv.preferences.PreferencesActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL8 = (Preference) findPreference("prefVirtualRLEQUIPMENT");
        prefRL8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.tv.oobe.settings.ACTION.DEVICE_CONTROL -n com.amazon.tv.devicecontrolsettings/.screens.main_menu.OzOobeSettingsActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL9 = (Preference) findPreference("prefVirtualRLNOTIFICATIONS");
        prefRL9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.tv.action.NOTIFICATION_CENTER -n com.amazon.tv.notificationcenter/.NotificationCenterActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL10 = (Preference) findPreference("prefVirtualRLACCOUNT");
        prefRL10.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.MY_ACCOUNT -n com.amazon.tv.settings.v2/.tv.my_account.MyAccountActivity"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL11 = (Preference) findPreference("prefVirtualRLADB");
        prefRL11.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "settings put global adb_enabled 1"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        Preference prefRL12 = (Preference) findPreference("prefVirtualRLINSECAPP");
        prefRL12.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {
            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                Intent localIntent = new Intent();
                try {
                    Runtime.getRuntime().exec(new String[]{"su", "-c", "settings put secure install_non_market_apps 1"});
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

    }
}
