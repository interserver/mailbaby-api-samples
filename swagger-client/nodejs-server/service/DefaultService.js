'use strict';


/**
 * displays a list of mail service orders
 *
 * id Long The ID of your mail order this will be sent through. (optional)
 * returns MailOrders
 **/
exports.getMailOrders = function(id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
}, {
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Checks if the server is running
 *
 * no response value expected for this operation
 **/
exports.pingServer = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * places a mail order
 * Adds an item to the system
 *
 * body MailOrder Inventory item to add (optional)
 * no response value expected for this operation
 **/
exports.placeMailOrder = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Sends an Email with Advanced Options
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 *
 * body SendMail 
 * returns GenericResponse
 **/
exports.sendAdvMailById = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "status_text" : "The command completed successfully.",
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
 * Sends An email through one of your mail orders.
 *
 * subject String The Subject of the email (optional)
 * body String The contents of the email (optional)
 * to String The email address of who this email will be sent to. (optional)
 * from String The email address of who this email will be sent from. (optional)
 * id Long The ID of your mail order this will be sent through. (optional)
 * toName String The name or title of who this email is being sent to. (optional)
 * fromName String The name or title of who this email is being sent from. (optional)
 * returns GenericResponse
 **/
exports.sendMailById = function(subject,body,to,from,id,toName,fromName) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "status_text" : "The command completed successfully.",
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
 * validatess order details before placing an order
 *
 * no response value expected for this operation
 **/
exports.validateMailOrder = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * displays the mail log
 * By passing in the appropriate options, you can search for available inventory in the system 
 *
 * id Long The ID of your mail order this will be sent through. (optional)
 * searchString String pass an optional search string for looking up inventory (optional)
 * skip Integer number of records to skip for pagination (optional)
 * limit Integer maximum number of records to return (optional)
 * returns List
 **/
exports.viewMailLogById = function(id,searchString,skip,limit) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "id" : 0
}, {
  "id" : 0
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

