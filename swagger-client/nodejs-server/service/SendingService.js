'use strict';


/**
 * Sends an Email with Advanced Options
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 *
 * body SendMailAdv 
 * returns GenericResponse
 **/
exports.sendAdvMail = function(body) {
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
 * Sends an Email with Advanced Options
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 *
 * body SendMailAdv 
 * returns GenericResponse
 **/
exports.sendAdvMail = function(body) {
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
 * Sends an Email
 * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
 *
 * body SendMail 
 * returns GenericResponse
 **/
exports.sendMail = function(body) {
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
 * Sends an Email
 * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
 *
 * body SendMail 
 * returns GenericResponse
 **/
exports.sendMail = function(body) {
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

