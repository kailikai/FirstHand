package lilin.bwie.com.firsthand.bean;

/**
 * Created by せしおゆ on 2017/12/8.
 */

public class HostBean {


    /**
     * data : {"url_host":"https://app.pretty.f8cam.com:17211"}
     * ret : 0
     */

    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * url_host : https://app.pretty.f8cam.com:17211
         */

        private String url_host;

        public String getUrl_host() {
            return url_host;
        }

        public void setUrl_host(String url_host) {
            this.url_host = url_host;
        }
    }
}
