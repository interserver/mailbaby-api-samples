'use strict';

var utils = require('../utils/writer.js');
var Default = require('../service/DefaultService');

module.exports.getMailOrders = function getMailOrders (req, res, next) {
  Default.getMailOrders()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.pingServer = function pingServer (req, res, next) {
  Default.pingServer()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendAdvMail = function sendAdvMail (req, res, next, body) {
  Default.sendAdvMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendAdvMail = function sendAdvMail (req, res, next, body) {
  Default.sendAdvMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendMail = function sendMail (req, res, next, body) {
  Default.sendMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendMail = function sendMail (req, res, next, body) {
  Default.sendMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.viewMailLog = function viewMailLog (req, res, next, id, search, skip, limit, startDate, endDate) {
  Default.viewMailLog(id, search, skip, limit, startDate, endDate)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
