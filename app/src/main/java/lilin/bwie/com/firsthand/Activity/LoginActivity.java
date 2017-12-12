package lilin.bwie.com.firsthand.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lilin.bwie.com.firsthand.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mYu;
    /**
     * +86
     */
    private EditText mPhone;
    private LinearLayout mZhu;
    /**
     * 新密码不少于6位数
     */
    private EditText mPassword;
    private LinearLayout mLinearLayout;
    /**
     * 忘记密码
     */
    private TextView mWangji;
    /**
     * 登录
     */
    private Button mButton;
    /**
     * 手机号快速注册
     */
    private Button mButton2;
    /**
     * 用社区账号登录
     */
    private TextView mTextView2;
    private ImageView mWeixin;
    private ImageView mQq;
    /**
     * 微信登录
     */
    private TextView mTextView3;
    /**
     * QQ登录
     */
    private TextView mTextView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        initView();

    }

    private void initView() {
        mYu = (ImageView) findViewById(R.id.yu);
        mPhone = (EditText) findViewById(R.id.phone);
        mZhu = (LinearLayout) findViewById(R.id.zhu);
        mPassword = (EditText) findViewById(R.id.password);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mWangji = (TextView) findViewById(R.id.wangji);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mWeixin = (ImageView) findViewById(R.id.weixin);
        mQq = (ImageView) findViewById(R.id.qq);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                break;
            case R.id.button2:
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
                break;
        }
    }
}
