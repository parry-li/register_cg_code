package com.tdr.registration.service;

import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.bean.CityConfigureBean;
import com.tdr.registration.bean.LoginBean;
import com.tdr.registration.http.utils.DdcResult;


import java.util.List;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;


public interface BaseService {

    @POST()
    Observable<DdcResult<List<CityBean>>> getCity(@Url String url);

    @POST()
    Observable<DdcResult<LoginBean>> login(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<CityConfigureBean>> getCityConfigure(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<CarCheckBean>> carCheck(@Url String url, @Body RequestBody route);
}
