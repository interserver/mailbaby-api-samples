# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule MailBabyEmailDeliveryAndManagementServiceAPI.Model.GetStats200ResponseInner do
  @moduledoc """
  
  """

  @derive Jason.Encoder
  defstruct [
    :id,
    :status,
    :username,
    :password,
    :comment
  ]

  @type t :: %__MODULE__{
    :id => integer(),
    :status => String.t,
    :username => String.t,
    :password => String.t | nil,
    :comment => String.t | nil
  }

  def decode(value) do
    value
  end
end
