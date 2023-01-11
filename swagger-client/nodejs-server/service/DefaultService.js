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
 * Get a listing of the emails sent through this system 
 *
 * id Long The ID of your mail order this will be sent through. (optional)
 * origin String originating ip address sending mail (optional)
 * mx String mx record mail was sent to (optional)
 * from String from email address (optional)
 * to String to/destination email address (optional)
 * subject String subject containing this string (optional)
 * mailid String mail id (optional)
 * skip Integer number of records to skip for pagination (optional)
 * limit Integer maximum number of records to return (optional)
 * startDate Long earliest date to get emails in unix timestamp format (optional)
 * endDate Long earliest date to get emails in unix timestamp format (optional)
 * returns MailLog
 **/
exports.viewMailLog = function(id,origin,mx,from,to,subject,mailid,skip,limit,startDate,endDate) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "emails" : [ {
    "subject" : "sell 0.005 shares",
    "created" : "2021-10-14 08:50:10",
    "transtype" : "ESMTPSA",
    "origin" : "199.231.189.154",
    "queued" : "2021-10-14T12:50:15.487Z",
    "messageId" : "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>",
    "sendingZone" : "interserver",
    "mxHostname" : "mx.j.is.cc",
    "interface" : "feeder",
    "lockTime" : 1634215818533,
    "response" : "250 2.0.0 Ok queued as C91D83E128C",
    "domain" : "interserver.net",
    "bodySize" : 63,
    "recipient" : "client@isp.com",
    "from" : "person@mysite.com",
    "assigned" : "relay1",
    "_id" : 103172,
    "id" : "17c7eda538e0005d03",
    "to" : "client@isp.com",
    "time" : 1634215809,
    "locked" : 1,
    "user" : "mb5658",
    "seq" : 1
  }, {
    "subject" : "sell 0.005 shares",
    "created" : "2021-10-14 08:50:10",
    "transtype" : "ESMTPSA",
    "origin" : "199.231.189.154",
    "queued" : "2021-10-14T12:50:15.487Z",
    "messageId" : "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>",
    "sendingZone" : "interserver",
    "mxHostname" : "mx.j.is.cc",
    "interface" : "feeder",
    "lockTime" : 1634215818533,
    "response" : "250 2.0.0 Ok queued as C91D83E128C",
    "domain" : "interserver.net",
    "bodySize" : 63,
    "recipient" : "client@isp.com",
    "from" : "person@mysite.com",
    "assigned" : "relay1",
    "_id" : 103172,
    "id" : "17c7eda538e0005d03",
    "to" : "client@isp.com",
    "time" : 1634215809,
    "locked" : 1,
    "user" : "mb5658",
    "seq" : 1
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

