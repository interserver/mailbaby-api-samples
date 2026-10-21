package handlers
import (
	"github.com/GIT_USER_ID/GIT_REPO_ID/models"
	"github.com/labstack/echo/v4"
	"net/http"
)

// AddRule - Create a deny rule to block a sender, domain, destination, or prefix
func (c *Container) AddRule(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}


// DeleteRule - Delete a deny rule by its numeric ruleId
func (c *Container) DeleteRule(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}


// DelistBlock - Delist an email address from the spam-filter block lists
func (c *Container) DelistBlock(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}


// GetMailBlocks - List addresses currently flagged by spam-filter block lists
func (c *Container) GetMailBlocks(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}


// GetRules - List custom deny rules (sender / domain / destination / prefix)
func (c *Container) GetRules(ctx echo.Context) error {
	return ctx.JSON(http.StatusOK, models.HelloWorld {
		Message: "Hello World",
	})
}

