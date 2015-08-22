package com.example.apple1.smartmanager2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.apple1.smartmanager2.R;


/**
 * Created by draft on 2015/7/20.
 */
public class AllRepairBillActivity extends Activity {

    ImageView image=null;
    EditText editLocation=null,editPhoneNumber=null,editRepairType=null,
            editSource=null,editRepresentation=null,editRemark=null;
    ImageButton btnCall=null;
    Button btnRepair;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_repair_bill);
        init();

    }


    //初始化各个控件
    private void init() {
        //报修的图片
        image=(ImageView)findViewById(R.id.image);
        //各个EditText
        editLocation=(EditText)findViewById(R.id.edit_location);
        editPhoneNumber=(EditText)findViewById(R.id.edit_phone_number);
        editRepairType=(EditText)findViewById(R.id.edit_repair_type);
        editSource=(EditText)findViewById(R.id.edit_source);
        editRepresentation=(EditText)findViewById(R.id.edit_representation);
        editRemark=(EditText)findViewById(R.id.edit_remark);
        //打电话的ImageButton
        btnCall=(ImageButton)findViewById(R.id.btn_call);
        //完成修理的按钮
        btnRepair=(Button)findViewById(R.id.btn_repair);

    }
}