package org.apache.cordova.plugin.chromecast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Chromecast extends CordovaPlugin {
    @Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("echo")) {
			this.echo(args.getString(0), callbackContext);
			return true;
		} 
		return false;
	}

	private void echo(String msg, CallbackContext callback) {
        callback.success(msg);
	}
}

