#import "FlutterToastPlugin.h"
#import <flutter_toast/flutter_toast-Swift.h>

@implementation FlutterToastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterToastPlugin registerWithRegistrar:registrar];
}
@end
