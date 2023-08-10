'use strict';

var utils = require('../utils/writer.js');
var Sending = require('../service/SendingService');

module.exports.sendAdvMail = function sendAdvMail (req, res, next, body) {
  Sending.sendAdvMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendAdvMail = function sendAdvMail (req, res, next, body) {
  Sending.sendAdvMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendMail = function sendMail (req, res, next, body) {
  Sending.sendMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.sendMail = function sendMail (req, res, next, body) {
  Sending.sendMail(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
