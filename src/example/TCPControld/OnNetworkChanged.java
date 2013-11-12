package example.TCPControld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Date: 12.11.13
 */

public class OnNetworkChanged extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Context context = Home.getContext();
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                //Wifi
            } else {
                //Cell
            }
        }

    }
}