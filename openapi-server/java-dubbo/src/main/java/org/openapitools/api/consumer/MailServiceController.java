package org.openapitools.api.consumer;

import org.openapitools.model.DateOrTimestamp;
import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.MailBlocks;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.openapitools.model.MailOrderDetail;
import org.openapitools.model.MailStatsType;
import org.openapitools.model.SendMailRaw;
import org.openapitools.model.SendMailTo;
import org.openapitools.model.*;
import org.openapitools.api.interfaces.MailService;
import java.util.List;
import java.util.Map;
import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

@RestController
@RequestMapping("/mail")
public class MailServiceController {

    @DubboReference
    private MailService mailService;

    @RequestMapping(method = RequestMethod.POST, value = "/rules")
    public GenericResponse addRule(
        @RequestParam(name = "type") String type,
        @RequestParam(name = "data") String data,
        @RequestParam(name = "user") String user
    ) {
        return mailService.addRule(type, data, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rules/{ruleId}")
    public GenericResponse deleteRule(
        @RequestParam(name = "ruleId") Integer ruleId
    ) {
        return mailService.deleteRule(ruleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/blocks/delete")
    public GenericResponse delistBlock(
        @RequestParam(name = "emailAddressParam") EmailAddressParam emailAddressParam
    ) {
        return mailService.delistBlock(emailAddressParam);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/blocks")
    public MailBlocks getMailBlocks(
    ) {
        return mailService.getMailBlocks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public MailOrderDetail getMailOrderById(
        @RequestParam(name = "id") Long id
    ) {
        return mailService.getMailOrderById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<MailOrder> getMailOrders(
    ) {
        return mailService.getMailOrders();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rules")
    public List<DenyRuleRecord> getRules(
    ) {
        return mailService.getRules();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stats")
    public MailStatsType getStats(
        @RequestParam(name = "time", defaultValue = "1h") String time
    ) {
        return mailService.getStats(time);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rawsend")
    public GenericResponse rawMail(
        @RequestParam(name = "sendMailRaw") SendMailRaw sendMailRaw
    ) {
        return mailService.rawMail(sendMailRaw);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/advsend")
    public GenericResponse sendAdvMail(
        @RequestParam(name = "subject") String subject,
        @RequestParam(name = "body") String body,
        @RequestParam(name = "from") EmailAddressTypes from,
        @RequestParam(name = "to") EmailAddressesTypes to,
        @RequestParam(name = "replyto") EmailAddressesTypes replyto,
        @RequestParam(name = "cc") EmailAddressesTypes cc,
        @RequestParam(name = "bcc") EmailAddressesTypes bcc,
        @RequestParam(name = "attachments") List<MailAttachment> attachments,
        @RequestParam(name = "id") Long id
    ) {
        return mailService.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    public GenericResponse sendMail(
        @RequestParam(name = "to") SendMailTo to,
        @RequestParam(name = "from") String from,
        @RequestParam(name = "subject") String subject,
        @RequestParam(name = "body") String body,
        @RequestParam(name = "id") Long id
    ) {
        return mailService.sendMail(to, from, subject, body, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/log")
    public MailLog viewMailLog(
        @RequestParam(name = "id") Long id,
        @RequestParam(name = "origin") String origin,
        @RequestParam(name = "mx") String mx,
        @RequestParam(name = "from") String from,
        @RequestParam(name = "to") String to,
        @RequestParam(name = "subject") String subject,
        @RequestParam(name = "mailid") String mailid,
        @RequestParam(name = "messageId") String messageId,
        @RequestParam(name = "replyto") String replyto,
        @RequestParam(name = "headerfrom") String headerfrom,
        @RequestParam(name = "delivered") Integer delivered,
        @RequestParam(name = "skip", defaultValue = "0") Integer skip,
        @RequestParam(name = "limit", defaultValue = "100") Integer limit,
        @RequestParam(name = "startDate") DateOrTimestamp startDate,
        @RequestParam(name = "endDate") DateOrTimestamp endDate,
        @RequestParam(name = "sort", defaultValue = "time") String sort,
        @RequestParam(name = "dir", defaultValue = "desc") String dir,
        @RequestParam(name = "groupby", defaultValue = "recipient") String groupby
    ) {
        return mailService.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby);
    }
}
