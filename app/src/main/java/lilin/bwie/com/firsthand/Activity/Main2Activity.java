package lilin.bwie.com.firsthand.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import lilin.bwie.com.firsthand.Fragment.one_frag;
import lilin.bwie.com.firsthand.Fragment.three_frag;
import lilin.bwie.com.firsthand.Fragment.two_frag;
import lilin.bwie.com.firsthand.R;

public class Main2Activity extends AppCompatActivity {
    BottomTabBar mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);
        mb.init(getSupportFragmentManager())
                .setImgSize(35,35)
                .setFontSize(14)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.YELLOW,Color.DKGRAY)
                .addTabItem("学习",R.mipmap.common_study_unselected,one_frag.class)
                .addTabItem("课程",R.mipmap.common_course_unselected, two_frag.class)
                .addTabItem("我的",R.mipmap.common_mine_unselected, three_frag.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }
}