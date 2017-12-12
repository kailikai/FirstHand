package lilin.bwie.com.firsthand.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lilin.bwie.com.firsthand.R;
import lilin.bwie.com.firsthand.RetrofitUtils;
import lilin.bwie.com.firsthand.bean.HostBean;
import lilin.bwie.com.firsthand.bean.JavaBean;
import lilin.bwie.com.firsthand.net.Api;
import lilin.bwie.com.firsthand.net.ApiService;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private String s2,id,private_key,s3;
    Long now,now2;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //======================首次握手=========================
        ApiService apiService = new RetrofitUtils().getInstance().getApiService(Api.url, ApiService.class);
        //时间戳
        now = getTime();
        Log.i("xxx", "时间戳" + String.valueOf(now));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("312045ED9D036BEED16E96F3878E222ED7E58AC9");
        stringBuffer.append("ANDROID");
        stringBuffer.append("12345");
        stringBuffer.append("1");
        stringBuffer.append(now + "");
        String parm = stringBuffer.toString();
        Log.i("xxx", "拼接结果" + parm);
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] result = digest.digest(parm.getBytes());
            //消息摘要
            String s = new BigInteger(1, result).toString(16);
            s2 = s.toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Observable<JavaBean> observable = apiService.getData("ANDROID", "12345", "1", now + "", s2);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "我的error" + e.getMessage());
                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                        JavaBean.DataBean data = javaBean.data;
                        id = data.app_id;
                        private_key = data.private_key;
                        sharedPreferences=MainActivity.this.getSharedPreferences("data",MODE_PRIVATE);
                        editor=sharedPreferences.edit();
                        editor.putString("id",id);
                        editor.putString("key",private_key);
                        editor.commit();
                        Log.i("xxx", "我的key" + private_key);
                        Log.i("xxx", "我的id" + id);
                        getSecond();
                    }
                });


    }
    //=========================获得端口号================

    public void getSecond(){
        now2=getTime();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(private_key);
        stringBuffer2.append(id);
        stringBuffer2.append("12345");
        stringBuffer2.append("1");
        stringBuffer2.append(now2 + "");
        String parm2= stringBuffer2.toString();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] result = digest.digest(parm2.getBytes());
            //消息摘要
            String ss = new BigInteger(1, result).toString(16);
            s3= ss.toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.url, ApiService.class);
        ApiService apiService = new RetrofitUtils().getInstance().getApiService(Api.url, ApiService.class);
        Observable<HostBean> host = apiService.getHost(id, "12345", "1", now2 + "", s3);
        host.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HostBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx",e.getMessage());
                    }

                    @Override
                    public void onNext(HostBean hostBean) {
                        String h=hostBean.getData().getUrl_host();
                        Log.i("xxx", "我的host地址" + h);
                        if(hostBean.toString().equals("")){
                            return;
                        }else {
                           handler.postDelayed(new Runnable() {
                               @Override
                               public void run() {
                                   Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                                   startActivity(intent);
                               }
                           },1000);
                        }
                    }
                });

    }
public static long getTime(){

        //获取系统时间的10位的时间戳
        long time = System.currentTimeMillis()/1000;

/*        String  str=String.valueOf(time);*/

        return time;


    }
    }
