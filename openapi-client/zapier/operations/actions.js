const BlockingApi = require('../apis/BlockingApi');
const HistoryApi = require('../apis/HistoryApi');
const SendingApi = require('../apis/SendingApi');
const ServicesApi = require('../apis/ServicesApi');
const StatusApi = require('../apis/StatusApi');
const { searchMiddleware, hasSearchRequisites, isSearchAction } = require('../utils/utils');

const actions = {
    [BlockingApi.addRule.key]: BlockingApi.addRule,
    [BlockingApi.deleteRule.key]: BlockingApi.deleteRule,
    [BlockingApi.delistBlock.key]: BlockingApi.delistBlock,
    [BlockingApi.getMailBlocks.key]: BlockingApi.getMailBlocks,
    [BlockingApi.getRules.key]: BlockingApi.getRules,
    [HistoryApi.getStats.key]: HistoryApi.getStats,
    [HistoryApi.viewMailLog.key]: HistoryApi.viewMailLog,
    [SendingApi.sendAdvMail.key]: SendingApi.sendAdvMail,
    [SendingApi.sendMail.key]: SendingApi.sendMail,
    [ServicesApi.getMailOrders.key]: ServicesApi.getMailOrders,
    [StatusApi.pingServer.key]: StatusApi.pingServer,
}

module.exports = {
    searchActions: () => Object.entries(actions).reduce((actions, [key, value]) => isSearchAction(key) && hasSearchRequisites(value) ? {...actions, [key]: searchMiddleware(value)} : actions, {}),
    createActions: () => Object.entries(actions).reduce((actions, [key, value]) => !isSearchAction(key) ? {...actions, [key]: value} : actions, {}),
}