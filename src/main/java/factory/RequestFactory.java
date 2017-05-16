/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import io.reactivex.Observable;
import ru.iate.reco.obj.Request;
import ru.iate.reco.obj.RequestType;

/**
 *
 * @author Egor
 */
public class RequestFactory {
    
    public static Observable<HttpResponse> request(Request rawRequest) {
        return Observable.create(e -> {
            HttpRequest request = null;
            switch (rawRequest.getRequestType()) {
                case GET:
                    request = Unirest.get(rawRequest.getAddress());
                    break;
                case DELETE:
                    request = Unirest.delete(rawRequest.getAddress());
                    break;
                case HEAD:
                    request = Unirest.head(rawRequest.getAddress());
                    break;
                case OPTIONS:
                    request = Unirest.options(rawRequest.getAddress());
                    break;
                case PATCH:
                    request = Unirest.patch(rawRequest.getAddress());
                    break;
                case POST:
                    request = Unirest.post(rawRequest.getAddress());
                    break;
                case PUT:
                    request = Unirest.put(rawRequest.getAddress());
                    break;
            }
            request.headers(rawRequest.getHeaders());
            if (rawRequest.getRequestType() == RequestType.GET 
                    || rawRequest.getRequestType() == RequestType.HEAD) {
                request.queryString(rawRequest.getRequestParamsGet());
            } else {
                ((HttpRequestWithBody) request).body(rawRequest.getRequestParamsPost());
            }
            e.onNext(request.asString());
        });
            
    }
    
}
