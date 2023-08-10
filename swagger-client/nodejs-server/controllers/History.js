'use strict';

var utils = require('../utils/writer.js');
var History = require('../service/HistoryService');

module.exports.getStats = function getStats (req, res, next) {
  History.getStats()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.viewMailLog = function viewMailLog (req, res, next, id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate) {
  History.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
