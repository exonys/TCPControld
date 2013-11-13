package example.TCPControld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Date: 12.11.13
 */

public class OnNetworkChanged extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Log.v("tcpcontrold", "Network Changed");
        Context context = Home.getContext();
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                //Wifi
                Log.v("tcpcontrold", "set mode WiFi");
                RootHelper.ExecuteRootCommand("sysctl -w net.ipv4.tcp_congestion_control=westwood");
            } else {
                //Cell
                RootHelper.ExecuteRootCommand("sysctl -w net.ipv4.tcp_congestion_control=rino");
                Log.v("tcpcontrold", "set mode Cell");
            }
        }

    }
}