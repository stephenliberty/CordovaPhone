package org.vertafore.cordova;

    import org.apache.cordova.CordovaPlugin;
    import org.apache.cordova.CallbackContext;
    import android.telephony.TelephonyManager;
    import org.json.JSONArray;
    import org.json.JSONException;

    import android.content.Intent;

    /**
     * This class echoes a string called from JavaScript.
     */
    public class Phone extends CordovaPlugin {

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:5551231234"));
            List<ResolveInfo> callAppsList = context.getPackageManager().queryIntentActivities(callIntent, 0);
            System.out.println(callAppsList.length);
            System.out.println(callAppsList);
            if(callAppsList.length > 0) {
                callbackContext.success();
            } else {
                callbackContext.error();
            }
        }
    }