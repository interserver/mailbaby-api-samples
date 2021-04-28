import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import * as models from '../models/all';
import { Configuration} from '../configuration'

import { GenericResponse } from '../models/GenericResponse';
import { MailLog } from '../models/MailLog';
import { MailOrder } from '../models/MailOrder';
import { ModelError } from '../models/ModelError';
import { ObservableDefaultApi } from './ObservableAPI';

import { DefaultApiRequestFactory, DefaultApiResponseProcessor} from "../apis/DefaultApi";
export class PromiseDefaultApi {
    private api: ObservableDefaultApi

    public constructor(
        configuration: Configuration,
        requestFactory?: DefaultApiRequestFactory,
        responseProcessor?: DefaultApiResponseProcessor
    ) {
        this.api = new ObservableDefaultApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * returns information about a mail order in the system with the given id.
     * Gets mail order information by id
     * @param id User ID
     */
    public getMailById(id: number, options?: Configuration): Promise<MailOrder> {
        const result = this.api.getMailById(id, options);
        return result.toPromise();
    }

    /**
     * displays a list of mail service orders
     */
    public getMailOrders(options?: Configuration): Promise<Array<MailOrder>> {
        const result = this.api.getMailOrders(options);
        return result.toPromise();
    }

    /**
     * Checks if the server is running
     */
    public pingServer(options?: Configuration): Promise<void> {
        const result = this.api.pingServer(options);
        return result.toPromise();
    }

    /**
     * Adds an item to the system
     * places a mail order
     * @param mailOrder Inventory item to add
     */
    public placeMailOrder(mailOrder?: MailOrder, options?: Configuration): Promise<void> {
        const result = this.api.placeMailOrder(mailOrder, options);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders.
     * Sends an Email
     * @param id User ID
     * @param subject 
     * @param body 
     * @param to 
     * @param from 
     */
    public sendMailById(id: number, subject?: string, body?: string, to?: string, from?: string, options?: Configuration): Promise<GenericResponse> {
        const result = this.api.sendMailById(id, subject, body, to, from, options);
        return result.toPromise();
    }

    /**
     * validatess order details before placing an order
     */
    public validateMailOrder(options?: Configuration): Promise<void> {
        const result = this.api.validateMailOrder(options);
        return result.toPromise();
    }

    /**
     * By passing in the appropriate options, you can search for available inventory in the system 
     * displays the mail log
     * @param id User ID
     * @param searchString pass an optional search string for looking up inventory
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     */
    public viewMailLogById(id: number, searchString?: string, skip?: number, limit?: number, options?: Configuration): Promise<Array<MailLog>> {
        const result = this.api.viewMailLogById(id, searchString, skip, limit, options);
        return result.toPromise();
    }


}



