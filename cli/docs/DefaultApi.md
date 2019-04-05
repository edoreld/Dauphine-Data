# DefaultApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**authenticate**](DefaultApi.md#authenticate) | **POST** /authentication | 
[**createCourse**](DefaultApi.md#createCourse) | **POST** /course | 
[**createLecture**](DefaultApi.md#createLecture) | **POST** /lecture | 
[**createPerson**](DefaultApi.md#createPerson) | **POST** /person | 
[**createPlanning**](DefaultApi.md#createPlanning) | **POST** /planning | 
[**deleteCourse**](DefaultApi.md#deleteCourse) | **DELETE** /course/{id} | 
[**deleteLecture**](DefaultApi.md#deleteLecture) | **DELETE** /lecture/{id} | 
[**deletePerson**](DefaultApi.md#deletePerson) | **DELETE** /person/{id} | 
[**deletePlanning**](DefaultApi.md#deletePlanning) | **DELETE** /planning/{id} | 
[**filterCourses**](DefaultApi.md#filterCourses) | **GET** /course/search | 
[**getCourse**](DefaultApi.md#getCourse) | **GET** /course/{id} | 
[**getLecture**](DefaultApi.md#getLecture) | **GET** /lecture/{id} | 
[**getPerson**](DefaultApi.md#getPerson) | **GET** /person/{id} | 
[**getPlanning**](DefaultApi.md#getPlanning) | **GET** /planning/{id} | 
[**listCourses**](DefaultApi.md#listCourses) | **GET** /course | 
[**listLectures**](DefaultApi.md#listLectures) | **GET** /lecture | 
[**listPersons**](DefaultApi.md#listPersons) | **GET** /person | 
[**listPlannings**](DefaultApi.md#listPlannings) | **GET** /planning | 
[**replaceCourse**](DefaultApi.md#replaceCourse) | **PUT** /course | 
[**replaceLecture**](DefaultApi.md#replaceLecture) | **PUT** /lecture | 
[**replacePerson**](DefaultApi.md#replacePerson) | **PUT** /person | 
[**replacePlanning**](DefaultApi.md#replacePlanning) | **PUT** /planning | 
[**sayHello**](DefaultApi.md#sayHello) | **GET** /home | 
[**whoAmI**](DefaultApi.md#whoAmI) | **GET** /authentication/whoami | 


## **authenticate**



### Example
```bash
 authenticate Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **credentials** | [**Credentials**](Credentials.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **createCourse**



### Example
```bash
 createCourse Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **course** | [**Course**](Course.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **createLecture**



### Example
```bash
 createLecture Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **lecture** | [**Lecture**](Lecture.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **createPerson**



### Example
```bash
 createPerson Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **person** | [**Person**](Person.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **createPlanning**



### Example
```bash
 createPlanning Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **planning** | [**Planning**](Planning.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteCourse**



### Example
```bash
 deleteCourse id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteLecture**



### Example
```bash
 deleteLecture id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deletePerson**



### Example
```bash
 deletePerson id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deletePlanning**



### Example
```bash
 deletePlanning id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **filterCourses**



### Example
```bash
 filterCourses  name=value  desc=value  lang=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **string** |  | [optional] [default to null]
 **desc** | **string** |  | [optional] [default to null]
 **lang** | **string** |  | [optional] [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

[**array[Course]**](Course.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getCourse**



### Example
```bash
 getCourse id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getLecture**



### Example
```bash
 getLecture id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getPerson**



### Example
```bash
 getPerson id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getPlanning**



### Example
```bash
 getPlanning id=value Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** |  | [default to null]
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listCourses**



### Example
```bash
 listCourses Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listLectures**



### Example
```bash
 listLectures Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listPersons**



### Example
```bash
 listPersons Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listPlannings**



### Example
```bash
 listPlannings Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **replaceCourse**



### Example
```bash
 replaceCourse Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **course** | [**Course**](Course.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **replaceLecture**



### Example
```bash
 replaceLecture Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **lecture** | [**Lecture**](Lecture.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **replacePerson**



### Example
```bash
 replacePerson Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **person** | [**Person**](Person.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **replacePlanning**



### Example
```bash
 replacePlanning Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]
 **planning** | [**Planning**](Planning.md) |  | [optional]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **sayHello**



### Example
```bash
 sayHello Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **whoAmI**



### Example
```bash
 whoAmI Bearer-Token:value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bearerToken** | **string** | The bearer authentication token | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

