window.echo = function(str, callback) {
    cordova.exec(callback, function(err) {
        callback('Nothing to echo.');
    }, "Chromecast", "echo", [str]);
};

window.listDevices = function(callback) {
  cordova.exec(callback, function(err) { callback('Cannot enumerate devices'); }, "Chromecast", "listDevices", []);
}
