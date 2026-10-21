import { Body, Controller, DefaultValuePipe, Delete, Get, Post, Param, ParseIntPipe, ParseFloatPipe, Query, Req } from '@nestjs/common';
import { Observable } from 'rxjs';
import { Cookies, Headers } from '../decorators';
import { BlockingApi } from '../api';
import { DenyRuleRecord, EmailAddressParam, GenericResponse, MailBlocks,  } from '../models';

@Controller()
export class BlockingApiController {
  constructor(private readonly blockingApi: BlockingApi) {}

  @Post('/mail/rules')
  addRule(type: string, data: string, user: string | undefined, @Req() request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse> {
    return this.blockingApi.addRule(type, data, user, request);
  }

  @Delete('/mail/rules/:ruleId')
  deleteRule(@Param('ruleId') ruleId: number, @Req() request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse> {
    return this.blockingApi.deleteRule(ruleId, request);
  }

  @Post('/mail/blocks/delete')
  delistBlock(@Body() emailAddressParam: EmailAddressParam, @Req() request: Request): GenericResponse | Promise<GenericResponse> | Observable<GenericResponse> {
    return this.blockingApi.delistBlock(emailAddressParam, request);
  }

  @Get('/mail/blocks')
  getMailBlocks(@Req() request: Request): MailBlocks | Promise<MailBlocks> | Observable<MailBlocks> {
    return this.blockingApi.getMailBlocks(request);
  }

  @Get('/mail/rules')
  getRules(@Req() request: Request): Array<DenyRuleRecord> | Promise<Array<DenyRuleRecord>> | Observable<Array<DenyRuleRecord>> {
    return this.blockingApi.getRules(request);
  }

} 