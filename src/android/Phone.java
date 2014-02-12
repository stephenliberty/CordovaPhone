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
import android.content.pm.PackageManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class Phone extends CordovaPlugin {
    
    private enum Actions {
        canDevicePlaceAPhoneCall,
        canDeviceSendSMS
    }
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Actions currentAction = Actions.valueOf(action);
        switch(currentAction){
            case canDevicePlaceAPhoneCall:
                this.canDevicePlaceAPhoneCall(callbackContext);
                return true;
            case canDeviceSendSMS:
                this.canDeviceSendSMS(callbackContext);
                return true;
        }
        
        return false;
    }
    
    public void canDevicePlaceAPhoneCall(CallbackContext callbackContext) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:1231231234"));
        List<ResolveInfo> callAppsList = this.cordova.getActivity().getApplicationContext().getPackageManager().queryIntentActivities(callIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if(callAppsList.size() > 0) {
            callbackContext.success();
        } else {
            callbackContext.error("No handler");
        }
    }
    
    public void canDeviceSendSMS(CallbackContext callbackContext) {
        Intent callIntent = new Intent(Intent.CATEGORY_APP_MESSAGING);
        callIntent.setData(Uri.parse("sms:1231231234"));
        List<ResolveInfo> callAppsList = this.cordova.getActivity().getApplicationContext().getPackageManager().queryIntentActivities(callIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if(callAppsList.size() > 0) {
            callbackContext.success();
        } else {
            callbackContext.error("No handler");
        }
    }
}