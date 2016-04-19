package snap.cam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;

//import willsimm.matcamlib;

//import com.afollestad.materialcamera.MaterialCamera;


//import mcl


public class CamActivity extends AppCompatActivity {



        private final static int CAMERA_RQ = 6969;
        private Window wind;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



            /******block is needed to raise the application if the lock is
            wind = this.getWindow();
            wind.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            wind.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            wind.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        /* ^^^^^^^block is needed to raise the application if the lock is*/

            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


            MaterialCamera xyz;
            xyz = new MaterialCamera(this);
            xyz.countdownSeconds(30f)


                    .allowRetry(false)                          // Whether or not 'Retry' is visible during playback
                    .autoSubmit(true)                         // Whether or not user is allowed to playback videos after recording. This can affect other things, discussed in the next section.
                            //.saveDir(saveFolder)                       // The folder recorded videos are saved to
                            //.primaryColorAttr(R.attr.colorPrimary)     // The theme color used for the camera, defaults to colorPrimary of Activity in the constructor
                    .showPortraitWarning(false)                 // Whether or not a warning is displayed if the user presses record in portrait orientation
                    .defaultToFrontFacing(false)               // Whether or not the camera will initially show the front facing camera
                            //.retryExits(false)                         // If true, the 'Retry' button in the playback screen will exit the camera instead of going back to the recorder
                    .start(CAMERA_RQ);
/*
            wind = this.getWindow();
            wind.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            wind.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            wind.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        /* ^^^^^^^block is needed to raise the application if the lock is*/



        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Received recording or error from MaterialCamera
            if (requestCode == CAMERA_RQ) {

                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "Saved to: " + data.getDataString(), Toast.LENGTH_LONG).show();
                } else if(data != null) {
                    Exception e = (Exception) data.getSerializableExtra(MaterialCamera.ERROR_EXTRA);
                    e.printStackTrace();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }
    }