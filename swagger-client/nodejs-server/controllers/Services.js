'use strict';

var utils = require('../utils/writer.js');
var Services = require('../service/ServicesService');

module.exports.getMailOrders = function getMailOrders (req, res, next) {
  Services.getMailOrders()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
