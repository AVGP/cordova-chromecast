package org.apache.cordova.plugin.chromecast;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.google.android.gms.cast.*;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter.RouteInfo;

public class Chromecast extends CordovaPlugin {

    private String AppID = "9A0FCE32";

    private MediaRouter mMediaRouter;
    private MediaRouteSelector mMediaRouteSelector;
    private MediaRouter.Callback mMediaRouterCallback;

    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // Configure Cast device discovery
    }

    @Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("echo")) {
			this.echo(args.getString(0), callbackContext);
			return true;
		} else if(action.equals("listDevices")) {
      listDevices(callbackContext);
    }

		return false;
	}

  private void listDevices(CallbackContext callbackContext) {
    mMediaRouter = MediaRouter.getInstance(cordova.getActivity().getApplicationContext());
    mMediaRouteSelector = new MediaRouteSelector.Builder()
      .addControlCategory(CastMediaControlIntent.categoryForCast(AppID))
      .build();
    mMediaRouterCallback = new MyMediaRouterCallback();

    mMediaRouter.addCallback(mMediaRouteSelector, mMediaRouterCallback, MediaRouter.CALLBACK_FLAG_PERFORM_ACTIVE_SCAN);

    if (callbackContext != null) {
        callbackContext.success();
    }
  }

	private void echo(String msg, CallbackContext callback) {
        callback.success(msg);
	}


  private class MyMediaRouterCallback extends MediaRouter.Callback {
    @Override
    public void onRouteAdded(MediaRouter router, RouteInfo route) {
      System.out.println("ROUTE ADDED");
//      super.onRouteAdded(router, route);
//      onReceiverListChanged();
    }

    @Override
    public void onRouteRemoved(MediaRouter router, RouteInfo route) {
      System.out.println("ROUTE REMOVED");
//    super.onRouteRemoved(router, route);
//      onReceiverListChanged();
    }

    @Override
    public void onRouteSelected(MediaRouter router, RouteInfo info) {
      System.out.println("ROUTE SELECTED");
      // Handle the user route selection.
    //  mSelectedDevice = getDevice(info);
    //  onReceiverListChanged();
    //  launchReceiver();
    }

    @Override
    public void onRouteUnselected(MediaRouter router, RouteInfo info) {
      System.out.println("ROUTE UNSELECTED");
      //onReceiverListChanged();
      //teardown();
      //mSelectedDevice = null;
    }
  }
}
