package com.pzj.androidmvp.module.register;


import com.pzj.androidmvp.base.BaseBean;
import com.pzj.androidmvp.base.BaseView;
import com.pzj.androidmvp.bean.User;

/**
 * Description : IRegisterView
 *
 * @author JeffPeng
 * @date 2020/2/8
 */

public interface IRegisterView extends BaseView {

    /**
     * 显示注册成功
     *
     * @param successMessage
     */
    void showRegisterSuccess(String successMessage);

    /**
     * 显示注册失败
     *
     * @param errorMessage
     */
    void showRegisterFailed(String errorMessage);

    /**
     * 注册成功
     *
     * @param user
     */
    void doSuccess(BaseBean<User> user);

}
