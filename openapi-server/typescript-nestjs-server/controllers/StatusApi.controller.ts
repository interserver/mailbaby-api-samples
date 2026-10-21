import { Body, Controller, DefaultValuePipe, Get, Param, ParseIntPipe, ParseFloatPipe, Query, Req } from '@nestjs/common';
import { Observable } from 'rxjs';
import { Cookies, Headers } from '../decorators';
import { StatusApi } from '../api';

@Controller()
export class StatusApiController {
  constructor(private readonly statusApi: StatusApi) {}

  @Get('/ping')
  pingServer(@Req() request: Request): string | Promise<string> | Observable<string> {
    return this.statusApi.pingServer(request);
  }

} 