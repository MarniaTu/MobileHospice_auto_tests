package ru.iteco.fmhandroid.ui.utils;

import android.graphics.Bitmap;

import androidx.test.runner.screenshot.Screenshot;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import io.qameta.allure.kotlin.Allure;

public class AllureScreenshotWatcher extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        try {
            // 1. Захват скриншота
            Bitmap bitmap = Screenshot.capture().getBitmap();

            // 2. Конвертация в InputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

            // 3. Корректное прикрепление через Kotlin Allure
            Allure.getLifecycle().addAttachment(
                    "FAIL_" + description.getMethodName(),
                    inputStream,
                    "image/png",
                    "png"

            );

        } catch (Exception ex) {
            Allure.step("Screenshot error: " + ex.getMessage());
        }
    }
}