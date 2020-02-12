package com.tdr.registration.service;

import com.tdr.registration.bean.CarCheckBean;
import com.tdr.registration.bean.CityBean;
import com.tdr.registration.bean.CityConfigureBean;
import com.tdr.registration.bean.CodeTableBean;
import com.tdr.registration.bean.EditInfoBean;
import com.tdr.registration.bean.InsuranceBean;
import com.tdr.registration.bean.InsuranceWaitBean;
import com.tdr.registration.bean.LoginBean;
import com.tdr.registration.bean.PhotoBean;
import com.tdr.registration.http.utils.DdcResult;


import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;
import rx.Observable;


public interface BaseService {
    /**
     * 公共请求
     *
     * @param url
     * @param route
     * @return
     */
    @POST()
    Observable<DdcResult> baseRequest(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<CityBean>>> getCity(@Url String url);

    @POST()
    Observable<DdcResult<LoginBean>> login(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<CityConfigureBean>>> getCityConfigure(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<CarCheckBean>> carCheck(@Url String url, @Body RequestBody route);


    @Multipart
    @POST()
    Call<DdcResult<PhotoBean>> sendImage(@Url String url, @Part MultipartBody.Part file);

    @POST()
    Observable<DdcResult> carChang(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<CodeTableBean>>> codeTable(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<InsuranceBean>>> getInsurance(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<EditInfoBean>> getEditInfo(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<InsuranceWaitBean>>> gWaitInsurance(@Url String url, @Body RequestBody route);
}


