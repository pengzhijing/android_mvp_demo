package com.pzj.androidmvp.base;

/**
 * Description : BaseView
 *
 * @author JeffPeng
 * @date 2020/2/7
 */


public interface BaseView {

    void showLoading();

    void hideLoading();

    void onErrorCode(BaseBean bean);

}
