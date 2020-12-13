package com.sgcai.mvvmproject.net.resp;

public class HomeActivityItem {

    /**
     * backgroundUrl : https://novelspread.s3.us-west-2.amazonaws.com/novelspread/banners/timg%20%2816%29.jpg
     * clickNum : 0
     * contentType : 2
     * createTime : 1563266344000
     * id : 35
     * jumpToUrl : https://www.baidu.com/?tn=08098039_pg&ch=12
     * novelId : 0
     * operator :
     * remark : 50
     * title : 呵呵
     * type : 1
     * weight : 50
     */

    private String backgroundUrl;
    private int contentType;
    private String jumpToUrl;
    private String title;


    private int activityId;
    private int boxSort;
    private int client;
    private long createTime;
    private String decription;
    private int delayTime;
    private String enName;
    private long endTime;
    private int id;
    private String imgUrl;
    private String json;
    private String name;
    private boolean show;
    private long startTime;


    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getJumpToUrl() {
        return jumpToUrl;
    }

    public void setJumpToUrl(String jumpToUrl) {
        this.jumpToUrl = jumpToUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getBoxSort() {
        return boxSort;
    }

    public void setBoxSort(int boxSort) {
        this.boxSort = boxSort;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}