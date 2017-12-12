package lilin.bwie.com.firsthand.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lilin.bwie.com.firsthand.R;
import lilin.bwie.com.firsthand.bean.RegisterBean;
import lilin.bwie.com.firsthand.databinding.ActivityRegBinding;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_reg);
       ActivityRegBinding regBinding=DataBindingUtil.setContentView(this, R.layout.activity_reg);
        RegisterBean registerBean=new RegisterBean(this);
        regBinding.setReg(registerBean);


    }
}
