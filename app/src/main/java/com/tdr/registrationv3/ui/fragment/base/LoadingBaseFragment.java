package com.tdr.registrationv3.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.tdr.registrationv3.http.LifeSubscription;
import com.tdr.registrationv3.http.Stateful;
import com.tdr.registrationv3.service.BasePresenter;
import com.tdr.registrationv3.view.LoadingPage;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by parry
 */

public abstract class LoadingBaseFragment<P extends BasePresenter> extends BaseFragment implements LifeSubscription, Stateful {

    protected P mPresenter;


    public boolean isRefresh = true;

    public LoadingPage mLoadingPage;

    public boolean mIsVisible = false;     // fragment是否显示了

    private boolean isPrepared = false;

    private boolean isFirst = true; //只加载一次界面


    protected View contentView;
    private Unbinder bind;
    private Subscription subscription;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {

            if (mLoadingPage == null) {
                mLoadingPage = new LoadingPage(getContext()) {
                    @Override
                    protected void initView() {
                        if (isFirst) {
                            LoadingBaseFragment.this.contentView = this.contentView;
                            bind = ButterKnife.bind(LoadingBaseFragment.this, contentView);
                            LoadingBaseFragment.this.initView();
                            isFirst = false;
                        }
                    }

                    @Override
                    protected void loadData() {
                        LoadingBaseFragment.this.loadData();
                    }

                    @Override
                    protected int getLayoutId() {
                        return LoadingBaseFragment.this.getLayoutId();
                    }
                };
            }
            isPrepared = true;
            loadBaseData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLoadingPage;


    }


    protected abstract P setPresenter();

    /**
     * 在这里实现Fragment数据的缓加载.
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {//fragment可见
            mIsVisible = true;
            onVisible();
        } else {//fragment不可见
            mIsVisible = false;
            onInvisible();
        }
//        mIsVisible = true;
//        onVisible();
    }

    @Override
    public void setState(int state) {
        mLoadingPage.state = state;
        if (isRefresh) {
            mLoadingPage.showPage();
        }

    }


    protected void onInvisible() {
//        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
//            this.mCompositeSubscription.unsubscribe();
//        }

    }

    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */
    protected void onVisible() {


        if (isFirst) {

            mPresenter = setPresenter();
            if (mPresenter != null) {
                mPresenter.attachView(this);
            }
        }
        loadBaseData();//根据获取的数据来调用showView()切换界面
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    public void loadBaseData() {
        if (!mIsVisible || !isPrepared || !isFirst) {
            return;
        }
        loadData();
    }

    /**
     * 1
     * 根据网络获取的数据返回状态，每一个子类的获取网络返回的都不一样，所以要交给子类去完成
     */
    protected abstract void loadData();

    /**
     * 2
     * 网络请求成功在去加载布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 3
     * 子类关于View的操作(如setAdapter)都必须在这里面，会因为页面状态不为成功，而binding还没创建就引用而导致空指针。
     * loadData()和initView只执行一次，如果有一些请求需要二次的不要放到loadData()里面。
     */
    protected abstract void initView();

    //    /**
    //     * dagger2注入
    //     */
    //    protected abstract void initInject();


    private CompositeSubscription mCompositeSubscription;

    //用于添加rx的监听的在onDestroy中记得关闭不然会内存泄漏。
    @Override
    public void bindSubscription(Subscription subscription) {
        this.subscription = subscription;
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(subscription);
    }





    @Override
    public void onDetach() {
        super.onDetach();
        if (bind != null) {
            bind.unbind();
        }
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
