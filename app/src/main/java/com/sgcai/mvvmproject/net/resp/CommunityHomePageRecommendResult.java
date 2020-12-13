package com.sgcai.mvvmproject.net.resp;

import java.util.ArrayList;
import java.util.List;

import cn.connie.mvvm.ex.BaseResponse;

/**
 * Created by hinge on 2018/12/24.
 */

public class CommunityHomePageRecommendResult  extends BaseResponse {


    /**
     * data : {"list":[{"dynamicCommentCount":2,"dynamicCreateTime":"2018-12-21 16:02:23","dynamicTitle":"2222","informationLabel":"圈内新鲜事标签","dynamicContent":"动态内容","dynamicId":"107ead2b5b3746a8bac71e3b29ab9e12","dynamicImage":["http://testcdn.dui1dui.com/benben/1812/svvjpxozkrg.jpg"],"dynamicIsPraise":false,"dynamicPraiseCount":2,"dynamicReadNumber":2,"dynamicType":2,"fans":false,"follow":false,"userHeadPortrait":"http://testcdn.dui1dui.com/benben/1809/6orjlw1ri80.jpg","userId":"5587bc9600f440dabbd1df4e2cfe8357","userNickName":"哈哈"}],"pageCnt":49,"pageSize":10,"recordCnt":487}
     */

    public DataBean data;

    public static class DataBean {
        /**
         * list : [{"dynamicCommentCount":2,"dynamicCreateTime":"2018-12-21 16:02:23","dynamicTitle":"2222","informationLabel":"圈内新鲜事标签","dynamicContent":"动态内容","dynamicId":"107ead2b5b3746a8bac71e3b29ab9e12","dynamicImage":["http://testcdn.dui1dui.com/benben/1812/svvjpxozkrg.jpg"],"dynamicIsPraise":false,"dynamicPraiseCount":2,"dynamicReadNumber":2,"dynamicType":2,"fans":false,"follow":false,"userHeadPortrait":"http://testcdn.dui1dui.com/benben/1809/6orjlw1ri80.jpg","userId":"5587bc9600f440dabbd1df4e2cfe8357","userNickName":"哈哈"}]
         * pageCnt : 49
         * pageSize : 10
         * recordCnt : 487
         */

        public int pageCnt;
        public int pageSize;
        public int recordCnt;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * dynamicCommentCount : 2
             * dynamicCreateTime : 2018-12-21 16:02:23
             * dynamicTitle : 2222
             * informationLabel : 圈内新鲜事标签
             * dynamicContent : 动态内容
             * dynamicId : 107ead2b5b3746a8bac71e3b29ab9e12
             * dynamicImage : ["http://testcdn.dui1dui.com/benben/1812/svvjpxozkrg.jpg"]
             * dynamicIsPraise : false
             * dynamicPraiseCount : 2
             * dynamicReadNumber : 2
             * dynamicType : 2
             * fans : false
             * follow : false
             * userHeadPortrait : http://testcdn.dui1dui.com/benben/1809/6orjlw1ri80.jpg
             * userId : 5587bc9600f440dabbd1df4e2cfe8357
             * userNickName : 哈哈
             */

            public int dynamicCommentCount;
            public String dynamicCreateTime;
            public String dynamicTitle;
            public String informationLabel;
            public String contentMapjson;
            public String dynamicContent;
            public String dynamicId;
            public boolean dynamicIsPraise;
            public int dynamicPraiseCount;
            public boolean dynamicIsCollect;//是否收藏
            public int dynamicCollectCount;//收藏数

            public int dynamicReadNumber;
            public int dynamicType;
            public int save;//0可保存 1 不可保存
            public boolean fans;
            public boolean follow;
            public String userHeadPortrait;
            public String userId;
            public String userNickName;
            public List<String> dynamicImage;
            public int cardLevel;  //（打卡等级  1 打卡新秀，2打卡达人，3打卡明星 ）
            public boolean breakSign;  //（true 断签，false 未断签）

            public String videoDuration;
            public String videoSize;
            public String videoUrl;

            public List<String> getDynamicImage() {
                return dynamicImage == null ? new ArrayList<String>() : dynamicImage;
            }
        }
    }
}
