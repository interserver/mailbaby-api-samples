# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule MailBabyEmailDeliveryAndManagementServiceAPI.Model.MailLogEntry do
  @moduledoc """
  An email record
  """

  @derive Jason.Encoder
  defstruct [
    :_id,
    :id,
    :from,
    :to,
    :subject,
    :created,
    :time,
    :user,
    :transtype,
    :origin,
    :interface,
    :sendingZone,
    :bodySize,
    :seq,
    :recipient,
    :domain,
    :locked,
    :lockTime,
    :assigned,
    :queued,
    :mxHostname,
    :response,
    :messageId
  ]

  @type t :: %__MODULE__{
    :_id => integer(),
    :id => String.t,
    :from => String.t,
    :to => String.t,
    :subject => String.t,
    :created => String.t,
    :time => integer(),
    :user => String.t,
    :transtype => String.t,
    :origin => String.t,
    :interface => String.t,
    :sendingZone => String.t,
    :bodySize => integer(),
    :seq => integer(),
    :recipient => String.t,
    :domain => String.t,
    :locked => integer(),
    :lockTime => integer(),
    :assigned => String.t,
    :queued => String.t,
    :mxHostname => String.t,
    :response => String.t,
    :messageId => String.t | nil
  }

  def decode(value) do
    value
  end
end
