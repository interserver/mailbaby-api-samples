import { Injectable } from '@nestjs/common';
import { Observable } from 'rxjs';
import { EmailAddressTypes, EmailAddressesTypes, GenericResponse, MailAttachment, SendMailRaw, SendMailTo,  } from '../models';


@Injectable()
export abstract class SendingApi {

  abstract rawMail(sendMailRaw: SendMailRaw,  request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse>;


  abstract sendAdvMail(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes | undefined, cc: EmailAddressesTypes | undefined, bcc: EmailAddressesTypes | undefined, attachments: Array<MailAttachment> | undefined, id: number | undefined,  request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse>;


  abstract sendMail(to: SendMailTo, _from: string, subject: string, body: string, id: number | undefined,  request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse>;

} 