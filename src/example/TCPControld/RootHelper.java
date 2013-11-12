package example.TCPControld;

import android.util.Log;

import java.io.IOException;

/**
 * Project: example.TCPControld
 * Date: 12.11.13
 */
public class RootHelper {
    public static void ExecuteRootCommand(String cmd) {
        try {
            Runtime.getRuntime().exec("su -c" + cmd);
        } catch (IOException e) {
            Log.e("tcpcontrold", e.getLocalizedMessage());
        }
    }
}
