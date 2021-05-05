import 'package:jaguar_retrofit/annotations/annotations.dart';
import 'package:jaguar_retrofit/jaguar_retrofit.dart';
import 'package:jaguar_serializer/jaguar_serializer.dart';
import 'package:jaguar_mimetype/jaguar_mimetype.dart';
import 'dart:async';

import 'package:openapi/model/generic_response.dart';
import 'package:openapi/model/mail_log.dart';
import 'package:openapi/model/send_mail_adv.dart';
import 'package:openapi/model/error_response.dart';
import 'package:openapi/model/mail_order.dart';
import 'package:openapi/model/body.dart';

part 'default_api.jretro.dart';

@GenApiClient()
class DefaultApi extends ApiClient with _$DefaultApiClient {
    final Route base;
    final Map<String, CodecRepo> converters;
    final Duration timeout;

    DefaultApi({this.base, this.converters, this.timeout = const Duration(minutes: 2)});

    /// displays a list of mail service orders
    ///
    /// 
    @GetReq(path: "/mail", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" }]})
    Future<List<MailOrder>> getMailOrders(
        
            @QueryParam("id") int id
        ) {
        return super.getMailOrders(
        
        id

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
    @PostReq(path: "/mail/order", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" }]})
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
    @PostReq(path: "/mail/advsend", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" }]})
    Future<GenericResponse> sendAdvMail(
            
             @AsJson() SendMailAdv sendMailAdv
        ) {
        return super.sendAdvMail(

        
        sendMailAdv
        ).timeout(timeout);
    }

    /// Sends an Email
    ///
    /// Sends An email through one of your mail orders.
    @PostReq(path: "/mail/send", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" }]})
    Future<GenericResponse> sendMail(
            
             @AsJson() Body body
        ) {
        return super.sendMail(

        
        body
        ).timeout(timeout);
    }

    /// validatess order details before placing an order
    ///
    /// 
    @GetReq(path: "/mail/order", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" }]})
    Future<void> validateMailOrder(
        ) {
        return super.validateMailOrder(

        ).timeout(timeout);
    }

    /// displays the mail log
    ///
    /// By passing in the appropriate options, you can search for available inventory in the system 
    @GetReq(path: "/mail/log", metadata: {"auth": [ {"type": "apiKey", "name": "apiKeyAuth", "keyName": "X-API-KEY", "where": "header" }]})
    Future<List<MailLog>> viewMailLogById(
        
            @QueryParam("id") int id, 
        
            @QueryParam("searchString") String searchString, 
        
            @QueryParam("skip") int skip, 
        
            @QueryParam("limit") int limit
        ) {
        return super.viewMailLogById(
        
        id, 
        
        searchString, 
        
        skip, 
        
        limit

        ).timeout(timeout);
    }


}
