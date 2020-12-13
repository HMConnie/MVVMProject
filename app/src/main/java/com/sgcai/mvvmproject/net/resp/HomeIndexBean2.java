package com.sgcai.mvvmproject.net.resp;

import java.util.List;

import cn.connie.mvvm.ex.BaseResponse;

/**
 * Describe:
 * Created by Dalvik on 2019-07-17.
 */
public class HomeIndexBean2 extends BaseResponse {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BookItemBean> Editorchoice;
        private List<BookItemBean> LadiesPick;
        private List<BookItemBean> NewOngoingRelease;
        private Translator RecruitingTranslator;
        private HomeActivityItem recruitTranslators;

        public Translator getRecruitingTranslator() {
            return RecruitingTranslator;
        }

        public void setRecruitingTranslator(Translator recruitingTranslator) {
            RecruitingTranslator = recruitingTranslator;
        }

        public List<BookItemBean> getEditorchoice() {
            return Editorchoice;
        }

        public void setEditorchoice(List<BookItemBean> editorchoice) {
            Editorchoice = editorchoice;
        }

        public List<BookItemBean> getLadiesPick() {
            return LadiesPick;
        }

        public void setLadiesPick(List<BookItemBean> ladiesPick) {
            LadiesPick = ladiesPick;
        }

        public List<BookItemBean> getNewOngoingRelease() {
            return NewOngoingRelease;
        }

        public void setNewOngoingRelease(List<BookItemBean> newOngoingRelease) {
            NewOngoingRelease = newOngoingRelease;
        }


        public HomeActivityItem getRecruitTranslators() {
            return recruitTranslators;
        }

        public void setRecruitTranslators(HomeActivityItem recruitTranslators) {
            this.recruitTranslators = recruitTranslators;
        }

        public static class Translator {
            private String BackgroundUrl;
            private String JumpToUrl;

            public String getBackgroundUrl() {
                return BackgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                BackgroundUrl = backgroundUrl;
            }

            public String getJumpToUrl() {
                return JumpToUrl;
            }

            public void setJumpToUrl(String jumpToUrl) {
                JumpToUrl = jumpToUrl;
            }
        }




    }
}
