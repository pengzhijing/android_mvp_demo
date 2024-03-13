package com.pzj.androidmvp.module.home;


import com.pzj.androidmvp.base.BaseBean;
import com.pzj.androidmvp.base.BaseView;
import com.pzj.androidmvp.bean.Article;

/**
 * created by xucanyou666
 * on 2020/2/8 00:37
 * email：913710642@qq.com
 */
public interface IHomeView extends BaseView {
    /**
     * 设置文章数据
     *
     * @param list 文章list
     */
    void setArticleData(BaseBean<Article> list);

    /**
     * 显示文章失败
     *
     * @param errorMessage 失败信息
     */
    void showArticleError(String errorMessage);

    /**
     * 显示收藏成功
     *
     * @param successMessage 成功信息
     */
    void showCollectSuccess(String successMessage);

    /**
     * 显示收藏失败
     *
     * @param errorMessage 失败信息
     */
    void showCollectError(String errorMessage);

    /**
     * 显示未收藏成功
     *
     * @param successMessage 成功信息
     */
    void showUncollectSuccess(String successMessage);

    /**
     * 显示未收藏失败
     *
     * @param errorMessage 失败信息
     */
    void showUncollectError(String errorMessage);
}
