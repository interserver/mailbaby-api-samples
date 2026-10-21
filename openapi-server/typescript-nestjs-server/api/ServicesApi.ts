import { Injectable } from '@nestjs/common';
import { Observable } from 'rxjs';
import { MailOrder, MailOrderDetail,  } from '../models';


@Injectable()
export abstract class ServicesApi {

  abstract getMailOrderById(id: number,  request: Request): MailOrderDetail | Promise<MailOrderDetail> | Observable<MailOrderDetail>;


  abstract getMailOrders( request: Request): Array<MailOrder> | Promise<Array<MailOrder>> | Observable<Array<MailOrder>>;

} 