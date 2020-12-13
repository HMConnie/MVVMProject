package com.sgcai.mvvmproject.net.resp;

import cn.connie.mvvm.ex.BaseResponse;

public class UserResult extends BaseResponse {

    /**
     * "accessToken": "b93410b28fd84fc8a13ef30732256693",
     * "clientType": "CUSTOMER_ANDROID",
     * "expiredIn": 604800,
     * "isGuided": 0,
     * "refreshToken": "5541e63df9cb4e9f9a74af8e77692184",
     * "userId": "74"
     */
    private LoginDataBean data;

    public LoginDataBean getData() {
        return data;
    }

    public void setData(LoginDataBean data) {
        this.data = data;
    }

    public static class LoginDataBean {
        private String accessToken;
        private String clientType;
        private String refreshToken;
        private String userId;
        private String invitationCode;
        private int invitedAwardSp;
        private int isFirstLogin;//0：非首次登录 1：首次登录（注册）
        private int isGuided; //是否选择性别和喜欢标签
        private int userLevel; //用户等级

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getClientType() {
            return clientType;
        }

        public void setClientType(String clientType) {
            this.clientType = clientType;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getIsGuided() {
            return isGuided;
        }

        public void setIsGuided(int isGuided) {
            this.isGuided = isGuided;
        }

        public int getIsFirstLogin() {
            return isFirstLogin;
        }

        public void setIsFirstLogin(int isFirstLogin) {
            this.isFirstLogin = isFirstLogin;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public int getInvitedAwardSp() {
            return invitedAwardSp;
        }

        public void setInvitedAwardSp(int invitedAwardSp) {
            this.invitedAwardSp = invitedAwardSp;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }
    }
}
