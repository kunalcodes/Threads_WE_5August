package com.example.threads_we;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTask1;
    private Button mBtnTask2;
    private WorkerThread workerThread;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread = new WorkerThread();
        workerThread.start();
        initViews();

        mBtnTask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskOne);
            }
        });
        mBtnTask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
            }
        });
    }

    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Task One " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Task Two " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private void initViews() {
        mBtnTask1 = findViewById(R.id.btnTask1);
        mBtnTask2 = findViewById(R.id.btnTask2);
    }
}