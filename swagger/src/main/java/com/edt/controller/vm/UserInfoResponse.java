package com.edt.controller.vm;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回当前的用户基本信息
 */
@ApiModel("用户基本信息返回")
public class UserInfoResponse {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("头像")
    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
