package com.example.fundemental7_1homework;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> load;

    SimpleAsyncTask(TextView tv, ProgressBar ld) {
        mTextView = new WeakReference<>(tv);
        load = new WeakReference<>(ld);
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;


    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    protected void onProgressUpdate(Integer... progress) {


        load.get().setProgress(progress[0]);


    }


    @Override
    protected String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;

        int chunk = s / 100;

        try {

            for (int i = 1; i < 100; i++) {
                Thread.sleep(chunk);
                publishProgress(i);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }
}


