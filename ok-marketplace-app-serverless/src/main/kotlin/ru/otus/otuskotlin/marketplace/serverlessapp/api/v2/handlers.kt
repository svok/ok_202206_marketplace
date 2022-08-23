package ru.otus.otuskotlin.marketplace.serverlessapp.api.v2

import kotlinx.datetime.Clock
import ru.otus.otuskotlin.marketplace.serverlessapp.api.model.Request
import ru.otus.otuskotlin.marketplace.serverlessapp.api.model.Response
import ru.otus.otuskotlin.marketplace.serverlessapp.api.utils.toResponse
import ru.otus.otuskotlin.marketplace.serverlessapp.api.utils.toTransportModel
import ru.otus.otuskotlin.marketplace.api.v2.models.*
import ru.otus.otuskotlin.marketplace.common.MkplContext
import ru.otus.otuskotlin.marketplace.common.models.MkplRequestId
import ru.otus.otuskotlin.marketplace.mappers.v2.fromTransport
import ru.otus.otuskotlin.marketplace.mappers.v2.toTransportCreate
import ru.otus.otuskotlin.marketplace.stubs.MkplAdStub
import yandex.cloud.sdk.functions.Context
import yandex.cloud.sdk.functions.YcFunction

class CreateAdHandler : YcFunction<Request, Response> {
    override fun handle(input: Request, context: Context): Response {
        println("CreateAdHandler v2 start work")
        val request = input.toTransportModel<AdCreateRequest>()
        val mkplContext = MkplContext(
            timeStart = Clock.System.now(),
            requestId = MkplRequestId(context.requestId)
        )
        mkplContext.fromTransport(request)
        mkplContext.adResponse = MkplAdStub.get()
        return mkplContext.toTransportCreate().toResponse()
    }
}

class ReadAdHandler : YcFunction<Request, Response> {
    override fun handle(input: Request, context: Context): Response {
        println("ReadAdHandler v2 start work")
        val request = input.toTransportModel<AdReadRequest>()
        val mkplContext = MkplContext(
            timeStart = Clock.System.now(),
            requestId = MkplRequestId(context.requestId)
        )
        mkplContext.fromTransport(request)
        mkplContext.adResponse = MkplAdStub.get()
        return mkplContext.toTransportCreate().toResponse()
    }
}

class UpdateAdHandler : YcFunction<Request, Response> {
    override fun handle(input: Request, context: Context): Response {
        println("UpdateAdHandler v2 start work")
        val request = input.toTransportModel<AdUpdateRequest>()
        val mkplContext = MkplContext(
            timeStart = Clock.System.now(),
            requestId = MkplRequestId(context.requestId)
        )
        mkplContext.fromTransport(request)
        mkplContext.adResponse = MkplAdStub.get()
        return mkplContext.toTransportCreate().toResponse()
    }
}

class DeleteAdHandler : YcFunction<Request, Response> {
    override fun handle(input: Request, context: Context): Response {
        println("DeleteAdHandler v2 start work")
        val request = input.toTransportModel<AdDeleteRequest>()
        val mkplContext = MkplContext(
            timeStart = Clock.System.now(),
            requestId = MkplRequestId(context.requestId)
        )
        mkplContext.fromTransport(request)
        return mkplContext.toTransportCreate().toResponse()
    }
}

class SearchAdHandler : YcFunction<Request, Response> {
    override fun handle(input: Request, context: Context): Response {
        println("SearchAdHandler v2 start work")
        val request = input.toTransportModel<AdSearchRequest>()
        val mkplContext = MkplContext(
            timeStart = Clock.System.now(),
            requestId = MkplRequestId(context.requestId)
        )
        mkplContext.fromTransport(request)
        mkplContext.adResponse = MkplAdStub.get()
        return mkplContext.toTransportCreate().toResponse()
    }
}

class OffersAdHandler : YcFunction<Request, Response> {
    override fun handle(input: Request, context: Context): Response {
        println("OffersAdHandler v2 start work")
        val request = input.toTransportModel<AdOffersRequest>()
        val mkplContext = MkplContext(
            timeStart = Clock.System.now(),
            requestId = MkplRequestId(context.requestId)
        )
        mkplContext.fromTransport(request)
        mkplContext.adsResponse.add(MkplAdStub.get())
        return mkplContext.toTransportCreate().toResponse()
    }
}