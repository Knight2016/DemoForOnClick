package com.bolg.macbook.demoforonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn01, btn02, btn03;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        text = (TextView) findViewById(R.id.text);

        /**
         * ①匿名内部类监听
         */
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("您通过（①匿名内部类监听）触发了我");
            }
        });

        /**
         * ②自定义监听类
         */
        btn02.setOnClickListener(onClickListener);

        /**
         * ③主类实现监听接口
         */
        btn03.setOnClickListener(this);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            text.setText("您通过（②自定义监听类）触发了我");
        }
    };

    @Override
    public void onClick(View view) {
        text.setText("您通过（③主类实现监听接口）触发了我");
    }

    /**
     * ④XML绑定监听
     */
    public void xmlOnclick(View v) {
        text.setText("您通过（④XML绑定监听）触发了我");
    }
}
