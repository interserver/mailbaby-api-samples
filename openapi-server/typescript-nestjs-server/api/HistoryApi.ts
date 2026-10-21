import { Injectable } from '@nestjs/common';
import { Observable } from 'rxjs';
import { 0 | 1, MailLog, MailStatsType,  } from '../models';


@Injectable()
export abstract class HistoryApi {

  abstract getStats(time: 'all' | 'billing' | 'month' | '7d' | '24h' | 'day' | '1h' | undefined,  request: Request): MailStatsType | Promise<MailStatsType> | Observable<MailStatsType>;


  abstract viewMailLog(id: number | undefined, origin: string | undefined, mx: string | undefined, _from: string | undefined, to: string | undefined, subject: string | undefined, mailid: string | undefined, messageId: string | undefined, replyto: string | undefined, headerfrom: string | undefined, delivered: 0 | 1 | undefined, skip: number | undefined, limit: number | undefined, startDate: string | undefined, endDate: string | undefined, sort: 'time' | undefined, dir: 'asc' | 'desc' | undefined, groupby: 'message' | 'recipient' | undefined,  request: Request): MailLog | Promise<MailLog> | Observable<MailLog>;

} 