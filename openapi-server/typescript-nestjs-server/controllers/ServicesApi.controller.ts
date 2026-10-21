import { Body, Controller, DefaultValuePipe, Get, Param, ParseIntPipe, ParseFloatPipe, Query, Req } from '@nestjs/common';
import { Observable } from 'rxjs';
import { Cookies, Headers } from '../decorators';
import { ServicesApi } from '../api';
import { MailOrder, MailOrderDetail,  } from '../models';

@Controller()
export class ServicesApiController {
  constructor(private readonly servicesApi: ServicesApi) {}

  @Get('/mail/:id')
  getMailOrderById(@Param('id') id: number, @Req() request: Request): MailOrderDetail | Promise<MailOrderDetail> | Observable<MailOrderDetail> {
    return this.servicesApi.getMailOrderById(id, request);
  }

  @Get('/mail')
  getMailOrders(@Req() request: Request): Array<MailOrder> | Promise<Array<MailOrder>> | Observable<Array<MailOrder>> {
    return this.servicesApi.getMailOrders(request);
  }

} 