package org.vertafore.cordova;

    import org.apache.cordova.CordovaPlugin;
    import org.apache.cordova.CallbackContext;
    import android.telephony.TelephonyManager;
    import org.json.JSONArray;
    import org.json.JSONException;
import android.content.Context;
import java.util.List;
    import android.content.Intent;
import android.net.Uri;
import android.content.pm.ResolveInfo;

    /**
     * This class echoes a string called from JavaScript.
     */
    public class Phone extends CordovaPlugin {

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            if(action.equals("canDevicePlaceACall") != true) {
                return false;
            }
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:5551231234"));
            List<ResolveInfo> callAppsList = this.cordova.getActivity().getApplicationContext().getPackageManager().queryIntentActivities(callIntent, 0);
            System.out.println(callAppsList.size());
            System.out.println(callAppsList);
            if(callAppsList.size() > 0) {
                callbackContext.success();
            } else {
                callbackContext.error("No handler");
            }
            return true;
        }
    }