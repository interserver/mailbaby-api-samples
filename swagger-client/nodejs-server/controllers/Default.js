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

module.exports.sendAdvMailById = function sendAdvMailById (req, res, next, body) {
  Default.sendAdvMailById(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendMailById = function sendMailById (req, res, next) {
  Default.sendMailById()
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

module.exports.viewMailLogById = function viewMailLogById (req, res, next, id, searchString, skip, limit) {
  Default.viewMailLogById(id, searchString, skip, limit)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
