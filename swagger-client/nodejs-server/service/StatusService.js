'use strict';


/**
 * Checks if the server is running
 * A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 
 *
 * returns String
 **/
exports.pingServer = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = "Server is up and running";
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

