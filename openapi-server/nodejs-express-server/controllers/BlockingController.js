/**
 * The BlockingController file is a very simple one, which does not need to be changed manually,
 * unless there's a case where business logic routes the request to an entity which is not
 * the service.
 * The heavy lifting of the Controller item is done in Request.js - that is where request
 * parameters are extracted and sent to the service, and where response is handled.
 */

const Controller = require('./Controller');
const service = require('../services/BlockingService');
const addRule = async (request, response) => {
  await Controller.handleRequest(request, response, service.addRule);
};

const deleteRule = async (request, response) => {
  await Controller.handleRequest(request, response, service.deleteRule);
};

const delistBlock = async (request, response) => {
  await Controller.handleRequest(request, response, service.delistBlock);
};

const getMailBlocks = async (request, response) => {
  await Controller.handleRequest(request, response, service.getMailBlocks);
};

const getRules = async (request, response) => {
  await Controller.handleRequest(request, response, service.getRules);
};


module.exports = {
  addRule,
  deleteRule,
  delistBlock,
  getMailBlocks,
  getRules,
};
