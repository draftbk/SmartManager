package com.example.apple1.smartmanager2.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple1.smartmanager2.Application.ManagerData;
import com.example.apple1.smartmanager2.R;
import com.example.apple1.smartmanager2.fragment.RepairListFragment;
import com.example.apple1.smartmanager2.fragment.RepairRecordFragment;
import com.example.apple1.smartmanager2.fragment.SettingFragment;
import com.example.apple1.smartmanager2.net.GetPicture;
import com.example.apple1.smartmanager2.tools.PictureChangeToRound;
import com.example.apple1.smartmanager2.tools.SlidingMenu;

public class MainInterfaceActivity extends FragmentActivity implements View.OnClickListener {
    private TextView itemText1;
    private ImageView headImage;
    private Button  itemButton2, itemButton3, itemButton4, itemButton5;
    private SlidingMenu mLeftMenu;
    private ManagerData managerData;
    private Handler hanGetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);
        //获取Application
        managerData= (ManagerData) getApplication();
        //设置初始界面
        setface();
        //初始化控件
        init();
        //设置头像
        GetPicture getPicture=new GetPicture(hanGetImage,managerData.getImagePath());
        Log.d("test1", "managerData.getImagePath()" + "           " + managerData.getImagePath());
        getPicture.start();
        //设置监听
        setOnClick();

    }

    private void setface() {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new RepairListFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }


    private void init() {
        itemText1 = (TextView) findViewById(R.id.item_text_1);
        headImage=(ImageView)findViewById(R.id.img1);
        itemButton2 = (Button) findViewById(R.id.item_button_2);
        itemButton3 = (Button) findViewById(R.id.item_button_3);
        itemButton4 = (Button) findViewById(R.id.item_button_4);
        itemButton5 = (Button) findViewById(R.id.item_button_5);
        mLeftMenu = (SlidingMenu) findViewById(R.id.menu);
        itemText1.setText(managerData.getNickName());
        hanGetImage = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                Bitmap bitmap = (Bitmap) msg.obj;
                Log.d("test1", "bitmap" + "           " + bitmap);
                //把图片变圆
                PictureChangeToRound pictureChangeToRound=new PictureChangeToRound();
                bitmap= pictureChangeToRound.toRoundBitmap(bitmap);
                super.handleMessage(msg);
                headImage.setImageBitmap(bitmap);

            }
        };
    }

    private void setOnClick() {
        itemButton2.setOnClickListener(this);
        itemButton3.setOnClickListener(this);
        itemButton4.setOnClickListener(this);
        itemButton5.setOnClickListener(this);
    }

    public void toggle() {
        mLeftMenu.toggle();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.item_button_2:
                fragment = new RepairListFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                toggle();
                break;
            case R.id.item_button_3:

                fragment = new RepairRecordFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                toggle();
                break;
            case R.id.item_button_4:

                fragment = new SettingFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                toggle();
                break;
            case R.id.item_button_5:
                Intent intent =new Intent(MainInterfaceActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }



    }

}