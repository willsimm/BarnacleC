package snap.cam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by will on 10/03/16.
 */



public class UpReceiver extends BroadcastReceiver  {
    @Override
    public void onReceive(Context context, Intent intent) {


        Log.i("hello", "onreceive called!");
        //Toast.makeText(context, "Up reciever Intent Detected.", Toast.LENGTH_SHORT).show();
/*
       Intent intentEmpty = new Intent(context, willsimm.barnaclec.EmptyActivity.class);
        intentEmpty.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentEmpty);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        Intent intentCam = new Intent(context, snap.cam.MainActivity.class);
        intentCam.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentCam);


    }
}