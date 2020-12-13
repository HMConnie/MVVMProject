package com.sgcai.mvvmproject.net.resp;

import java.util.List;

import cn.connie.mvvm.ex.BaseResponse;

/**
 * Describe:
 * Created by Dalvik on 2019-07-17.
 */
public class HomeIndexBean3 extends BaseResponse {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BookItemBean> LatestUpdates;
        private List<CategoryTagItemBean> popularTags;
        private TopicTO topicTO;

        public TopicTO getTopicTO() {
            return topicTO;
        }

        public void setTopicTO(TopicTO topicTO) {
            this.topicTO = topicTO;
        }

        public List<BookItemBean> getLatestUpdates() {
            return LatestUpdates;
        }

        public void setLatestUpdates(List<BookItemBean> latestUpdates) {
            LatestUpdates = latestUpdates;
        }

        public List<CategoryTagItemBean> getPopularTags() {
            return popularTags;
        }

        public void setPopularTags(List<CategoryTagItemBean> popularTags) {
            this.popularTags = popularTags;
        }


        public static class TopicTO {

            /**
             * activityNum : 3
             * createTime : 1562833741000
             * id : 1
             * img : https://novelspread.s3.us-west-2.amazonaws.com/novelspread/banners/1-1F925141635.jpg
             * name : APP往期活动
             * remark :
             * status : 1
             */

            private int activityNum;
            private long createTime;
            private int id;
            private String img;
            private String name;
            private String remark;
            private int status;

            public int getActivityNum() {
                return activityNum;
            }

            public void setActivityNum(int activityNum) {
                this.activityNum = activityNum;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
