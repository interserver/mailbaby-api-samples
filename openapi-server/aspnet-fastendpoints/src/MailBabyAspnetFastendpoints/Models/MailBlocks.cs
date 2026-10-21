namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
/// </summary>
public class MailBlocks 
{
    public List<MailBlockClickHouse> Local { get; set; }
    public List<MailBlockClickHouse> Mbtrap { get; set; }
    public List<MailBlockRspamd> Subject { get; set; }
}


