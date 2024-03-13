package com.pzj.androidmvp.module.login;


import com.pzj.androidmvp.base.BaseView;

/**
 * Description : ILoginView
 *
 * @author JeffPeng
 * @date 2020/2/8
 */

public interface ILoginView extends BaseView {

    /**
     * 显示登陆成功
     *
     * @param successMessage 成功信息
     */
    void showLoginSuccess(String successMessage);

    /**
     * 显示登陆失败
     *
     * @param errorMessage 失败信息
     */
    void showLoginFailed(String errorMessage);

    void doSuccess();

}
