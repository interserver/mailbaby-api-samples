namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
/// </summary>
public class MailLog 
{
    public int Total { get; set; }
    public int Skip { get; set; }
    public int Limit { get; set; }
    public List<MailLogEntry> Emails { get; set; }
}


