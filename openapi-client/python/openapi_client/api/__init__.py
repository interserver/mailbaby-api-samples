# flake8: noqa

if __import__("typing").TYPE_CHECKING:
    # import apis into api package
    from openapi_client.api.blocking_api import BlockingApi
    from openapi_client.api.history_api import HistoryApi
    from openapi_client.api.sending_api import SendingApi
    from openapi_client.api.services_api import ServicesApi
    from openapi_client.api.status_api import StatusApi
    
else:
    from lazy_imports import LazyModule, as_package, load

    load(
        LazyModule(
            *as_package(__file__),
            """# import apis into api package
from openapi_client.api.blocking_api import BlockingApi
from openapi_client.api.history_api import HistoryApi
from openapi_client.api.sending_api import SendingApi
from openapi_client.api.services_api import ServicesApi
from openapi_client.api.status_api import StatusApi

""",
            name=__name__,
            doc=__doc__,
        )
    )
