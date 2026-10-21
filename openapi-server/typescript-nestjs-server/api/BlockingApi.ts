import { Injectable } from '@nestjs/common';
import { Observable } from 'rxjs';
import { DenyRuleRecord, EmailAddressParam, GenericResponse, MailBlocks,  } from '../models';


@Injectable()
export abstract class BlockingApi {

  abstract addRule(type: string, data: string, user: string | undefined,  request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse>;


  abstract deleteRule(ruleId: number,  request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse>;


  abstract delistBlock(emailAddressParam: EmailAddressParam,  request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse>;


  abstract getMailBlocks( request: Request): MailBlocks | Promise<MailBlocks> | Observable<MailBlocks>;


  abstract getRules( request: Request): Array<DenyRuleRecord> | Promise<Array<DenyRuleRecord>> | Observable<Array<DenyRuleRecord>>;

} 