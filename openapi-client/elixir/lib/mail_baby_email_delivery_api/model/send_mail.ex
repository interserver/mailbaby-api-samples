# NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
# https://openapi-generator.tech
# Do not edit the class manually.

defmodule MailBabyEmailDeliveryAPI.Model.SendMail do
  @moduledoc """
  Details for an Email
  """

  @derive [Poison.Encoder]
  defstruct [
    :"to",
    :"from",
    :"subject",
    :"body"
  ]

  @type t :: %__MODULE__{
    :"to" => String.t,
    :"from" => String.t,
    :"subject" => String.t,
    :"body" => String.t
  }
end

defimpl Poison.Decoder, for: MailBabyEmailDeliveryAPI.Model.SendMail do
  def decode(value, _options) do
    value
  end
end

