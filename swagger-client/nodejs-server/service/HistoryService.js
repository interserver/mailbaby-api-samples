'use strict';


/**
 * Account usage statistics.
 * Returns information about the usage on your mail accounts.
 *
 * time String The timeframe for the statistics. (optional)
 * returns MailStatsType
 **/
exports.getStats = function(time) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "time" : "all",
  "usage" : 55,
  "currency" : "USD",
  "currencySymbol" : "$",
  "cost" : 1.02,
  "received" : 508,
  "sent" : 495,
  "volume" : {
    "to" : {
      "client@domain.com" : 395,
      "user@site.net" : 57,
      "sales@company.com" : 47,
      "client@anothersite.com" : 9
    },
    "from" : {
      "billing@somedomain.com" : 369,
      "sales@somedomain.com" : 139
    },
    "ip" : {
      "1.1.1.1" : 142,
      "2.2.2.2" : 132,
      "3.3.3.3" : 129,
      "4.4.4.4" : 105
    }
  }
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
 * replyto String Reply-To Email Address (optional)
 * headerfrom String Header From Email Address (optional)
 * delivered String Limiting the emails to wether or not they were delivered. (optional)
 * returns MailLog
 **/
exports.viewMailLog = function(id,origin,mx,from,to,subject,mailid,skip,limit,startDate,endDate,replyto,headerfrom,delivered) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "total" : 1,
  "skip" : 0,
  "limit" : 100,
  "emails" : [ {
    "_id" : 103172,
    "id" : "17c7eda538e0005d03",
    "from" : "person@mysite.com",
    "to" : "client@isp.com",
    "subject" : "sell 0.005 shares",
    "messageId" : "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>",
    "created" : "2021-10-14T08:50:10.000Z",
    "time" : 1634215809,
    "user" : "mb5658",
    "transtype" : "ESMTPSA",
    "origin" : "199.231.189.154",
    "interface" : "feeder",
    "sendingZone" : "interserver",
    "bodySize" : 63,
    "seq" : 1,
    "delivered" : 1,
    "recipient" : "client@isp.com",
    "domain" : "interserver.net",
    "locked" : 1,
    "lockTime" : "1634215818533",
    "assigned" : "relay1",
    "queued" : "2021-10-14T12:50:15.487Z",
    "mxHostname" : "mx.j.is.cc",
    "response" : "250 2.0.0 Ok queued as C91D83E128C"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

