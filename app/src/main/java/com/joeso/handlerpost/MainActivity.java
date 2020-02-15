package com.joeso.handlerpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler=new Handler();// we don't need any additional code for the Handler here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton=findViewById(R.id.button);
        final TextView mTextView=findViewById(R.id.textView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    String result;
                    @Override
                    public void run(){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            result="work done.";
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(result);
                            }
                        });
                    }
                }.start();
            }
        });

    }
}
