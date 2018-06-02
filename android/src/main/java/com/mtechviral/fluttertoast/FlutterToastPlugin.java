package com.mtechviral.fluttertoast;

import android.app.Activity;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterToastPlugin */
public class FlutterToastPlugin implements MethodCallHandler {

  private  final MethodChannel channel;
  private Activity activity;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_toast");
    channel.setMethodCallHandler(new FlutterToastPlugin(registrar.activity(),channel));
  }

  private FlutterToastPlugin(Activity activity, MethodChannel channel){
    this.activity = activity;
    this.channel = channel;
    this.channel.setMethodCallHandler(this);
  }


  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    else if(call.method.equals("showToast")){
      String msg = call.argument("msg").toString();
      Toast.makeText(activity,msg,Toast.LENGTH_LONG).show();
    }

    else {
      result.notImplemented();
    }
  }
}
