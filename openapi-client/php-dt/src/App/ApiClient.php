<?php
declare(strict_types=1);

namespace App;

use Articus\DataTransfer as DT;
use OpenAPIGenerator\APIClient as OAGAC;
use Psr\Http\Client\ClientExceptionInterface;
use Psr\Http\Message\ResponseInterface;

/**
 * MailBaby Email Delivery API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.
 * The version of the OpenAPI document: 1.0.0
 */
class ApiClient extends OAGAC\AbstractApiClient
{
    //region getMailOrders
    /**
     * displays a list of mail service orders
     * @param iterable|string[][] $security
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
     * @param iterable|string[][] $security
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
        switch ($response->getStatusCode())
        {
            case 200:
                /* OK */
                $responseContent = new \App\DTO\Collection();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
            case 404:
                /* Unauthorized */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
        }
        $this->parseBody($response, $responseContent);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * displays a list of mail service orders
     * @param iterable|string[][] $security
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

    //region pingServer
    /**
     * Checks if the server is running
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function pingServerRaw(
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/ping', [], []);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Checks if the server is running
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function pingServer(
    ): array
    {
        $response = $this->pingServerRaw();
        $responseContent = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* Server is up and running */
                break;
            default:
                /* Something is wrong */
                break;
        }
        $this->parseBody($response, $responseContent);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Checks if the server is running
     * @return mixed
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function pingServerResult(
    ): mixed
    {
        return $this->getSuccessfulContent(...$this->pingServer());
    }
    //endregion

    //region sendAdvMail
    /**
     * Sends an Email with Advanced Options
     * @param \App\DTO\SendMailAdv $requestContent
     * @param iterable|string[][] $security
     * @param string $requestMediaType
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function sendAdvMailRaw(
        \App\DTO\SendMailAdv $requestContent,
        iterable $security = ['apiKeyAuth' => []],
        string $requestMediaType = 'application/json',
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
     * @param iterable|string[][] $security
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
        string $requestMediaType = 'application/json',
        string $responseMediaType = 'application/json'
    ): array
    {
        $response = $this->sendAdvMailRaw($requestContent, $security, $requestMediaType, $responseMediaType);
        $responseContent = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
        }
        $this->parseBody($response, $responseContent);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Sends an Email with Advanced Options
     * @param \App\DTO\SendMailAdv $requestContent
     * @param iterable|string[][] $security
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
        string $requestMediaType = 'application/json',
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
     * @param iterable|string[][] $security
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
     * @param iterable|string[][] $security
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
        switch ($response->getStatusCode())
        {
            case 200:
                /* search results matching criteria */
                $responseContent = new \App\DTO\GenericResponse();
                break;
            case 400:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
            case 401:
                /* Unauthorized */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
            case 404:
                /* The specified resource was not found */
                $responseContent = new \App\DTO\GetMailOrders401Response();
                break;
        }
        $this->parseBody($response, $responseContent);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Sends an Email
     * @param \App\DTO\SendMail $requestContent
     * @param iterable|string[][] $security
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
     * @param iterable|string[][] $security
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
     * @param iterable|string[][] $security
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
        $this->parseBody($response, $responseContent);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * displays the mail log
     * @param \App\DTO\ViewMailLogParameterData $parameters
     * @param iterable|string[][] $security
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

