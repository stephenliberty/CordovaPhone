#import <Cordova/CDV.h>

@interface Phone : CDVPlugin

- (void)canDevicePlaceAPhoneCall:(CDVInvokedUrlCommand*)command;

- (void)canDeviceSendSMS:(CDVInvokedUrlCommand*)command;

@end