# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule MailBabyEmailDeliveryAndManagementServiceAPI.Model.EmailAddressName do
  @moduledoc """
  An email contact.
  """

  @derive Jason.Encoder
  defstruct [
    :email,
    :name
  ]

  @type t :: %__MODULE__{
    :email => String.t,
    :name => String.t | nil
  }

  def decode(value) do
    value
  end
end
