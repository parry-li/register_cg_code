package com.tdr.registrationv3.service;

import com.tdr.registrationv3.bean.BlcakCarBean;
import com.tdr.registrationv3.bean.CarCheckBean;
import com.tdr.registrationv3.bean.CityBean;
import com.tdr.registrationv3.bean.CityConfigureBean;
import com.tdr.registrationv3.bean.CodeTableBean;
import com.tdr.registrationv3.bean.EditInfoBean;
import com.tdr.registrationv3.bean.InfoBean;
import com.tdr.registrationv3.bean.InsuranceBean;
import com.tdr.registrationv3.bean.InsuranceWaitBean;
import com.tdr.registrationv3.bean.LoginBean;
import com.tdr.registrationv3.bean.PhotoBean;
import com.tdr.registrationv3.bean.StatisticsBean;
import com.tdr.registrationv3.bean.UnitBean;
import com.tdr.registrationv3.http.utils.DdcResult;


import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
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

    @POST()
    Observable<DdcResult<StatisticsBean>> getStatistics(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<UnitBean>> getUnit(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<InfoBean>> queryCarInfo(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<BlcakCarBean>>> checkShelvesNumber(@Url String url, @Body RequestBody route);

    @POST()
    Observable<DdcResult<List<BlcakCarBean>>> checkShelvesLabel(@Url String url, @Body RequestBody route);
    @POST()
    Observable<DdcResult<StatisticsBean>> query2Unit(@Url String url, @Body RequestBody route);

    @POST()
    Call<DdcResult> checkLabel(@Url String url, @Body RequestBody route);
}


