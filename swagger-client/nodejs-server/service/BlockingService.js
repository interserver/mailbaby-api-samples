'use strict';


/**
 * Creates a new email deny rule.
 * Adds a new email deny rule into the system to block new emails that match the given criteria
 *
 * body DenyRuleNew These are the fields needed to create a new email deny rule.
 * returns GenericResponse
 **/
exports.addRule = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "text" : "The command completed successfully.",
  "status" : "ok"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Creates a new email deny rule.
 * Adds a new email deny rule into the system to block new emails that match the given criteria
 *
 * body DenyRuleNew These are the fields needed to create a new email deny rule.
 * returns GenericResponse
 **/
exports.addRule = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "text" : "The command completed successfully.",
  "status" : "ok"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Removes an deny mail rule.
 * Removes one of the configured deny mail rules from the system.
 *
 * ruleId Integer The ID of the Rules entry.
 * returns GenericResponse
 **/
exports.deleteRule = function(ruleId) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "text" : "The command completed successfully.",
  "status" : "ok"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Removes an email address from the blocked list
 * Removes an email address from the various block lists. 
 *
 * body EmailAddress 
 * returns GenericResponse
 **/
exports.delistBlock = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "text" : "The command completed successfully.",
  "status" : "ok"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Removes an email address from the blocked list
 * Removes an email address from the various block lists. 
 *
 * body EmailAddress 
 * returns GenericResponse
 **/
exports.delistBlock = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "text" : "The command completed successfully.",
  "status" : "ok"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * displays a list of blocked email addresses
 *
 * returns MailBlocks
 **/
exports.getMailBlocks = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "local" : [ {
    "date" : "2023-08-07",
    "from" : "user@domain.com",
    "messageId" : "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com",
    "subject" : "Test Email",
    "to" : "['client@site.com']"
  } ],
  "mbtrap" : [ {
    "date" : "2023-08-07",
    "from" : "user@domain.com",
    "messageId" : "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com",
    "subject" : "Test Email",
    "to" : "['client@site.com']"
  } ],
  "subject" : [ {
    "from" : "user@domain.com",
    "subject" : "Test Email"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Displays a listing of deny email rules.
 * Returns a listing of all the deny block rules you have configured.
 *
 * returns List
 **/
exports.getRules = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "id" : 14,
  "user" : "mb20682",
  "type" : "email",
  "data" : "domeinwo@server.guesshost.net",
  "created" : "2022-03-22 19:16:35"
}, {
  "id" : 14,
  "user" : "mb20682",
  "type" : "email",
  "data" : "domeinwo@server.guesshost.net",
  "created" : "2022-03-22 19:16:35"
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

