package com.pzj.androidmvp.module.home;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pzj.androidmvp.R;
import com.pzj.androidmvp.adapter.ArticleAdapter;
import com.pzj.androidmvp.base.BaseActivity;
import com.pzj.androidmvp.base.BaseBean;
import com.pzj.androidmvp.bean.Article;
import com.pzj.androidmvp.util.ToastUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description : MainActivity 主页活动
 *
 * @author JeffPeng
 * @date 2020/2/8
 */


public class HomeActivity extends BaseActivity<HomePresenter> implements IHomeView, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.home_recycler_view)
    RecyclerView mHomeRecyclerView;
    private ArticleAdapter mArticleAdapter;
    private List<Article.DataDetailBean> mArticles = new ArrayList<>();
    private int mPosition;
    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getArticleList();
    }

    @Override
    protected void initData() {

    }


    @Override
    public void setArticleData(BaseBean<Article> list) {
        mArticles = list.data.datas;
        mArticleAdapter = new ArticleAdapter(R.layout.item_article_list, list.data.datas);
        mHomeRecyclerView.setAdapter(mArticleAdapter);
        mArticleAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void showArticleError(String errorMessage) {
        ToastUtil.showToast(errorMessage);
    }

    @Override
    public void showCollectSuccess(String successMessage) {
        ToastUtil.showToast(successMessage);
        mArticles.get(mPosition).collect = true;
        //因为收藏成功，所以要刷新界面，以显示小红心
        mArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCollectError(String errorMessage) {
        ToastUtil.showToast(errorMessage);

    }

    @Override
    public void showUncollectSuccess(String successMessage) {
        ToastUtil.showToast(successMessage);
        mArticles.get(mPosition).collect = false;
        //因为取消收藏成功，所以要刷新界面，以取消显示小红心
        mArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showUncollectError(String errorMessage) {
        ToastUtil.showToast(errorMessage);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.article_favorite) {
            mPosition = position;
            if (mArticles.get(position).collect) {
                presenter.uncollect(mArticles.get(position).id);
            } else {
                presenter.collect(mArticles.get(position).id);
            }
        }
    }
}
