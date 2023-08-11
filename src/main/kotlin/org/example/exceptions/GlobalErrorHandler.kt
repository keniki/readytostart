package org.example.exceptions

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.netty.handler.codec.http.HttpResponseStatus
import org.example.models.CommonError

@Controller
class GlobalErrorHandler {

    @Error(global = true)
    fun genericError(request: HttpRequest<*>, e: Throwable): HttpResponse<CommonError> =
        CommonError(
            message = "Third party Error",
            code = HttpResponseStatus.INTERNAL_SERVER_ERROR.code()
        ).let { HttpResponse.serverError<CommonError?>().body(it) }
}