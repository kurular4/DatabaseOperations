package com.example.okurular.database.RestApi;


public class BaseManager {

    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.Data_url);
        return  restApiClient.getRestApi();
    }
}
