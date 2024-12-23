package com.dhruva.lock.mvp.contract;

import android.content.Context;

import com.dhruva.lock.base.BasePresenter;
import com.dhruva.lock.base.BaseView;
import com.dhruva.lock.model.CommLockInfo;
import com.dhruva.lock.mvp.p.LockMainPresenter;

import java.util.List;



public interface LockMainContract {
    interface View extends BaseView<Presenter> {

        void loadAppInfoSuccess(List<CommLockInfo> list);
    }

    interface Presenter extends BasePresenter {
        void loadAppInfo(Context context);

        void searchAppInfo(String search, LockMainPresenter.ISearchResultListener listener);

        void onDestroy();
    }
}
