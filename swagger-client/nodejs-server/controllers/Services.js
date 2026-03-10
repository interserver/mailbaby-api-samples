'use strict';

var utils = require('../utils/writer.js');
var Services = require('../service/ServicesService');

module.exports.getMailOrderById = function getMailOrderById (req, res, next, id) {
  Services.getMailOrderById(id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getMailOrders = function getMailOrders (req, res, next) {
  Services.getMailOrders()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
