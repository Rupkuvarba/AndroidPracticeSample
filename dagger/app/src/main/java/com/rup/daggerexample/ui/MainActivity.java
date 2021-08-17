package com.rup.daggerexample.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.rup.daggerexample.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize MainViewModel
        viewModel = new MainViewModel(this.getApplicationContext());

        TextView tvData = findViewById(R.id.tvData);
        tvData.setText(viewModel.getSomeData());
    }
}
