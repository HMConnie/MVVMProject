package com.sgcai.mvvmproject.net.resp;


import cn.connie.mvvm.ex.BaseResponse;

public class ChapterItemDataBean extends BaseResponse {
    public static final int CHAPTER = 0;
    public static final int VIP_BANNER = 1;
    private int id;
    private int chapterNumber;//第几章
    private int novelId; //小说id
    private long publishTime;
    private String updatedAt;
    private String title; //章节标题
    private String views; //章节浏览量
    private String translator; //译者
    private int isPayment; //支付需要付费,0不需要，1需要
    private int paymentAmount; //需要付费的金额
    private boolean unlockStatus; //解锁状态
    private int isDiscount; //是否打折 1 打折 0未打折
    private int originalPaymentAmount; //原价
    private String discount; //折扣
    private String icon; //图标
    private int type;//1 小说 2 漫画

    private int isLimitFree;// 是否限时免费，0不免费 1免费 ,
    private long countDownTime;// 限时免费倒计时


    private int limitedTimeFreeNovel;// 是否限时免费，0不免费 1免费 ,

    private int vipStatus;//vip免费状态,0 不是vip，1是vip
    private int firstLookStatus;//抢先看状态，0不是抢先看,1是抢先看

    private int currentReadId; //当前阅读的小说id(如果存在阅读记录的话)

    private int itemType;
    private String firstLookImg;//抢先看图片地址

    public String getFirstLookImg() {
        return firstLookImg;
    }

    public void setFirstLookImg(String firstLookImg) {
        this.firstLookImg = firstLookImg;
    }


    public int getLimitedTimeFreeNovel() {
        return limitedTimeFreeNovel;
    }

    public void setLimitedTimeFreeNovel(int limitedTimeFreeNovel) {
        this.limitedTimeFreeNovel = limitedTimeFreeNovel;
    }

    public int getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(int vipStatus) {
        this.vipStatus = vipStatus;
    }

    public int getFirstLookStatus() {
        return firstLookStatus;
    }

    public void setFirstLookStatus(int firstLookStatus) {
        this.firstLookStatus = firstLookStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public int getCurrentReadId() {
        return currentReadId;
    }

    public void setCurrentReadId(int currentReadId) {
        this.currentReadId = currentReadId;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public boolean isUnlockStatus() {
        return unlockStatus;
    }

    public void setUnlockStatus(boolean unlockStatus) {
        this.unlockStatus = unlockStatus;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIsLimitFree() {
        return isLimitFree;
    }

    public void setIsLimitFree(int isLimitFree) {
        this.isLimitFree = isLimitFree;
    }

    public long getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(long countDownTime) {
        this.countDownTime = countDownTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChapterItemDataBean{" +
                "id=" + id +
                ", chapterNumber=" + chapterNumber +
                ", novelId=" + novelId +
                ", publishTime=" + publishTime +
                ", updatedAt='" + updatedAt + '\'' +
                ", title='" + title + '\'' +
                ", views='" + views + '\'' +
                ", translator='" + translator + '\'' +
                ", isPayment=" + isPayment +
                ", paymentAmount=" + paymentAmount +
                ", unlockStatus=" + unlockStatus +
                ", isDiscount=" + isDiscount +
                ", originalPaymentAmount=" + originalPaymentAmount +
                ", discount='" + discount + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", isLimitFree=" + isLimitFree +
                ", countDownTime=" + countDownTime +
                ", currentReadId=" + currentReadId +
                '}';
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
