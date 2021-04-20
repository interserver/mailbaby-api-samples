import 'package:jaguar_retrofit/annotations/annotations.dart';
import 'package:jaguar_retrofit/jaguar_retrofit.dart';
import 'package:jaguar_serializer/jaguar_serializer.dart';
import 'package:jaguar_mimetype/jaguar_mimetype.dart';
import 'dart:async';

import 'package:openapi/model/generic_response.dart';
import 'package:openapi/model/mail_log.dart';
import 'package:openapi/model/error_response.dart';
import 'package:openapi/model/send_mail.dart';
import 'package:openapi/model/mail_order.dart';
import 'package:openapi/model/error_resposne.dart';

part 'default_api.jretro.dart';

@GenApiClient()
class DefaultApi extends ApiClient with _$DefaultApiClient {
    final Route base;
    final Map<String, CodecRepo> converters;
    final Duration timeout;

    DefaultApi({this.base, this.converters, this.timeout = const Duration(minutes: 2)});

    /// Gets mail order information by id
    ///
    /// returns information about a mail order in the system with the given id.
    @GetReq(path: "/mail/:id", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<MailOrder> getMailById(
            @PathParam("id") int id
        ) {
        return super.getMailById(
        id

        ).timeout(timeout);
    }

    /// displays a list of mail service orders
    ///
    /// 
    @GetReq(path: "/mail", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<List<MailOrder>> getMailOrders(
        ) {
        return super.getMailOrders(

        ).timeout(timeout);
    }

    /// Checks if the server is running
    ///
    /// 
    @GetReq(path: "/ping")
    Future<void> pingServer(
        ) {
        return super.pingServer(

        ).timeout(timeout);
    }

    /// places a mail order
    ///
    /// Adds an item to the system
    @PostReq(path: "/mail/order", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<void> placeMailOrder(
            
             @AsJson() MailOrder mailOrder
        ) {
        return super.placeMailOrder(

        
        mailOrder
        ).timeout(timeout);
    }

    /// Sends an Email with Advanced Options
    ///
    /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    @PostReq(path: "/mail/:id/advsend", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<GenericResponse> sendAdvMailById(
            @PathParam("id") int id
            ,
             @AsJson() SendMail sendMail
        ) {
        return super.sendAdvMailById(
        id

        ,
        sendMail
        ).timeout(timeout);
    }

    /// Sends an Email
    ///
    /// Sends An email through one of your mail orders.
    @PostReq(path: "/mail/:id/send", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<GenericResponse> sendMailById(
            @PathParam("id") int id
        ,
            @QueryParam("subject") String subject, 
        
            @QueryParam("body") String body, 
        
            @QueryParam("to") String to, 
        
            @QueryParam("toName") String toName, 
        
            @QueryParam("from") String from, 
        
            @QueryParam("fromName") String fromName
        ) {
        return super.sendMailById(
        id
        ,
        subject, 
        
        body, 
        
        to, 
        
        toName, 
        
        from, 
        
        fromName

        ).timeout(timeout);
    }

    /// validatess order details before placing an order
    ///
    /// 
    @GetReq(path: "/mail/order", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<void> validateMailOrder(
        ) {
        return super.validateMailOrder(

        ).timeout(timeout);
    }

    /// displays the mail log
    ///
    /// By passing in the appropriate options, you can search for available inventory in the system 
    @GetReq(path: "/mail/:id/log", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" },  {"type": "apiKey", "name": "apiLoginAuth", "keyName": "X-API-LOGIN", "where": "header" },  {"type": "apiKey", "name": "apiPasswordAuth", "keyName": "X-API-PASS", "where": "header" }]})
    Future<List<MailLog>> viewMailLogById(
            @PathParam("id") int id
        ,
            @QueryParam("searchString") String searchString, 
        
            @QueryParam("skip") int skip, 
        
            @QueryParam("limit") int limit
        ) {
        return super.viewMailLogById(
        id
        ,
        searchString, 
        
        skip, 
        
        limit

        ).timeout(timeout);
    }


}
