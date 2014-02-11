package org.apache.cordova.plugin;

    import org.apache.cordova.CordovaPlugin;
    import org.apache.cordova.CallbackContext;
    import android.telephony.TelephonyManager;
    import android.intent;

    /**
     * This class echoes a string called from JavaScript.
     */
    public class Echo extends CordovaPlugin {

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:5551231234"));
            List<ResolveInfo> callAppsList = context.getPackageManager().queryIntentActivities(callIntent, 0);
            if(callAppsList.length > 0) {
                callbackContext.success();
            } else {
                callbackContext.error();
            }
        }
    }