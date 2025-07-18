# Nim API client for MailBaby Email Delivery and Management Service API (Package: openapiclient)

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**
# Overview
This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).
# Authentication
In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.
We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.


## Overview

This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.  By using the [openapi-spec](https://openapis.org) from a remote server, you can easily generate an API client.

- API version: 1.1.0
- Package version: 1.0.0
    - Generator version: 7.14.0-SNAPSHOT
- Build package: org.openapitools.codegen.languages.NimClientCodegen
    For more information, please visit [https://www.mail.baby/contact/](https://www.mail.baby/contact/)

## Installation

Put the package under your project folder and add the following to the nimble file of your project:

```
import openapiclient
```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Module | Proc | HTTP request | Description
------------ | ------------- | ------------- | -------------
api_blocking | addRule | **POST** /mail/rules | Creates a new email deny rule.
api_blocking | deleteRule | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
api_blocking | delistBlock | **POST** /mail/blocks/delete | Removes an email address from the blocked list
api_blocking | getMailBlocks | **GET** /mail/blocks | displays a list of blocked email addresses
api_blocking | getRules | **GET** /mail/rules | Displays a listing of deny email rules.
api_history | getStats | **GET** /mail/stats | Account usage statistics.
api_history | viewMailLog | **GET** /mail/log | displays the mail log
api_sending | sendAdvMail | **POST** /mail/advsend | Sends an Email with Advanced Options
api_sending | sendMail | **POST** /mail/send | Sends an Email
api_services | getMailOrders | **GET** /mail | displays a list of mail service orders
api_status | pingServer | **GET** /ping | Checks if the server is running


To generate documentation with Nim DocGen, use:

```
nim doc --project --index:on openapiclient.nim
```
