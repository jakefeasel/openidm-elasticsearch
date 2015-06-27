// ScriptedREST-based connectors are based on the org.apache.http.client.HttpClient package
// this CustomizerScript is responsible for extending the plain HttpClient "connection" object
// with the details necessary to work with this particular target (elasticsearch in this case).
// This customized connection object will be made available to the other scripts via the
// "customizedConnection" variable

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import groovyx.net.http.RESTClient

customize {

    /**
     * This method is passed an object that will be used in the construction of the connection.
     * Do not return from this; instead, make changes to the builder object. Those changes will be used
     * in the creation of the connection
     */
    init { HttpClientBuilder builder ->
        // nothing to do here
    }

    /**
     * This Closure can customize the httpClient and the returning object is injected into the Script Binding as the
     * customizedConnection variable. Any object can be returned from here, but probably should be a variation of the httpClient
     */
    decorate { HttpClient httpClient ->

        // return a friendly RESTClient object using the more low-level HttpClient object
        RESTClient restClient = new RESTClient(delegate.serviceAddress, 'application/json')
        restClient.setClient(httpClient)
        restClient.setHeaders([ "Content-type": "application/json" ])

        return restClient
    }
}
