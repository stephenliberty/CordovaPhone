#import "Phone.h"
#import <Cordova/CDV.h>

@implementation Phone
    - (void)canDevicePlaceAPhoneCall:(CDVInvokedUrlCommand*)command {
        CDVPluginResult* pluginResult = nil;
        // Check if the device can place a phone call
        if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"tel://"]]) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }

- (void)canDeviceSendSMS:(CDVInvokedUrlCommand*)command {
    CDVPluginResult* pluginResult = nil;
    // Check if the device can place a phone call
    if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"sms://"]]) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end