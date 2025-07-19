'use strict';

var utils = require('../utils/writer.js');
var Blocking = require('../service/BlockingService');

module.exports.addRule = function addRule (req, res, next, body) {
  Blocking.addRule(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.addRule = function addRule (req, res, next, body) {
  Blocking.addRule(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.deleteRule = function deleteRule (req, res, next, ruleId) {
  Blocking.deleteRule(ruleId)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.delistBlock = function delistBlock (req, res, next, body) {
  Blocking.delistBlock(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getMailBlocks = function getMailBlocks (req, res, next) {
  Blocking.getMailBlocks()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getRules = function getRules (req, res, next) {
  Blocking.getRules()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
