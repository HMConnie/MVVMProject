package com.sgcai.mvvmproject.net.resp;

import java.io.Serializable;
import java.util.List;

/**
 * Describe:
 * Created by Dalvik on 2019/4/8.
 */
public class BookItemBean implements Serializable {
    /**
     * "chapterId": 0,
     * "chineseName": "string",
     * "collectingTime": "2019-04-08T09:33:35.545Z",
     * "currentChapterNumber": 0,
     * "description": "string",
     * "hot": 0,
     * "id": 0,
     * "latestReadingTime": "2019-04-08T09:33:35.545Z",
     * "name": "string",
     * "readingProgress": 0,
     * "readingStatus": 0,
     * "score": 0,
     * "status": "string",
     * "subscribers": 0,
     * "thumb": "string",
     * "timeGroup": "string",
     * "totalChapterNumber": 0,
     * "updatedChapterNumber": 0,
     * "visible": false
     */
    //列表item字段
    private String chineseName;
    private String collectingTime;

    private String description;
    private int hot; //浏览量
    private int id;
    private String latestReadingTime;
    private String name;
    private float readingProgress; //整本书阅读进度
    private float pageReadingProgress; //当前章的阅读进度
    private int readingStatus;
    private float score;
    private int status;//书的状态
    private int subscribers;
    private String thumb;
    private int totalChapterNumber;
    private int updatedChapterNumber;//更新的章节数

    private int currentChapterNumber;//当前阅读章节number
    private String currentChapterTitle;//当前阅读章节标题
    private int currentChapterId;//当前阅读章节ID

    private int latestChapterNumber;//最新章节number
    private String latestChapterTitle;//最新章节标题
    private int latestChapterId;//最新章节ID

    private List<CategoryTagItemBean> tagTOS;//小说的标签

    private int type;//1 小说 2 漫画

    //详情页需要字段
    private String author;
    private String category;
    private int categoryId;
    private int chapterId;
    private String chapterName;
    private int chapterNum;
    private int isOriginal; //是否为原创
    private String lastUpdatetime;
    private String translator;
    private int isAddCollection;
    private String siteName;
    private String path;
    private List<BookItemBean> recommendNovels;

    private int tagId;

    private long countDownTime;//限时免费倒计时
    private int isLimitFree;//是否限时免费，0不免费 1免费
    private int lotteryFree;//是否抽奖免费，0不免费 1免费


    private int voteNumber;
    private int rewardsNumber;
    private int ranking;
    private int rankBy; //1 礼物 2 投票
    private String translatorName;

    private boolean download;//是否下载过

    private int notificationSwitchStatus;//小说订阅推送开关 1开 0关


    private int limitedTimeFreeNovel; //是否限时免费，0不免费 1免费
    private long limitedTimeFreeNovelCountDownSeconds;//限时免费倒计时 单位秒

    private int vipStatus;//vip状态,0 不是vip，1是vip
    private int firstLookStatus;//抢先看状态，0不是抢先看,1是抢先看


    private int sort;//排序

    //书架管理字段
    private boolean checked;//是否选择

    private boolean editMode; //是否是编辑模式


    private boolean downloading; //是否在下载中
    private String downloadPro;

    private String chapterData;//章节数据
    private String nextChapterId; //下一章的id

    public String getNextChapterId() {
        return nextChapterId;
    }

    public void setNextChapterId(String nextChapterId) {
        this.nextChapterId = nextChapterId;
    }

    public String getChapterData() {
        return chapterData;
    }

    public void setChapterData(String chapterData) {
        this.chapterData = chapterData;
    }

    //选中
    private boolean select;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public int getFirstLookStatus() {
        return firstLookStatus;
    }

    public void setFirstLookStatus(int firstLookStatus) {
        this.firstLookStatus = firstLookStatus;
    }

    public int getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(int vipStatus) {
        this.vipStatus = vipStatus;
    }

    public int getLimitedTimeFreeNovel() {
        return limitedTimeFreeNovel;
    }

    public void setLimitedTimeFreeNovel(int limitedTimeFreeNovel) {
        this.limitedTimeFreeNovel = limitedTimeFreeNovel;
    }

    public long getLimitedTimeFreeNovelCountDownSeconds() {
        return limitedTimeFreeNovelCountDownSeconds;
    }

