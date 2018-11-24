package com.ntd.englishconversation.data.source;

import com.ntd.englishconversation.data.model.Setting;

/**
 * Created by doan.van.toan on 1/16/18.
 */

public interface SettingDataSource {
    Setting getSetting();

    void saveSetting(Setting setting);
}
