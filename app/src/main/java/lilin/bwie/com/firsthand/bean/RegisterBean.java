package lilin.bwie.com.firsthand.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lilin.bwie.com.firsthand.RetrofitUtils;
import lilin.bwie.com.firsthand.net.Api;
import lilin.bwie.com.firsthand.net.ApiService;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2017/12/8.
 */

public class RegisterBean {
    String s2,s3;
    /**
     * ret : 0
     * data : {"\u201csession\u201d":"5559936945f96e05efbbf344"}
     */

    private int ret;
    private DataBean data;
    private String mobile;
    private String rand;
    private String password;
    private Context context;
    private String key,id;
    private String session;
    public RegisterBean(Context context) {
        this.context = context;
    }

    public String getRand() {
        return this.rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String session; // FIXME check this code

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }
    }
//点击的方法
    public void OnReg(String mobile){
        if(mobile==null){
            Log.i("xxc","点击为空");
        }
        Log.i("xxc","点击"+mobile);
        SharedPreferences sharedPreferences=context.getSharedPreferences("data",MODE_PRIVATE);
        id=sharedPreferences.getString("id","");
        key=sharedPreferences.getString("key","");
        Register(mobile,key,id);
        Log.i("xxc","这是我的APPID"+id+"钥匙"+key);
    }

    private void Register(String mobile,String key,String id) {

        ApiService apiService = new RetrofitUtils().getInstance().getApiService(Api.baseurl, ApiService.class);
        //时间戳
        Long now = getTime();
        Log.i("xxc", "时间戳" + String.valueOf(now));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(key);
        stringBuffer.append(id);
        stringBuffer.append("12345");
        stringBuffer.append("1");
        stringBuffer.append(now + "");
        stringBuffer.append(mobile);
        String parm = stringBuffer.toString();
        Log.i("xxc", "拼接结果" + parm);
        Log.i("xxc", "钥匙钥匙" + key);
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] result = digest.digest(parm.getBytes());
            //消息摘要
            String s = new BigInteger(1, result).toString(16);
             s2 = s.toUpperCase();
            Log.i("xxc", "SIng" + s2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Observable<RegisterBean> observable = apiService.getReg(id,"12345","1",now+"",mobile,s2);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxc", "请求失败啦" +e.getMessage());
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        String ret=String.valueOf(registerBean.toString());
                        session=registerBean.getData().session;
                        Log.i("xxc", "请求成功啦" + session);

                    }

                });


    }
    public void OnCheck(String rand,String passpord){
        if(rand==null&&passpord==null){
            Log.i("xxc","点击为空");
        }
        Checked(session,rand,passpord);
    }
    private void Checked(String session,String rand,String password) {
        ApiService apiService = new RetrofitUtils().getInstance().getApiService(Api.baseurl, ApiService.class);
        //时间戳
        Long now2 = getTime();
        Log.i("xxc", "时间戳" + String.valueOf(now2));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(key);
        stringBuffer2.append(id);
        stringBuffer2.append("12345");
        stringBuffer2.append("1");
        stringBuffer2.append(now2+"");
        stringBuffer2.append(session);
        stringBuffer2.append(rand);
        stringBuffer2.append(password);
        String parm2 = stringBuffer2.toString();
        Log.i("xxc", "检查拼接结果" + parm2);
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] result = digest.digest(parm2.getBytes());
            //消息摘要
            String s = new BigInteger(1, result).toString(16);
            s3 = s.toUpperCase();
            Log.i("xxc", "SINGG    " + s3);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Observable<CheckCodeBean> observable = apiService.getCheck(id,"12345","1",now2+"",session,rand,password,s3);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckCodeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxc","检查失败"+e.getMessage());
                    }

                    @Override
                    public void onNext(CheckCodeBean checkCodeBean) {
                        String ret=String.valueOf(checkCodeBean.getRet());
                       Log.i("xxc","检查成功"+ret);
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
