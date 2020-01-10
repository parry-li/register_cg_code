package com.tdr.registration.presenter;

import com.tdr.registration.bean.CuBean;
import com.tdr.registration.http.utils.DdcResult;


import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


public interface NewsService {

    @POST("api/site/queryRegister")
    Observable<DdcResult<CuBean>> getCuData(@Query("DEVICEIDs") String DEVICEIDs);
}
