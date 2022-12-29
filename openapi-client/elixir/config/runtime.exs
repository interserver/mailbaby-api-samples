import Config

# config/runtime.exs is executed for all environments, including
# during releases. It is executed after compilation and before the
# system starts, so it is typically used to load production configuration
# and secrets from environment variables or elsewhere. Do not define
# any compile-time configuration in here, as it won't be applied.
# The block below contains prod specific runtime configuration.

if env = System.get_env("MAIL_BABY_EMAIL_DELIVERY_API_BASE_URI") do
  config :mail_baby_email_delivery_api, base_url: env
end
