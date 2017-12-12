package lilin.bwie.com.firsthand.net;

import lilin.bwie.com.firsthand.bean.CheckCodeBean;
import lilin.bwie.com.firsthand.bean.HostBean;
import lilin.bwie.com.firsthand.bean.JavaBean;
import lilin.bwie.com.firsthand.bean.RegisterBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by せしおゆ on 2017/12/4.
 */

public interface ApiService {
    //首次握手
    @POST("app/v1/first_hand")
    @FormUrlEncoded
    Observable<JavaBean> getData(@Field("type")String type, @Field("dev_id")String dev_id, @Field("ver_code")String ver_code, @Field("tick")String tick, @Field("sign")String sign);
    //获得端口号
    @POST("app/v1/get_host")
    @FormUrlEncoded
    Observable<HostBean> getHost(@Field("app_id")String app_id, @Field("dev_id")String dev_id, @Field("ver_code")String ver_code, @Field("tick")String tick, @Field("sign")String sign);
    //注册
    @POST("app/v1/user_reg")
    @FormUrlEncoded
    Observable<RegisterBean> getReg(@Field("app_id")String app_id, @Field("dev_id")String dev_id, @Field("ver_code")String ver_code, @Field("tick")String tick,@Field("mobile")String mobile,@Field("sign")String sign);
    //校验
    @POST("app/v1/user_check_rand")
    @FormUrlEncoded
    Observable<CheckCodeBean> getCheck(@Field("app_id")String app_id, @Field("dev_id")String dev_id, @Field("ver_code")String ver_code, @Field("tick")String tick, @Field("session")String session,@Field("rand")String rand ,@Field("passwd")String passwd,@Field("sign")String sign);


}
