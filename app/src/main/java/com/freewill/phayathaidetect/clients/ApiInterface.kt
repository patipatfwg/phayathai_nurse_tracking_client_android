package com.fg.mdp.fwgfacilitiesfinder.clients


import com.google.gson.JsonObject
import io.reactivex.Observable
import okhttp3.RequestBody

import retrofit2.Response
import retrofit2.http.*
import java.util.*


interface ApiInterface {
//    @GET("/apimdc/api/locker")
//    //@GET("/apimdc/api/locker?user=ponglang&locker_id=FWG001")
//    fun getLocker(@Query("user") user: String
//                  , @Query("locker_id") locker_id: String)
//            : Observable<Response<JsonObject>>

//    @GET("/apimdc/api/locker/")
//    fun getLocker( @Query("user") user: String
//                   ,@Query("locker_id") locker_id: String): Observable<Response<JsonObject>>


//    @FormUrlEncoded
//    @POST("/api/locker")
//    fun getLocker(@Field("user") user: String,
//                 @Field("locker_id") locker_id: String)
//            : Observable<Response<JsonObject>>


    //@FormUrlEncoded
    
    @Headers("Content-Type:application/json; charset=UTF-8")
    @POST("/api/locker/")
    fun getLocker(@Body data : HashMap<String, String>)
            : Observable<Response<JsonObject>>

    @GET("/hrservices/api/login?")
    abstract fun APIlogin(
        @Query("username") username: String, @Query("password") password: String,
        @Query("platform") platform: String
    ): Observable<Response<JsonObject>>

    @FormUrlEncoded
    //@Headers("Content-Type: application/json")
    @POST("/restroom/wait_restroom/authen.php?")
    abstract fun getDataFromURL(
        @Field("employee_id") employee_id: String,
        @Field("name") name: String,
        @Field("surname") platform: String,
        @Field("os") os: String,
        @Field("imei")imei: String,
        @Field("token_id")token_id: String

    ): Observable<Response<JsonObject>>


    @FormUrlEncoded
    //@Headers("Content-Type: application/json")
    @POST("/restroom/wait_restroom/get_restroom_status.php?")
    abstract fun getUrlStatus(
        @Field("employee_id") employee_id: String

    ): Observable<Response<JsonObject>>

    @POST("v2detect.php")
     fun getSendDetect( @Body data: RequestBody)
    : Observable<Response<JsonObject>>

}