package com.sgcai.mvvmproject.net.resp;

import java.io.Serializable;
import java.util.List;

import cn.connie.mvvm.ex.BaseResponse;

/**
 * Created by hinge on 17/11/7.
 */

public class LabelListResult extends BaseResponse {

    public List<DataBean> data;

    public static class DataBean implements Serializable {
        /**
         * id : 0
         * isCollection : 0
         * isIndex : 0
         * label : 精选
         * labelId : 1
         * order : 1
         * showSubLabel : 1
         * state : 0
         */

        public String id;
        public int isCollection;
        public int showSubLabel;
        public int isIndex;
        public String label;
        public String labelId;
        public String order;
        public int state;

        /**
         * 是否显示精选
         */
        public boolean isShowCollection() {
            return isCollection == 1;
        }

        /**
         * 是否显示最新和最热
         */
        public boolean isShowSubLabel() {
            return showSubLabel == 1;
        }
    }
}
