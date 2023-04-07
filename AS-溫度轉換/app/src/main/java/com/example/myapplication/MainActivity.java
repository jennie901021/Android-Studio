package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextTemperature;
    private RadioGroup mRadioGroupTemperatureUnit;
    private RadioButton mRadioButtonCelsius;
    private RadioButton mRadioButtonFahrenheit;
    private Button mButtonConvert;
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 綁定UI元件
        mEditTextTemperature = findViewById(R.id.editTextTemperature);
        mRadioGroupTemperatureUnit = findViewById(R.id.radioGroupTemperatureUnit);
        mRadioButtonCelsius = findViewById(R.id.radioButtonCelsius);
        mRadioButtonFahrenheit = findViewById(R.id.radioButtonFahrenheit);
        mButtonConvert = findViewById(R.id.buttonConvert);
        mTextViewResult = findViewById(R.id.textViewResult);

        // 為按鈕設定OnClickListener
        mButtonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取得使用者輸入的溫度
                String temperatureString = mEditTextTemperature.getText().toString();
                if (TextUtils.isEmpty(temperatureString)) {
                    mTextViewResult.setText("請輸入溫度！");
                    return;
                }
                double temperature = Double.parseDouble(temperatureString);

                // 判斷使用者選擇的溫度單位
                if (mRadioButtonCelsius.isChecked()) {
                    // 轉換攝氏溫度為華氏溫度
                    double fahrenheit = (temperature * 1.8) + 32;
                    mTextViewResult.setText(String.format("%.1f °F", fahrenheit));
                } else if (mRadioButtonFahrenheit.isChecked()) {
                    // 轉換華氏溫度為攝氏溫度
                    double celsius = (temperature - 32) / 1.8;
                    mTextViewResult.setText(String.format("%.1f °C", celsius));
                } else {
                    mTextViewResult.setText("請選擇溫度單位！");
                }
            }
        });
    }
}