# NOTE: This file is auto generated by OpenAPI Generator 7.14.0-SNAPSHOT (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule MailBabyEmailDeliveryAndManagementServiceAPI.Model.SendMailAdv do
  @moduledoc """
  Details for an Email
  """

  @derive JSON.Encoder
  defstruct [
    :subject,
    :body,
    :from,
    :to,
    :replyto,
    :cc,
    :bcc,
    :attachments,
    :id
  ]

  @type t :: %__MODULE__{
    :subject => String.t,
    :body => String.t,
    :from => MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressTypes.t,
    :to => MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes.t,
    :replyto => MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes.t | nil,
    :cc => MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes.t | nil,
    :bcc => MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes.t | nil,
    :attachments => [MailBabyEmailDeliveryAndManagementServiceAPI.Model.MailAttachment.t] | nil,
    :id => integer() | nil
  }

  alias MailBabyEmailDeliveryAndManagementServiceAPI.Deserializer

  def decode(value) do
    value
     |> Deserializer.deserialize(:from, :struct, MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressTypes)
     |> Deserializer.deserialize(:to, :struct, MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes)
     |> Deserializer.deserialize(:replyto, :struct, MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes)
     |> Deserializer.deserialize(:cc, :struct, MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes)
     |> Deserializer.deserialize(:bcc, :struct, MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressesTypes)
     |> Deserializer.deserialize(:attachments, :list, MailBabyEmailDeliveryAndManagementServiceAPI.Model.MailAttachment)
  end
end

