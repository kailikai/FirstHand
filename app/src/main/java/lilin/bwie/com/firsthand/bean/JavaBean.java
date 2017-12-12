package lilin.bwie.com.firsthand.bean;

/**
 * Created by せしおゆ on 2017/12/4.
 */

public class JavaBean {

    /**
     * data : {"private_key":"001C796300128D05866EEE8AFC90C3586F562C8A","app_id":"HYUP6ONU"}
     * ret : 0
     */

    public DataBean data;
    public int ret;

    public static class DataBean {
        /**
         * private_key : 001C796300128D05866EEE8AFC90C3586F562C8A
         * app_id : HYUP6ONU
         */

        public String private_key;
        public String app_id;
    }
}
