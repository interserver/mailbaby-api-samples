package main

import (
	"github.com/GIT_USER_ID/GIT_REPO_ID/handlers"
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
)

func main() {
	e := echo.New()

	//todo: handle the error!
	c, _ := handlers.NewContainer()

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())


	// AddRule - Create a deny rule to block a sender, domain, destination, or prefix
	e.POST("/mail/rules", c.AddRule)

	// DeleteRule - Delete a deny rule by its numeric ruleId
	e.DELETE("/mail/rules/:ruleId", c.DeleteRule)

	// DelistBlock - Delist an email address from the spam-filter block lists
	e.POST("/mail/blocks/delete", c.DelistBlock)

	// GetMailBlocks - List addresses currently flagged by spam-filter block lists
	e.GET("/mail/blocks", c.GetMailBlocks)

	// GetRules - List custom deny rules (sender / domain / destination / prefix)
	e.GET("/mail/rules", c.GetRules)

	// GetStats - Account usage, cost, and volume statistics for a time window
	e.GET("/mail/stats", c.GetStats)

	// ViewMailLog - Query the mail delivery log (filterable, paginated)
	e.GET("/mail/log", c.ViewMailLog)

	// RawMail - Send a pre-built RFC 822 message verbatim (preserves DKIM)
	e.POST("/mail/rawsend", c.RawMail)

	// SendAdvMail - Send email with multiple recipients, CC/BCC, attachments, named contacts
	e.POST("/mail/advsend", c.SendAdvMail)

	// SendMail - Send a simple email (single recipient, plain or HTML)
	e.POST("/mail/send", c.SendMail)

	// GetMailOrderById - Get one mail order's full detail including SMTP password
	e.GET("/mail/:id", c.GetMailOrderById)

	// GetMailOrders - List your provisioned mail orders (sending accounts)
	e.GET("/mail", c.GetMailOrders)

	// PingServer - Health check — verify the API is reachable
	e.GET("/ping", c.PingServer)


	// Start server
	e.Logger.Fatal(e.Start(":8080"))
}