    public void setLimitedTimeFreeNovelCountDownSeconds(long limitedTimeFreeNovelCountDownSeconds) {
        this.limitedTimeFreeNovelCountDownSeconds = limitedTimeFreeNovelCountDownSeconds;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getCollectingTime() {
        return collectingTime;
    }

    public void setCollectingTime(String collectingTime) {
        this.collectingTime = collectingTime;
    }

    public int getCurrentChapterNumber() {
        return currentChapterNumber;
    }

    public void setCurrentChapterNumber(int currentChapterNumber) {
        this.currentChapterNumber = currentChapterNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatestReadingTime() {
        return latestReadingTime;
    }

    public void setLatestReadingTime(String latestReadingTime) {
        this.latestReadingTime = latestReadingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getReadingProgress() {
        return readingProgress;
    }

    public void setReadingProgress(float readingProgress) {
        this.readingProgress = readingProgress;
    }

    public int getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(int readingStatus) {
        this.readingStatus = readingStatus;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getTotalChapterNumber() {
        return totalChapterNumber;
    }

    public void setTotalChapterNumber(int totalChapterNumber) {
        this.totalChapterNumber = totalChapterNumber;
    }

    public int getUpdatedChapterNumber() {
        return updatedChapterNumber;
    }

    public void setUpdatedChapterNumber(int updatedChapterNumber) {
        this.updatedChapterNumber = updatedChapterNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public int getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(int isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(String lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }


    public int getIsAddCollection() {
        return isAddCollection;
    }

    public void setIsAddCollection(int isAddCollection) {
        this.isAddCollection = isAddCollection;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public float getPageReadingProgress() {
        return pageReadingProgress;
    }

    public void setPageReadingProgress(float pageReadingProgress) {
        this.pageReadingProgress = pageReadingProgress;
    }

    public String getCurrentChapterTitle() {
        return currentChapterTitle;
    }

    public void setCurrentChapterTitle(String currentChapterTitle) {
        this.currentChapterTitle = currentChapterTitle;
    }

    public int getCurrentChapterId() {
        return currentChapterId;
    }

    public void setCurrentChapterId(int currentChapterId) {
        this.currentChapterId = currentChapterId;
    }

    public int getLatestChapterNumber() {
        return latestChapterNumber;
    }

    public void setLatestChapterNumber(int latestChapterNumber) {
        this.latestChapterNumber = latestChapterNumber;
    }

    public String getLatestChapterTitle() {
        return latestChapterTitle;
    }

    public void setLatestChapterTitle(String latestChapterTitle) {
        this.latestChapterTitle = latestChapterTitle;
    }

    public int getLatestChapterId() {
        return latestChapterId;
    }

    public void setLatestChapterId(int latestChapterId) {
        this.latestChapterId = latestChapterId;
    }


    public List<CategoryTagItemBean> getTagTOS() {
        return tagTOS;
    }

    public void setTagTOS(List<CategoryTagItemBean> tagTOS) {
        this.tagTOS = tagTOS;
    }

    public List<BookItemBean> getRecommendNovels() {
        return recommendNovels;
    }

    public void setRecommendNovels(List<BookItemBean> recommendNovels) {
        this.recommendNovels = recommendNovels;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }

    public int getRewardsNumber() {
        return rewardsNumber;
    }

    public void setRewardsNumber(int rewardsNumber) {
        this.rewardsNumber = rewardsNumber;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRankBy() {
        return rankBy;
    }

    public void setRankBy(int rankBy) {
        this.rankBy = rankBy;
    }

    public String getTranslatorName() {
        return translatorName;
    }

    public void setTranslatorName(String translatorName) {
        this.translatorName = translatorName;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public long getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(long countDownTime) {
        this.countDownTime = countDownTime;
    }

    public int getIsLimitFree() {
        return isLimitFree;
    }

    public void setIsLimitFree(int isLimitFree) {
        this.isLimitFree = isLimitFree;
    }

    public int getLotteryFree() {
        return lotteryFree;
    }

    public void setLotteryFree(int lotteryFree) {
        this.lotteryFree = lotteryFree;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNotificationSwitchStatus() {
        return notificationSwitchStatus;
    }

    public void setNotificationSwitchStatus(int notificationSwitchStatus) {
        this.notificationSwitchStatus = notificationSwitchStatus;
    }

    public boolean isDownloading() {
        return downloading;
    }

    public void setDownloading(boolean downloading) {
        this.downloading = downloading;
    }

    public String getDownloadPro() {
        return downloadPro;
    }

    public void setDownloadPro(String downloadPro) {
        this.downloadPro = downloadPro;
    }
}
