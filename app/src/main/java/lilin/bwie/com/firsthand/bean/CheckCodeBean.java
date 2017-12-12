package lilin.bwie.com.firsthand.bean;

/**
 * Created by Administrator on 2017/12/10.
 */

public class CheckCodeBean {

    /**
     * ret : 0
     * data : {"login":true,"session":"\u201c5559936945f96e05efbbf344\u201d","uname":"13800000","alert":true,"message":"఍឴஑ᩪᭆ100شز؀̶"}
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
         * login : true
         * session : “5559936945f96e05efbbf344”
         * uname : 13800000
         * alert : true
         * message : ఍឴஑ᩪᭆ100شز؀̶
         */

        private boolean login;
        private String session;
        private String uname;
        private boolean alert;
        private String message;

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
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
