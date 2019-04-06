package io.github.oliviercailloux.y2018.opendata.resource;

import io.swagger.v3.jaxrs2.Reader;
import io.swagger.v3.jaxrs2.ReaderListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Swagger Custom modifier that changes the naming scheme of route.
 * <p>
 * This was necessary because swagger annotations didn't work well with our AbstractResource model and ended up
 * giving the same OperationId to every routes sharing the same method.
 * <p>
 * This modifier replace the operation id like this :
 * - POST /course -> create_course
 * - PUT /course/{id} -> replace_course
 * - GET /course -> list_courses
 * ...
 */
@OpenAPIDefinition
public class SwaggerOperationIdModifier implements ReaderListener {
    
    private final Pattern patternRouteId = Pattern.compile("^/([^/]*)/\\{id\\}$");
    private final Pattern patternRouteNoId = Pattern.compile("^/([^/]*)$");
    private final Pattern patternRouteFilter = Pattern.compile("^/([^/]*)/search$");
    
    
    private final List<Pattern> ignoredRoutes = Stream.of("^/home$", "^/authentication").map(Pattern::compile).collect(Collectors.toList());
    
    @Override
    public void beforeScan(Reader reader, OpenAPI openAPI) {
    }
    
    @Override
    public void afterScan(Reader reader, OpenAPI openAPI) {
        openAPI.getPaths().forEach((path, pathItem) -> {
            
            if (ignoredRoutes.stream().anyMatch(p -> p.matcher(path).matches())) return ;
            
            Matcher matcherId = patternRouteId.matcher(path);
            Matcher matcherNoId = patternRouteNoId.matcher(path);
            Matcher matchFilter = patternRouteFilter.matcher(path);
            
            pathItem.readOperationsMap().forEach((httpMethod, operation) -> {
                
                if (matcherId.matches()) {
    
                    String action = httpMethod.name().toLowerCase();
                    
                    operation.setOperationId(action + "_" + matcherId.group(1));
                    
                } else if (matcherNoId.matches()) {
                    
                    String action = httpMethod.name().toLowerCase();
                    boolean plural = false;
                    if (httpMethod.equals(PathItem.HttpMethod.GET)) {
                        action = "list";
                        plural = true;
                    }
                    else if (httpMethod.equals(PathItem.HttpMethod.POST)) {
                        action = "create";
                    }
                    else if (httpMethod.equals(PathItem.HttpMethod.PUT)) {
                        action = "replace";
                    }
                    operation.setOperationId(action + "_" + matcherNoId.group(1) + (plural ? "s" : ""));
                }
                else if (matchFilter.matches()) {
                    String action = "filter";
                    operation.setOperationId(action + "_" + matchFilter.group(1) + "s");
                }
            });
        });
    }
}