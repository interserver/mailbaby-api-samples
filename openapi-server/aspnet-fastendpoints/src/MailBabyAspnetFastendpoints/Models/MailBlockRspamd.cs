namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
/// </summary>
public class MailBlockRspamd 
{
    public string From { get; set; }
    public string Subject { get; set; }
}


