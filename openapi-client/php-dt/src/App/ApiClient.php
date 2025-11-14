<?php
declare(strict_types=1);

namespace App;

use Articus\DataTransfer as DT;
use OpenAPIGenerator\APIClient as OAGAC;
use Psr\Http\Client\ClientExceptionInterface;
use Psr\Http\Message\ResponseInterface;

/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.
 * The version of the OpenAPI document: 1.3.0
 */
class ApiClient extends OAGAC\AbstractApiClient
{
    //region addRule
    /**
     * Creates a new email deny rule.
     * @param \App\DTO\DenyRuleNew $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function addRuleRaw(
        \App\DTO\DenyRuleNew $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('POST', '/mail/rules', [], []);
        $request = $this->addBody($request, $requestMediaType, $requestContent);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Creates a new email deny rule.
     * @param \App\DTO\DenyRuleNew $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function addRule(
        \App\DTO\DenyRuleNew $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->addRuleRaw($requestContent, $security, $requestMediaType, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* Error message when there was a problem with the input parameters. */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Creates a new email deny rule.
     * @param \App\DTO\DenyRuleNew $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return \App\DTO\GenericResponse
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function addRuleResult(
        \App\DTO\DenyRuleNew $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): \App\DTO\GenericResponse
    {
        return $this->getSuccessfulContent(...$this->addRule($requestContent, $security, $requestMediaType, $responseMediaType));
    }
    //endregion

    //region deleteRule
    /**
     * Removes an deny mail rule.
     * @param \App\DTO\DeleteRuleParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function deleteRuleRaw(
        \App\DTO\DeleteRuleParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('DELETE', '/mail/rules/{ruleId}', $this->getPathParameters($parameters), []);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Removes an deny mail rule.
     * @param \App\DTO\DeleteRuleParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function deleteRule(
        \App\DTO\DeleteRuleParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->deleteRuleRaw($parameters, $security, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* Error message when there was a problem with the input parameters. */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Removes an deny mail rule.
     * @param \App\DTO\DeleteRuleParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return \App\DTO\GenericResponse
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function deleteRuleResult(
        \App\DTO\DeleteRuleParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): \App\DTO\GenericResponse
    {
        return $this->getSuccessfulContent(...$this->deleteRule($parameters, $security, $responseMediaType));
    }
    //endregion

    //region delistBlock
    /**
     * Removes an email address from the blocked list
     * @param string $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function delistBlockRaw(
        string $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('POST', '/mail/blocks/delete', [], []);
        $request = $this->addBody($request, $requestMediaType, $requestContent);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Removes an email address from the blocked list
     * @param string $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function delistBlock(
        string $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->delistBlockRaw($requestContent, $security, $requestMediaType, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* Error message when there was a problem with the input parameters. */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Removes an email address from the blocked list
     * @param string $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return \App\DTO\GenericResponse
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function delistBlockResult(
        string $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): \App\DTO\GenericResponse
    {
        return $this->getSuccessfulContent(...$this->delistBlock($requestContent, $security, $requestMediaType, $responseMediaType));
    }
    //endregion

    //region getMailBlocks
    /**
     * displays a list of blocked email addresses
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function getMailBlocksRaw(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/mail/blocks', [], []);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * displays a list of blocked email addresses
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function getMailBlocks(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->getMailBlocksRaw($security, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* OK */
                $responseContent = new \App\DTO\MailBlocks();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * displays a list of blocked email addresses
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return \App\DTO\MailBlocks
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function getMailBlocksResult(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): \App\DTO\MailBlocks
    {
        return $this->getSuccessfulContent(...$this->getMailBlocks($security, $responseMediaType));
    }
    //endregion

    //region getMailOrders
    /**
     * displays a list of mail service orders
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function getMailOrdersRaw(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/mail', [], []);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * displays a list of mail service orders
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function getMailOrders(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->getMailOrdersRaw($security, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* OK */
                $responseContent = new \App\DTO\Collection();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * displays a list of mail service orders
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return \App\DTO\Collection
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function getMailOrdersResult(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): \App\DTO\Collection
    {
        return $this->getSuccessfulContent(...$this->getMailOrders($security, $responseMediaType));
    }
    //endregion

    //region getRules
    /**
     * Displays a listing of deny email rules.
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function getRulesRaw(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/mail/rules', [], []);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Displays a listing of deny email rules.
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function getRules(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->getRulesRaw($security, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* OK */
                $responseContent = new \App\DTO\Collection6();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Displays a listing of deny email rules.
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return \App\DTO\Collection6
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function getRulesResult(
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): \App\DTO\Collection6
    {
        return $this->getSuccessfulContent(...$this->getRules($security, $responseMediaType));
    }
    //endregion

    //region getStats
    /**
     * Account usage statistics.
     * @param \App\DTO\GetStatsParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function getStatsRaw(
        \App\DTO\GetStatsParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/mail/stats', [], $this->getQueryParameters($parameters));
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Account usage statistics.
     * @param \App\DTO\GetStatsParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function getStats(
        \App\DTO\GetStatsParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->getStatsRaw($parameters, $security, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* OK */
                $responseContent = new \App\DTO\MailStatsType();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Account usage statistics.
     * @param \App\DTO\GetStatsParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return \App\DTO\MailStatsType
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function getStatsResult(
        \App\DTO\GetStatsParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): \App\DTO\MailStatsType
    {
        return $this->getSuccessfulContent(...$this->getStats($parameters, $security, $responseMediaType));
    }
    //endregion

