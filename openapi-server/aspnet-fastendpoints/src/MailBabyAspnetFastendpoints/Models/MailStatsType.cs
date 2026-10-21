namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
/// </summary>
public class MailStatsType 
{
    
    /// <summary>
    /// The time window these `received`, `sent`, and `volume` statistics cover.
    /// </summary>
    /// <value>The time window these `received`, `sent`, and `volume` statistics cover.</value>
    public enum TimeEnum
    {
        
        /// <summary>
        /// Enum All for all
        /// </summary>
        All = 1,
        
        /// <summary>
        /// Enum Billing for billing
        /// </summary>
        Billing = 2,
        
        /// <summary>
        /// Enum Month for month
        /// </summary>
        Month = 3,
        
        /// <summary>
        /// Enum SevenDays for 7d
        /// </summary>
        SevenDays = 4,
        
        /// <summary>
        /// Enum TwentyFourHours for 24h
        /// </summary>
        TwentyFourHours = 5,
        
        /// <summary>
        /// Enum Day for day
        /// </summary>
        Day = 6,
        
        /// <summary>
        /// Enum OneHour for 1h
        /// </summary>
        OneHour = 7,
        
        /// <summary>
        /// Enum UnknownDefaultOpenApiEnum for unknown_default_open_api
        /// </summary>
        UnknownDefaultOpenApiEnum = 8
    }

    public TimeEnum Time { get; set; } = TimeEnum.OneHour;
    public int Usage { get; set; }
    public string Currency { get; set; }
    public double Cost { get; set; }
    public int Received { get; set; }
    public int Sent { get; set; }
    public MailStatsVolume Volume { get; set; }
}


