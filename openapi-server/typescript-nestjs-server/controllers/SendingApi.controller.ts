import { Body, Controller, DefaultValuePipe, Post, Param, ParseIntPipe, ParseFloatPipe, Query, Req } from '@nestjs/common';
import { Observable } from 'rxjs';
import { Cookies, Headers } from '../decorators';
import { SendingApi } from '../api';
import { EmailAddressTypes, EmailAddressesTypes, GenericResponse, MailAttachment, SendMailRaw, SendMailTo,  } from '../models';

@Controller()
export class SendingApiController {
  constructor(private readonly sendingApi: SendingApi) {}

  @Post('/mail/rawsend')
  rawMail(@Body() sendMailRaw: SendMailRaw, @Req() request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse> {
    return this.sendingApi.rawMail(sendMailRaw, request);
  }

  @Post('/mail/advsend')
  sendAdvMail(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes | undefined, cc: EmailAddressesTypes | undefined, bcc: EmailAddressesTypes | undefined, attachments: Array<MailAttachment> | undefined, id: number | undefined, @Req() request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse> {
    return this.sendingApi.sendAdvMail(subject, body, _from, to, replyto, cc, bcc, attachments, id, request);
  }

  @Post('/mail/send')
  sendMail(to: SendMailTo, _from: string, subject: string, body: string, id: number | undefined, @Req() request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse> {
    return this.sendingApi.sendMail(to, _from, subject, body, id, request);
  }

} 