    //region pingServer
    /**
     * Checks if the server is running
     * @param iterable<string, string[]> $security
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function pingServerRaw(
        iterable $security = ['apiKeyAuth' => []]
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/ping', [], []);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Checks if the server is running
     * @param iterable<string, string[]> $security
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function pingServer(
        iterable $security = ['apiKeyAuth' => []]
    ): array
    {
        $response = $this->pingServerRaw($security);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* Server is up and running */
                break;
            default:
                /* Something is wrong */
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Checks if the server is running
     * @param iterable<string, string[]> $security
     * @return mixed
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function pingServerResult(
        iterable $security = ['apiKeyAuth' => []]
    ): mixed
    {
        return $this->getSuccessfulContent(...$this->pingServer($security));
    }
    //endregion

    //region rawMail
    /**
     * Sends a raw email
     * @param \App\DTO\RawMail $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function rawMailRaw(
        \App\DTO\RawMail $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('POST', '/mail/rawsend', [], []);
        $request = $this->addBody($request, $requestMediaType, $requestContent);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Sends a raw email
     * @param \App\DTO\RawMail $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function rawMail(
        \App\DTO\RawMail $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->rawMailRaw($requestContent, $security, $requestMediaType, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* successful email response */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* Error message when there was a problem with the input parameters. */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Sends a raw email
     * @param \App\DTO\RawMail $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return \App\DTO\GenericResponse
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function rawMailResult(
        \App\DTO\RawMail $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): \App\DTO\GenericResponse
    {
        return $this->getSuccessfulContent(...$this->rawMail($requestContent, $security, $requestMediaType, $responseMediaType));
    }
    //endregion

    //region sendAdvMail
    /**
     * Sends an Email with Advanced Options
     * @param \App\DTO\SendMailAdv $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function sendAdvMailRaw(
        \App\DTO\SendMailAdv $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('POST', '/mail/advsend', [], []);
        $request = $this->addBody($request, $requestMediaType, $requestContent);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Sends an Email with Advanced Options
     * @param \App\DTO\SendMailAdv $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function sendAdvMail(
        \App\DTO\SendMailAdv $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->sendAdvMailRaw($requestContent, $security, $requestMediaType, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* Error message when there was a problem with the input parameters. */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Sends an Email with Advanced Options
     * @param \App\DTO\SendMailAdv $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return \App\DTO\GenericResponse
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function sendAdvMailResult(
        \App\DTO\SendMailAdv $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): \App\DTO\GenericResponse
    {
        return $this->getSuccessfulContent(...$this->sendAdvMail($requestContent, $security, $requestMediaType, $responseMediaType));
    }
    //endregion

    //region sendMail
    /**
     * Sends an Email
     * @param \App\DTO\SendMail $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function sendMailRaw(
        \App\DTO\SendMail $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('POST', '/mail/send', [], []);
        $request = $this->addBody($request, $requestMediaType, $requestContent);
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Sends an Email
     * @param \App\DTO\SendMail $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function sendMail(
        \App\DTO\SendMail $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->sendMailRaw($requestContent, $security, $requestMediaType, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* Error message when there was a problem with the input parameters. */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\ErrorMessage();
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Sends an Email
     * @param \App\DTO\SendMail $requestContent
     * @param iterable<string, string[]> $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return \App\DTO\GenericResponse
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function sendMailResult(
        \App\DTO\SendMail $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/x-www-form-urlencoded',
        string $responseMediaType = 'application/json'
    ): \App\DTO\GenericResponse
    {
        return $this->getSuccessfulContent(...$this->sendMail($requestContent, $security, $requestMediaType, $responseMediaType));
    }
    //endregion

    //region viewMailLog
    /**
     * displays the mail log
     * @param \App\DTO\ViewMailLogParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function viewMailLogRaw(
        \App\DTO\ViewMailLogParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/mail/log', [], $this->getQueryParameters($parameters));
        $request = $this->addAcceptHeader($request, $responseMediaType);
        $request = $this->addSecurity($request, $security);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * displays the mail log
     * @param \App\DTO\ViewMailLogParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function viewMailLog(
        \App\DTO\ViewMailLogParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->viewMailLogRaw($parameters, $security, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\MailLog();
                break;
            case 400:
                /* bad input parameter */
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * displays the mail log
     * @param \App\DTO\ViewMailLogParameterData $parameters
     * @param iterable<string, string[]> $security
     * @param string $responseMediaType
     * @return \App\DTO\MailLog
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function viewMailLogResult(
        \App\DTO\ViewMailLogParameterData $parameters,
        iterable $security = ['apiKeyAuth' => []],
        string $responseMediaType = 'application/json'
    ): \App\DTO\MailLog
    {
        return $this->getSuccessfulContent(...$this->viewMailLog($parameters, $security, $responseMediaType));
    }
    //endregion
}

