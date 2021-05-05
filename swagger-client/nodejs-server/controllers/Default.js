'use strict';

var utils = require('../utils/writer.js');
var Default = require('../service/DefaultService');

module.exports.getMailOrders = function getMailOrders (req, res, next, id) {
  Default.getMailOrders(id)
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

module.exports.placeMailOrder = function placeMailOrder (req, res, next, body) {
  Default.placeMailOrder(body)
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

module.exports.validateMailOrder = function validateMailOrder (req, res, next) {
  Default.validateMailOrder()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.viewMailLog = function viewMailLog (req, res, next, id, searchString, skip, limit) {
  Default.viewMailLog(id, searchString, skip, limit)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
