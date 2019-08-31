# Application Purpose
Spring Boot Rest WebServices application for Directory and files Listing inside any given valid directory of the specified system.

## Primary Functionality Implementation Description
Application is having layered based architecture Controller,Service and business and in each layer there are interface and its implementation.
Dao layer is not required as such there is no database interaction required.
Its is returning the response in XML format recursively and sorted on basis of file/directory name.
The XML format contains name of file/directory,full path of file, size of file, and flag value for file it is "f" and for directory it is "d" 

## Additional Functionality  Implementation
abstraction is taken care by using interface and its implementation.
Exception is handed at each layer where ever it is required to handle.
Logger is integrated at each layer.
Java Docker is used for meaning full comments at class and method level. 

## Rest API URL
URL For listing the files/Directory
http://localhost:9091/listAllFiles?directoryPath=G:/Images
host name and port could be changed.

## Method Type
HTTP method used
GET

## Sample Response representation-XML    
.
<List>
    <item>
        <fileName>Images</fileName>
        <fileDescription>G:\Images</fileDescription>
        <fileSize/>
        <flagValue>d</flagValue>
    </item>
    <item>
        <fileName>Nature.jpg</fileName>
        <fileDescription>G:\Images\Nature.jpg</fileDescription>
        <fileSize>11667</fileSize>
        <flagValue>f</flagValue>
    </item>
    <item>
        <fileName>Nature2.jpg</fileName>
        <fileDescription>G:\Images\Nature2.jpg</fileDescription>
        <fileSize>12674</fileSize>
        <flagValue>f</flagValue>
    </item>
</List>
 
 
 
## HTTP Status Codes
200 Ok: Response to a successful GET

## Application Deployment and Running Process
clone the project from GIT
import as  existing maven project
updated the project for the  maven dependencies
run as Spring Boot app.
embedded tomcat server is used for application deployment.
hit the url in postman to get the success response in xml format. 


