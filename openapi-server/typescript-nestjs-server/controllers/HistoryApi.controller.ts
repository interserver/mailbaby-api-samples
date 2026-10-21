import { Body, Controller, DefaultValuePipe, Get, Param, ParseIntPipe, ParseFloatPipe, Query, Req } from '@nestjs/common';
import { Observable } from 'rxjs';
import { Cookies, Headers } from '../decorators';
import { HistoryApi } from '../api';
import { 0 | 1, DateOrTimestamp, MailLog, MailStatsType,  } from '../models';

@Controller()
export class HistoryApiController {
  constructor(private readonly historyApi: HistoryApi) {}

  @Get('/mail/stats')
  getStats(@Query('time', new DefaultValuePipe('1h')) time: 'all' | 'billing' | 'month' | '7d' | '24h' | 'day' | '1h' | undefined, @Req() request: Request): MailStatsType | Promise<MailStatsType> | Observable<MailStatsType> {
    return this.historyApi.getStats(time, request);
  }

  @Get('/mail/log')
  viewMailLog(@Query('id') id: number | undefined, @Query('origin') origin: string | undefined, @Query('mx') mx: string | undefined, @Query('from') _from: string | undefined, @Query('to') to: string | undefined, @Query('subject') subject: string | undefined, @Query('mailid') mailid: string | undefined, @Query('messageId') messageId: string | undefined, @Query('replyto') replyto: string | undefined, @Query('headerfrom') headerfrom: string | undefined, @Query('delivered') delivered: 0 | 1 | undefined, @Query('skip', new DefaultValuePipe(0)) skip: number | undefined, @Query('limit', new DefaultValuePipe(100)) limit: number | undefined, @Query('startDate') startDate: DateOrTimestamp | undefined, @Query('endDate') endDate: DateOrTimestamp | undefined, @Query('sort', new DefaultValuePipe('time')) sort: 'time' | undefined, @Query('dir', new DefaultValuePipe('desc')) dir: 'asc' | 'desc' | undefined, @Query('groupby', new DefaultValuePipe('recipient')) groupby: 'message' | 'recipient' | undefined, @Req() request: Request): MailLog | Promise<MailLog> | Observable<MailLog> {
    return this.historyApi.viewMailLog(id, origin, mx, _from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby, request);
  }

} 