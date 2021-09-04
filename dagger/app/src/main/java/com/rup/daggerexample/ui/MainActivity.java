package com.rup.daggerexample.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.rup.daggerexample.MyApplication;
import com.rup.daggerexample.R;
import com.rup.daggerexample.di.component.DaggerActivityComponent;
import com.rup.daggerexample.di.module.ActivityModule;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication)getApplication()).applicationComponent)
                .build()
                .inject(this);

        TextView tvData = findViewById(R.id.tvData);
        tvData.setText(viewModel.getSomeData());
    }
}
