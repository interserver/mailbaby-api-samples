'use strict';


/**
 * Checks if the server is running
 * A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
 *
 * no response value expected for this operation
 **/
exports.pingServer = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}

