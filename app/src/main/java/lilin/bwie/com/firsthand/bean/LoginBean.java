package lilin.bwie.com.firsthand.bean;

/**
 * Created by Administrator on 2017/12/8.
 */

public class LoginBean {

    /**
     * ret : 0
     * data : {"session":"5559936945f96e05efbbf344","alert":false,"message":" ୨໛מ௳"}
     */

    private int ret;
    private DataBean data;

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
        /**
         * session : 5559936945f96e05efbbf344
         * alert : false
         * message :  ୨໛מ௳
         */

        private String session;
        private boolean alert;
        private String message;

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
