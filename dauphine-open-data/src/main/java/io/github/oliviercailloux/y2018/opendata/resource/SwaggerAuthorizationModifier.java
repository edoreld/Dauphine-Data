package io.github.oliviercailloux.y2018.opendata.resource;

import io.swagger.v3.jaxrs2.Reader;
import io.swagger.v3.jaxrs2.ReaderListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;

import javax.ws.rs.core.HttpHeaders;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This swagger modifier add the implicit `authorization` header parameter on every route.
 */
@OpenAPIDefinition
public class SwaggerAuthorizationModifier implements ReaderListener {
    
    @Override
    public void beforeScan(Reader reader, OpenAPI openAPI) {
    }
    
    @Override
    public void afterScan(Reader reader, OpenAPI openAPI) {
        HeaderParameter authorizationHeader = new HeaderParameter();
        
        authorizationHeader.setName("Bearer-Token");
        authorizationHeader.setRequired(false);
        authorizationHeader.setDescription("The bearer authentication token");
        authorizationHeader.setSchema(new StringSchema());
        
        openAPI.getPaths().forEach((path, pathItem) ->
                pathItem.readOperations().forEach(operation ->
                        operation.addParametersItem(authorizationHeader)));
    }
}