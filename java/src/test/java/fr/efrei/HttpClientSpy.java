package fr.efrei;

import fr.efrei.mailprovider.SendRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HttpClientSpy implements HttpClient {
    private final List<String> requestParamsOrdered = new ArrayList<>();
    private final List<SendRequest> validParametersUsed = new ArrayList<>();

    @Override
    public Response post(String url, Object request) {
        Response response;
        try {
            SendRequest requestParsed = (SendRequest) request;
            requestParamsOrdered.add(requestParsed.name());
            requestParamsOrdered.add(requestParsed.email());
            requestParamsOrdered.add(requestParsed.subject());
            requestParamsOrdered.add(requestParsed.message());
            validParametersUsed.add(requestParsed);
        } catch (ClassCastException ignored) {

        } finally {
            response = new Response(503, "Well done !");
        }
        return response;
    }

    public List<String> getRequestParamsOrdered() {
        return Collections.unmodifiableList(requestParamsOrdered);
    }

    public int nbOfCallWithValidParams() {
        return validParametersUsed.size();
    }
}
