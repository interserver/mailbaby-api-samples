'use strict';

var utils = require('../utils/writer.js');
var History = require('../service/HistoryService');

module.exports.getStats = function getStats (req, res, next, time) {
  History.getStats(time)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.viewMailLog = function viewMailLog (req, res, next, id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered) {
  History.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
