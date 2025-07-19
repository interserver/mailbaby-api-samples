'use strict';


/**
 * displays a list of mail service orders
 * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
 *
 * returns List
 **/
exports.getMailOrders = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "id" : 21472,
  "status" : "active",
  "username" : "mb21472"
}, {
  "id" : 21472,
  "status" : "active",
  "username" : "mb21472"
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

