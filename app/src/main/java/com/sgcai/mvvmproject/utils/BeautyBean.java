package com.sgcai.mvvmproject.utils;

public class BeautyBean {
    public String imagePath;
    public int whitening;//美白程度
    public int smoothing;//磨皮程度
    public int thinface;//瘦脸程度
    public int enlarge_eye;//大眼程度
    public int remove_eyebrow;//去眉毛程度

    public BeautyBean(String imagePath) {
        this.imagePath = imagePath;
    }
}
