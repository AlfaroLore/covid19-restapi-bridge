package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import play.mvc.*;
import play.libs.Json;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import facades.Covid19Facade;
import models.Country;

import static util.Covid19APIConstants.STATUS_CODE_FOR_MISSING_INVALID_PARAMETERS;
import static util.Covid19APIConstants.STATUS_DESC_FOR_MISSING_INVALID_PARAMETERS;

@Api(value  = "Covid19Controller", description = "Retrieves covid19 updated info from RapidAPI")
public class Covid19Controller extends Controller{
    public Covid19Facade covid19Facade;

    @Inject
    public Covid19Controller(Covid19Facade facade){
        this.covid19Facade=facade;
    }
    @ApiOperation(value = "Gets a covid19 report by country and date", notes = "Returns an array of Country info.")
    @ApiResponses(value = {
            @ApiResponse(code = Http.Status.OK, message = "Ok", response = Country.class, responseContainer = "List"),
            @ApiResponse(code = Http.Status.BAD_REQUEST, message = "Bad request"),
            @ApiResponse(code = STATUS_CODE_FOR_MISSING_INVALID_PARAMETERS, message = STATUS_DESC_FOR_MISSING_INVALID_PARAMETERS)
    })
    public Result returnCountryReport(@ApiParam(value = "Date") String date, @ApiParam(value = "Country code") String code) {
        List<Country> countryList = this.covid19Facade.getCountryDailyReportByCode(date, code);
        JsonNode content = Json.toJson(countryList);
        return ok(content);
    }
}
