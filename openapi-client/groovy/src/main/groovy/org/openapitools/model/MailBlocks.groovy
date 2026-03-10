package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import org.openapitools.model.MailBlockClickHouse;
import org.openapitools.model.MailBlockRspamd;

@Canonical
class MailBlocks {
    /* Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. */
    List<MailBlockClickHouse> local = new ArrayList<>()
    /* Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection. */
    List<MailBlockClickHouse> mbtrap = new ArrayList<>()
    /* Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days. */
    List<MailBlockRspamd> subject = new ArrayList<>()
}
