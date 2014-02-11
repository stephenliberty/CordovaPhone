#import "Phone.h"
#import <Cordova/CDV.h>
#import <CoreTelephony/CTTelephonyNetworkInfo.h>
#import <CoreTelephony/CTCarrier.h>


@implementation Phone
    - (void)canDevicePlaceAPhoneCall:(CDVInvokedUrlCommand*)command {
        CDVPluginResult* pluginResult = nil;
        // Check if the device can place a phone call
        if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"tel://"]]) {
            // Device supports phone calls, lets confirm it can place one right now
            CTTelephonyNetworkInfo *netInfo = [[[CTTelephonyNetworkInfo alloc] init]];
            CTCarrier *carrier = [netInfo subscriberCellularProvider];
            NSString *mnc = [carrier mobileNetworkCode]; 
            if (([mnc length] == 0) || ([mnc isEqualToString:@"65535"])) {
                // Device cannot place a call at this time.  SIM might be removed.
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
            } else {
                // Device can place a phone call
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
            }
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }

@end