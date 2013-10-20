
package com.ws.service.xsd.random_schema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ws.service.xsd.random_schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ws.service.xsd.random_schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRandomResponse }
     * 
     */
    public GetRandomResponse createGetRandomResponse() {
        return new GetRandomResponse();
    }

    /**
     * Create an instance of {@link GetRandomFault }
     * 
     */
    public GetRandomFault createGetRandomFault() {
        return new GetRandomFault();
    }

    /**
     * Create an instance of {@link GetRandomRequest }
     * 
     */
    public GetRandomRequest createGetRandomRequest() {
        return new GetRandomRequest();
    }

}
