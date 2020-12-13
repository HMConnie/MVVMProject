package com.sgcai.mvvmproject.net.resp;

import com.google.gson.Gson;

import java.util.List;

/**
 *
 */
public class ChapterContentDataBean {
    /**
     * "id": 1,
     * "chapter_number": 1,
     * "chapter_title": "The Young Boy – Lin Xun",
     * "chapter_content":
     */

    private int chapterId;
    private String title;
    private int currentChapterNumber;
    private String content;

    private String novelChineseName;

    private String novelEnglishName;

    private String translator;

    private boolean unlockStatus;
    private int isPayment;
    private int paymentAmount;
    private int isDiscount; //是否打折 1 打折 0未打折
    private int originalPaymentAmount; //原价
    private String discount; //折扣

    private String nowTime;

    private int commentNum;
    private CharSequence notifyMsg;
    private List<BookItemBean> recommend;

    private String newUserVipFreeMes;// 新用户付费小说免费读提示语 ,


    private boolean autoUnLock;
    private List<ComicChapterItem> comicChapterContent;

    //新app缓存到本地为加密数据
    private boolean newApp = true;
    private boolean isLockPage;


    public boolean isNewApp() {
        return newApp;
    }

    public String getNewUserVipFreeMes() {
        return newUserVipFreeMes;
    }

    public void setNewUserVipFreeMes(String newUserVipFreeMes) {
        this.newUserVipFreeMes = newUserVipFreeMes;
    }

    public void setNewApp(boolean newApp) {
        this.newApp = newApp;
    }

    public List<BookItemBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<BookItemBean> recommend) {
        this.recommend = recommend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCurrentChapterNumber() {
        return currentChapterNumber;
    }

    public void setCurrentChapterNumber(int currentChapterNumber) {
        this.currentChapterNumber = currentChapterNumber;
    }

    public List<ComicChapterItem> getComicChapterContent() {
        return comicChapterContent;
    }

    public void setComicChapterContent(List<ComicChapterItem> comicChapterContent) {
        this.comicChapterContent = comicChapterContent;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNovelChineseName() {
        return novelChineseName;
    }

    public void setNovelChineseName(String novelChineseName) {
        this.novelChineseName = novelChineseName;
    }

    public String getNovelEnglishName() {
        return novelEnglishName;
    }

    public void setNovelEnglishName(String novelEnglishName) {
        this.novelEnglishName = novelEnglishName;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }


    public boolean isUnlockStatus() {
        return unlockStatus;
    }

    public void setUnlockStatus(boolean unlockStatus) {
        this.unlockStatus = unlockStatus;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }


    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public CharSequence getNotifyMsg() {
        return notifyMsg;
    }

    public void setNotifyMsg(CharSequence notifyMsg) {
        this.notifyMsg = notifyMsg;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public boolean isAutoUnLock() {
        return autoUnLock;
    }

    public void setAutoUnLock(boolean autoUnLock) {
        this.autoUnLock = autoUnLock;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }


    public int getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(int isDiscount) {
        this.isDiscount = isDiscount;
    }

    public int getOriginalPaymentAmount() {
        return originalPaymentAmount;
    }

    public void setOriginalPaymentAmount(int originalPaymentAmount) {
        this.originalPaymentAmount = originalPaymentAmount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setLockPage(boolean isLockPage) {
        this.isLockPage = isLockPage;
    }

    public boolean isLockPage() {
        return isLockPage;
    }

    public static class ComicChapterItem {

        /**
         * chapterId : 1
         * createTime : 1583292497000
         * id : 1
         * imgHeight : 0
         * imgNumber : 1
         * imgUrl : hztvs@/5tkszcjn4fryonm-ritey.ios/to|ers54=4j2i96d8al17e?8l6lf83i979ja6d;.ppm
         * imgWidth : 0
         * updateTime : 1583292502000
         */

        private int chapterId;
        private long createTime;
        private int id;
        private int imgHeight;
        private int imgNumber;
        private String imgUrl;
        private int imgWidth;
        private long updateTime;


        public static ComicChapterItem objectFromData(String str) {

            return new Gson().fromJson(str, ComicChapterItem.class);
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getImgHeight() {
            return imgHeight;
        }

        public void setImgHeight(int imgHeight) {
            this.imgHeight = imgHeight;
        }

        public int getImgNumber() {
            return imgNumber;
        }

        public void setImgNumber(int imgNumber) {
            this.imgNumber = imgNumber;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getImgWidth() {
            return imgWidth;
        }

        public void setImgWidth(int imgWidth) {
            this.imgWidth = imgWidth;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }


    }

}
