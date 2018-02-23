package com.zl.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zl.retrofittest.bean.DouBanRadioBean;
import com.zl.retrofittest.mvp.MainContract;
import com.zl.retrofittest.mvp.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Present mainPresenter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        new MainPresenter(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.start();
            }
        });
    }

    @Override
    public void getHttpTestSuccess(DouBanRadioBean douBanRadioBean) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < douBanRadioBean.getChannels().size(); i++){
            stringBuilder.append(douBanRadioBean.getChannels().get(i).getName()).append("\t");
        }
        tv.setText(stringBuilder);

    }

    @Override
    public void setPresenter(MainContract.Present presenter) {
        this.mainPresenter = presenter;
    }
}
