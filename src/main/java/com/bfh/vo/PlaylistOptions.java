package com.bfh.vo;

import java.io.Serializable;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description 播放列表设置
 */
public class PlaylistOptions implements Serializable {

    private Boolean enableRemoveControls;
    private Boolean autoPlay;

    public Boolean getEnableRemoveControls() {
        return enableRemoveControls;
    }

    public void setEnableRemoveControls(Boolean enableRemoveControls) {
        this.enableRemoveControls = enableRemoveControls;
    }

    public Boolean getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(Boolean autoPlay) {
        this.autoPlay = autoPlay;
    }
}
