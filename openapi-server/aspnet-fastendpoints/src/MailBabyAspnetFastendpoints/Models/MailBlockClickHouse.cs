namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
/// </summary>
public class MailBlockClickHouse 
{
    public DateTime Date { get; set; }
    public string From { get; set; }
    public string Subject { get; set; }
    public string To { get; set; }
    public string MessageId { get; set; }
}


