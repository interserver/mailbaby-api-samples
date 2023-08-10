'use strict';

var utils = require('../utils/writer.js');
var Status = require('../service/StatusService');

module.exports.pingServer = function pingServer (req, res, next) {
  Status.pingServer()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
