import { Injectable } from '@nestjs/common';
import { Observable } from 'rxjs';


@Injectable()
export abstract class StatusApi {

  abstract pingServer( request: Request): string | Promise<string> | Observable<string>;

} 