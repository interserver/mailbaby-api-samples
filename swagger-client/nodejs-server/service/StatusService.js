'use strict';


/**
 * Health check — verify the API is reachable
 * **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
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

