package handlers
import (
	"github.com/GIT_USER_ID/GIT_REPO_ID/models"
	"github.com/labstack/echo/v4"
	"net/http"
)

// RawMail - Send a pre-built RFC 822 message verbatim (preserves DKIM)
func (c *Container) RawMail(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}


// SendAdvMail - Send email with multiple recipients, CC/BCC, attachments, named contacts
func (c *Container) SendAdvMail(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}


// SendMail - Send a simple email (single recipient, plain or HTML)
func (c *Container) SendMail(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}

