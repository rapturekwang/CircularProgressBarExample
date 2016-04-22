package com.example.circularprogressbarexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer;
    private DonutProgress donutProgress;
    private CircleProgress circleProgress;
    private ArcProgress arcProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        circleProgress = (CircleProgress) findViewById(R.id.circle_progress);
        arcProgress = (ArcProgress) findViewById(R.id.arc_progress);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        donutProgress.setProgress(donutProgress.getProgress() + 1);
                        circleProgress.setProgress(circleProgress.getProgress() + 1);
                        arcProgress.setProgress(arcProgress.getProgress() + 1);
                    }
                });
            }
        }, 1000, 100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_viewpager:
                startActivity(new Intent(this, ViewPagerActivity.class));
                return true;
            case R.id.action_list:
                startActivity(new Intent(this, ItemListActivity.class));
                return true;
            case R.id.action_arch_tab:
                startActivity(new Intent(this, ArcInFragment.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        CircularProgressBar c1 = (CircularProgressBar) findViewById(R.id.circularprogressbar1);
//        c1.setProgress(45);
//
//        final CircularProgressBar c2 = (CircularProgressBar) findViewById(R.id.circularprogressbar2);
//        c2.animateProgressTo(0, 77, new CircularProgressBar.ProgressAnimationListener() {
//
//            @Override
//            public void onAnimationStart() {
//            }
//
//            @Override
//            public void onAnimationProgress(int progress) {
//                c2.setTitle(progress + "%");
//            }
//
//            @Override
//            public void onAnimationFinish() {
//                c2.setSubTitle("done");
//            }
//        });
//
//        CircularProgressBar c3 = (CircularProgressBar) findViewById(R.id.circularprogressbar3);
//        c3.setTitle("June");
//        c3.setSubTitle("2013");
//        c3.setProgress(42);
//
//        CircularProgressBar c4 = (CircularProgressBar) findViewById(R.id.circularprogressbar4);
//        c4.setProgress(99);
//    }
//}
