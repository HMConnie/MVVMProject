package com.sgcai.mvvmproject.net.resp;

import java.util.List;

import cn.connie.mvvm.ex.BaseResponse;

/**
 *
 */
public class ChapterBean extends BaseResponse {

    private ChapterListBean data;
    private ChapterListOtherData chapterListOtherData;

    public ChapterListBean getData() {
        return data;
    }

    public void setData(ChapterListBean data) {
        this.data = data;
    }


    public ChapterListOtherData getChapterListOtherData() {
        return chapterListOtherData;
    }

    public void setChapterListOtherData(ChapterListOtherData chapterListOtherData) {
        this.chapterListOtherData = chapterListOtherData;
    }

    public static class ChapterListBean {
        private List<ChapterItemDataBean> list;
        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ChapterItemDataBean> getList() {
            return list;
        }

        public void setList(List<ChapterItemDataBean> list) {
            this.list = list;
        }
    }

    public static class ChapterListOtherData {
        private String chapterListFirstLookImg;

        public String getChapterListFirstLookImg() {
            return chapterListFirstLookImg;
        }

        public void setChapterListFirstLookImg(String chapterListFirstLookImg) {
            this.chapterListFirstLookImg = chapterListFirstLookImg;
        }
    }
}
