'use strict';


/**
 * displays a list of mail service orders
 *
 * returns List
 **/
exports.getMailOrders = function() {
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


/**
 * displays the mail log
 * By passing in the appropriate options, you can search for available inventory in the system 
 *
 * id Long The ID of your mail order this will be sent through. (optional)
 * search String pass an optional search string for looking up inventory (optional)
 * skip Integer number of records to skip for pagination (optional)
 * limit Integer maximum number of records to return (optional)
 * startDate Long earliest date to get emails in unix timestamp format (optional)
 * endDate Long earliest date to get emails in unix timestamp format (optional)
 * returns MailLog
 **/
exports.viewMailLog = function(id,search,skip,limit,startDate,endDate) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "emails" : [ {
    "date" : "Thu, 14 Oct 2021 08:50:09 -0400",
    "subject" : "sell 0.005 shares",
    "origin" : "199.231.189.154",
    "queued" : "2021-10-14T12:50:15.487Z",
    "logger" : "logger",
    "connectionKey" : "206.72.200.46:interserver.net:25",
    "interface" : "feeder",
    "md5Match" : 1,
    "mxPort" : 25,
    "sentBodySize" : 63,
    "lockTime" : 1634215818533,
    "from" : "person@mysite.com",
    "id" : "17c7eda538e0005d03",
    "locked" : 1,
    "seq" : 1,
    "sentBodyHash" : "1d7058e6a30369f200b0c34fab2fac92",
    "created" : "2021-10-14 08:50:10",
    "transtype" : "ESMTPSA",
    "sourceMd5" : "1d7058e6a30369f200b0c34fab2fac92",
    "_lock" : "lock 17c7eda538e0005d03 001",
    "messageId" : "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>",
    "sendingZone" : "interserver",
    "mxHostname" : "mx.j.is.cc",
    "transhost" : "relay0.mailbaby.net",
    "originhost" : "199.231.189.154",
    "domain" : "interserver.net",
    "bodySize" : 63,
    "recipient" : "client@isp.com",
    "assigned" : "relay1",
    "_id" : 103172,
    "to" : "client@isp.com",
    "time" : 1634215809,
    "user" : "mb5658"
  }, {
    "date" : "Thu, 14 Oct 2021 08:50:09 -0400",
    "subject" : "sell 0.005 shares",
    "origin" : "199.231.189.154",
    "queued" : "2021-10-14T12:50:15.487Z",
    "logger" : "logger",
    "connectionKey" : "206.72.200.46:interserver.net:25",
    "interface" : "feeder",
    "md5Match" : 1,
    "mxPort" : 25,
    "sentBodySize" : 63,
    "lockTime" : 1634215818533,
    "from" : "person@mysite.com",
    "id" : "17c7eda538e0005d03",
    "locked" : 1,
    "seq" : 1,
    "sentBodyHash" : "1d7058e6a30369f200b0c34fab2fac92",
    "created" : "2021-10-14 08:50:10",
    "transtype" : "ESMTPSA",
    "sourceMd5" : "1d7058e6a30369f200b0c34fab2fac92",
    "_lock" : "lock 17c7eda538e0005d03 001",
    "messageId" : "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>",
    "sendingZone" : "interserver",
    "mxHostname" : "mx.j.is.cc",
    "transhost" : "relay0.mailbaby.net",
    "originhost" : "199.231.189.154",
    "domain" : "interserver.net",
    "bodySize" : 63,
    "recipient" : "client@isp.com",
    "assigned" : "relay1",
    "_id" : 103172,
    "to" : "client@isp.com",
    "time" : 1634215809,
    "user" : "mb5658"
  } ],
  "total" : 10234,
  "limit" : 100,
  "skip" : 0
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

